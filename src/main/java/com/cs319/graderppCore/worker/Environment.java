package com.cs319.graderppCore.worker


public class Environment{

    protected int memoryLimit, timeLimit;

    public Environment(int memoryLimit, int timeLimit) {

    }

    protected void runEvaluator () throws IOException {

        Runtime rt = Runtime.getRuntime();
        String[] commands = {"docker","run", "-v", "/home/scanozulku/workspace/cs319/localdropfolder:/dropzone", "-w", "/dropzone", "amatem/graderpp", "sh", "/dropzone/asd.sh"};

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
            System.out.println(s);
        }

        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }

    }
}