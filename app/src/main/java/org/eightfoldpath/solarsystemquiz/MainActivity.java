package org.eightfoldpath.solarsystemquiz;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String EARTH = "earth";
    private final static int HIGH_SCORE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scoreQuiz(View view) {
        int totalCorrect = getTotalCorrect();
        Resources res = getResources();
        String toastMessage = "";
        if (totalCorrect == HIGH_SCORE) {
            toastMessage += "\n" + res.getString(R.string.expert_message);
        } else {
            toastMessage += "\n" + res.getString(R.string.try_again_message);
        }
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        toast.show();

        TextView quizResult = (TextView) findViewById(R.id.quiz_result);
        String resultMessage = res.getString(R.string.result_message) + " " + totalCorrect;
        quizResult.setText(resultMessage);
    }

    private int getTotalCorrect() {
        int totalCorrect = 0;

        boolean madeOfCheese = ((RadioButton) findViewById(R.id.radio_moon_yes)).isChecked();
        Log.i("MainActivity.java", "Moon made of cheese: " + madeOfCheese);
        if (madeOfCheese == false) totalCorrect += 1;

        String planet = ((TextView) findViewById(R.id.third_planet_answer)).getText().toString();
        Log.i("MainActivity.java", "Third planet :" + planet);
        if (planet.toLowerCase().equals(EARTH)) totalCorrect++;

        boolean mercuryMoons = ((CheckBox) findViewById(R.id.mercury_moons)).isChecked();
        boolean venusMoons = ((CheckBox) findViewById(R.id.venus_moons)).isChecked();
        boolean jupiterMoons = ((CheckBox) findViewById(R.id.jupiter_moons)).isChecked();
        if (mercuryMoons && venusMoons && !jupiterMoons) {
            totalCorrect++;
        }

        boolean saturnRings = ((RadioButton) findViewById(R.id.radio_saturn_rings)).isChecked();
        if (saturnRings) totalCorrect++;

        return totalCorrect;

    }

}
