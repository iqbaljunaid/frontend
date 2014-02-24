/**
 * 
 */
package com.example.ui_milestone1;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;


import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
/**
 * @author jiqbal
 *
 */
public class OrdersView extends VerticalLayout implements View {
public static final String VIEW_NAME = "orders";
public OrdersView() {
Label lblOrders = new Label("New orders: ");
addComponent(lblOrders);
}



@Override
public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
	
}
}