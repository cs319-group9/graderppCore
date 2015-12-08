package com.cs319.graderppCore.worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Environment{

    private String stdOutVal ="", stdErrorVal="";
    private String[] commands = {"docker","run"};
    // "-v", "/home/scanozulku/workspace/cs319/localdropfolder:/dropzone", "-w", "/dropzone", "amatem/graderpp", "sh", };

    public void addRunParameter(String s){
        String[] newCommands = new String[commands.length + 1];
        for(int i=0; i<commands.length; i++){
            newCommands[i] = commands[i];
        }
        newCommands[commands.length] = s;
        commands = newCommands;
    }

    public String getStdOutVal() {
        return stdOutVal;
    }

    public String getStdErrorVal() {
        return stdErrorVal;
    }

    protected void runEvaluator () throws IOException {

        Runtime rt = Runtime.getRuntime();

        Process proc = rt.exec(commands);

        //docker run --privileged -v /home/workspace/cs319/localdropfolder:/dropzone -w /dropzone amatem/graderpp ./asd.sh

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));


        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            //System.out.println(s);
            stdOutVal = stdOutVal + s + "\n";
        }

        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
            stdErrorVal = stdErrorVal + s + "\n";
        }
    }
}