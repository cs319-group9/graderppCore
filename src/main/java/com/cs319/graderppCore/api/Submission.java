package com.cs319.graderppCore.api;

import com.cs319.graderppCore.utils.Constants;
import com.cs319.graderppCore.utils.Util;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.activation.MimeType;
import javax.ws.rs.*;
import java.io.File;
import java.io.InputStream;

/**
 * Created by reink on 12/7/15.
 */
@Path("submit/{submissionID}")
public class Submission {

    @POST
    @Consumes(MimeType.MULTIPART_FORM_DATA)
    @Produces(MimeType.TEXT_PLAIN)
    public String uploadSubmission(
            @PathParam("submissionID") String submissionID,
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file") ContentDisposition dispHandler){
        String folder = Constants.BASE_PATH + "submissions/";
        File f = new File(folder);
        f.mkdirs();

        Util.saveFile(inputStream, folder + submissionID + ".cpp");
    }
}
