package woaf.core.functions;

import static org.junit.Assert.*;

import org.junit.Test;

import woaf.core.LookupManager;
import woaf.dto.DTOContract;

public class DTOCollectorForChooseTest {

	@Test
	public void lookupTest(){
		assertNotNull(LookupManager.getInstance().getDTOCollectorForChoose());
	}
	
	@Test
	public void getDTOListForChooseTest(){
		DTOCollectorForChoose collectorForChoose = LookupManager.getInstance().getDTOCollectorForChoose();
		AvaiableSimpleFunction sf = new AvaiableSimpleFunction();
		sf.setSubjectType(SubjectType.CONTRACT);
		sf.setStateId(1);
		collectorForChoose.getDTOListForChoose(sf, DTOContract.class);
		for(DTOContract dtoContract : collectorForChoose.getDTOListForChoose(sf, DTOContract.class)){
			assertNotNull(dtoContract);
		}
	}
}
