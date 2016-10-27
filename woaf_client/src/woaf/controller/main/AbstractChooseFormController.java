package woaf.controller.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class AbstractChooseFormController<T> implements Initializable {

	@FXML TableView<T> tbxMain;
	private Stage ownerStage;
	
	private boolean bCancelled = true;
	
	private T choosedData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML public void f_choose() {
		System.out.println("choose");
		bCancelled = false;
		choosedData = tbxMain.getSelectionModel().getSelectedItem();
		ownerStage.close();
	}

	@FXML public void f_cancel() {
		System.out.println("cancel");
		bCancelled = true;
		ownerStage.close();
	}

	public void setTableBoxColumns(List<TableColumn<T,?>> tableColumns) {
		tbxMain.getColumns().addAll(tableColumns);
	}

	public void setTableViewRows(ObservableList<T> observableList) {
		tbxMain.setItems(observableList);
	}
	
	public T getChoosedRowData(){
		return choosedData;
	}

	public void setOwnerStage(Stage ownerStage) {
		this.ownerStage = ownerStage;
	}

	public boolean isChooseCancelled() {
		return bCancelled;
	}
	

}
