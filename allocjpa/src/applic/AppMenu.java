package applic;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;

public class AppMenu extends MenuBar {

	private static final long serialVersionUID = -79240858275010505L;

	public AppMenu() {
		super();
	}

	public void makeMenu() {
		// Команды
		MenuBar.Command notif1 = new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				Notification.show("Меню нажато. Открывайся интерфейс");
			}
		};

		// Пункты меню
		MenuBar.MenuItem menuSettings = addItem("Настройка", null);
		menuSettings.addItem("Классификаторы", null, notif1);
		MenuBar.MenuItem menuEntData = addItem("Ввод данных", null);
		MenuBar.MenuItem menuReports = addItem("Отчёты", null);

	}
}
