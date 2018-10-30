package com.example.ana.quiz;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int numberOfClicks=0;
    int score = 0;
    String Message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Next(View view) {
        RadioButton r1 = (RadioButton)findViewById(R.id.rb1);
        RadioButton r2 = (RadioButton)findViewById(R.id.rb2);
        RadioButton r3 = (RadioButton)findViewById(R.id.rb3);
        Questions q = new Questions();
        TextView question = (TextView)findViewById(R.id.question);
        r1.setVisibility(View.VISIBLE);
        r2.setVisibility(View.VISIBLE);
        r3.setVisibility(View.VISIBLE);
        if(r1.isChecked() && r1.getText().toString() == q.rightAnswers[numberOfClicks-1]
                || r2.isChecked() && r2.getText().toString() == q.rightAnswers[numberOfClicks-1]
                ||r3.isChecked() && r3.getText().toString() == q.rightAnswers[numberOfClicks-1]){
            score+=2;
            if(score>=6){
                Message = "Congratulations! You have "+score+ " score!";
            }
            else{
                Message = "You have failed! and your score is"+score;
            }
        }
        if(numberOfClicks<5){
            question.setText(q.questions[numberOfClicks]);
            r1.setText(q.answers[numberOfClicks][0]);
            r2.setText(q.answers[numberOfClicks][1]);
            r3.setText(q.answers[numberOfClicks][2]);
            numberOfClicks++;
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Score");
            alert.setMessage(Message);
            alert.setNegativeButton("Okay", null);
            alert.create();
            alert.show();
        }
    }
}
