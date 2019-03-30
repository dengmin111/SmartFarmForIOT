package com.nuc.init;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuc.SerialToInternet.StartListen;
import com.nuc.service.UserService;

@Component
public class Init implements Filter{

        @Autowired
	    UserService userService;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	    // TODO Auto-generated method stub
try {
	StartListen.startListen();
} catch (NullPointerException e) {
System.out.println("未找到硬件设备");	
e.printStackTrace();
}
// new Thread(){public void run() {while(true){
//	 List<User> list = userService.list();
//	 for (User user : list) {
//		System.out.println(user);
//	}
//	 
//	 try {
//		Thread.sleep(2000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
// }
// };}.start();

	}

}
