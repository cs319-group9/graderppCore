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

        String compileFolder = Constants.BASE_PATH + "task/" + taskID + "/compile:/tmp/compile";
        String inputFolder = Constants.BASE_PATH + "task/" + taskID + "/input:/tmp/input";
        String outputFolder = Constants.BASE_PATH + "task/" + taskID + "/output:/tmp/output";
        String submissionFile = Constants.BASE_PATH + "submission/code.cpp:/tmp/submission/code.cpp";
        String shellFile = Constants.BASE_PATH + "helper/run.sh:/dropzone/run.sh";
        String libPyFile = Constants.BASE_PATH + "helper/lib.py:/dropzone/lib.py";

        container.addRunParameter("-v");
        container.addRunParameter(compileFolder);

        container.addRunParameter("-v");
        container.addRunParameter(inputFolder);

        container.addRunParameter("-v");
        container.addRunParameter(outputFolder);

        container.addRunParameter("-v");
        container.addRunParameter(submissionFile);
        container.addRunParameter("-v");
        container.addRunParameter(shellFile);
        container.addRunParameter("-v");
        container.addRunParameter(libPyFile);

        container.addRunParameter("-w");
        container.addRunParameter("/dropzone");


        container.addRunParameter("amatem/graderpp");
        container.addRunParameter("sh");
        container.addRunParameter("run.sh");


    }
}

//  /task/TASKId/compile,    /submission/submissionid.cpp
//  /task/Taskid/input
//  /task/Taskid/output
