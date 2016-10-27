package woaf.controller.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class 
AbstractDoFunctionFormController implements Initializable{

	@FXML HBox avaiableTransitionsBox;
	private Stage ownerStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void setTransitionButtons(List<Button> transitionButtons){
		avaiableTransitionsBox.getChildren().addAll(transitionButtons);
	}
	
	public void setOwnerStage(Stage ownerStage){
		this.ownerStage = ownerStage;
	}

	public void close() {
		ownerStage.close();
	}

}
