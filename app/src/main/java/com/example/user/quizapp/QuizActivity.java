package com.example.user.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;


/**
 * QuizActivity class
 */


public class QuizActivity extends AppCompatActivity {

    String userName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quiz);

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        if (userName.isEmpty())
            userName = getString(R.string.userName);
    }

    public void onSubmit(View view){
        int correct = 0;
        RadioGroup group1 = (RadioGroup)findViewById(R.id.Question1);
        int answer1 = group1.getCheckedRadioButtonId();
        if (answer1 == R.id.question1_2)
            correct += 1;

        RadioGroup group2 = (RadioGroup)findViewById(R.id.Question2);
        int answer2 = group2.getCheckedRadioButtonId();
        if (answer2 == R.id.question2_4)
            correct += 1;

        CheckBox question3cb1 = (CheckBox) findViewById(R.id.Question3_1);
        CheckBox question3cb2 = (CheckBox) findViewById(R.id.Question3_2);
        CheckBox question3cb3 = (CheckBox) findViewById(R.id.Question3_3);
        CheckBox question3cb4 = (CheckBox) findViewById(R.id.Question3_4);

        if (question3cb1.isChecked() && !question3cb2.isChecked() && question3cb3.isChecked() && !question3cb4.isChecked())
        {
            correct += 1;
        }

        EditText question4 = (EditText) findViewById(R.id.Question4);
        if (question4.getText().toString().equalsIgnoreCase(getString(R.string.answer4)))
            correct += 1;

        RadioGroup group5 = (RadioGroup)findViewById(R.id.Question5);
        int answer5 = group5.getCheckedRadioButtonId();
        if (answer5 == R.id.question5_3)
            correct += 1;

        String message = userName + " ";
        String strResult = getString(R.string.result, correct);
        String strDisplay = "";
        if (correct == 5)
            strDisplay = getString(R.string.congrats) + "\n" + strResult.substring(0, 1).toUpperCase() + strResult.substring(1);
        else
            strDisplay = strResult;
        message += strDisplay;

        new AlertDialog.Builder(QuizActivity.this)
                .setMessage(message)
                .setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                        })
                .show();
    }

    public void onReset(View view) {

        // Reset radio buttons
        RadioGroup question1 = (RadioGroup) findViewById(R.id.Question1);
        question1.clearCheck();
        RadioGroup question2 = (RadioGroup) findViewById(R.id.Question2);
        question2.clearCheck();
        RadioGroup question5 = (RadioGroup) findViewById(R.id.Question5);
        question5.clearCheck();

        //Reset checkboxes
        CheckBox question3_1 = (CheckBox) findViewById(R.id.Question3_1);
        question3_1.setChecked(false);
        CheckBox question3_2 = (CheckBox) findViewById(R.id.Question3_2);
        question3_2.setChecked(false);
        CheckBox question3_3 = (CheckBox) findViewById(R.id.Question3_3);
        question3_3.setChecked(false);
        CheckBox question3_4 = (CheckBox) findViewById(R.id.Question3_4);
        question3_4.setChecked(false);

        //Reset editText
        EditText question4 = (EditText) findViewById(R.id.Question4);
        question4.getText().clear();
    }


}
