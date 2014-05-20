package applic;

import com.spc.allocjpa.AllocjpaUI;
import com.spc.forms.ClassifForm;
import com.spc.forms.FrmPersonsEdit;
import com.spc.forms.SimpleForm;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;

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
				TabSheet mainTabSheet = currentUi.getMainWindowForm()
						.getMainTabSheet();
				ClassifForm tabItem = new ClassifForm();
				tabItem.setHeight("100%");
				mainTabSheet.addComponent(tabItem);
				mainTabSheet.setHeight("100%");
				mainTabSheet.getTab(tabItem).setCaption("Классификаторы");
				mainTabSheet.getTab(tabItem).setClosable(true);

			}
		};
		MenuBar.Command addSimpleForm = new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				AllocjpaUI currentUi = AllocjpaUI.getCurrent();
				TabSheet mainTabSheet = currentUi.getMainWindowForm()
						.getMainTabSheet();
				SimpleForm tabItem = new SimpleForm();
				mainTabSheet.addComponent(tabItem);
				mainTabSheet.setHeight("100%");
				mainTabSheet.getTab(tabItem).setCaption("Простая форма");
				mainTabSheet.getTab(tabItem).setClosable(true);
			}
		};

		MenuBar.Command addPersonEditForm = new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				AllocjpaUI currentUi = AllocjpaUI.getCurrent();
				TabSheet mainTabSheet = currentUi.getMainWindowForm()
						.getMainTabSheet();
				FrmPersonsEdit tabItem = new FrmPersonsEdit();
				mainTabSheet.addComponent(tabItem);
				mainTabSheet.setHeight("100%");
				mainTabSheet.getTab(tabItem).setCaption("Редактирование Person");
				mainTabSheet.getTab(tabItem).setClosable(true);
			}
		};

		// Пункты меню
		MenuBar.MenuItem menuSettings = addItem("Настройка", null);
		menuSettings.addItem("Классификаторы", null, addTabClassif);
		menuSettings.addItem("Простая форма", null, addSimpleForm);
		menuSettings.addItem("Тест формы редактирования", null,
				addPersonEditForm);
		MenuBar.MenuItem menuEntData = addItem("Ввод данных", null);
		menuEntData.addItem("Значения кост-драйверов", null, notif1);

		@SuppressWarnings("unused")
		MenuBar.MenuItem menuReports = addItem("Отчёты", null);

	}
}
