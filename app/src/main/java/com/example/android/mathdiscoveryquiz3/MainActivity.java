package com.example.android.mathdiscoveryquiz3;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static android.R.attr.id;
import static android.R.attr.max;
import static android.R.attr.visible;
import static android.R.id.list;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
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

    String[] listOfTopics = {"fractal", "golden", "simplex", "exponential", "physics"};

    List<Integer> numbersOfTopics = new ArrayList<>();

    List<Integer> numbersOfPictures = new ArrayList<>();

    int stage = 0;

    /* Switches view to main activity */
    public void start(View view) {
        setContentView(R.layout.activity_main);

        /* Shuffles the possible topics */
        for (int i = 0; i < listOfTopics.length; i++) {
            numbersOfTopics.add(i);
        }
        Collections.shuffle(numbersOfTopics);
        /* verbose */
        for (int number : numbersOfTopics){
            Log.v("topic: ", listOfTopics[number]);
        }

        /* Creates the list of possible pictures */
        Log.v("creation: ", "list of possible pictures succesfully created");
        for (int i = 0; i < listOfTopics.length * 3; i++) {
            numbersOfPictures.add(i);
        }

        buildQuiz();

    }

    /* Builds a new quiz */
    public void buildQuiz() {
        TextView topicQuestion = (TextView) findViewById(R.id.topicQuestionView);
        topicQuestion.setText(listOfTopics[numbersOfTopics.get(stage)] + "?");



        Collections.shuffle(numbersOfPictures);
        /* verbose */
        for (int number : numbersOfPictures){
            Log.v("topic: ", "" + number);
        }
        int assignedCheckButtons = 0;
        int assignedFalseCheckButtons = 0;
        int searchedPicture = 0;
        List<Integer> truePictures = new ArrayList<>();
        while (assignedCheckButtons < 9) {
            Log.v("state: ", assignedCheckButtons + " " + assignedFalseCheckButtons + " " + searchedPicture);
            int identImageButton = getResources().getIdentifier("picture" + (assignedCheckButtons + 1), "id", getPackageName());
            Log.v("state: ", "recoge el id: " + identImageButton);
            ImageButton imageButton = (ImageButton) findViewById(identImageButton);
            int candidate = numbersOfPictures.get(searchedPicture);
            Log.v("candidate: ", "" + candidate);
            int identDrawable = getResources().getIdentifier(listOfTopics[candidate / 3] + (candidate % 3 + 1), "drawable", getPackageName());

            if ( candidate / 3 == numbersOfTopics.get(stage) ){
                imageButton.setImageResource(identDrawable);
                assignedCheckButtons = assignedCheckButtons + 1;
                truePictures.add(assignedCheckButtons);
            } else if ( assignedFalseCheckButtons < 6 ) {
                imageButton.setImageResource(identDrawable);
                assignedCheckButtons = assignedCheckButtons + 1;
                assignedFalseCheckButtons = assignedFalseCheckButtons + 1;
            }

            searchedPicture = searchedPicture + 1;
        }

        for (int number : truePictures){
            Log.v("truePicture: ", "" + number);
        }

    }

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
