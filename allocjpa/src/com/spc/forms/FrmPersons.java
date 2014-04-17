package com.spc.forms;

import com.spc.domain.Person;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class FrmPersons extends VerticalLayout{
	
	private static final long serialVersionUID = 8614338900936773139L;
	private String PERSISTENCE_UNIT = "allocjpa";

	public FrmPersons() {
		JPAContainer<Person> persons = JPAContainerFactory.make(Person.class, PERSISTENCE_UNIT);
		persons.sort(new String[] {"id"}, 
					 new boolean [] {false});
		Table personsTable = new Table("Таблица Persons", persons);
		addComponent(personsTable);
		
	}
}
