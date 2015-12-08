package com.cs319.graderppCore.evaluators;

import com.cs319.graderppCore.utils.IsolateOptions;

/**
 * Created by reink on 12/8/15.
 */
public class RuntimeEvaluator implements Evaluator{
    public RuntimeEvaluator() {
    }

    @Override
    public String evalute(IsolateOptions opts) {
        return "run(" + opts.toPythonArgs() + ")";
    }
}
