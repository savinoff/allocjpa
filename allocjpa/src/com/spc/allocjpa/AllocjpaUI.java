package com.spc.allocjpa;


import com.spc.forms.MWF;
import com.spc.forms.MainWindowForm;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("allocjpa")
public class AllocjpaUI extends UI {
	
	private MainWindowForm mainWindowForm;

	@Override
	protected void init(VaadinRequest request) {
		mainWindowForm = new MainWindowForm();
		setContent(mainWindowForm);
	}
	
	public static AllocjpaUI getCurrent() {
		return (AllocjpaUI) UI.getCurrent();
	}

	public MainWindowForm getMainWindowForm() {
		return mainWindowForm;
	}
}