package org.eightfoldpath.solarsystemquiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String EARTH = "earth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scoreQuiz(View view) {
        int totalCorrect = getTotalCorrect();
        Resources res = getResources();
        String resultMessage = res.getString(R.string.result_message) + " " + totalCorrect;
        TextView quizResult = (TextView) findViewById(R.id.quiz_result);
        quizResult.setText(resultMessage);
    }

    private int getTotalCorrect() {
        int totalCorrect = 0;

        boolean madeOfCheese = ((RadioButton) findViewById(R.id.radio_moon_yes)).isChecked();
        Log.i("MainActivity.java", "Moon made of cheese: " + madeOfCheese);
        if (madeOfCheese == false) totalCorrect += 1;

        String planet = ((TextView) findViewById(R.id.third_planet_answer)).getText().toString();
        Log.i("MainActivity.java", "Third planet :" + planet);
        if (planet.toLowerCase().equals(EARTH)) totalCorrect += 1;

        boolean mercuryMoons = ((CheckBox) findViewById(R.id.mercury_moons)).isChecked();
        boolean venusMoons = ((CheckBox) findViewById(R.id.venus_moons)).isChecked();
        boolean jupiterMoons = ((CheckBox) findViewById(R.id.jupiter_moons)).isChecked();
        if (mercuryMoons && venusMoons && !jupiterMoons) {
            totalCorrect += 1;
        }

        boolean saturnRings = ((RadioButton) findViewById(R.id.radio_saturn_rings)).isChecked();
        if (saturnRings) totalCorrect += 1;

        return totalCorrect;

    }

}
