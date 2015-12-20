package com.brunozambiazi.ws.consumer;

import com.brunozambiazi.ws.publisher.HelloWebService;
import com.brunozambiazi.ws.publisher.HelloWebServiceService;

public class Consumer {

    public static void main(String[] args) {
        HelloWebServiceService service = new HelloWebServiceService();
        HelloWebService port = service.getHelloWebServicePort();
        port.print("First consumer!");
    }

}