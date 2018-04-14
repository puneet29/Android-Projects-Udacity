package com.example.android.morningheadstart;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView timeView, score, question, result;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    RelativeLayout innerLayout;
    Button playAgain;
    GridLayout choices;
    CountDownTimer timer;
    private int qCount = 0, correctAnswer = 0, positionOfAnswer;

    public void choiceClick(View view) {
        if (Integer.toString(positionOfAnswer).equals(view.getTag())) {
            result.setText("Correct!");
            correctAnswer++;
        } else {
            result.setText("Wrong!");
        }
        qCount++;
        score.setText(Integer.toString(correctAnswer) + "/" + Integer.toString(qCount));
        generateChoices();
    }

    private void generateChoices() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        int wrongAns;

        question.setText(Integer.toString(a) + "+" + Integer.toString(b));

        positionOfAnswer = rand.nextInt(4);
        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == positionOfAnswer) {
                answers.add(a + b);
                ((Button) (choices.getChildAt(i))).setText(Integer.toString(answers.get(i)));
            } else {
                wrongAns = rand.nextInt(41);
                while (wrongAns == a + b) {
                    wrongAns = rand.nextInt(41);
                }
                answers.add(wrongAns);
                ((Button) (choices.getChildAt(i))).setText(Integer.toString(answers.get(i)));
            }
        }
    }

    public void playAgain(View view) {
        view.setVisibility(View.INVISIBLE);
        for (int i = 0; i < 4; i++) {
            ((Button) (choices.getChildAt(i))).setClickable(true);
        }
        generateChoices();
        correctAnswer = 0;
        score.setText("0/0");
        result.setText("");
        timeView.setText("30s");
        qCount = 0;
        timer.start();
    }

    public void firstClick(View view) {
        view.setVisibility(View.INVISIBLE);
        innerLayout.setVisibility(View.VISIBLE);
        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeView.setText(Long.toString(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                timeView.setText("0s");
                result.setText("Your score is: " + score.getText().toString());
                for (int i = 0; i < 4; i++) {
                    ((Button) (choices.getChildAt(i))).setClickable(false);
                }
                playAgain.setVisibility(View.VISIBLE);
            }
        };
        timer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.splash);
        //display the logo during 3 seconds,
        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long millisUntilFinished){}

            @Override
            public void onFinish(){
                //set the new Content of your activity
                MainActivity.this.setContentView(R.layout.activity_main);
                innerLayout = findViewById(R.id.innerLayout);
                timeView = findViewById(R.id.timeView);
                score = findViewById(R.id.scoreView);
                question = findViewById(R.id.questionView);
                choices = findViewById(R.id.choices);
                result = findViewById(R.id.resultView);
                playAgain = findViewById(R.id.playAgainButton);
                generateChoices();
            }
        }.start();
    }
}
