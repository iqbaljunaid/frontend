/**
 * 
 */
package com.example.ui_milestone1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.ChartClickEvent;
import com.vaadin.addon.charts.ChartClickListener;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * @author jiqbal
 *
 */

public class UserPatternView  extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "UserPatternView";
	public UserPatternView(){
		
	final  ListSeries series = new ListSeries(29.9, 71.5);
	
	UploadReceiverChart URCHART = new UploadReceiverChart(series);
	Upload upload1 = new Upload("Upload User Pattern", URCHART);
	
	final Configuration configuration = new Configuration();
    configuration.getChart().setType(ChartType.SPLINE);
    configuration.getTitle().setText("User supplied Request Pattern ");
    configuration.fireAnimationChanged(true);
    configuration.getSubTitle().setText("Click the plot area to add a point.");
    configuration.setSeries(series);

    final Chart chart = new Chart();
    chart.setId("chart");
    chart.setHeight("720px");
    chart.setWidth("100%");
    
    
    chart.setConfiguration(configuration);
    chart.drawChart(configuration);
    
    chart.addChartClickListener(new ChartClickListener() {
        @Override
        public void onClick(ChartClickEvent event) {
        	double getyAxisValue = event.getyAxisValue();
            series.addData(getyAxisValue);
            //lastAction.setValue("Added point : "+ getyAxisValue);
        }
    });
	
	
	
	
	
	
	final	 String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
	final Button saveExcel = new Button("Save Chart Data");
	java.util.Date date= new java.util.Date();
	final Resource res = new FileResource(new File(basepath +"/chartdata"+ new Timestamp(date.getTime())+".txt"));
    
	final FileDownloader fd = new FileDownloader(res);
	fd.extend(saveExcel);
	

	
	
	saveExcel.addClickListener(new Button.ClickListener() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void buttonClick(ClickEvent event) {
			
			try {
				
				PrintWriter out = new PrintWriter(basepath+"/chartdata.txt");
								
				Number[] chartdata = series.getData();
				
				for (int k=0; k < chartdata.length; k++){
					out.println(k +"\t"+ chartdata[k]);
				}
				
				out.close();
				
				Resource res1 = new FileResource(new File(basepath +"/chartdata.txt"));
						
				fd.setFileDownloadResource(res1);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				new Notification("Could not Dowload  file/>",
	                    e.getMessage(),
	                    Notification.Type.ERROR_MESSAGE)
	       .show(Page.getCurrent());
				
			}
		}
	});
	
	upload1.addSucceededListener(URCHART);
	upload1.addFailedListener(URCHART);
	
	
	addComponent(chart);
	addComponent(upload1);
	addComponent(saveExcel);
	
	
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}