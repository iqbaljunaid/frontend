/**
 * 
 */
package com.example.ui_milestone1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;

/**
 * @author Junaid Iqbal
 *
 */
public  class PopulatryFinder{


	protected String Fname;
	
	public PopulatryFinder() {
		// TODO Auto-generated constructor stub
					
	}
	
public String PopFileName(String s){
	
	Fname=s;
	
	return Fname;
	
}


public void PopParsefile () {
	
		String line;
	 try {
		BufferedReader br = new BufferedReader(new FileReader(Fname));
	 		
		try {
			while ((line = br.readLine()) != null)  
			{      
				String[] s = line.split("\t");
				System.out.println(s[0]);
			
			
			
			
			}
					} catch (IOException e) {   ///  readline catch
							// TODO Auto-generated catch block
						new Notification("Could not open file<br/>",
			                    e.getMessage(),
			                    Notification.Type.ERROR_MESSAGE)
			       .show(Page.getCurrent());	
						
						e.printStackTrace();
							}
	 
	 	} catch (FileNotFoundException e) { /// FileReader catch
		// TODO Auto-generated catch block
	 		new Notification("Could not open file<br/>",
                    e.getMessage(),
                    Notification.Type.ERROR_MESSAGE)
       .show(Page.getCurrent());
	 		e.printStackTrace();
	}  
    
	
	
}





}
