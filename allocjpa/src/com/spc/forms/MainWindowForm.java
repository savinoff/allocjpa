package com.spc.forms;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

public class MainWindowForm extends VerticalLayout implements View{

	private static final long serialVersionUID = 4194571697943213541L;

	private VerticalLayout headerLayout;
	private VerticalLayout bodyLayout;
	private TabSheet mainTabSheet;
	private HorizontalLayout footerLayout;
	private Embedded header_img;
	private MenuBar menuBar;
	private Label footerLabel;
	private ProgressBar progressBar;
	
	public MainWindowForm() {
		buildMainWindowForm();	
	}

	private void buildMainWindowForm() {
		// header
		headerLayout = new VerticalLayout();
		headerLayout.setImmediate(false);
		headerLayout.setWidth("100%");
		// header_img
		header_img = new Embedded();
		header_img.setImmediate(false);
		header_img.setWidth("100%");
		header_img.setHeight("80px");
		header_img.setSource(new ThemeResource("header.png"));
		header_img.setType(1);
		header_img.setMimeType("image/png");
		headerLayout.addComponent(header_img);
		// menu
		menuBar = new MenuBar();
		headerLayout.addComponent(menuBar);
		// body
		bodyLayout = new VerticalLayout();
		bodyLayout.setHeight("100%");
		bodyLayout.setWidth("100%");
		mainTabSheet = new TabSheet();
		bodyLayout.addComponent(mainTabSheet);
		// footer
		footerLayout = new HorizontalLayout();
		footerLabel = new Label();
		footerLabel.setCaption("2014-04-14 1-ая версия. Ожидаемая дата выхода приложения 10 мая 2014 года");
		footerLayout.addComponent(footerLabel);
		progressBar = new ProgressBar();
		footerLayout.addComponent(progressBar);	
		// соберём
		setHeight("100%");
		addComponent(headerLayout);
		addComponent(bodyLayout);
		addComponent(footerLayout);
		setExpandRatio(bodyLayout, 1.0f);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Переход в основную экран");
		
	}

	public VerticalLayout getBodyLayout() {
		return bodyLayout;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public Label getFooterLabel() {
		return footerLabel;
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}

	public TabSheet getMainTabSheet() {
		return mainTabSheet;
		
	}

}
