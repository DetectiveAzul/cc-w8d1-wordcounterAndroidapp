package com.example.detectiveazul.wordcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WordCounterActivity extends AppCompatActivity {
    private EditText wordsToCountText;
    private Button countButton;
    private TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_counter);
        wordsToCountText = findViewById(R.id.wordsToCountText);
        countButton = findViewById(R.id.countButton);
        countView = findViewById(R.id.countView);
    }

    public String getWordsToCountText() {
        return wordsToCountText.getText().toString();
    }

    public void setCountView(String wordCount) {
        this.countView.setText(wordCount);
    }

    public void onCountButtonClicked(View view) {
        WordCounter wordCounter = new WordCounter(getWordsToCountText());
        String string = wordCounter.getStringWordsByCount();
        setCountView(string);
    }
}
