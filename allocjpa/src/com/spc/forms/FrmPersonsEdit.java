package com.spc.forms;

import applic.BasicCrudView;

import com.spc.domain.Person;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class FrmPersonsEdit extends VerticalLayout {

	private static final long serialVersionUID = -7682520434956907843L;
	private String PERSISTENCE_UNIT = "allocjpa";

	public FrmPersonsEdit() {
		System.out.println("FrmPersonsEdit start to work....");

		
		BasicCrudView<Person> view = new BasicCrudView<Person> (Person.class, PERSISTENCE_UNIT);
		view.setHeight("900px");
		//view.setWidth("100%");
		//setMargin(true);
		addComponent(view);
		//setExpandRatio(view, 1.0f);
	}

}
