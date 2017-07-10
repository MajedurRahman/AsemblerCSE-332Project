package com.example.majedurrahman.asembler.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.majedurrahman.asembler.R;


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
        textView1.setText(ins.toString());
        textView2.setText(Code.toString());

    }
}
