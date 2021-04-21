/**
 * 
 */
package com.duo.goodreads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author Matthew Mazzotta
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String homeController() {
		return "html/home";
	}
}