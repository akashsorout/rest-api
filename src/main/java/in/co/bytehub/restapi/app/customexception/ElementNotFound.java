package in.co.bytehub.restapi.app.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="This Element is not present")
public class ElementNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementNotFound()  {
	
	}

}
