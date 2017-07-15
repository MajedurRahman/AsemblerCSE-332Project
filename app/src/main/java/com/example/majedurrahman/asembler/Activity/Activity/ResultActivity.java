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
        String instruction = bundle.getString("Assembly");

        textView1 = (TextView) findViewById(R.id.instTv);
        textView2 = (TextView) findViewById(R.id.resultTv);

        textView2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        textView1.setText(instruction.toString());
        textView2.setText(Code.toString());
        writeIntoFile(Code, instruction);

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
