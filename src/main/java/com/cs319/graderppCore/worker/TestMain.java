package com.cs319.graderppCore.worker;

import java.io.IOException;

/**
 * Created by reink on 12/8/15.
 */
public class TestMain {
    public static void main(String argsp[]) throws IOException {
        Worker w = new Worker("1", "1");
        w.run();
    }
}
