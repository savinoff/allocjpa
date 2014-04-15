package com.spc.forms;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class SimpleForm extends HorizontalLayout implements View{

	private static final long serialVersionUID = -2200158269515623473L;

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public SimpleForm() {
		// TODO Auto-generated constructor stub
		addComponent(new Label("Простая тестовая форма"));
	}
}
