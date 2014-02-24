/**
 * 
 */
package com.example.ui_milestone1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

/**
 * @author jiqbal
 *
 */
class UploadReceiverChart implements Receiver, SucceededListener, FailedListener {
    private static final long serialVersionUID = -1276759102490466761L;
    
    
    public ListSeries series;
    
    public File file;
   String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
   
    
   
   
   
   
   
   
   public ListSeries getSeries() {
	return series;
}

public void setSeries(ListSeries series) {
	this.series = series;
}

public UploadReceiverChart(ListSeries series) {
	super();
	this.series = series;
	
}

public OutputStream receiveUpload(String filename, String mimeType) {
        // Create upload stream
        FileOutputStream fos = null; // Output stream to write to
        try {
            // Open the file for writing.
            
        	file = new File(basepath + filename);
        	
            fos = new FileOutputStream(file);
           
            
            //new Notification("Uploading File...", basepath, Notification.Type.ERROR_MESSAGE)
       //.show(Page.getCurrent());
        } catch (final java.io.FileNotFoundException e) {
        	new Notification("Could not open file<br/>",
                    e.getMessage(),
                    Notification.Type.ERROR_MESSAGE)
       .show(Page.getCurrent());
        	
        	//getWindow().showNotification(
            //        "Could not open file<br/>", e.getMessage(),
            //        Notification.TYPE_ERROR_MESSAGE);
            return null;
        }
        return fos; // Return the output stream to write to
    }

	@Override
	public void uploadSucceeded(SucceededEvent event) {
		// TODO Auto-generated method stub
		try {
			 BufferedReader br = new BufferedReader(new FileReader(basepath + event.getFilename()));  
		      String line;
		    
		      
		      try {
				while ((line = br.readLine()) != null)  
				        {      
				        	String[] s = line.split("\t");
				        			        	
				        series.addData(Float.parseFloat(s[1]), true, false);
				        		                        
				    	
				        	
				        }
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				
				System.out.println("Number formation error");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("I O exception");
				e.printStackTrace();
			} //while 
		       /////////////////
		      
		      
		 } // try 
			catch(FileNotFoundException e) { 
	            		new Notification("Failed to Upload File(first)."+event.getFilename(),e.getMessage(),
	            				Notification.Type.ERROR_MESSAGE)
	               .show(Page.getCurrent());
	            	
	            	} 	            	
	           
	
		new Notification("Chart data file Uploaded sucessfully",event.getFilename() +"Type :" + event.getMIMEType() ,
				Notification.Type.HUMANIZED_MESSAGE)
   .show(Page.getCurrent());
		
		
	}




	public void uploadFailed(FailedEvent event) {
		// TODO Auto-generated method stub
		
		new Notification("Failed to Upload File(Last)."+event.getFilename(), event.getReason().toString() ,
				Notification.Type.ERROR_MESSAGE)
   .show(Page.getCurrent());
		
		
	}

	


}// end class