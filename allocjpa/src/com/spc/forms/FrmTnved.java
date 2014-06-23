package com.spc.forms;

import com.spc.domain.Tnved;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class FrmTnved extends VerticalLayout{
	
	private static final long serialVersionUID = 8614338900936773139L;
	private String PERSISTENCE_UNIT = "allocjpa";

	public FrmTnved() {
		final TextField searchField = new TextField("Поиск");
		searchField.setImmediate(true);
		final JPAContainer<Tnved> tnved=JPAContainerFactory.make(Tnved.class, PERSISTENCE_UNIT);
		
		Filter filter = new SimpleStringFilter("tnname", searchField.getValue(), true, false);
		tnved.addContainerFilter(filter);
//		Filter filter = new SimpleStringFilter("tnname", "проч", true, false);
		
		Table tnvedTable = new Table("Справочник ТНВЭД", tnved);
		tnvedTable.setSizeFull();
		tnvedTable.setSelectable(true);
		tnvedTable.setMultiSelect(true);
		tnvedTable.setImmediate(true);
		
		searchField.addValueChangeListener (new Property.ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			public void valueChange(ValueChangeEvent event) {
		        // Assuming that the value type is a String
		        String value = (String) event.getProperty().getValue();
	
		        // Do something with the value
		        Notification.show("Value is: " + value);
		        tnved.removeContainerFilter(tnved.getFilters().get(0));
		        Filter filter = new SimpleStringFilter("tnname", searchField.getValue(), true, false);
				tnved.addContainerFilter(filter);
		        tnved.applyFilters();
		        
		    };
		}
		);
		
		
		addComponent(searchField);
		addComponent(tnvedTable);
				
	}

}
