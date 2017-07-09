package com.example.majedurrahman.asembler.Activity.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.majedurrahman.asembler.R;

/**
 * Created by Majedur Rahman on 7/9/2017.
 */

public class AssemblerActivity extends AppCompatActivity {

    EditText editor;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assembler_layout);
        editor = (EditText) findViewById(R.id.editor);
        message = (TextView) findViewById(R.id.messageTV);

       editor.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



           }

           @Override
           public void afterTextChanged(Editable editable) {


           }
       });

    }


}