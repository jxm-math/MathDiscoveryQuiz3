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

    boolean pict1 = false;

    /* one boolean variable for each ImageButton, indicating whether selected or not */
    boolean pict2 = false;
    boolean pict3 = false;
    boolean pict4 = false;
    boolean pict5 = false;
    boolean pict6 = false;
    boolean pict7 = false;
    boolean pict8 = false;
    boolean pict9 = false;
    String[] listOfTopics = {"fractal", "golden", "simplex", "exponential", "physics"}; /* list of topic keywords */
    List<Integer> numbersOfTopics = new ArrayList<>(); /* to index the topics */
    List<Integer> numbersOfPictures = new ArrayList<>(); /* to index the pictures */
    List<Integer> numbersOfButtons = new ArrayList<>(); /* to index the 9 buttons */
    int stage = 0; /* number of quizzes made during the app */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout); /* app starts with the welcome layout */
    }

    /* Switches view to main activity */
    public void start(View view) {
        setContentView(R.layout.activity_main);

        /* Creates and shuffles the possible topics */
        for (int i = 0; i < listOfTopics.length; i++) {
            numbersOfTopics.add(i);
        }
        Collections.shuffle(numbersOfTopics);

        /* Creates the list of possible pictures */
        for (int i = 0; i < listOfTopics.length * 3; i++) {
            numbersOfPictures.add(i);
        }

        /* Creates the list of 9 buttons */
        for (int i = 1; i <= 9; i++) {
            numbersOfButtons.add(i);
        }

        buildQuiz(); /* start the first quiz */

    }

    /* Builds a new quiz */
    public void buildQuiz() {

        /* Updates the topic related to the quiz */
        TextView topicQuestion = (TextView) findViewById(R.id.topicQuestionView);
        topicQuestion.setText(listOfTopics[numbersOfTopics.get(stage)] + "?");

        /* Shuffles the ImageButtons */
        Collections.shuffle(numbersOfButtons);

        /* True pictures are assigned for the first three buttons */
        for (int i = 0; i <= 2; i++) {
            int identImageButton = getResources().getIdentifier("picture" + numbersOfButtons.get(i), "id", getPackageName());
            ImageButton imageButton = (ImageButton) findViewById(identImageButton);
            int identDrawable = getResources().getIdentifier(listOfTopics[numbersOfTopics.get(stage)] + (i + 1), "drawable", getPackageName());
            imageButton.setImageResource(identDrawable);
        }

        /* Shuffles the pictures in order to assign the false pictures */
        Collections.shuffle(numbersOfPictures);

        int searchedPicture = 0; /* which picture is to be proposed as a false picture */
        boolean foundFalsePicture; /* whether a false picture has been found */

        /* False pictures are assigned for the last six buttons */
        for (int i = 3; i <= 8; i++) {
            foundFalsePicture = false;
            int identImageButton = getResources().getIdentifier("picture" + numbersOfButtons.get(i), "id", getPackageName());
            ImageButton imageButton = (ImageButton) findViewById(identImageButton);
            while (!foundFalsePicture) {
                int candidate = numbersOfPictures.get(searchedPicture);
                /* Checks that the candidate does not match the quiz topic */
                if (candidate / 3 != numbersOfTopics.get(stage)) {
                    int identDrawable = getResources().getIdentifier(listOfTopics[candidate / 3] + (candidate % 3 + 1), "drawable", getPackageName());
                    imageButton.setImageResource(identDrawable);
                    foundFalsePicture = true;
                }
                searchedPicture = searchedPicture + 1;
            }
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
