package com.text.Li;

public class OnlineC {
	 private static long online = 0;
     public static long getOnline(){
		return online;
    	 
     }
     public static void raise(){
    	 online++;
     }
     public static void reduce(){
    	 online--;
     }
}
