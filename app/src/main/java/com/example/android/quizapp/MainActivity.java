package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variable to keep the total score in the quiz
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void checkQuestion1() {
        RadioGroup answer1 = (RadioGroup) findViewById(R.id.answer1);

        if (answer1.getCheckedRadioButtonId() == R.id.correctAnswer1)
            score++;
    }

    private void checkQuestion2() {
        RadioGroup answer2 = (RadioGroup) findViewById(R.id.answer2);

        if (answer2.getCheckedRadioButtonId() == R.id.correctAnswer2)
            score++;
    }

    private void checkQuestion3() {
        RadioGroup answer3 = (RadioGroup) findViewById(R.id.answer3);

        if (answer3.getCheckedRadioButtonId() == R.id.correctAnswer3)
            score++;
    }

    private void checkQuestion4() {
        EditText answer4 = (EditText) findViewById(R.id.answer4);

        if (answer4.getText().toString().equals(getString(R.string.correct_answer41)) ||
                answer4.getText().toString().equals(getString(R.string.correct_answer42)))
            score++;
    }

    private void checkQuestion5() {
        CheckBox answer51 = (CheckBox) findViewById(R.id.answer51);

        if (answer51.isChecked()) {
            CheckBox answer52 = (CheckBox) findViewById(R.id.answer52);
            if (!answer52.isChecked()) {
                CheckBox answer53 = (CheckBox) findViewById(R.id.answer53);
                if (!answer53.isChecked()) {
                    CheckBox answer54 = (CheckBox) findViewById(R.id.answer54);
                    if (answer54.isChecked())
                        score++;
                }
            }
        }
    }

    private void checkQuestion6() {
        EditText answer6 = (EditText) findViewById(R.id.answer6);
        if (answer6.getText().toString().equals(getString(R.string.correct_answer61)) ||
                answer6.getText().toString().equals(getString(R.string.correct_answer62)))
            score++;
    }


    /**
     * This method is called when the submit answers button is clicked.
     */

    public void submitAnswers(View view) {
        score = 0;
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();
        checkQuestion6();
        display(score);
    }


    /**
     * Method which defines how the result appears in screen.
     *
     * @param score is the final score, when submit answers button is pressed
     */

    private void display(int score) {
        String message;

        if (score == 6) message = "Excellent!!!";
        else if (score > 3) message = "Not bad!";
        else message = "I'm sorry. Try again!";

        message += "\n" + "Your score is: " + score + " points";

        LinearLayout layout = new LinearLayout(this);
        TextView tv = new TextView(this);

        // TextView properties
        tv.setTextSize(22);

        tv.setText(message);
        layout.addView(tv);

        Toast toast = new Toast(this);
        // Set the layout as Toast View
        toast.setView(layout);

        // Position toast 100 dp from bottom
        toast.setGravity(Gravity.BOTTOM, 0, 100);
        toast.show();
    }
}

