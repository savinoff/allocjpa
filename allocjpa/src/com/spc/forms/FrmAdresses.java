package com.spc.forms;

import com.spc.domain.Adress;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class FrmAdresses extends VerticalLayout{
	
	private static final long serialVersionUID = -5443362867617666169L;
	private String PERSISTENCE_UNIT = "allocjpa";
	
	public FrmAdresses() {
//		JPAContainer<Adress> adressesContainer = JPAContainerFactory.make(Adress.class, PERSISTENCE_UNIT);
//		Table adressesTable = new Table("Таблица adresses", adressesContainer);
//		
		Label label = new Label("форма под Адреса");
		addComponent(label);
		Table adressesTable = new Table("Таблица adresses");
		adressesTable.setSizeFull();
		adressesTable.setSelectable(true);
		adressesTable.setMultiSelect(true);
		adressesTable.setImmediate(true);
		addComponent(adressesTable);
	}

}
