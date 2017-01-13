package com.text.Li;

import java.util.ArrayList;

public class Utils {
     public static User getUserBySessionId(ArrayList<User> userLists,String sessionId){
		User u = null;
		for(User user:userLists){
			String sId = user.getSessionId();
			if(sId !=null && sId.equals(sessionId)){
				u=user;
				break;
			}
		}
    	 return u;
		
    	 
     }
}
