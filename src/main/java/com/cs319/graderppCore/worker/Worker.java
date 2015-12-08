package com.cs319.graderppCore.worker;

import com.cs319.graderppCore.storage.MongoCoreBinder;
import com.cs319.graderppCore.utils.Constants;
import com.cs319.graderppCore.utils.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class Worker {
    private String submissionID;
    private String taskID;

    public Worker(String submissionID, String taskID) {
        this.submissionID = submissionID;
        this.taskID = taskID;
    }

    public void run() {
        MongoCoreBinder mongo = new MongoCoreBinder();
        Environment container = new Environment();

        String compileFolder = Constants.BASE_PATH + "task/" + taskID + "/compile:/tmp/compile";
        String inputFolder = Constants.BASE_PATH + "task/" + taskID + "/input:/tmp/input";
        String outputFolder = Constants.BASE_PATH + "task/" + taskID + "/output:/tmp/output";
        String submissionFile = Constants.BASE_PATH + "submissions/"+submissionID+".cpp:/tmp/submission/kod.cpp";

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
        int testCaseNum = mongo.getTestCaseNum(taskID);
        container.addRunParameter(Integer.toString(testCaseNum));
        try {
            container.runEvaluator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String out = container.getStdOutVal();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Result res = gson.fromJson(out, Result.class);
    }
}
