package woaf.controller.subject.customer;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import woaf.controller.main.FormManager;
import woaf.controller.main.WoafController;
import woaf.controller.subject.address.AddressViewHandler;
import woaf.core.functions.SimpleTransition;
import woaf.dto.DTOAddress;
import woaf.dto.DTOCustomerForManipulation;
import woaf.subject.address.AAddressController;
import woaf.subject.customer.ACustomerController;

public class CustomerController extends ACustomerController implements Initializable, WoafController{

	private Stage ownerStage;
	@FXML TextField stfFirstName;
	@FXML TextField stfLastName;
	@FXML TextField stfAddress;
	@FXML TextField stfCustomerId;
	private int addressId;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void setParentStage(Stage stage){
		this.ownerStage = stage;
	}

	@Override
	public DTOCustomerForManipulation getCustomerForInsert() {
		DTOCustomerForManipulation dto = new DTOCustomerForManipulation();
		dto.setFirstName(stfFirstName.getText());
		dto.setLastName(stfLastName.getText());
		dto.setAddressId(addressId);
		return dto;
	}

	@Override
	public DTOCustomerForManipulation getCustomerForModify() {
		DTOCustomerForManipulation dto = new DTOCustomerForManipulation();
		dto.setCustomerId(Integer.parseInt(stfCustomerId.getText()));
		dto.setFirstName(stfFirstName.getText());
		dto.setLastName(stfLastName.getText());
		dto.setAddressId(addressId);
		return dto;
	}
	
	

	@FXML public void f_ChooseOrEditAddress() {
		DTOAddress address = super.chooseOrModifyAddress(addressId);
		this.setDTOAddress(address);
	}

	
	private void setDTOAddress(DTOAddress address) {
		addressId = address.getAddressId();
		stfAddress.setText(address.getCity() + " " + address.getStreet() 
		+ " " + address.getNumber());
	}


	private FormManager addressFormManager;
	@Override
	public AAddressController getAddressController() {
		AddressViewHandler vh = new AddressViewHandler();
		String fxml = vh.getCreateFormForSubject();
		addressFormManager = new FormManager(fxml,ownerStage);
		addressFormManager.loadDoForm();		
		return (AAddressController) addressFormManager.getDoController();
	}

	@Override
	public void showAddressForm(List<SimpleTransition> transitions) {
		addressFormManager.loadAbstractDoForm();
		addressFormManager.setTransitions(transitions);
		addressFormManager.show();
	}

}
