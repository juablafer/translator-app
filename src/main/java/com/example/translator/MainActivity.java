package com.example.translator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSourceWord, textViewCorrect, textViewWrong;
    private EditText editTextResultWord;
    private Button buttonReset, buttonCheck;
    int correctAnswers = 0, wrongAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSourceWord = findViewById(R.id.textViewSourceWord);
        textViewCorrect = findViewById(R.id.textViewCorrect);
        textViewWrong = findViewById(R.id.textViewWrong);

        editTextResultWord = findViewById(R.id.editTextResultWord);

        getRandomWord();

    }

    private void getRandomWord() {
        Random rand = new Random();
        Object[] keys = Dictionary.VALUES.keySet().toArray();
        int maxWords = rand.nextInt(keys.length);
        String randomWord = (String) keys[maxWords];
        textViewSourceWord.setText(randomWord);
    }

    public void resetAnswerCounter(View view) {
        correctAnswers = 0;
        wrongAnswers = 0;
        textViewCorrect.setText("Correct answers: " + correctAnswers);
        textViewWrong.setText("Wrong answers: " + wrongAnswers);

    }

    public void checkWord(View view) {
        String userGuess = editTextResultWord.getText().toString();
        String correctAnswer = Dictionary.VALUES.get(textViewSourceWord.getText().toString());
        if (!"".equals(userGuess)) {
            if (correctAnswer.equalsIgnoreCase(userGuess)) {
                textViewCorrect.setText("Correct answers: " + ++correctAnswers);
                getRandomWord();
                editTextResultWord.setText("");
            } else {
                textViewWrong.setText("Wrong answers: " + ++wrongAnswers);
            }
        }
    }
}