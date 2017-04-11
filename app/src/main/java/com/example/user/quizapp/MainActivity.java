package com.example.user.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void startQuiz(View view) {
        EditText editName = (EditText) findViewById(R.id.editName);
        String userName = editName.getText().toString();
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }
}
