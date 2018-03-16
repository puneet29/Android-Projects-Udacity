package com.example.android.cricketscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreLeft = 0;
    int scoreRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayLeft(getResources().getString(R.string.left_score);
        displayRight(getResources().getString(R.string.right_score);
        displayInnings(getResources().getString(R.string.innings));
        displayLeftTeam(getResources().getString(R.string.left_team);
        displayRightTeam(getResources().getString(R.string.right_team);
    }

    public void addLeftOne(View view) {
        if(scoreRight<10) {
            scoreLeft++;
            displayLeft(scoreLeft);
        }
    }

    public void addLeftTwo(View view) {
        if (scoreRight < 10) {
            scoreLeft += 2;
            displayLeft(scoreLeft);
        }
    }

    public void addLeftThree(View view) {
        if (scoreRight < 10) {
            scoreLeft += 3;
            displayLeft(scoreLeft);
        }
    }

    public void addLeftFour(View view) {
        if (scoreRight < 10) {
            scoreLeft += 4;
            displayLeft(scoreLeft);
        }
    }

    public void addLeftSix(View view) {
        if (scoreRight < 10) {
            scoreLeft += 6;
            displayLeft(scoreLeft);
        }
    }

    public void addRightOne(View view) {
        if (scoreRight < 10) {
            scoreRight++;
            displayRight(scoreRight);
        }
    }

    public void changeInnings(View view) {
        TextView inningView = findViewById(R.id.innings);
        if (inningView.getText().equals("Second Inning")) {
            displayRight(scoreRight);
            displayLeft(scoreLeft);
        } else {
            displayInnings("Second Inning");
            displayLeftTeam("Team B");
            displayRightTeam("Team A");
            scoreRight = 0;
            scoreLeft = 0;
            displayRight(scoreRight);
            displayLeft(scoreLeft);
        }
    }

    public void reset(View view) {
        scoreLeft=0;
        scoreRight=0;
        displayLeft(scoreLeft);
        displayRight(scoreRight);
        displayInnings("First Inning");
        displayRightTeam("Team B");
        displayLeftTeam("Team A");
    }

    public void displayLeftTeam(String leftTeam) {
        TextView leftTeamView = findViewById(R.id.left_team);
        leftTeamView.setText(String.valueOf(leftTeam));
    }

    public void displayRightTeam(String rightTeam) {
        TextView rightTeamView = findViewById(R.id.right_team);
        rightTeamView.setText(String.valueOf(rightTeam));
    }

    public void displayLeft(int scoreLeft) {
        TextView leftView = findViewById(R.id.batting);
        leftView.setText(String.valueOf(scoreLeft));
    }

    public void displayRight(int scoreRight) {
        TextView rightView = findViewById(R.id.balling);
        rightView.setText(String.valueOf(scoreRight));
    }

    public void displayInnings(String innings) {
        TextView inningView = findViewById(R.id.innings);
        inningView.setText(innings);
    }

}
