package com.spc.forms;


import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.Page;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;

public class ClassifForm extends HorizontalSplitPanel{

	private static final long serialVersionUID = 8171549744161227310L;

	private Tree navigationTree;
	private FrmPersons frmPersons;
	private FrmAdresses frmAdresses;
	
	private String treeItemClassif = "Справочники";
	private String treeItemClassifPerson = "Person";
	private String treeItemClassifAdress = "Adress";
	
	
	public ClassifForm () {
		super();
		buildForm();
		addListener();
//		setSecondComponent(frmPersons);
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
	}
	
	private void addListener () {
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
