package com.cs319.graderppCore.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;

/**
 * Created by reink on 12/7/15.
 */
@Path("task")
public class Task {
    private static final String SERVER_UPLOAD_LOCATION_FOLDER = "/home/reink/cs319/test/";

    @POST
    @Path("{taskID}/compile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadCompileFiles(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file")FormDataContentDisposition dispHandler,
            @PathParam("taskID") String taskID) {
        String location = SERVER_UPLOAD_LOCATION_FOLDER + "task/" + taskID + "/compile/" + dispHandler.getFileName();
        saveFile(inputStream, location);

        return "yarrak";
    }

    // save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream,
                          String serverLocation) {

        File f = new File(serverLocation);
        f.mkdirs();
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
