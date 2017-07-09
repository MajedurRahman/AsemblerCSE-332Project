package com.example.majedurrahman.asembler.Activity.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.majedurrahman.asembler.Activity.Constants;
import com.example.majedurrahman.asembler.Activity.Operation;
import com.example.majedurrahman.asembler.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity";


    ArrayList<String> operationNameList;
    ArrayList<String> operationCodeList, rType, iType, tType;

    ArrayList<Operation> operationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operationNameList = new ArrayList<>();
        operationCodeList = new ArrayList<>();
        operationArrayList = new ArrayList<>();

        rType = new ArrayList<>();
        tType = new ArrayList<>();
        iType = new ArrayList<>();


        Button button = (Button) findViewById(R.id.assemblerActivityButton);
        loadData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AssemblerActivity.class));
            }
        });


    }


    public void loadData() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                addOperationNameToList();
                addOperationCodeToList();

                setOperationList();

            }
        });

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
                Log.e(TAG, op.getOpName() +" "+" "+op.getOpCode()+ " Type " + op.getOpType());

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


        Log.e(TAG, "Load All Operation Code : Size :: " + operationCodeList.size());


        rType.add("0000");
        rType.add("0001");
        iType.add("0010");
        iType.add("0011");
        iType.add("0100");
        rType.add("0101");
        rType.add("0110");
        rType.add("0111");
        iType.add("1000");
        rType.add("1001");
        iType.add("1010");
        rType.add("1011");
        iType.add("1100");


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

        Log.e(TAG, "Load All Operation Name : Size :: " + operationNameList.size());


    }


}
