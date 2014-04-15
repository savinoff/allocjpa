package applic;

import com.spc.allocjpa.AllocjpaUI;
import com.spc.forms.SimpleForm;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;

public class AppMenu extends MenuBar {

	private static final long serialVersionUID = -79240858275010505L;

	public AppMenu() {
		super();
	}
	@SuppressWarnings("serial")
	public void makeMenu() {
		// Команды
		
		MenuBar.Command notif1 = new MenuBar.Command() {
			private static final long serialVersionUID = 1941909748130652376L;

			@Override
			public void menuSelected(MenuItem selectedItem) {
				Notification.show("Меню нажато. Открывайся интерфейс");
			}
		};
		MenuBar.Command addTabClassif = new MenuBar.Command() {		
			@Override
			public void menuSelected(MenuItem selectedItem) {
				AllocjpaUI currentUi = AllocjpaUI.getCurrent();
				TabSheet mainTabSheet = currentUi.getMainWindowForm().getMainTabSheet();
				SimpleForm tabItem = new SimpleForm();
				mainTabSheet.addComponent(tabItem);
				mainTabSheet.getTab(tabItem).setCaption("Простая форма");
				mainTabSheet.getTab(tabItem).setClosable(true);
			}
		};
		MenuBar.Command closeTab = new MenuBar.Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				AllocjpaUI currentUi = AllocjpaUI.getCurrent();
				TabSheet mainTabSheet = currentUi.getMainWindowForm().getMainTabSheet();
				String tabCaption = mainTabSheet.getSelectedTab().getCaption();
				mainTabSheet.removeComponent((Component) mainTabSheet.getSelectedTab());
				Notification.show("Закрыт таб " + tabCaption);
				
			}
		};

		// Пункты меню
		MenuBar.MenuItem menuSettings = addItem("Настройка", null);
		menuSettings.addItem("Классификаторы", null, addTabClassif);
		menuSettings.addItem("Закрыть TAB", closeTab);
		MenuBar.MenuItem menuEntData = addItem("Ввод данных", null);
		menuEntData.addItem("Значения кост-драйверов", null, notif1);
		
		MenuBar.MenuItem menuReports = addItem("Отчёты", null);

	}
}
