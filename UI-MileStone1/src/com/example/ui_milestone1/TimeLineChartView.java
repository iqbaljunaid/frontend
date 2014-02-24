package com.example.ui_milestone1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.github.wolfie.refresher.Refresher;
import com.github.wolfie.refresher.Refresher.RefreshListener;
import com.vaadin.addon.timeline.Timeline;
import com.vaadin.addon.timeline.Timeline.EventButtonClickEvent;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;


public class TimeLineChartView extends VerticalLayout implements View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "TimeLineChartView";
	public CGDS CGDS = new CGDS();
	public  Container.Indexed graphDS  = CGDS.createGraphDataSource();
	public Calendar cal = Calendar.getInstance();
	
	
	
	
	
	
	
	public TimeLineChartView() {
		super();
	
	Timeline timeline = new Timeline("Our timeline");
	timeline.setWidth("100%");
	timeline.setHeight("480px");
	
timeline.addGraphDataSource(CGDS.createGraphDataSource(), 
            Timeline.PropertyId.TIMESTAMP,
            Timeline.PropertyId.VALUE);

timeline.setMarkerDataSource(CGDS.createMarkerDataSource(), 
            Timeline.PropertyId.TIMESTAMP, 
            Timeline.PropertyId.CAPTION, 
            Timeline.PropertyId.VALUE);

timeline.setEventDataSource(CGDS.createEventDataSource(), 
            Timeline.PropertyId.TIMESTAMP,     
            Timeline.PropertyId.CAPTION);
	
	
//public Container.Indexed graphDS  = CGDS.createGraphDataSource();
Container.Indexed markerDS = CGDS.createMarkerDataSource();
final Container.Indexed eventDS  = CGDS.createEventDataSource();

  
//Add our data sources
timeline.addGraphDataSource(graphDS, 
                          Timeline.PropertyId.TIMESTAMP,
                          Timeline.PropertyId.VALUE);
timeline.setMarkerDataSource(markerDS, 
                           Timeline.PropertyId.TIMESTAMP,
                           Timeline.PropertyId.CAPTION,     
                           Timeline.PropertyId.VALUE);
timeline.setEventDataSource(eventDS, 
                          Timeline.PropertyId.TIMESTAMP,
                          Timeline.PropertyId.CAPTION);
//Set the caption of the graph
//timeline.setGraphFillColor(graphDS, new Color(255,0,0,128));

//Add some zoom levels
timeline.addZoomLevel("Milisecond", 1L);
timeline.addZoomLevel("Second", 1000L);
timeline.addZoomLevel("Minute", 60000L);
timeline.addZoomLevel("Hour", 3600000L);
timeline.addZoomLevel("Day", 86400000L);
timeline.addZoomLevel("Week", 7 * 86400000L);
timeline.addZoomLevel("Month", 2629743830L);
timeline.addZoomLevel("Year", 12 *2629743830L);
timeline.addZoomLevel("5 Year", 5*12 *2629743830L);
//Set the color of the browser graph
	
//Listen to click events from events
timeline.addListener(new Timeline.EventClickListener() {
@Override
public void eventClick(EventButtonClickEvent event) {
   Item item = eventDS.getItem(event.getItemIds()
                              .iterator().next());
   Date sunday = (Date) item.getItemProperty(
                 Timeline.PropertyId.TIMESTAMP).getValue();
   SimpleDateFormat formatter =
       new SimpleDateFormat("EEE, MMM d, ''yy");
  
   Notification.show(formatter.format(sunday));
}        
});
	
	
Refresher refresher = new Refresher();
refresher.setRefreshInterval(0000);
refresher.addListener(new RefreshListener(){
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void refresh(Refresher source) {
       
    	Item item =graphDS.addItem(cal.getTime());
        
        // Set the timestamp property
        item.getItemProperty(Timeline.PropertyId.TIMESTAMP)
            .setValue(cal.getTime());
            
        // Set the value property
        item.getItemProperty(Timeline.PropertyId.VALUE)
            .setValue(new Random().nextFloat());
        
        cal.add(Calendar.MINUTE,5);
        //cal.add(Calendar.DAY_OF_MONTH, 1);            
    	
    	
    }
});


addExtension(refresher);
addComponent(timeline);


	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}



}
