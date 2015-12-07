package com.cs319.graderppCore.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by reink on 12/7/15.
 */
@Path("/hello")
public class HelloWorld {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        String path = System.getenv("HOME") + "/deneme/deneme.txt";
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Denemedeneme");
            bw.close();
        }
        catch(IOException ex) {
            return "Error writing to the file:\n" + ex.toString();
        }
        return "Hello world!";
    }
}