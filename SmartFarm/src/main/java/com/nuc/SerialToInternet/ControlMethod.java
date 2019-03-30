package com.nuc.SerialToInternet;

import javax.xml.bind.DatatypeConverter;

import gnu.io.SerialPort;

public class ControlMethod {
	
	//port com口，temp第几盏灯，s，当前控制器返回的数据，status要改变的等的状态0灭1亮
		public static void Control(SerialPort port,int temp,String s,int status){
			String method = s;
			byte[] data = null;
			switch(temp){
				case 1:
					method=change(s,1,status);
					break;
				case 2:
					method=change(s,2,status);
					break;
				case 3:
					method=change(s,4,status);
					break;
				case 4:
					method=change(s,8,status);
					break;
			}
			data = DatatypeConverter.parseHexBinary(method);
			System.out.print(DatatypeConverter.printHexBinary(data));
			
			SerialTool.sendToPort(port, data);
		}
		public static String change(String s,int a,int status){
			int b,c;
			String res;
			String bs,cs;
			res = s.substring(0,s.length()-4);
			b = Integer.valueOf(s.substring(s.length()-4,s.length()-2),16);
			c = Integer.valueOf(s.substring(s.length()-2,s.length()),16);
			if(status == 1){
				b = b + a;
				c = c - a;
			}else{
				b = b - a;
				c = c + a;
			}
			bs = Integer.toHexString(b);
			cs = Integer.toHexString(c);
			res = res+"0"+bs+cs;
			System.out.println(bs);
			return res;
		}
	}
