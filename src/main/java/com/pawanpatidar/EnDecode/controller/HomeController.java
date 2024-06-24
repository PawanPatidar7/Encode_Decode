package com.pawanpatidar.EnDecode.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.pawanpatidar.EnDecode.services.EnDecodeService;



@Controller
public class HomeController {

	@Autowired
	private EnDecodeService enDecodeService;
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "Home Page");
		return "endeCode";
	}
	
	
	
	@PostMapping("/process")
	public  String processHandler(@RequestParam("inputText") String str,@RequestParam("action") String action,Model m) {
		String outputtext="";
		if("encode".equals(action)) {
			 outputtext =enDecodeService.encodeHandler(str);
		}
		else if("decode".equals(action)) {
			
			 try {
	               
				 outputtext = enDecodeService.decoderHandler(str);
	            } catch (IllegalArgumentException e) {
	                outputtext = "Invalid input for decoding";
	            }
			
			
		}
		
		 m.addAttribute("outputtext", outputtext);
		
		return "endeCode";
	}
	
	
}
