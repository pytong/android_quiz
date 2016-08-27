package com.puiyeetong.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitAnswers(View view) {
        int numCorrect = 0;

        // Check question 1 answer
        EditText question1Field = (EditText) findViewById(R.id.question1_answer);
        String question1Answer = question1Field.getText().toString();

        if(question1Answer.compareToIgnoreCase(getString(R.string.picnic)) == 0) {
            numCorrect += 1;
        }

        // Check question 2 answer
        RadioGroup question2RadioButtonGroup = (RadioGroup)findViewById(R.id.question2_answer);
        RadioButton checkedButton = (RadioButton)findViewById(question2RadioButtonGroup.getCheckedRadioButtonId());

        String question2Answer;
        if(checkedButton != null) {
            question2Answer = checkedButton.getText().toString();
            if(question2Answer.compareToIgnoreCase(getString(R.string.mozzarella)) == 0) {
                numCorrect += 1;
            }
        }

        // Check question 3 answer
        CheckBox waterCheckBox = (CheckBox) findViewById(R.id.water_checkbox);
        boolean hasWater = waterCheckBox.isChecked();

        CheckBox waterChemicalNotationCheckBox = (CheckBox) findViewById(R.id.water_chemical_notation_checkbox);
        boolean hasWaterChemicalNotation = waterChemicalNotationCheckBox.isChecked();

        CheckBox wineCheckBox = (CheckBox) findViewById(R.id.wine_checkbox);
        boolean hasWine = wineCheckBox.isChecked();

        if(hasWater && hasWaterChemicalNotation && !hasWine) {
            numCorrect += 1;
        }

        // Check question 4 answer
        EditText question4Field = (EditText) findViewById(R.id.question4_answer);
        String question4Answer = question4Field.getText().toString();

        if(question4Answer.compareToIgnoreCase(getString(R.string.corona)) == 0) {
            numCorrect += 1;
        }

        // Check question 5 answer
        EditText question5Field = (EditText) findViewById(R.id.question5_answer);
        String question5Answer = question5Field.getText().toString();

        if(question5Answer.compareToIgnoreCase(getString(R.string.paprika)) == 0) {
            numCorrect += 1;
        }

        Toast.makeText(this, "You got " + numCorrect + " points", Toast.LENGTH_LONG).show();
    }
}
