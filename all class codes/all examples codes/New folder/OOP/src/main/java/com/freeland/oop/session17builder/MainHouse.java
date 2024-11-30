package com.freeland.oop.session17builder;

//Main.java
public class MainHouse {
 public static void main(String[] args) {
         House validHouse = 
        		 new House.Builder()
        		 			.area(150)
        		 			.location("Tehran")
        		 			.name("Family Home")
        		 			.postalCode("123456")
        		 			.build();

         House invalidHouse = new House.Builder()
	                 .area(10)
	                 .location("") // This will trigger validation
	                 .name("Invalid House")
	                 .postalCode("234237")
	                 .build();

//         Http2ClientConfig config = new Http2ClientConfig.Builder()
//                 .maxConnections(20)
//                 .timeout(3000)
//                 .enableLogging(true)
//                 .userAgent("CustomHttp2Client/1.0")
//                 .proxy("proxy.example.com", 8080)
//				   .readTimeout(12000)        
//                 .build();
 }
}