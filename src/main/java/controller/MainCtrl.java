package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2016/7/3 19:49
 */

@Controller
public class MainCtrl {


	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value = {"/one.req", "/two.req", "/home.req", "/poiTest.req"}, method = RequestMethod.GET)
	public String requests() {

		System.out.println("测试数据来的呀！@");

		String s = request.getRequestURI();
		if (s.equals("/one.req")) {
			return "one";
		} else if (s.equals("/two.req")) {
			return "two";
		} else if (s.equals("/home.req")) {
			System.out.println("homesdfsdfd");
			return "default";
		} else if (s.equals("/poiTest.req")) {
			return "poiTest";
		} else {
			return "";
		}

	}


}
