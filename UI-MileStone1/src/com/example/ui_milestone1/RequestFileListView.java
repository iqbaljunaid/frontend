/**
 * 
 */
package com.example.ui_milestone1;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.addon.tableexport.CsvExport;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ListSelect;

/**
 * @author jiqbal
 *
 */

public class RequestFileListView extends VerticalLayout implements View {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static final String VIEW_NAME = "RequestFileListView";
public RequestFileListView() {
	// TODO Auto-generated constructor stub

	
final Button exportCSV = new Button("Export as CSV");
final Button DumpValue = new Button("Dump Values");
final StreamTable streamtable = new StreamTable();
final CheckBox switchEditable = new CheckBox("Edit Table");
final ListSelect listselect = new ListSelect("GetAllValues");


switchEditable.addValueChangeListener(
	        new Property.ValueChangeListener() {
	    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

		public void valueChange(ValueChangeEvent event) {
	        streamtable.setEditable(((Boolean)event.getProperty()
	                             .getValue()).booleanValue());
	    }
	});
	switchEditable.setImmediate(true);
	
	
	
	
	exportCSV.addClickListener(new Button.ClickListener() {
		 
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
	   public void buttonClick(ClickEvent event) {
	    	CsvExport cvsExport = new CsvExport(streamtable);
	    	java.util.Date date= new java.util.Date();
	    	
	    	cvsExport.setExportFileName("Streams"+new Timestamp(date.getTime())+".dat");
	    	
	    	cvsExport.export();
	    	
	    	}
	    });
	
	DumpValue.addClickListener(new Button.ClickListener() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
			
			//List<String> uList = streamtable.GetAllItems();
			 Iterator<Component> itr = streamtable.iterator();
		      while(itr.hasNext()) {
		         
		    	  listselect.addItem(itr.next());
		    	  itr.next();
		      }
			
		}
	});
	
	
	
addComponent(streamtable);
addComponent(switchEditable);
addComponent(exportCSV);
addComponent(DumpValue);
addComponent(listselect);	
	
	
	
	
	
}	
	
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
