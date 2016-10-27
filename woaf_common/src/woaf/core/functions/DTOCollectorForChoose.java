package woaf.core.functions;

import java.util.List;

public interface DTOCollectorForChoose {
	public <T> List<T> getDTOListForChoose(AvaiableSimpleFunction simpleFunction,Class<T> clazz);
}
