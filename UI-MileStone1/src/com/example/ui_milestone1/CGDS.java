/**
 * 
 */
package com.example.ui_milestone1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.vaadin.addon.timeline.Timeline;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;


/**
 * @author Junaid
 *
 */
public class CGDS {

	/**
	 * Creates a marker container with a marker for each seven days    
	 * @return 
	 */
	
	

	
	
	
	public Container.Indexed createMarkerDataSource(){
	        
	    // Create the container
	    Container.Indexed container = new IndexedContainer();
	        
	    // Add the required property IDs (use the default ones here)
	    container.addContainerProperty(Timeline.PropertyId.TIMESTAMP,
	            Date.class, null);
	    container.addContainerProperty(Timeline.PropertyId.CAPTION, 
	            String.class, "Our marker symbol");
	    container.addContainerProperty(Timeline.PropertyId.VALUE, 
	            String.class, "Our description");
	        
	    // Add a marker for every seven days
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MONTH, -1);
	    Date today = new Date();
	    SimpleDateFormat formatter =
	            new SimpleDateFormat("EEE, MMM d, ''yy");
	    while(cal.getTime().before(today)){
	        // Create a point in time
	        Item item = container.addItem(cal.getTime());
	        
	        // Set the timestamp property
	        item.getItemProperty(Timeline.PropertyId.TIMESTAMP)
	                .setValue(cal.getTime());
	        
	        // Set the caption property
	        item.getItemProperty(Timeline.PropertyId.CAPTION)
	                .setValue("M");
	            
	        // Set the value property
	        item.getItemProperty(Timeline.PropertyId.VALUE).
	           setValue("Today is "+formatter.format(cal.getTime()));

	        cal.add(Calendar.DAY_OF_MONTH, 7);
	    }
	    
	    return container;        
	}




	/**
	 * Creates a event container with a marker for each sunday
	 */
	public Container.Indexed createEventDataSource(){
			
		// Create the container
		Container.Indexed container = new IndexedContainer();
		
		// Add the required property IDs (use the default ones here)
		container.addContainerProperty(Timeline.PropertyId.TIMESTAMP,
			Date.class, null);
		container.addContainerProperty(Timeline.PropertyId.CAPTION, 
			String.class, "Our marker symbol");
				
		// Add a marker for every seven days
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date today = new Date();		
		while(cal.getTime().before(today)){
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				// Create a point in time
				Item item = container.addItem(cal.getTime());
					
				// Set the timestamp property
				item.getItemProperty(Timeline.PropertyId.TIMESTAMP)
	                .setValue(cal.getTime());
	 
	 // Set the caption property
	 item.getItemProperty(Timeline.PropertyId.CAPTION)
	 .setValue("Sunday");			
	 }			
	 cal.add(Calendar.DAY_OF_MONTH, 1);
	 }
	 
	 return container;		
	}


	
	
	
	public Container.Indexed createGraphDataSource(){
        
	    // Create the container
	    Container.Indexed container = new IndexedContainer();
	        
	    // Add the required property ids (use the default ones here)
	    container.addContainerProperty(Timeline.PropertyId.TIMESTAMP, 
	        Date.class, null);
	    container.addContainerProperty(Timeline.PropertyId.VALUE, 
	        Float.class, 0f);
	        
	    // Add some random data to the container
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MONTH, -1);
	    Date today = new Date();
	    Random generator = new Random();
	        
	    while(cal.getTime().before(today)){
	        // Create  a point in time
	        Item item = container.addItem(cal.getTime());
	            
	        // Set the timestamp property
	        item.getItemProperty(Timeline.PropertyId.TIMESTAMP)
	            .setValue(cal.getTime());
	            
	        // Set the value property
	        item.getItemProperty(Timeline.PropertyId.VALUE)
	            .setValue(generator.nextFloat());
	        
	        cal.add(Calendar.MINUTE, 1);            
	    }
	        
	    return container;        
	}
	
}
