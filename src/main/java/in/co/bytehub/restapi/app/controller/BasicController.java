package in.co.bytehub.restapi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BasicController {

	@RequestMapping("/")
 	@ResponseBody                     // We have use @Controller .. if we don't use @ResponseBody then mvc will try to find corresponding jsp for name 
	public String greet() {			// But, Now we told spring  that this String should be in Response Body 
		System.out.println("hi");
		return "<hr> <br>Welcome to my Page";
	}

}
