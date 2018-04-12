package com.example.android.eggcounter;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    MediaPlayer mediaPlayer;
    CountDownTimer myTimer;

    private void updateTimer(int secLeft) {
        int minutes = secLeft / 60;
        int seconds = secLeft - minutes * 60;
        String display;
        if ((Integer.toString(seconds).length() == 1) && (Integer.toString(minutes).length() == 1)) {
            display = ("0" + minutes + ":" + "0" + seconds);
        } else if (Integer.toString(seconds).length() == 1) {
            display = (minutes + ":" + "0" + seconds);
        } else if (Integer.toString(minutes).length() == 1) {
            display = ("0" + minutes + ":" + seconds);
        } else {
            display = (minutes + ":" + seconds);
        }
        textView.setText(display);
    }

    public void countdownTimer(final View view) {
        final String buttonName = ((Button) view).getText().toString();
        if (buttonName == "Set Timer") {
            seekBar.setEnabled(false);
            ((Button) view).setText("Reset");

            myTimer = new CountDownTimer(seekBar.getProgress() * 1000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    if (buttonName == "Set Timer") {
                        updateTimer((int) millisUntilFinished / 1000);
                    }
                }

                @Override
                public void onFinish() {
                    textView.setText("00:00");
                    seekBar.setEnabled(true);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                    ((Button) view).setText("Set Timer");
                }
            }.start();

        } else {
            seekBar.setEnabled(true);
            seekBar.setProgress(30);
            textView.setText("00:30");
            myTimer.cancel();
            ((Button) view).setText("Set Timer");
        }
    }

    public void stopIt(View view) {
        mediaPlayer.setLooping(false);
        seekBar.setProgress(30);
        textView.setText("00:30");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);

        textView = findViewById(R.id.textView);

        ((Button) findViewById(R.id.button)).setText("Set Timer");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
