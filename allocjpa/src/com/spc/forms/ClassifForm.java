package com.spc.forms;


import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Tree;

public class ClassifForm extends HorizontalSplitPanel{

	private static final long serialVersionUID = 8171549744161227310L;

	private Tree navigationTree;
	
	private String treeItemClassif = "Справочники";
	private String treeItemClassifPerson = "Person";
	private String treeItemClassifAdress = "Adress";
	
	
	public ClassifForm () {
		super();
		buildForm();
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
		
	}
	

}
