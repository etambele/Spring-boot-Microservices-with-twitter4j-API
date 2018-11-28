package com.example.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

@RestController
public class tweets {
	
	int gen = 0;
	
	@RequestMapping("/hello")
	public String sayhi() {
		return "hi";
	}
	
	
	@RequestMapping("/tweet")
	public String say() throws TwitterException {
		if(gen == 0) {
		port ob = new port();
		ob.start();
		}
		return "hi";
	}
	
	class port extends Thread{
		List<String> result = new ArrayList<>();
		public void run(){
			
			try {
				callMethod("i");
				
			} catch (TwitterException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		 public void callMethod(String myName) throws TwitterException  {
		    	twitter1 tweet = new twitter1(myName);
		    	QueryResult results = tweet.get();
		    	int count = 0 ;
		    	System.out.println("got here");
			    for (Status stat : results.getTweets()) {
			    	count++;
			    	if (count < 3) {			       
			    		result.add(stat.getText() );
			    			get(result.get(0).trim());
			    	
			    	}
			    	else
			    		break;
			    }
		    }
		 
		 public void get(String message) {			 
			 try (DatagramSocket serverSocket = new DatagramSocket(1000)) {
		            // The server will generate 3 messages and send them to the client
		                DatagramPacket datagramPacket = new DatagramPacket(
		                        message.getBytes(),
		                        message.length(),
		                        InetAddress.getLocalHost(),
		                        4000
		                );
		                serverSocket.send(datagramPacket);
		              //  System.out.println("---> "+lasttweet);
		                System.out.println(message);
		            serverSocket.close();
		        } catch (SocketException e) {
		            e.printStackTrace();
		        } catch (UnknownHostException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			 
		    }
	 
	}
	
	

}
