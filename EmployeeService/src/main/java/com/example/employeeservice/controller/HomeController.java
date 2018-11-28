package com.example.employeeservice.controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.example.employeeservice.services.LoginService;
import com.example.employeeservice.services.employeeservice;
import com.examples.employeeservice.employees.employees;

@Controller
public class HomeController {
	@Autowired
    LoginService service;
	@Autowired
	private employeeservice empservice;
		
	
	private List<String> allTweets = new ArrayList<>();
	
	@RequestMapping(value="/pas", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "pas";
    }
	
	 @RequestMapping(value="/pas", method = RequestMethod.POST)
	    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
	        boolean isValidUser = service.validateUser(name, password);
	        if (!isValidUser) {
	            model.put("errorMessage", "Invalid Credentials");
	            return "pas";
	        }
	        model.put("name", name);
	        model.put("password", password);
	        return "welcome";
	    }
	 
	 	
		@RequestMapping(value="/dashboard", method = RequestMethod.GET)
		//@ResponseBody
	    public String showDashBoard(ModelMap model){
			List<employees> emps = empservice.getallemps();
			model.addAttribute("employees", emps);
			model.addAttribute("tweets", allTweets);
	        return "dashboard";
	    }
		@RequestMapping(value="/dashboard2", method = RequestMethod.GET)
		//@ResponseBody
	    public String showDashBoard2(ModelMap model){
			model.addAttribute("tweets", allTweets);
	        return "dashboard2";
	    }
		
		@RequestMapping(value="/emp/{id}", method = RequestMethod.GET)
		//@ResponseBody
	    public String showEmployee(@PathVariable String id, ModelMap model){
			employees emp = empservice.getemp(id);
			model.addAttribute("employee", emp);
	        return "empdetail";
	    }
		
		
		@RequestMapping(value="/gettweets", method = RequestMethod.GET)
		@ResponseBody
	    public String test2(ModelMap model){
			System.out.println("over here");
			DatagramSocket clientSocket = null;
			try { clientSocket = new DatagramSocket(4000);
		          
	            byte[] buffer = new byte[1000];

	            //clientSocket.setSoTimeout(3000);
	                DatagramPacket datagramPacket = new DatagramPacket(buffer,0, buffer.length);
	                clientSocket.receive(datagramPacket);

	                String receivedMessage = new String(datagramPacket.getData());
	                System.out.println(receivedMessage);
	                allTweets.add(receivedMessage.trim());
	                clientSocket.close();
	            
	        } catch (SocketException e) {
	            e.printStackTrace();
	        } catch (SocketTimeoutException e) {
	        	clientSocket.close();
	        } catch (IOException e) {
	            System.out.println("Timeout. Client is closing.");
	            
	        }
							
	        return "test2";
	    }
		
		
		
}
