package woaf.controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import woaf.core.ApplicationSession;
import woaf.core.authentication.WoafAuthenticationException;
import woaf.core.LookupManager;

public class LoginController implements Initializable {

	@FXML PasswordField cPassword;
	@FXML TextField cLoginName;
	private Stage stage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void setStage(Stage stage){
		this.stage = stage;
	}

	@FXML public void f_login() {
		try {
			ApplicationSession.getInstance().getUserSession()
				.login(cLoginName.getText(), cPassword.getText());
			stage.close();
			
		} catch (WoafAuthenticationException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Sikertelen bejelentkezés!");
			alert.setContentText("Hibás felhasználónév vagy jelszó!");
			alert.showAndWait();
		}
	}

	@FXML public void f_cancel() {
		stage.close();
	}

}
