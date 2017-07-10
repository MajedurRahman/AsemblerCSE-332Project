package com.example.majedurrahman.asembler.Activity.Model;

/**
 * Created by Majedur Rahman on 7/9/2017.
 */

public class Operation {

    private String opName;
    private String opCode;
    private String opType;

    public Operation() {


    }

    public String getOpName() {
        return opName.toUpperCase();
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpCode() {
        return opCode.toUpperCase();
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpType() {
        return opType.toUpperCase();
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }
}
