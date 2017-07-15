package com.example.majedurrahman.asembler.Activity.Activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TextView;

import com.example.majedurrahman.asembler.Activity.FileWriter;
import com.example.majedurrahman.asembler.R;

import java.io.File;


public class ResultActivity extends AppCompatActivity {


    TextView textView2, textView1, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        String Code = bundle.getString("Code");
        String instruction = bundle.getString("Assembly");
        String hex = bundle.getString("Hex");

        textView1 = (TextView) findViewById(R.id.instTv);
        textView2 = (TextView) findViewById(R.id.resultTv);
        textView3 = (TextView) findViewById(R.id.resultTvHex);

        textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        textView1.setText(instruction.toString());
        textView2.setText(Code.toString());
        textView3.setText(hex.toString());

        writeIntoFile(Code, instruction, hex.trim());

    }


    // Write Instruction and Machine code if file
    private void writeIntoFile(String code, String instruction, String hex) {
        long nameExtendedKey = SystemClock.elapsedRealtime();
        FileWriter fileWriter = new FileWriter(ResultActivity.this);

        try {
            File subDirectory = fileWriter.createSubDirectory(fileWriter.getExternalStorageDirectory(), "Assembler Folder");
            fileWriter.writeDataToFile(subDirectory, nameExtendedKey + "_Code.txt", code.toString());
            fileWriter.writeDataToFile(subDirectory, nameExtendedKey + "_Instructions.txt", instruction.toString());
            fileWriter.writeDataToFile(subDirectory, nameExtendedKey + "_HEXcode.txt", hex.toString());
        } catch (FileWriter.ExternalFileWriterException e) {
            e.printStackTrace();
        }

    }
}
