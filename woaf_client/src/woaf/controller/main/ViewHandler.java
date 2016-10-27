package woaf.controller.main;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import woaf.core.LookupManager;
import woaf.core.functions.AvaiableSimpleFunction;
import woaf.core.functions.Transition;
import woaf.dto.DTOContract;

/**
 * Az adott subjecthez kell biztosítani a megfelelő
 *  felületeket, adatokat, állapotátmeneteket 
 * @author fuzessy
 *
 */
public interface ViewHandler {

	String getCreateFormForSubject();
	
	public <T> List<Transition> getTransitions(T controller, AvaiableSimpleFunction function);

	String getDoFunctionForSubjectState(int stateId);

	Class<?> getDTOForChooseDTOClass();
	/**
	 * Táblázat fejlécének beállítása, és a szükséges adatok átadása
	 */
	@SuppressWarnings("unchecked")
	public default void setDTOForChoose(AbstractChooseFormController controller,
			AvaiableSimpleFunction simpleFuction) {
		
		DTOTableBoxBuilder tbxBuilder = new DTOTableBoxBuilder();
		
		controller.setTableBoxColumns(tbxBuilder.getTableColumns(getDTOForChooseDTOClass()));
		
		@SuppressWarnings("rawtypes")
		List dtos = LookupManager.getInstance()
			.getDTOCollectorForChoose()
			.getDTOListForChoose(simpleFuction, getDTOForChooseDTOClass());
																																																																																	
		ObservableList observableList = FXCollections.observableArrayList(dtos);
		controller.setTableViewRows(observableList);
	}
}
