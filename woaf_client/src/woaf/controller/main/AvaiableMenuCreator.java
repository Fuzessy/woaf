package woaf.controller.main;


import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import woaf.core.LookupManager;
import woaf.core.functions.AvaiableFunctionList;
import woaf.core.functions.AvaiableFunctions;

public class AvaiableMenuCreator {
	
	private Stage mainStage;
	
	public MenuBar createAvaiableMenuBar(Stage stage){
		this.mainStage = stage;
		
		MenuBar menuBar = new MenuBar();
		
		Menu menu = new Menu();
		menu.setText("Fájl");
		
		MenuItem exitMenuItem = new MenuItem();
		exitMenuItem.setText("Kilépés");
		exitMenuItem.setOnAction(action -> stage.close());
		
		menu.getItems().add(exitMenuItem);
		
		menuBar.getMenus().add(menu);
		
		AvaiableFunctions avaiableFunctions = 
				LookupManager.getInstance().getAvaiableFunctionsHandler().getAvaiableFunctions();
		menuBar.getMenus().addAll(createMainMenus(avaiableFunctions.getFunctionList().getFunctions()));
		return menuBar;
	}

	private List<Menu> createMainMenus(List<AvaiableFunctions> functionList) {
		List<Menu> menus = new ArrayList<>();
		for(AvaiableFunctions functions : functionList){
			for(MenuItem mi : createMenu(functions)){
				menus.add((Menu)mi);
			}
		}
		return menus;
	}

	private List<MenuItem> createMenu(AvaiableFunctions functions) {
		List<MenuItem> menuItems = new ArrayList<>();
		if(functions.isSimpleFunction()){
			MenuItem menuItem = new MenuItem();
			menuItem.setText(functions.getFunctionName());
			menuItem.setOnAction(eh -> {
				(new MenuEventHandler(functions.getSimpleFunction(),mainStage)).onAction();
			});
			menuItems.add(menuItem);
		}else{
			Menu menu = new Menu();
			menu.setText(functions.getFunctionName());
			for(AvaiableFunctions fs : functions.getFunctionList().getFunctions()){
				menu.getItems().addAll(createMenu(fs));	
			}
			menuItems.add(menu);
		}
		return menuItems;
	}
}
