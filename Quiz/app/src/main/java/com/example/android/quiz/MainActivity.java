package com.example.android.quiz;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    RadioButton ans;
    int ansid, count = 10, sum = 0;

    public void onFirstClick1(View v) {
        if (count == 10) {
            ans = findViewById(R.id.q1r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q1rg1);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 9;
            }
        }
    }

    public void onFirstClick2(View v) {
        if (count == 9) {
            ans = findViewById(R.id.q2r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q2rg2);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 8;
            }
        }
    }

    public void onFirstClick3(View v) {
        if (count == 8) {
            ans = findViewById(R.id.q3r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q3rg3);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 7;
            }
        }
    }

    public void onFirstClick4(View v) {
        if (count == 7) {
            ans = findViewById(R.id.q4r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q4rg4);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 6;
            }
        }
    }

    public void onFirstClick5(View v) {
        if (count == 6) {
            ans = findViewById(R.id.q5r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q5rg5);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 5;
            }
        }
    }

    public void onFirstClick6(View v) {
        if (count == 5) {
            ans = findViewById(R.id.q6r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q6rg6);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 4;
            }
        }
    }

    public void onFirstClick7(View v) {
        if (count == 4) {
            ans = findViewById(R.id.q7r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q7rg7);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 3;
            }
        }
    }

    public void onFirstClick8(View v) {
        if (count == 3) {
            ans = findViewById(R.id.q8r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q8rg8);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 2;
            }
        }
    }

    public void onFirstClick9(View v) {
        if (count == 2) {
            ans = findViewById(R.id.q9r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q9rg9);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 1;
            }
        }
    }

    public void onFirstClick10(View v) {
        if (count == 1) {
            ans = findViewById(R.id.q10r1);
            ansid = ans.getId();
            RadioGroup rg = findViewById(R.id.q10rg10);

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                ans.setBackgroundResource(R.drawable.shape2);
                count = 0;
            }
        }
    }

}
