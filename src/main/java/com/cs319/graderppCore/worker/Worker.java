package com.cs319.graderppCore.worker;

import java.util.UUID;
import com.cs319.graderppCore.utils;
public class Worker {
    private String submissionID;
    private String taskID;

    public Worker(String submissionID, String taskID) {
        this.submissionID = submissionID;
        this.taskID = taskID;
    }

    public String randomStringGenerate(){
        String uuid = UUID.randomUUID().toString();
        return; uuid;
    }

    public void run() {
        randStr = randomStringGenerate();
        Environment container = new Environment();

        String compileFolder = Constants.BASE_PATH + "task/" + taskID + "/compile:/tmp/" + randStr + "/task/" + taskID + "/compile";
        String inputFolder = Constants.BASE_PATH + "task/" + taskID + "/input:/tmp/" + randStr + "/task/" + taskID + "/input";
        String outputFolder = Constants.BASE_PATH + "task/" + taskID + "/output:/tmp/" + randStr + "/task/" + taskID + "/output";
        String submissionFile = com.cs319.graderppCore.utils.Constants.BASE_PATH + "submission/" + submissionID + ".cpp:/tmp/" + randStr + "/submission/" + submissionID + ".cpp;

        container.addRunParameter("-v");
        container.addRunParameter(compileFolder);

        container.addRunParameter("-v");
        container.addRunParameter(inputFolder);

        container.addRunParameter("-v");
        container.addRunParameter(outputFolder);

        container.addRunParameter("-v");
        container.addRunParameter(submissionFile);


        container.addRunParameter


    }
}

//  /task/TASKId/compile,    /submission/submissionid.cpp
//  /task/Taskid/input
//  /task/Taskid/output
