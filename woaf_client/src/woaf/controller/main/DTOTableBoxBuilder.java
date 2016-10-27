package woaf.controller.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;
import woaf.dto.DTOName;

public class DTOTableBoxBuilder {

	/**
	 * Az adott entitás szerint elkészíti a megfelelő táblázatot
	 * DTOName annotációval ellátott DTO-t jelenít meg
	 * @param clazz
	 * @return
	 */
	public <T> List<TableColumn<T,?>> getTableColumns(Class<T> clazz){
		return Arrays.asList(clazz.getDeclaredFields())
				.stream()
				.map( f -> new Pair<Field,DTOName>(f,f.getAnnotation(DTOName.class)))
				.filter(pair -> pair.getValue() != null)
				.map(p -> {
					TableColumn<T,?> tc = new TableColumn<>(p.getValue().value());
					tc.setCellValueFactory(new PropertyValueFactory<>(p.getKey().getName()));
					return tc;
					} )
				.collect(Collectors.toList());
	}
}
