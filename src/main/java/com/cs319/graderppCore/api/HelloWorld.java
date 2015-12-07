package com.cs319.graderppCore.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by reink on 12/7/15.
 */
@Path("/hello")
public class HelloWorld {
    @GET
    public String yarrak() {
        return "dassak";
    }
}
