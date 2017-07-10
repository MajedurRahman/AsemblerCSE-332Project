package com.example.majedurrahman.asembler.Activity.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.majedurrahman.asembler.Activity.Constants;
import com.example.majedurrahman.asembler.Activity.Model.Operation;
import com.example.majedurrahman.asembler.Activity.Model.Register;
import com.example.majedurrahman.asembler.Activity.Oparends;
import com.example.majedurrahman.asembler.R;

import java.util.ArrayList;

/**
 * Created by Majedur Rahman on 7/9/2017.
 */

public class AssemblerActivity extends AppCompatActivity {

    EditText editor;
    TextView message;

    StringBuilder assembly = new StringBuilder();
    StringBuilder code = new StringBuilder();
    StringBuilder assemblyIns = new StringBuilder();


    ArrayList<String> operationNameList, registerList;
    ArrayList<String> operationCodeList, rType, iType, tType;

    ArrayList<Operation> operationArrayList;
    ArrayList<Register> registerArrayList;

    ArrayList<String> codeList, immediateValue;


    Button add, sub, lw, sw, addi, and, or, nor, sll, srl, bne, slt, jump, coma, semiclone, solveBtn, space, zero, s0, s1, t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assembler_layout);

        codeList = new ArrayList<>();
        operationNameList = new ArrayList<>();
        operationCodeList = new ArrayList<>();
        operationArrayList = new ArrayList<>();
        registerList = new ArrayList<>();
        registerArrayList = new ArrayList<>();
        immediateValue = new ArrayList<>();

        rType = new ArrayList<>();
        tType = new ArrayList<>();
        iType = new ArrayList<>();

        initComponent();
        loadData();


        for (int i = 0; i < operationArrayList.size(); i++) {
            Log.e("Oparations ", operationArrayList.get(i).getOpName() + " " + operationArrayList.get(i).getOpType());
        }

    }


    public void initComponent() {

        editor = (EditText) findViewById(R.id.editor);
        message = (TextView) findViewById(R.id.messageTV);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        lw = (Button) findViewById(R.id.lw);
        sw = (Button) findViewById(R.id.sw);
        addi = (Button) findViewById(R.id.addi);
        and = (Button) findViewById(R.id.and);
        or = (Button) findViewById(R.id.or);
        nor = (Button) findViewById(R.id.nor);
        sll = (Button) findViewById(R.id.sll);
        srl = (Button) findViewById(R.id.srl);
        bne = (Button) findViewById(R.id.bne);
        slt = (Button) findViewById(R.id.slt);
        jump = (Button) findViewById(R.id.jump);
        coma = (Button) findViewById(R.id.coma);
        semiclone = (Button) findViewById(R.id.semiclone);
        solveBtn = (Button) findViewById(R.id.solve);
        space = (Button) findViewById(R.id.space);

        zero = (Button) findViewById(R.id.zero);
        s0 = (Button) findViewById(R.id.s0);
        s1 = (Button) findViewById(R.id.s1);
        t1 = (Button) findViewById(R.id.t1);


    }


    public void onClick(View view) {

        if (view.getId() == add.getId()) {
            assembly.append(add.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());

        } else if (view.getId() == sub.getId()) {
            assembly.append(sub.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());

        } else if (view.getId() == lw.getId()) {
            assembly.append(lw.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == sw.getId()) {
            assembly.append(sw.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == addi.getId()) {
            assembly.append("ADDi");
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == and.getId()) {
            assembly.append(and.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == or.getId()) {
            assembly.append(or.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == nor.getId()) {
            assembly.append(nor.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == sll.getId()) {
            assembly.append(sll.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == srl.getId()) {
            assembly.append(srl.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());

        } else if (view.getId() == bne.getId()) {
            assembly.append(bne.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == slt.getId()) {
            assembly.append(slt.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == jump.getId()) {
            assembly.append(jump.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == coma.getId()) {
            assembly.append(coma.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == semiclone.getId()) {
            assembly.append(semiclone.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == space.getId()) {
            assembly.append("   ");
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == zero.getId()) {
            assembly.append(zero.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == s1.getId()) {
            assembly.append(s1.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == s0.getId()) {
            assembly.append(s0.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == t1.getId()) {
            assembly.append(t1.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        } else if (view.getId() == solveBtn.getId()) {

            codeList.clear();
            this.code.delete(0, this.code.length());
            this.assemblyIns.delete(0, this.assemblyIns.length());

            String code = editor.getText().toString().toUpperCase().trim().replaceAll(" +", " ");
            String codec[] = code.split(";");

            for (int i = 0; i < codec.length; i++) {

                codeList.add(codec[i].trim().toUpperCase());
                checkInstructions(codeList.get(i).toString());

                this.assemblyIns.append(codec[i].toUpperCase() + "\n");


            }

            startActivity(new Intent(AssemblerActivity.this, ResultActivity.class)
                    .putExtra("Code", this.code.toString())
                    .putExtra("Assembly", this.assemblyIns.toString()));


        }


    }

    private void checkInstructions(String code) {

        String codePart[] = code.split(" ");
        if (codePart.length == 4) {


            if (rType.contains(codePart[0].toUpperCase())) {

                Log.e(" Type ", "R type ");
                Oparends oparend = new Oparends();
                oparend.setOp(codePart[0].toUpperCase());
                oparend.setRd(codePart[1].toUpperCase());
                oparend.setRs(codePart[2].toUpperCase());
                oparend.setRt(codePart[3].toUpperCase());

                if (operationNameList.contains(oparend.getOp().toUpperCase())) {

                    if (registerList.contains(oparend.getRd().toUpperCase()) && !oparend.getRd().equalsIgnoreCase(zero.getText().toString())) {

                        if (registerList.contains(oparend.getRs())) {

                            if (registerList.contains(oparend.getRt())) {

                                getMachineCode(oparend.getOp(), oparend.getRd(), oparend.getRs(), oparend.getRt(), "R");

                            } else {
                                Toast.makeText(this, "Incorrect Statement in RT", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(this, "Incorrect Statement in RS", Toast.LENGTH_SHORT).show();
                        }


                    } else {

                        Toast.makeText(this, "Incorrect Statement in RD !!", Toast.LENGTH_SHORT).show();
                    }


                } else {

                    Toast.makeText(this, "InCorrect Operation Name !!", Toast.LENGTH_SHORT).show();
                }

            } else if (iType.contains(codePart[0].toUpperCase())) {

                Log.e(" Type ", "I type ");

                Oparends oparend = new Oparends();
                oparend.setOp(codePart[0].toUpperCase());
                oparend.setRd(codePart[1].toUpperCase());
                oparend.setRs(codePart[2].toUpperCase());
                //Here RT  used as Immediate because both of them are same bit
                oparend.setRt(codePart[3].toUpperCase());

                if (operationNameList.contains(oparend.getOp().toUpperCase())) {

                    if (registerList.contains(oparend.getRd().toUpperCase()) && !oparend.getRd().equalsIgnoreCase(zero.getText().toString())) {

                        if (registerList.contains(oparend.getRs())) {

                            if (immediateValue.contains(oparend.getRt())) {

                                if (oparend.getRt().equalsIgnoreCase("0")) {
                                    getMachineCode(oparend.getOp(), oparend.getRd(), oparend.getRs(), "00", "I");

                                } else if (oparend.getRt().equalsIgnoreCase("1")){
                                    getMachineCode(oparend.getOp(), oparend.getRd(), oparend.getRs(), "01", "I");

                                }
                                else if (oparend.getRt().equalsIgnoreCase("2")) {
                                    getMachineCode(oparend.getOp(), oparend.getRd(), oparend.getRs(), "10", "I");

                                }
                                else if (oparend.getRt().equalsIgnoreCase("3")){
                                    getMachineCode(oparend.getOp(), oparend.getRd(), oparend.getRs(), "11", "I");

                                }



                            } else {
                                Toast.makeText(this, "Incorrect Statement in Immediate Value !!", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(this, "Incorrect Statement in RS !!", Toast.LENGTH_SHORT).show();
                        }


                    } else {

                        Toast.makeText(this, "Incorrect Statement in RD !!", Toast.LENGTH_SHORT).show();
                    }


                } else {

                    Toast.makeText(this, "InCorrect Operation Name !!", Toast.LENGTH_SHORT).show();
                }

            }


        } else {

            Toast.makeText(this, "InComplete Statement !! ", Toast.LENGTH_SHORT).show();
        }
    }

    private void getMachineCode(String op, String rd, String rs, String rt, String type) {
        String code = "";
        if (type.equalsIgnoreCase("R")) {
            code = getOpCodeValue(op.toUpperCase()) + getRegisterValue(rd) + getRegisterValue(rs) + getRegisterValue(rt);

        } else if (type.equalsIgnoreCase("I")) {
            code = getOpCodeValue(op.toUpperCase()) + getRegisterValue(rd) + getRegisterValue(rs) + rt;

        }


        this.code.append(code + "\n");
    }

    public String getOpCodeValue(String rs) {

        for (int i = 0; i < operationArrayList.size(); i++) {

            if (operationArrayList.get(i).getOpName().equalsIgnoreCase(rs)) {


                return operationArrayList.get(i).getOpCode();
            }
        }

        return null;
    }

    public String getRegisterValue(String value) {


        for (int i = 0; i < registerArrayList.size(); i++) {
            if (registerArrayList.get(i).getName().equalsIgnoreCase(value)) {
                return registerArrayList.get(i).getValue();
            }
        }
        return null;
    }


    public void loadData() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                addOperationNameToList();
                addOperationCodeToList();
                loadRegister();
                loadRegisterData();
                setOperationList();

            }
        });

    }


    private void loadRegister() {

        registerList.add(zero.getText().toString().toUpperCase());
        registerList.add(s0.getText().toString().toUpperCase());
        registerList.add(s1.getText().toString().toUpperCase());
        registerList.add(t1.getText().toString().toUpperCase());
    }

    private void loadRegisterData() {

        Register register = new Register(zero.getText().toString().toUpperCase(), "00");
        registerArrayList.add(register);
        register = new Register(s0.getText().toString().toUpperCase(), "01");
        registerArrayList.add(register);
        register = new Register(s1.getText().toString().toUpperCase(), "10");
        registerArrayList.add(register);
        register = new Register(t1.getText().toString().toUpperCase(), "11");
        registerArrayList.add(register);


    }

    private void setOperationList() {

        if (operationNameList.size() == operationCodeList.size()) {


            for (int i = 0; i < operationCodeList.size(); i++) {

                Operation op = new Operation();
                op.setOpCode(operationCodeList.get(i));
                op.setOpName(operationNameList.get(i));
                if (rType.contains(operationCodeList.get(i))) {
                    op.setOpType("R");


                } else if (iType.contains(operationCodeList.get(i))) {
                    op.setOpType("I");
                }

                operationArrayList.add(op);

            }


        } else {
            Toast.makeText(this, " Error While Loading Data !! ", Toast.LENGTH_SHORT).show();
        }

    }

    private void addOperationCodeToList() {

        // Maintain this sequence is mandatory
        operationCodeList.add(Constants.ADDcode);
        operationCodeList.add(Constants.SUBcode);
        operationCodeList.add(Constants.LWcode);
        operationCodeList.add(Constants.SWcode);
        operationCodeList.add(Constants.ADDicode);
        operationCodeList.add(Constants.ANDcode);
        operationCodeList.add(Constants.ORcode);
        operationCodeList.add(Constants.NORcode);
        operationCodeList.add(Constants.SLLcode);
        operationCodeList.add(Constants.SRLcode);
        operationCodeList.add(Constants.BNEcode);
        operationCodeList.add(Constants.SLTcode);
        operationCodeList.add(Constants.JUMPcode);


        Log.e("Load :: ", "Load All Operation Code : Size :: " + operationCodeList.size());


        rType.add("ADD");
        rType.add("SUB");
        iType.add("LW");
        iType.add("SW");
        iType.add("ADDI");
        rType.add("AND");
        rType.add("OR");
        rType.add("NOR");
        iType.add("SLL");
        iType.add("SRL");
        iType.add("BNE");
        rType.add("SLT");
        iType.add("JUMP");


        immediateValue.add("0");
        immediateValue.add("1");
        immediateValue.add("2");
        immediateValue.add("3");


    }

    private void addOperationNameToList() {

        // Maintain this sequence is mandatory
        operationNameList.add(Constants.ADDname);
        operationNameList.add(Constants.SUBname);
        operationNameList.add(Constants.LWname);
        operationNameList.add(Constants.SWname);
        operationNameList.add(Constants.ADDiname);
        operationNameList.add(Constants.ANDname);
        operationNameList.add(Constants.ORname);
        operationNameList.add(Constants.NORname);
        operationNameList.add(Constants.SLLname);
        operationNameList.add(Constants.SRLname);
        operationNameList.add(Constants.BNEname);
        operationNameList.add(Constants.SLTname);
        operationNameList.add(Constants.JUMPname);

        Log.e("Load : ", "Load All Operation Name : Size :: " + operationNameList.size());


    }

}