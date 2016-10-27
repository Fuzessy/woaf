package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import woaf.controller.login.LoginController;
import woaf.controller.main.AvaiableMenuCreator;
import woaf.core.ApplicationSession;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage primaryStage;
	private BorderPane root;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
	    Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
	    	e.printStackTrace();
	    	Alert a = new Alert(AlertType.ERROR);
	    	a.setContentText(e.toString());
	    	a.showAndWait();
//	        Dialogs.create().title("Error")
//	            .message("An uncaught exception was thrown in thread \"" + t
//	                    + "\". Click below to view the stacktrace, or close this "
//	                    + "dialog to terminate the application.")
//	            .style(DialogStyle.NATIVE)
//	            .showExceptionInNewWindow(e);
//	        Platform.exit();
	    });
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("/woaf/view/main/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
			
			if(login()){
				startApplication();
			}else{
				primaryStage.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void startApplication() {
		// create menu
		AvaiableMenuCreator menuCreator = new AvaiableMenuCreator();
		root.setTop(menuCreator.createAvaiableMenuBar(primaryStage));
	}

	private boolean login() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/woaf/view/login/Login.fxml"));
		Pane pane = loader.load();
		
		Stage loginStage = new Stage();
		loginStage.setTitle("Edit Person");
		loginStage.initModality(Modality.WINDOW_MODAL);
		loginStage.initOwner(primaryStage);
		
		LoginController lc = loader.getController();
		lc.setStage(loginStage);
		Scene scene = new Scene(pane);
		loginStage.setScene(scene);
		loginStage.showAndWait();
		return ApplicationSession.getInstance().getUserSession().getUserData() != null;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
