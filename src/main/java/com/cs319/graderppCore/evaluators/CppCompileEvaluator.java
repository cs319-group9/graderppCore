package com.cs319.graderppCore.evaluators;

import com.cs319.graderppCore.utils.IsolateOptions;

/**
 * Created by reink on 12/8/15.
 */
public class CppCompileEvaluator implements Evaluator{
    public CppCompileEvaluator() {

    }

    @Override
    public String evalute(IsolateOptions opts) {
        return "compile(" + opts.toPythonArgs() + ")\n";

    }
}
