package com.example.cpacheco4983.myfirstapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PalindromeTesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome_tester);

        final EditText inputText = findViewById(R.id.palindromeTestInput);
        final Button isPalindromeBtn = findViewById(R.id.testStringBtn);

        // onClick run isPalindrome method to check string
        isPalindromeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView testStringTV = findViewById(R.id.palindromeTestInput);
                String testString = testStringTV.getText().toString().toUpperCase();
                String scrubbedString = testString.replaceAll("[^A-Za-z0-9]", "");
                TextView isPalindromeResult = findViewById(R.id.isPalindromeResult);

                // Don't run the method if there aren't more than 2 valid characters
                if(scrubbedString.length() < 2) {
                    isPalindromeResult.setText(R.string.palindrome_invalid_input);
                } else {
                    if(isPalindrome(scrubbedString)) {
                        isPalindromeResult.setText(R.string.string_is_palindrome);
                    } else {
                        isPalindromeResult.setText(R.string.string_is_not_palindrome);
                    }
                }
                // Hide keyboard when user clicks button.
                // Thought this would be taken care of by the onFocusChangeListener but it was not
                hideKeyboard(v);
            }
        });

        // Hide the keyboard if user clicks outside of text box
        inputText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
    }

    // Method to check if string input is a palindrome by checking original text against reversed text
    // Don't really need this since I'm only using it once I guess but I think my code looks cleaner with it
    private boolean isPalindrome(String scrubbedString) {
        boolean isPalindrome = false;
        String reverseScrubbedString = new StringBuilder(scrubbedString).reverse().toString();

        if(scrubbedString.equals(reverseScrubbedString)) {
            isPalindrome = true;
        }

        return isPalindrome;
    }

    // Hide the keyboard so they can see the output
    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
