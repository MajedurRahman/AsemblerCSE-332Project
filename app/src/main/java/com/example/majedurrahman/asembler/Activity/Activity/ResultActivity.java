package com.example.majedurrahman.asembler.Activity.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.majedurrahman.asembler.R;

import java.io.IOException;
import java.io.OutputStreamWriter;


public class ResultActivity extends AppCompatActivity {


    TextView textView2,textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        String Code = bundle.getString("Code");
        String ins = bundle.getString("Assembly");
        textView1 = (TextView) findViewById(R.id.instTv);
        textView2 = (TextView) findViewById(R.id.resultTv);

        textView2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        textView1.setText(ins.toString());
        textView2.setText(Code.toString());

        writeToFile(Code,this);
        getDataFromFile();
        writeIntoFile(Code);


    }

    private void writeIntoFile(String data) {

        SharedPreferences  shp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= shp.edit();
        editor.putString("Code",data);

        editor.apply();
    }

    private String getDataFromFile() {

        SharedPreferences sh = getPreferences(Context.MODE_PRIVATE);

       String data = sh.getString("Code","Data Not Found !! ");

        return data;
    }


    private void writeToFile(String data,Context context) {

    try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("CODE.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Toast.makeText(context, "Write Data Finished !! ", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
