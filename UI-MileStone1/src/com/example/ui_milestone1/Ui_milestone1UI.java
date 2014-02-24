package com.example.ui_milestone1;

import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;



@SuppressWarnings("serial")
@Theme("chameleon")
//@Theme("ui_milestone1")
//@Theme("mch")
public class Ui_milestone1UI extends UI {
	
	public Navigator navigator;
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Ui_milestone1UI.class, widgetset = "com.example.ui_milestone1.widgetset.Ui_milestone1Widgetset")
	public static class Servlet extends VaadinServlet {
	}




 
    @Override
    protected void init(VaadinRequest request) {
       // getPage().setTitle("Navigation Example");
        
        // Create a navigator to control the views
    	navigator = new Navigator(this, this);
    	       
        // Create and register the views
    	 navigator.addView(MainView.VIEW_NAME, new MainView());
    	
    	navigator.addView(UserPatternView.VIEW_NAME, new UserPatternView());
        navigator.addView(RequestFileListView.VIEW_NAME, new RequestFileListView());
        navigator.addView(TimeLineChartView.VIEW_NAME ,new TimeLineChartView());
        navigator.navigateTo(MainView.VIEW_NAME);
       //navigator.addView(MAINVIEW, new MainView());
    }
	

}// main 






