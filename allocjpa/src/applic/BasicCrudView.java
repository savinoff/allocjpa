package applic;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.spc.domain.Person;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.client.ui.layout.Margins;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.VerticalSplitPanel;

public class BasicCrudView<T> extends VerticalLayout implements
		Property.ValueChangeListener, Handler, ClickListener {

	private static final long serialVersionUID = -5192296686882906063L;

	private JPAContainer<T> container;
	private Table table;
	private FieldGroup fieldGroup;
	private FieldFactory fieldFactory;
	//FieldGroupFieldFactory fieldFactory;
	private FormLayout form;
	private Class<T> entityClass;
	private Button commit;
	private Button discard;
	private Object[] formPropertyIds;
	private Button addButton;
	private Button deleteButton;
	private Panel panel;
	private final String persistenceUnit;

	public BasicCrudView(Class<T> entityClass, final String persistenceUnit) {
		this.entityClass = entityClass;
		this.persistenceUnit = persistenceUnit;
		setSizeFull();
		System.out.println("SFS");
		initContainer();
	    initFieldFactory();
		buildView();
	}

	protected void buildView() {
		table.setSelectable(true);
		table.addValueChangeListener(this);
		table.setImmediate(true);
		table.addActionHandler(this);
		
		VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
		verticalSplitPanel.addComponent(table);
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		addButton = new Button("+", this);
		addButton.setDescription("Add new " + getEntityClass().getSimpleName());
		addButton.setStyleName(Reindeer.BUTTON_SMALL);
		horizontalLayout.addComponent(addButton);
		
		deleteButton = new Button("-", this);
		deleteButton.setDescription("Delete selected "
					+ getEntityClass().getSimpleName());
		deleteButton.setStyleName(Reindeer.BUTTON_SMALL);
		deleteButton.setEnabled(false);
		horizontalLayout.addComponent(deleteButton);
		addComponent(horizontalLayout);
		
		addComponent(verticalSplitPanel);
		setExpandRatio(verticalSplitPanel, 1.0f);
		
		fieldGroup = new FieldGroup();
//		fieldGroup.setVisible(false);
//		fieldGroup.setSizeUndefined();
		//formLayout form.setWriteThrough(false); ??
		
		//fieldGroup.setFieldFactory((FieldGroupFieldFactory) fieldFactory);
		form = new FormLayout();
		form.setCaption("Caption of Form");
		verticalSplitPanel.addComponent(form);
		//form.addComponent(fieldGroup.buildAndBind(propertyId));
		//fieldGroup.
	}

	private void initFieldFactory() {
		fieldFactory = new FieldFactory();
		//fieldFactory = new FieldGroupFieldFactory();
		// fieldFactory.setVisibleProperties(containerType,
		// propertyIdentifiers);

	}

	private void initContainer() {
		container = JPAContainerFactory.make(getEntityClass(), persistenceUnit);
		table = new Table(null, container);
		System.out.println("initContainer");
	}

	private Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public Action[] getActions(Object target, Object sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleAction(Action action, Object sender, Object target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
