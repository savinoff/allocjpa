package com.spc.forms;

import java.util.HashMap;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;

public class ClassifForm extends HorizontalSplitPanel {

	private static final long serialVersionUID = 8171549744161227310L;

	private Tree navigationTree;

	// Пункт меню { (ID), Форма, Родитель (ID Родителя) }
	private static Object[][] treeItems = new Object[][] {
		new Object[] { "Заголовочный пункт дерева" },
		new Object[] { "Справочнички"},
				 new Object[] {"Persons", "Справочнички", new FrmPersons()},
				 new Object[] {"Адреса","Справочнички", new FrmAdresses()},
				 new Object[] {"Добавляемые Persons", "Справочнички", new FrmPersonsEdit()},
		new Object[] { "Завершающий пукт дерева" } };

	private HashMap<String, Object> treeItemsFrms = new HashMap<String, Object>();


	public ClassifForm() {
		super();
		buildForm();
		addListener();
	}

	private void buildForm() {
		navigationTree = new Tree();
		navigationTree.setCaption("Классификаторы");
		navigationTree.setSelectable(true);
		navigationTree.setNullSelectionAllowed(false);
		navigationTree.setImmediate(true);
		setFirstComponent(navigationTree);
		setSplitPosition(200, Unit.PIXELS);
		

		for(int i=0; i < treeItems.length; i++) {
			System.out.println(treeItems[i][0]);
			navigationTree.addItem((String) treeItems[i][0]);
			System.out.println(treeItems[i].length);
			if( treeItems[i].length > 1) {
					navigationTree.setChildrenAllowed((String) treeItems[i][1], true);
					navigationTree.setParent((String) treeItems[i][0], (String) treeItems[i][1]);
					navigationTree.setChildrenAllowed((String) treeItems[i][0], false);
					treeItemsFrms.put((String) treeItems[i][0], treeItems[i][2] );
			} else {
				navigationTree.setChildrenAllowed(treeItems[i][0], false);
				System.out.println(navigationTree);
			}
		}
	}

	private void addListener() {
		navigationTree.addItemClickListener(new ItemClickListener() {
			private static final long serialVersionUID = 1L;

			public void itemClick(ItemClickEvent event) {
				Object value = event.getItemId();
				Notification.show((String) value);
				AbstractLayout secondComponent;
				secondComponent = (AbstractLayout) treeItemsFrms.get(value);
//				AbsoluteLayout secondComponent;
//				secondComponent = (AbsoluteLayout) treeItemsFrms.get(value);
				setSecondComponent(secondComponent);
				System.out.println("selected tree itemid: "+(String) value);
			}
		});
	}

}
