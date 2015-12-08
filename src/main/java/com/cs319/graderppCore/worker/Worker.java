package com.cs319.graderppCore.worker;

import java.util.UUID;
import com.cs319.graderppCore.utils.Constants;

public class Worker {
    private String submissionID;
    private String taskID;

    public Worker(String submissionID, String taskID) {
        this.submissionID = submissionID;
        this.taskID = taskID;
    }

    public void run() {
        Environment container = new Environment();

        String compileFolder = Constants.BASE_PATH + "task/" + taskID + "/compile:/tmp/compile";
        String inputFolder = Constants.BASE_PATH + "task/" + taskID + "/input:/tmp/input";
        String outputFolder = Constants.BASE_PATH + "task/" + taskID + "/output:/tmp/output";
        String submissionFile = Constants.BASE_PATH + "submission/kod.cpp:/tmp/submission/kod.cpp";

        container.addRunParameter("-v");
        container.addRunParameter(compileFolder);

        container.addRunParameter("-v");
        container.addRunParameter(inputFolder);

        container.addRunParameter("-v");
        container.addRunParameter(outputFolder);

        container.addRunParameter("-v");
        container.addRunParameter(submissionFile);

        container.addRunParameter("amatem/graderpp");
        container.addRunParameter("python");
        container.addRunParameter("run.py");
    }
}
