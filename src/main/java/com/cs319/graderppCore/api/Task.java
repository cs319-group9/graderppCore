package com.cs319.graderppCore.api;

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
    private static final String SERVER_UPLOAD_LOCATION_FOLDER = "/home/reink/cs319/test/";

    @POST
    @Path("compile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadCompileFiles(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file")FormDataContentDisposition dispHandler,
            @PathParam("taskID") String taskID) {
        String location = SERVER_UPLOAD_LOCATION_FOLDER + "task/" + taskID + "/compile/";
        File f = new File(location);
        f.mkdirs();
        saveFile(inputStream, location + dispHandler.getFileName());

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
        String location = SERVER_UPLOAD_LOCATION_FOLDER + "task/" + taskID + "/input/";
        File f = new File(location);
        f.mkdirs();
        saveFile(inputStream, location + "inp" + inputID + ".txt");

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
        String location = SERVER_UPLOAD_LOCATION_FOLDER + "task/" + taskID + "/output/";
        File f = new File(location);
        f.mkdirs();
        saveFile(inputStream, location + "out" + outputID + ".txt");

        return "";
    }

    // save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream,
                          String serverLocation) {

        File f = new File(serverLocation);
        try {
            OutputStream outpuStream = new FileOutputStream(f);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }
            outpuStream.flush();
            outpuStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

