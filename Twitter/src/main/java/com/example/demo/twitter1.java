package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class twitter1 {
	
	String data;
	
	

	public twitter1(String SearchString) {
		data = SearchString;
	}

	public QueryResult get() throws TwitterException  {
		// TODO Auto-generated method stub
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
						.setOAuthConsumerKey("iuh1dBIa8bXvOjBSRLpIF7e40")
						.setOAuthConsumerSecret("GAupJH5iFkWycp9r72dN44Tvd0pO14Tkoi4WSsoMt8dSN4GB3E")
						.setOAuthAccessToken("972273228046569473-4GTgsikGCKHXse3RxzTwqSUk23cEhe8")
						.setOAuthAccessTokenSecret("xctHGp1WG295EARuD7uWKuWJuAI9hgPxmDI0IxmK0ZtAI");

		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();

		 Query query = new Query(data);
		 List <String> results = new ArrayList<>();
		    QueryResult result = twitter.search(query);
		 /*  int count = 0 ;
		    for (Status stat : result.getTweets()) {
		    	count++;
		    	if (count <= 10) {
		       // System.out.println( count + " " +"@" + stat.getUser().getScreenName() + ": \n " + stat.getText());
		        results.add(count + " " +"@" + stat.getUser().getScreenName() + ": \n " + stat.getText());
		    	}
		    	else
		    		break;
		    }*/
		    return result;
		    
		    
	}
	
	public String getProfile() throws TwitterException  {
		// TODO Auto-generated method stub
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
						.setOAuthConsumerKey("iuh1dBIa8bXvOjBSRLpIF7e40")
						.setOAuthConsumerSecret("GAupJH5iFkWycp9r72dN44Tvd0pO14Tkoi4WSsoMt8dSN4GB3E")
						.setOAuthAccessToken("972273228046569473-4GTgsikGCKHXse3RxzTwqSUk23cEhe8")
						.setOAuthAccessTokenSecret("xctHGp1WG295EARuD7uWKuWJuAI9hgPxmDI0IxmK0ZtAI");

		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();

		//List<Status> status = twitter.getHomeTimeline();
		
		User user = twitter.showUser(data);
		
		return user.getFollowersCount() + " "+ user.getFriendsCount() + " "+ user.getLocation() + " "+ user.getDescription() + " "+ user.getScreenName();
				    
		    
	}
		
		public List<Status> getDetails() throws TwitterException{
			ConfigurationBuilder cb = new ConfigurationBuilder();
			
			cb.setDebugEnabled(true)
							.setOAuthConsumerKey("iuh1dBIa8bXvOjBSRLpIF7e40")
							.setOAuthConsumerSecret("GAupJH5iFkWycp9r72dN44Tvd0pO14Tkoi4WSsoMt8dSN4GB3E")
							.setOAuthAccessToken("972273228046569473-4GTgsikGCKHXse3RxzTwqSUk23cEhe8")
							.setOAuthAccessTokenSecret("xctHGp1WG295EARuD7uWKuWJuAI9hgPxmDI0IxmK0ZtAI");
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter4j.Twitter twitter = tf.getInstance();

			
			//List<Status> status = twitter.getHomeTimeline();
			List<Status> details = twitter.getUserTimeline(data);
				
			return details;
			
		}

}
