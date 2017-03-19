package com.example.android.mathdiscoveryquiz3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.R.attr.visible;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    boolean pict1 = false;
    boolean pict2 = false;
    boolean pict3 = false;
    boolean pict4 = false;
    boolean pict5 = false;
    boolean pict6 = false;
    boolean pict7 = false;
    boolean pict8 = false;
    boolean pict9 = false;

    /* Toggles the visibility of the check mark 1*/
    public void checkPicture1(View view) {
        pict1 = !pict1;
        ImageView checkImage = (ImageView) findViewById(R.id.check1);
        if (pict1) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 2*/
    public void checkPicture2(View view) {
        pict2 = !pict2;
        ImageView checkImage = (ImageView) findViewById(R.id.check2);
        if (pict2) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 3*/
    public void checkPicture3(View view) {
        pict3 = !pict3;
        ImageView checkImage = (ImageView) findViewById(R.id.check3);
        if (pict3) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 4*/
    public void checkPicture4(View view) {
        pict4 = !pict4;
        ImageView checkImage = (ImageView) findViewById(R.id.check4);
        if (pict4) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 5*/
    public void checkPicture5(View view) {
        pict5 = !pict5;
        ImageView checkImage = (ImageView) findViewById(R.id.check5);
        if (pict5) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 6*/
    public void checkPicture6(View view) {
        pict6 = !pict6;
        ImageView checkImage = (ImageView) findViewById(R.id.check6);
        if (pict6) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 7*/
    public void checkPicture7(View view) {
        pict7 = !pict7;
        ImageView checkImage = (ImageView) findViewById(R.id.check7);
        if (pict7) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 8*/
    public void checkPicture8(View view) {
        pict8 = !pict8;
        ImageView checkImage = (ImageView) findViewById(R.id.check8);
        if (pict8) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 9*/
    public void checkPicture9(View view) {
        pict9 = !pict9;
        ImageView checkImage = (ImageView) findViewById(R.id.check9);
        if (pict9) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

}
