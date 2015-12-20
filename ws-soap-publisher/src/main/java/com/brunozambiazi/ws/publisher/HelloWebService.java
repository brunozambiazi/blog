package com.brunozambiazi.ws.publisher;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HelloWebService {

    @WebMethod
    public void print(@WebParam String something) {
        System.out.format("Printing '%s'", something);
    }

}