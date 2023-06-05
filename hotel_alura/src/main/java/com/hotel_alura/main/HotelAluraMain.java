package com.hotel_alura.main;



import javax.swing.JFrame;


import com.hotel_alura.views.HuespedesFrame;
import com.hotel_alura.views.ReservasView;
import com.hotel_alura.views.Login;


public class HotelAluraMain {

	public static void main(String[] args) {
		
		
		/*HuespedesFrame huespedesFrame =new HuespedesFrame();
		huespedesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		huespedesFrame.setVisible(true);*/
		
		
		
		
		/*ReservasView reservasView =new ReservasView();
		reservasView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reservasView.setVisible(true);*/
		
		Login login = new Login();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);		
		
		

	}

}
