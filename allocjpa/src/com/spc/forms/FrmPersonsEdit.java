package com.spc.forms;

import applic.BasicCrudView;

import com.spc.domain.Person;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class FrmPersonsEdit extends VerticalLayout {

	private static final long serialVersionUID = -7682520434956907843L;
	private String PERSISTENCE_UNIT = "allocjpa";

	public FrmPersonsEdit() {
		//Class<?> javaType = Person.class ;
		System.out.println("FrmPersonsEdit start to work....");
		Label label = new Label("Форма редактирования Персонов");
		addComponent(label);
		
		BasicCrudView view = new BasicCrudView (Person.class, PERSISTENCE_UNIT);
		addComponent(view);
	}

}
