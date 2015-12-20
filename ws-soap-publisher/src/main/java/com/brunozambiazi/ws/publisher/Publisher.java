package com.brunozambiazi.ws.publisher;

import javax.xml.ws.Endpoint;

public class Publisher {

    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        System.out.println("Publishing service...");
        Endpoint.publish("http://localhost:8080/helloWebService", new HelloWebService());
    }

}