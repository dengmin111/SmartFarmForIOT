package com.nuc.controller;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuc.SerialToInternet.SerialTool;
import com.nuc.SerialToInternet.StartListen;
import com.nuc.pojo.Setting;
import com.nuc.service.SettingService;

import gnu.io.SerialPort;

@Controller
public class SettingController {
@Autowired
SettingService settingService;

@RequestMapping("set")
@ResponseBody
public int set(@RequestBody Setting setting){
	return settingService.updateByPrimaryKeySelective(setting);
}

@RequestMapping("controller")
@ResponseBody
public String controller(int temp,String statusCode ,int status ){
	System.out.println(temp+"stausCode"+statusCode+"status:"+status);
	
	String s = statusCode;
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
	//SerialPort a = SerialTool.openPort("COM3", 115200);
	SerialTool.sendToPort(StartListen.a, data);
	//a.close();
	System.out.println("端口已关闭");
	return DatatypeConverter.printHexBinary(data);
}
public static String change(String s,int a,int status){
	int b,c;
	System.out.println(s);
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

