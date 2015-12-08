package com.cs319.graderppCore.api;

import com.cs319.graderppCore.utils.Constants;
import com.cs319.graderppCore.utils.Util;
import com.cs319.graderppCore.worker.WorkerQueue;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import java.io.File;
import java.io.InputStream;
import javax.ws.rs.core.MediaType;

/**
 * Created by reink on 12/7/15.
 */
@Path("submit/{submissionID}/{taskID}")
public class Submission {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadSubmission(
            @PathParam("submissionID") String submissionID,
            @PathParam("taskID") String taskID,
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file") ContentDisposition dispHandler){
        String folder = Constants.BASE_PATH + "submissions/";
        File f = new File(folder);
        f.mkdirs();
        Util.saveFile(inputStream, folder + submissionID + ".cpp");
        WorkerQueue.getInstance().AddWorker(submissionID, taskID);
        return "";
    }
}
