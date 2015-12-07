package com.cs319.graderppCore.utils;

import java.io.*;

/**
 * Created by reink on 12/7/15.
 */
public class Util {
    // save uploaded file to a defined location on the server
    public static void saveFile(InputStream uploadedInputStream,
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
