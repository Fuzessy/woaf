package woaf.controller.main;

import org.junit.Test;

import javafx.scene.control.TableColumn;
import woaf.dto.DTOContract;

public class DTOTableBoxBuilderTest {

	@Test
	public void testWithDTOContract(){
		DTOTableBoxBuilder builder = new DTOTableBoxBuilder();
		for(TableColumn col : builder.getTableColumns(DTOContract.class)){
			System.out.println(col.getText());
		}
	}
}
