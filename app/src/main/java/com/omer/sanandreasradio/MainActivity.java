package com.omer.sanandreasradio;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    ArrayList<RadioClass> radios = new ArrayList<>(10);

    ImageView currentradioIMG, nextbtn, backbtn, playpauseIMG;
    TextView currentradioname;
    Button startpausbtn;
    int indexcontrol = 0 ;
    int randomPosition;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currentradioIMG = findViewById(R.id.currentRadioIMG);
        backbtn = findViewById(R.id.backbtn);
        nextbtn = findViewById(R.id.nextbtn);
        playpauseIMG = findViewById(R.id.IMGplaypause);
        startpausbtn = findViewById(R.id.BTNplaypause);
        currentradioname = findViewById(R.id.currentradioname);
        initRadio();


        backbtn.setOnClickListener(view -> {
            mediaPlayer.stop();

            if (indexcontrol == 0) {
                indexcontrol = 11;
                currentradioIMG.setImageResource(0);
                currentradioname.setText("RADIO OFF");
            } else {
                loadnew(indexcontrol -= 1);
            }

        });
        nextbtn.setOnClickListener(view -> {
            mediaPlayer.stop();

            if (indexcontrol == 11) {
                mediaPlayer.stop();

                indexcontrol = -1;
                currentradioIMG.setImageResource(0);
                currentradioname.setText("RADIO OFF");
            }
            loadnew(indexcontrol += 1);


        });


        startpausbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playpauseIMG.setImageResource(R.drawable.ic_play);
                } else {
                    mediaPlayer.start();
                    playpauseIMG.setImageResource(R.drawable.ic_pause);
                }

            }
        });

    }

    public void initRadio() {

        try {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bouncefm);


            mediaPlayer.seekTo(randomPosition);

        } catch (Exception exception) {
            Toast.makeText(this, "hata aldik", Toast.LENGTH_SHORT).show();
        }

        currentradioname.setText("Bounce FM");
        currentradioIMG.setImageResource(R.drawable.bouncefm);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }


    @SuppressLint({"SetTextI18n", "ResourceType"})
    public void initRadio(int n) {
        RadioClass bouncefm = new RadioClass(1, "Bounce FM");
        RadioClass csr = new RadioClass(2, "CSR");
        RadioClass kdst = new RadioClass(3, "K-DST");
        RadioClass kjahwest = new RadioClass(4, "K-JAH WEST");
        RadioClass krose = new RadioClass(5, "K-ROSE");
        RadioClass lossantos = new RadioClass(6, "Radio Los Santos");
        RadioClass mastersounds = new RadioClass(7, "Master Sounds");
        RadioClass playback = new RadioClass(8, "Playback FM");
        RadioClass radiox = new RadioClass(9, "Radio:X");
        RadioClass sfur = new RadioClass(10, "SF-UR");
        RadioClass wctr = new RadioClass(11, "WC-TR");
        RadioClass off = new RadioClass(12, "RADIO OFF");
        radios.add(bouncefm);
        radios.add(csr);
        radios.add(kdst);
        radios.add(kjahwest);
        radios.add(krose);
        radios.add(lossantos);
        radios.add(mastersounds);
        radios.add(playback);
        radios.add(radiox);
        radios.add(sfur);
        radios.add(wctr);
        radios.add(off);
        RadioClass q = radios.get(n);

        randomPosition = ThreadLocalRandom.current().nextInt(0, mediaPlayer.getDuration() + 1);

        currentradioname.setText(q.getRadioName());
        if (q.getRadioID() == 1) {

            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bouncefm);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.bouncefm);
        } else if (q.getRadioID() == 2) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.csr);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.csr);
        } else if (q.getRadioID() == 3) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.kdst);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.kdst);
        } else if (q.getRadioID() == 4) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.kjah);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();

            currentradioIMG.setImageResource(R.drawable.kjahwest);
        } else if (q.getRadioID() == 5) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.krose);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.krose);
        } else if (q.getRadioID() == 6) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.lossantos);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.lossantos);
        } else if (q.getRadioID() == 7) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.master);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.mastersounds);
        } else if (q.getRadioID() == 8) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.playback);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.playback);
        } else if (q.getRadioID() == 9) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.radiox);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.radiox);
        } else if (q.getRadioID() == 10) {
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sfur);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.sfur);
        } else if (q.getRadioID() == 11) {

            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.wctr);

            mediaPlayer.seekTo(randomPosition);
            mediaPlayer.start();
            currentradioIMG.setImageResource(R.drawable.wctr);
        } else {
            currentradioname.setText("RADIO OFF");
            currentradioIMG.setImageResource(0);
            mediaPlayer.stop();
        }


    }

    public void loadnew(int abc) {
        this.indexcontrol = abc;
        initRadio(indexcontrol);

    }

}