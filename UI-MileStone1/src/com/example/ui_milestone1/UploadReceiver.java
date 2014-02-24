package com.example.ui_milestone1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

class UploadReceiver implements Receiver, SucceededListener, FailedListener {
    private static final long serialVersionUID = -1276759102490466761L;

    public File file;
   String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
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
		
		
		
		new Notification("File Uploaded sucessfully",event.getFilename() +"Type :" + event.getMIMEType() ,
				Notification.Type.HUMANIZED_MESSAGE)
   .show(Page.getCurrent());
		
		
	}




	public void uploadFailed(FailedEvent event) {
		// TODO Auto-generated method stub
		
		new Notification("Failed to Upload File."+event.getFilename(), event.getReason().toString() ,
				Notification.Type.HUMANIZED_MESSAGE)
   .show(Page.getCurrent());
		
		
	}

	


}

