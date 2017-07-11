package com.example.majedurrahman.asembler.Activity.Activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.example.majedurrahman.asembler.Activity.FileWriter;
import com.example.majedurrahman.asembler.R;

import java.io.File;


public class ResultActivity extends AppCompatActivity {


    TextView textView2, textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        String Code = bundle.getString("Code");
        String instraction = bundle.getString("Assembly");

        String[] split = Code.split("\n");


        textView1 = (TextView) findViewById(R.id.instTv);
        textView2 = (TextView) findViewById(R.id.resultTv);

        textView2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        textView1.setText(instraction.toString());
        textView2.setText(Code.toString());
        writeIntoFile(Code, instraction);
        getHexCode(split);


    }

    private void getHexCode(String[] split) {


        for (int i = 0; i < split.length; i++) {

            Log.e("hex", Integer.toHexString(Integer.parseInt(split[i])) + "");


            //    Log.e("bbbbbbbbbb" , codsplit.length +"" + codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+codsplit[1]+);
            //      Log.e("bbbb" , split.length+"  si  "+split[0]+split[1]+split[2]+split[3]+split[4]+split[5]+split[6]+split[7]+split[8]+split[9]+"");

        }
        /*for (int i = 0; i < splitt.length; i++) {

            char[] split = splitt[i].toCharArray();

            String h1 = String.valueOf(split[0] + split[1] + split[2] + split[3]);
            String h2 = String.valueOf(split[4] + split[5] + split[6] + split[7]);
            String h3 = String.valueOf(split[8] + split[9]);
            // Log.e("HX " , h1 + "  " + h2 +" " + h3);

            Log.e("HX ", "" + splitt[i]);
            String HexValue = Integer.toHexString(Integer.parseInt(h3)) + Integer.toHexString(Integer.parseInt(h2)) + Integer.toHexString(Integer.parseInt(h1));
            Log.e("HX ", HexValue);

        }*/
    }

    // Write Instruction and Machine code if file
    private void writeIntoFile(String code, String instruction) {
        long nameExtendedKey = SystemClock.elapsedRealtime();
        FileWriter fileWriter = new FileWriter(ResultActivity.this);

        try {
            File subDirectory = fileWriter.createSubDirectory(fileWriter.getExternalStorageDirectory(), "Assembler Folder");
            fileWriter.writeDataToFile(subDirectory, nameExtendedKey + "_Code.txt", code.toString());
            fileWriter.writeDataToFile(subDirectory, nameExtendedKey + "_Instructions.txt", instruction.toString());
        } catch (FileWriter.ExternalFileWriterException e) {
            e.printStackTrace();
        }

    }
}
