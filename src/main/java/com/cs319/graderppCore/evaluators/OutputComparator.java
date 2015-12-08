package com.cs319.graderppCore.evaluators;

import com.cs319.graderppCore.utils.IsolateOptions;

/**
 * Created by reink on 12/8/15.
 */
public class OutputComparator implements Evaluator{
    public OutputComparator() {

    }

    @Override
    public String evalute(IsolateOptions opts) {
        return "compare(" + opts.toPythonArgs() + ")";
    }
}
