package woaf.controller.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import woaf.core.functions.SimpleTransition;

public class FormManager {

	private String doFxml;
	final private String frameFxml = "/woaf/view/main/AbstractDoFunctionForm.fxml";
	private Stage mainStage;
	
	private WoafController doController;
	private Pane doPane;
	private Stage doStage;
	private Scene doScene;
	private AbstractDoFunctionFormController doFunctionFormController;
	
	public FormManager(String doFxml, Stage mainStage){
		this.doFxml = doFxml;
		this.mainStage = mainStage;
	}
	
	public void loadDoForm(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(doFxml));
			doPane = (Pane) loader.load();
			doController = loader.getController();
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public WoafController getDoController() {
		return doController;
	}

	public void setDoController(WoafController doController) {
		this.doController = doController;
	}

	public Pane getDoPane() {
		return doPane;
	}

	public void setDoPane(Pane doPane) {
		this.doPane = doPane;
	}

	public void loadAbstractDoForm() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(frameFxml));
			BorderPane doPane = (BorderPane) loader.load();
			doPane.setCenter(this.doPane);
			doScene = new Scene(doPane);
			
			doStage = new Stage();
			doController.setParentStage(mainStage);
			doFunctionFormController = loader.getController();
			doFunctionFormController.setOwnerStage(doStage);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public <T extends SimpleTransition> void setTransitions(List<T> avaiableStartTransitions){
		doFunctionFormController.setTransitionButtons(
				createTransitionButtons(avaiableStartTransitions, doFunctionFormController));
	}
	
	public void show(){
		doStage.setTitle("FORM CÍME");
		doStage.initModality(Modality.WINDOW_MODAL);
		doStage.initOwner(mainStage);
		
		doStage.setScene(doScene);
		doStage.showAndWait();
	}
	
	private <T extends SimpleTransition> List<Button> createTransitionButtons(List<T> avaiableStartTransitions,
			AbstractDoFunctionFormController doFunctionFormController) {
		List<Button> buttons = new ArrayList<>();
		for(SimpleTransition tr : avaiableStartTransitions){
			Button button = new Button();
			button.setText(tr.getName());
			button.setOnAction( x -> {
				try{
					tr.getFunction().run();
					doFunctionFormController.close();
				}catch(Exception exc){
					// itt még finomítani kell
					throw exc;
				}
			});
			buttons.add(button);
		}
		return buttons;
	}
	
	
}