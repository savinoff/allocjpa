//package test;
//
//import java.util.Dictionary;
//
//import com.spc.forms.FrmAdresses;
//import com.spc.forms.FrmPersons;
//
//public class MainTest {
//	
//	private static Object[][] treeItems = new Object[][] {
//			new Object[] { "Заголовочный пункт дерева" },
//			new Object[] { "Справочнички"},
//					 new Object[] {"Persons", "Справочнички", new FrmPersons()},
//					 new Object[] {"Адреса","Справочнички", new FrmAdresses()},
//			new Object[] { "Завершающий пукт дерева" } };
//	
//	private Dictionary<String, Object> treeItemsFrms;
//
//	public static void main(String[] args) {
//		System.out.println("Проверочный скрипты");
//		System.out.println("Пробег по дереву");
//		
//		for(int i=0; i < treeItems.length; i++) {
//			System.out.println(treeItems[i][0]);
//			System.out.println(treeItems[i].length);
//			if( treeItems[i].length > 1) {
//					System.out.println("Установим родителя " + treeItems[i][1]);
//					System.out.println("Добавим связь формы и ид части дерева для " + treeItems[i][0] + " форма " + treeItems[i][2]);
//			}
//		}
//
//	}
//	
//	
//}
