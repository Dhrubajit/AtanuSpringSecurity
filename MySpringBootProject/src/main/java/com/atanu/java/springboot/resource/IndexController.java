/**
 * 
 */
package com.atanu.java.springboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Atanu Bhowmick
 *
 */

@RestController
public class IndexController implements ErrorController {
	private static final String PATH = "/error";

	@Autowired
	private Environment env;

	@Override
	public String getErrorPath() {
		return PATH;
	}

	@RequestMapping(value = PATH)
	public String getError() {
		String contextPath = env.getProperty("server.servlet.context-path");
		String swaggerUrl = contextPath + "/swagger-ui.html";
		return "Please go through the <a href='" + swaggerUrl
				+ "'>API doucumentation</a> and consume valid endpoint with proper Http method and Media type.";
	}
}
