package test;

import java_cup.internal_error;

import com.spc.forms.FrmAdresses;

public class MainTest {

	private static Object[][] treeItems = new Object[][] {
			new Object[] { "Заголовочный пункт дерева" },
			new Object[] { "Справочнички",
					new Object[] { "Persons", "Справочнички" },
					new Object[] { "Адреса", new FrmAdresses(), "Справочнички" } },
			new Object[] { "Завершающий пукт дерева" } };

	public static void main(String[] args) {
		System.out.println("Проверочный скрипты");
		System.out.println("Пробег по дереву");
		
		for(int i=0; i < treeItems.length; i++) {
			System.out.println(treeItems[i][0]);
			System.out.println(treeItems[i].length);
			if( treeItems[i].length > 1) {
				for (int u= 1; u < treeItems[i].length; u++){
					System.out.println(treeItems[i][u]);
				}
			}
		}

	}
}
