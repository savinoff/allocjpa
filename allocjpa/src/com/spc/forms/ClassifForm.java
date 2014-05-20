package com.spc.forms;

import java.util.HashMap;
import java.util.List;

import java_cup.internal_error;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.Page;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;

public class ClassifForm extends HorizontalSplitPanel {

	private static final long serialVersionUID = 8171549744161227310L;

	private Tree navigationTree;
	private FrmPersons frmPersons;
	private FrmAdresses frmAdresses;

	private String treeItemClassif = "Справочники";
	private String treeItemClassifPerson = "Person";
	private String treeItemClassifAdress = "Adress";

	// Пункт меню (ID), Форма, Родитель (ID Родителя)
	private static Object[][] treeItems = new Object[][] {
		new Object[] { "Заголовочный пункт дерева" },
		new Object[] { "Справочнички"},
				 new Object[] {"Persons", "Справочнички", new FrmPersons()},
				 new Object[] {"Адреса","Справочнички", new FrmAdresses()},
		new Object[] { "Завершающий пукт дерева" } };

	//private HashMap<String, Object> treeItemsFrms;
	private HashMap treeItemsFrms = new HashMap();
	
	private Object[] treeItemsForms = new Object[] {
			"Persons", new FrmPersons()
	};

	public ClassifForm() {
		super();
		buildForm();
		addListener();
		// setSecondComponent(frmPersons);
	}

	private void buildForm() {
		navigationTree = new Tree();
		navigationTree.setCaption("Классификаторы");
		navigationTree.addItem(treeItemClassif);
		navigationTree.setChildrenAllowed(treeItemClassif, true);

		navigationTree.addItem(treeItemClassifPerson);
		navigationTree.setParent(treeItemClassifPerson, treeItemClassif);

		navigationTree.addItem(treeItemClassifAdress);
		navigationTree.setParent(treeItemClassifAdress, treeItemClassif);

		navigationTree.expandItemsRecursively(treeItemClassif);
		navigationTree.setNullSelectionAllowed(false);

		setFirstComponent(navigationTree);
		setSplitPosition(200, Unit.PIXELS);

		frmPersons = new FrmPersons();
		frmAdresses = new FrmAdresses();

		for(int i=0; i < treeItems.length; i++) {
			System.out.println(treeItems[i][0]);
			navigationTree.addItem(treeItems[i][0]);
			System.out.println(treeItems[i].length);
			if( treeItems[i].length > 1) {
					String currItemString = (String) treeItems[i][0];
					System.out.println("Установим родителя " + treeItems[i][1]);
					navigationTree.setParent(treeItems[i][0], treeItems[i][1]);
					System.out.println("Добавим связь формы и ид части дерева для " + treeItems[i][0] + " форма " + treeItems[i][2]);
					treeItemsFrms.put((String) treeItems[i][0], treeItems[i][2] );
			} else {
				navigationTree.setChildrenAllowed(treeItems[i][0], false);
			}
		}
	}

	private void addListener() {
		navigationTree.addItemClickListener(new ItemClickListener() {
			private static final long serialVersionUID = 1L;

			public void itemClick(ItemClickEvent event) {
				// TODO Auto-generated method stub
				Object value = event.getItemId();
				Notification.show((String) value);
				if (treeItemClassifPerson.equals(value)) {

					setSecondComponent(frmPersons);
				} else if (treeItemClassifAdress.equals(value)) {
					Notification.show("Отработал elseif");
					setSecondComponent(frmAdresses);
				}
				navigationTree.select(event);
				System.out.println("ttt");
			}
		});
	}

}
