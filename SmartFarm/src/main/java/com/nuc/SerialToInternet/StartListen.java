package com.nuc.SerialToInternet;

import java.util.ArrayList;
import java.util.TooManyListenersException;

import gnu.io.SerialPort;

public class StartListen {
	//���쵥��ģʽ
	private static StartListen StartListen = null;
	public static SerialPort a;
		
	static {
		if (StartListen == null) {
			StartListen = new StartListen();
	    }
	}
	private StartListen(){}		
	public static StartListen getStartListen() {
	    if (StartListen == null) {
	    	StartListen = new StartListen();
	    }
	    return StartListen;
	}
	public static void startListen() {
		// TODO Auto-generated method stub
		ArrayList<String> protName = SerialTool.findPort();
		for( int i = 0 ;i<protName.size();i++){
			System.out.println(protName.get(i));
		}
		
			 a = SerialTool.openPort("COM3", 115200);
			
			try {
				
				SerialTool.addListener(a, new SerialListener(a));
			} catch (TooManyListenersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		

	 
}}
