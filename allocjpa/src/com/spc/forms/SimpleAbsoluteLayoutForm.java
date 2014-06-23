package com.spc.forms;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class SimpleAbsoluteLayoutForm extends AbsoluteLayout implements View{
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public SimpleAbsoluteLayoutForm() {
		// TODO Auto-generated constructor stub
		setWidth("100%");
		setHeight("200px");
		
		addComponent(new Label("Простая тестовая форма"),"top:10px;left:10px");
		
	}
}
