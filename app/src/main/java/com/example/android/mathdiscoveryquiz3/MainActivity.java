package com.example.android.mathdiscoveryquiz3;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static android.R.attr.id;
import static android.R.attr.max;
import static android.R.attr.name;
import static android.R.attr.visible;
import static android.R.id.list;
import static android.R.id.message;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    /* one boolean variable for each ImageButton, indicating whether selected or not */
    boolean pict1;
    boolean pict2;
    boolean pict3;
    boolean pict4;
    boolean pict5;
    boolean pict6;
    boolean pict7;
    boolean pict8;
    boolean pict9;

    String[] listOfTopics = {"fractal", "golden", "simplex", "exponential", "physics"}; /* list of topic keywords */
    List<Integer> numbersOfTopics = new ArrayList<>(); /* to index the topics */
    List<Integer> numbersOfPictures = new ArrayList<>(); /* to index the pictures */
    List<Integer> numbersOfButtons = new ArrayList<>(); /* to index the 9 buttons */
    int stage = -1; /* number of quizzes made during the app */

    String chosen = ""; /* chosen topic for further references */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout); /* app starts with the welcome layout */
    }

    /* Creates the variables needed for the entire game */
    public void start(View view) {

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

        buildQuiz(); /* starts the first quiz */

    }

    /* Builds a new quiz */
    public void buildQuiz() {

        /* If the three quizzes have been done, the app moves to the survey of the most liked topic */
        if (stage == 2) {
            survey();
            return;
        }

        /* Updates the stage */
        stage = stage + 1;

        /* The game starts with everything unchecked */
        pict1 = false;
        pict2 = false;
        pict3 = false;
        pict4 = false;
        pict5 = false;
        pict6 = false;
        pict7 = false;
        pict8 = false;
        pict9 = false;

        /* Switches view to main activity */
        setContentView(R.layout.activity_main);

        /* Updates the topic related to the quiz */
        TextView topicQuestion = (TextView) findViewById(R.id.topicQuestionView);
        int identQuizTopic = getResources().getIdentifier(listOfTopics[numbersOfTopics.get(stage)], "string", getPackageName());
        topicQuestion.setText(String.format("%s?", getString(identQuizTopic)));

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

    /* Toggles the visibility of the check mark 1 */
    public void checkPicture1(View view) {
        pict1 = !pict1;
        ImageView checkImage = (ImageView) findViewById(R.id.check1);
        if (pict1) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 2 */
    public void checkPicture2(View view) {
        pict2 = !pict2;
        ImageView checkImage = (ImageView) findViewById(R.id.check2);
        if (pict2) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 3 */
    public void checkPicture3(View view) {
        pict3 = !pict3;
        ImageView checkImage = (ImageView) findViewById(R.id.check3);
        if (pict3) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 4 */
    public void checkPicture4(View view) {
        pict4 = !pict4;
        ImageView checkImage = (ImageView) findViewById(R.id.check4);
        if (pict4) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 5 */
    public void checkPicture5(View view) {
        pict5 = !pict5;
        ImageView checkImage = (ImageView) findViewById(R.id.check5);
        if (pict5) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 6 */
    public void checkPicture6(View view) {
        pict6 = !pict6;
        ImageView checkImage = (ImageView) findViewById(R.id.check6);
        if (pict6) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 7 */
    public void checkPicture7(View view) {
        pict7 = !pict7;
        ImageView checkImage = (ImageView) findViewById(R.id.check7);
        if (pict7) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 8 */
    public void checkPicture8(View view) {
        pict8 = !pict8;
        ImageView checkImage = (ImageView) findViewById(R.id.check8);
        if (pict8) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Toggles the visibility of the check mark 9 */
    public void checkPicture9(View view) {
        pict9 = !pict9;
        ImageView checkImage = (ImageView) findViewById(R.id.check9);
        if (pict9) {
            checkImage.setVisibility(View.VISIBLE);
        } else {
            checkImage.setVisibility(View.INVISIBLE);
        }
    }

    /* Checks quiz */
    public void checkQuiz(View view) {
        int intPict1 = (pict1) ? 1 : 0;
        int intPict2 = (pict2) ? 1 : 0;
        int intPict3 = (pict3) ? 1 : 0;
        int intPict4 = (pict4) ? 1 : 0;
        int intPict5 = (pict5) ? 1 : 0;
        int intPict6 = (pict6) ? 1 : 0;
        int intPict7 = (pict7) ? 1 : 0;
        int intPict8 = (pict8) ? 1 : 0;
        int intPict9 = (pict9) ? 1 : 0;

        int numberCheckedButtons = intPict1 + intPict2 + intPict3 + intPict4 + intPict5 + intPict6 + intPict7 + intPict8 + intPict9;

        if (numberCheckedButtons != 3) {
            Toast.makeText(this, "Please check exactly 3 pictures", Toast.LENGTH_SHORT).show();
            return;
        }

        int hits = 0;
        for (int i = 0; i <= 2; i++) {
            int truePicture = numbersOfButtons.get(i);
            boolean hitCondition = (pict1 && 1 == truePicture)
                    || (pict2 && 2 == truePicture)
                    || (pict3 && 3 == truePicture)
                    || (pict4 && 4 == truePicture)
                    || (pict5 && 5 == truePicture)
                    || (pict6 && 6 == truePicture)
                    || (pict7 && 7 == truePicture)
                    || (pict8 && 8 == truePicture)
                    || (pict9 && 9 == truePicture);
            if (hitCondition) {
                hits = hits + 1;
            }

        }

        if (hits == 0) {
            Toast.makeText(this, "Ooops! You have no right answers... try again!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (hits == 1) {
            Toast.makeText(this, "One hit... keep trying!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (hits == 2) {
            Toast.makeText(this, "Two hits! You almost have it... ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (hits == 3) {
            Toast.makeText(this, "AWESOME!!", Toast.LENGTH_SHORT).show();
            explain();
        }


    }

    /* Asks for a new quiz */
    public void startNewQuiz(View view) {

        buildQuiz(); /* starts another quiz */

    }

    public void explain() {
        setContentView(R.layout.explanation_layout);

        /* Explanations are set */
        for (int i = 0; i <= 2; i++) {
            int identExplPicture = getResources().getIdentifier("explPict" + (i + 1), "id", getPackageName());
            ImageView imageView = (ImageView) findViewById(identExplPicture);
            int identDrawable = getResources().getIdentifier(listOfTopics[numbersOfTopics.get(stage)] + (i + 1), "drawable", getPackageName());
            imageView.setImageResource(identDrawable);

            int identExplText = getResources().getIdentifier("explText" + (i + 1), "id", getPackageName());
            TextView textView = (TextView) findViewById(identExplText);
            int identExplString = getResources().getIdentifier("expl_" + listOfTopics[numbersOfTopics.get(stage)] + (i + 1), "string", getPackageName());
            textView.setText(identExplString);
        }

    }

    public void survey() {
        setContentView(R.layout.survey_layout);

        /* Radio Buttons are set */
        for (int i = 0; i <= 2; i++) {
            int identRadioButton = getResources().getIdentifier("radio_topic" + (i + 1), "id", getPackageName());
            RadioButton radioButton = (RadioButton) findViewById(identRadioButton);
            int identRadioString = getResources().getIdentifier(listOfTopics[numbersOfTopics.get(i)], "string", getPackageName());
            radioButton.setText(identRadioString);
        }
    }

    /* Leads to the final view for radio button 1 */
    public void finalView1(View view) {

        setContentView(R.layout.final_layout);
        chosen = listOfTopics[numbersOfTopics.get(0)];
        int identChosenTopic = getResources().getIdentifier(chosen, "string", getPackageName());
        TextView chosenTopic = (TextView) findViewById(R.id.chosen_topic);
        chosenTopic.setText(identChosenTopic);
    }

    /* Leads to the final view for radio button 2 */
    public void finalView2(View view) {

        setContentView(R.layout.final_layout);
        chosen = listOfTopics[numbersOfTopics.get(1)];
        int identChosenTopic = getResources().getIdentifier(chosen, "string", getPackageName());
        TextView chosenTopic = (TextView) findViewById(R.id.chosen_topic);
        chosenTopic.setText(identChosenTopic);
    }

    /* Leads to the final view for radio button 3 */
    public void finalView3(View view) {

        setContentView(R.layout.final_layout);
        chosen = listOfTopics[numbersOfTopics.get(2)];
        int identChosenTopic = getResources().getIdentifier(chosen, "string", getPackageName());
        TextView chosenTopic = (TextView) findViewById(R.id.chosen_topic);
        chosenTopic.setText(identChosenTopic);
    }

    /* Intents to Wikipedia webpage */
    public void intentWikipedia(View view) {

        int identWebpage = getResources().getIdentifier("wikipedia_" + chosen, "string", getPackageName());
        String nameWebpage = getResources().getString(identWebpage);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(nameWebpage));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /* Intents to Mathifold webpage */
    public void intentMathifold(View view) {

        int identWebpage = getResources().getIdentifier("mathifold_" + chosen, "string", getPackageName());
        String nameWebpage = getResources().getString(identWebpage);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(nameWebpage));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}





