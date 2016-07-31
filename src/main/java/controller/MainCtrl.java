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

//		String path = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

//		System.out.println("the request url:"+s);
//		String s = request.getRequestURI();

		String s = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());

		if (s.equals("/one.req")) {
			return "one";
		} else if (s.equals("/two.req")) {
			return "two";
		} else if (s.equals("/home.req")) {
			return "default";
		} else if (s.equals("/poiTest.req")) {
			return "poiTest";
		} else {
			return "";
		}

	}


}
