package applic;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalSplitPanel;

public class BasicCrudView<T> extends AbsoluteLayout implements
Property.ValueChangeListener, Handler, ClickListener {

	private static final long serialVersionUID = -5192296686882906063L;

	private JPAContainer<T> container;
	private Table table;
	private FieldFactory fieldFactory;
	private Class<T> entityClass;
	private Button commit;
	private Button discard;
	private Object[] formPropertyIds;
	private Button addButton;
	private Button deleteButton;
	private Panel panel;
	private final String persistenceUnit;
	
	public BasicCrudView(Class<T> entityClass,final String persistenceUnit) {
		this.entityClass = entityClass;
		this.persistenceUnit = persistenceUnit;
		setSizeFull();
		initContainer();
		initFieldFactory();
		buildView();
		
	}
	
	protected void buildView() {
		setSizeFull();
		panel = new Panel(getCaption());
		panel.setSizeFull();
		addComponent(panel);
		
		VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
		verticalSplitPanel.setSizeFull();
		
		table.setSizeFull();
		table.setSelectable(true);
		//table.; - добавить листнеры и прочее
		
		verticalSplitPanel.addComponent(table);
		
	}

	private void initFieldFactory() {
		fieldFactory = new FieldFactory();
		//fieldFactory.setVisibleProperties(containerType, propertyIdentifiers);
		
	}

	private void initContainer() {
		container = JPAContainerFactory.make(getEntityClass(), persistenceUnit);
		table = new Table(null,container);
		
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
