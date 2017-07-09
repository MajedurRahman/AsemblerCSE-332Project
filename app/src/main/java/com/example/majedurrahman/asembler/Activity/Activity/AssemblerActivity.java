package com.example.majedurrahman.asembler.Activity.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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
    StringBuilder assembly=new StringBuilder();


    Button add ,sub , lw,sw,addi,and,or,nor,sll,srl,bne,slt,jump,coma ,semiclone , solveBtn ,space;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assembler_layout);
        initComponent();

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

    public void initComponent(){

        editor = (EditText) findViewById(R.id.editor);
        message = (TextView) findViewById(R.id.messageTV);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        lw= (Button) findViewById(R.id.lw);
        sw = (Button) findViewById(R.id.sw);
        addi = (Button) findViewById(R.id.addi);
        and= (Button) findViewById(R.id.and);
        or = (Button) findViewById(R.id.or);
        nor = (Button) findViewById(R.id.nor);
        sll = (Button) findViewById(R.id.sll);
        srl = (Button) findViewById(R.id.srl);
        bne = (Button) findViewById(R.id.bne);
        slt = (Button) findViewById(R.id.slt);
        jump = (Button) findViewById(R.id.jump);
        coma= (Button) findViewById(R.id.coma);
        semiclone = (Button) findViewById(R.id.semiclone);
        solveBtn = (Button) findViewById(R.id.solve);
        space = (Button) findViewById(R.id.space);


    }


    public void onClick(View view) {

        if (view.getId()==add.getId()){
            assembly.append(add.getText());
            editor.setText(editor.getText() + assembly.toString());
           editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());

        }
        else if (view.getId()==sub.getId()){
            assembly.append(sub.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());

        }
        else if (view.getId()==lw.getId()){
            assembly.append(lw.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==sw.getId()){
            assembly.append(sw.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==addi.getId()){
            assembly.append("ADDi");
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }

        else if (view.getId()==and.getId()){
            assembly.append(and.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }

        else if (view.getId()==or.getId()){
            assembly.append(or.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==nor.getId()){
            assembly.append(nor.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==sll.getId()){
            assembly.append(sll.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==srl.getId()){
            assembly.append(srl.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());

        }
        else if (view.getId()==bne.getId()){
            assembly.append(bne.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==slt.getId()){
            assembly.append(slt.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==jump.getId()){
            assembly.append(jump.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==coma.getId()){
            assembly.append(coma.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==semiclone.getId()){
            assembly.append(semiclone.getText());
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }
        else if (view.getId()==space.getId()){
            assembly.append("   ");
            editor.setText(editor.getText() + assembly.toString());
            editor.setSelection(editor.length());
            assembly.delete(0, assembly.length());
        }

        else if (view.getId()==solveBtn.getId()){


            //Solve every thing
        }


    }
}