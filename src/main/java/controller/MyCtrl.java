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
public class MyCtrl {


	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value = {"/one.req","/two.req","/home.req"},method = RequestMethod.GET)
	public String requests() {

		System.out.println("hahah");
		switch (request.getRequestURI()){

			case "/one.req":
				return "one";
			case "/two.req":
				return "two";
			case "/home.req":
				return "default";
			default:
				return "";
		}

	}


}
