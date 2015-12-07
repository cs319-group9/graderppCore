package com.cs319.graderppCore.api;

import com.cs319.graderppCore.utils.Constants;
import com.cs319.graderppCore.utils.Util;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;

/**
 * Created by reink on 12/7/15.
 */
@Path("task/{taskID}")
public class Task {

    @POST
    @Path("compile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadCompileFiles(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file")FormDataContentDisposition dispHandler,
            @PathParam("taskID") String taskID) {
        String location = Constants.BASE_PATH + "task/" + taskID + "/compile/";
        File f = new File(location);
        f.mkdirs();
        Util.saveFile(inputStream, location + dispHandler.getFileName());

        return "";
    }

    @POST
    @Path("input/{inputID}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadInput(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file")FormDataContentDisposition dispHandler,
            @PathParam("taskID") String taskID,
            @PathParam("inputID") String inputID) {
        String location = Constants.BASE_PATH + "task/" + taskID + "/input/";
        File f = new File(location);
        f.mkdirs();
        Util.saveFile(inputStream, location + "inp" + inputID + ".txt");

        return "";
    }


    @POST
    @Path("output/{outputID}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadOutput(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file")FormDataContentDisposition dispHandler,
            @PathParam("taskID") String taskID,
            @PathParam("outputID") String outputID) {
        String location = Constants.BASE_PATH + "task/" + taskID + "/output/";
        File f = new File(location);
        f.mkdirs();
        Util.saveFile(inputStream, location + "out" + outputID + ".txt");

        return "";
    }
}

