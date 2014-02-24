/**
 * 
 */
package com.example.ui_milestone1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.Page;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;


/**
 * @author jiqbal
 *
 */
public class StreamTable extends Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7944908518630432378L;
	private BeanItemContainer<Stream> tableContainer = new
			BeanItemContainer<Stream>(Stream.class);
	public static final Object[] NATURAL_COL_ORDER = new Object[] {
		"Videoid","Duration","OverAllBitRate","VideoBitRate","Width","Height","ExpectedBitRate","FPS","Codec","Catagory","Url"};
	public int debugLimit = 500;
	//Table table = new Table();




public StreamTable() {
	
	addContainerProperty("videoid", 			String.class,  null);
	addContainerProperty("duration",  		Float.class,  null);
	addContainerProperty("bitrateoverall",   	Float.class, null);
	addContainerProperty("videobitrate", 		Float.class,  null);
	addContainerProperty("width",  			Float.class,  null);
	addContainerProperty("height",       		Float.class, null);
	addContainerProperty("tbr", 				Float.class,  null);
	addContainerProperty("fps",  		Float.class,  null);
	addContainerProperty("codec",       		String.class, null);
	addContainerProperty("catagory", 		String.class,  null);
	addContainerProperty("pop",  		Integer.class,  null);
	addContainerProperty("url",       		String.class, null);
	
	setColumnHeader("videoid", "Video ID");
	setColumnHeader("duration", "Duration");
	setColumnHeader("bitrateoverall", "Over All Bit Rate");
	setColumnHeader("videobitrate", "Video BitRate");
	setColumnHeader("width", "Width");
	setColumnHeader("height", "Height");
	setColumnHeader("tbr", "Expected BitRate");
	setColumnHeader("fps", "Frames/Sec");
	setColumnHeader("codec", "Codec");
	setColumnHeader("catagory", "Catagory");
	setColumnHeader("pop", "Popularity");
	setColumnHeader("url", "URL");


	
	

	
	
	//fillTableContainer(tableContainer, 10000);
	fillRequestTable ("D:/Browser/Download/streams.dat");
	setPageLength(20);
	setCacheRate(10);
	setSizeUndefined();
	setWidth("100%");
    //setHeight(-1);
    //setPageLength(0);
	
	//setContainerDataSource(tableContainer);
	
	// Allow selecting items from the table.
	setSelectable(true);

	// Send changes in selection immediately to server.
	setImmediate(true);

	// Shows feedback from selection.
	//final Label current = new Label("Selected: -");
	//setColumnHeaderMode(COLUMN_HEADER_MODE_EXPLICIT);
	// Handle selection change.
	//setEditable(true);
	//setColumnHeaders(columnHeaders);
	//setVisibleColumns(new Object[]{"Videoid","Duration","OverAllBitRate","VideoBitRate","Width","Height","ExpectedBitRate","FPS","Codec","Catagory","Url"});
	//this.setVisibleColumns(visibleColumns)
	 //setContainerDataSource(tableContainer

////////////////////////////////////////////////////////////////////////
final CheckBox switchEditable = new CheckBox("Editable");
switchEditable.addValueChangeListener(
new Property.ValueChangeListener() {

	public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {

setEditable(((Boolean)event.getProperty()
.getValue()).booleanValue());
}





});





}

	
private void fillRequestTable (String fileName ){
String line;
int k =0;


//////////For Data  table Headers ///////////////////////7
	
   
	
	
	
	//String inputFile = "/home/jiqbal/Downloads/data_format_header.txt";
    //String inputFile2 = "/home/jiqbal/Downloads/estimation.dat";  
    
/*try {  
   BufferedReader br = new BufferedReader(new FileReader(fileName));  
   
   while ((line = br.readLine()) != null)  
   {      
   	String[] s = line.split("\t");
   	for(int i=0;i<6;i++){
   		container.addContainerProperty(s[i], String.class,  null);	
   	
   	} 
                	
	}  

br.close();
}   

catch (FileNotFoundException a) {  
   System.out.println("Could not open file");  
   a.printStackTrace();  
}  
catch(IOException b){  
       System.out.println("IOException occured");  
       b.printStackTrace();  
}  
*/
//HashMap<String, Integer> videoMap = new HashMap<String, Integer>();   
HashMap<String, Integer> videoMap = new HashMap<String, Integer>(FindDup(fileName));

HashMap<String, Integer>  map = new HashMap<String, Integer>();
Iterator<String> keySetIterator = videoMap.keySet().iterator();
// setting all keys to 1 also they should appear in list once
while(keySetIterator.hasNext()){
  String key = keySetIterator.next();
  
  if (map.containsKey(key)) {
	  	 // Increase the count
		  // cache.put(videoid, cache.get(videoid) + 1);
	   }
	   else{
	  	 // Video is not in Hash Create it 
		   map.put(key, 1);
    //System.out.println("key: " + key + " value: " + map.get(key) + "Map Value :"+ videoMap.get(key));

	   	}
}





/////////////////////////////////////////  for Table data////////////////////////7
try {  
   BufferedReader br = new BufferedReader(new FileReader(fileName));  
   line = br.readLine();
   while ((line = br.readLine()) != null)  
     {      
	   String[] s = line.split("\t"); 
	   String videoid 		= s[0].toString();
		float duration 		= Float.parseFloat(s[1]);
		float bitRateOverall	= Float.parseFloat(s[2]);
		float videobitRate	= Float.parseFloat (s[3]);
		float width			= Float.parseFloat(s[4]);
		float height			= Float.parseFloat(s[5]);
		float expectedBitRate	= Float.parseFloat(s[6]);
		float fps				= Float.parseFloat(s[7]);
		String codec		= s[8].toString();
		String catagory		= s[9].toString();
		String url			= s[10].toString();
		int pop =0;
		
		//create a new hashmap for duplicate counting.
		
		
		
		if (map.containsKey(videoid)) {
			pop= (Integer) videoMap.get(videoid);
			addItem(new Object[]{videoid, duration,bitRateOverall,
					videobitRate, width, height, expectedBitRate,fps,
					codec, catagory, pop,url }, new Integer(k));
			
			/*container.addItem( new Stream(videoid, duration,bitRateOverall,
					videobitRate, width, height, expectedBitRate,fps,
					codec, catagory, url,pop));*/
				map.remove(videoid);
				k++;
									}
		
		
     //if (k++==debugLimit) break;
     }  

 br.close();
}   
catch (FileNotFoundException a) {  
								new Notification("Could not open datafile",
									a.getMessage(),
									Notification.Type.ERROR_MESSAGE)
								.show(Page.getCurrent());
	
								}  
catch(IOException b){  
	new Notification("IOException occured ",
					b.getMessage(),
           			Notification.Type.ERROR_MESSAGE)
					.show(Page.getCurrent());
		 
					}  
}


/*	private void fillTableContainer(
									BeanItemContainer<Stream> container, int count) {
									for (int i = 0; i < count; i++) {
									container.addItem( new Stream ());
}
}*/




private Item findItem(Container container) {
   for (Object itemId : container.getItemIds()) {
      //Item item = container.getItem(itemId);
      //Object propertyValue = item.getItemProperty(propertyId).getValue();
      System.out.println(container.getItem(itemId));
      
      // Do Null Checks Here
     // if(propertyValue.equals(value)){
     //   return item;
      //}
    }
    return null;
  }



private HashMap<String, Integer> FindDup (String fileName){
int j=0;
String videoid="",line="";
HashMap<String, Integer> cache = new HashMap<String, Integer>();

try {  
	   BufferedReader br = new BufferedReader(new FileReader(fileName));  
	   line = br.readLine();
	   while ((line = br.readLine()) != null)  
	     {      
		   String[] s = line.split("\t"); 
		   videoid 		= s[0].toString();
			
		 //checking if item exist
		   if (cache.containsKey(videoid)) {
		  	 // Increase the count
			   cache.put(videoid, cache.get(videoid) + 1);
		   }
		   else{
		  	 // Video is not in Hash Create it 
			   cache.put(videoid, 1);
		   }
// if (j++==debugLimit) break;
	     }  

	 br.close();
	}   
	catch (FileNotFoundException a) {  
									new Notification("Could not open datafile",
										a.getMessage(),
										Notification.Type.ERROR_MESSAGE)
									.show(Page.getCurrent());
		
									}  
	catch(IOException b){  
		new Notification("IOException occured ",
						b.getMessage(),
	           			Notification.Type.ERROR_MESSAGE)
						.show(Page.getCurrent());
			 
						}  
	





return cache;
}
/*

//increase key in hashmap 
map.put(key, map.get(key) + 1);
// to create a HashMap 
HashMap<String, Integer> cache = new HashMap<String, Integer>();

// adding item to Hashmap
map.put(21, "Twenty One");

//checking if item exist
map.containsKey(21));

*/


public List<String> GetAllItems(){
	final List<String> userList = new ArrayList<String>();
	String s;
	
	// Iterate over the item identifiers of the table.
	for (Iterator i = getItemIds().iterator(); i.hasNext();) {
	    // Get the current item identifier, which is an integer.
	    int iid = (Integer) i.next();
	    
	    // Now get the actual item from the table.
	    Item item = getItem(iid);
	    userList.add((String)(item.getItemProperty("Videoid").getValue()));
	}
	
return userList;


} 







} // Class ends here