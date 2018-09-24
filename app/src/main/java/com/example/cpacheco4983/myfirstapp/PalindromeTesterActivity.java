package com.example.cpacheco4983.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PalindromeTesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome_tester);

        final Button isPalindromeBtn = findViewById(R.id.testStringBtn);

        // onClick run isPalindrome method to check string
        isPalindromeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView testStringTV = findViewById(R.id.palindromeTestString);
                String testString = testStringTV.getText().toString().toUpperCase();
                TextView isPalindromeResult = findViewById(R.id.isPalindromeResult);

                if(isPalindrome(testString)) {
                    isPalindromeResult.setText(R.string.string_is_palindrome);
                } else {
                    isPalindromeResult.setText(R.string.string_is_not_palindrome);
                }
            }
        });
    }

    // Method to check if string input is a palindrome by checking original text against reversed text
    private boolean isPalindrome(String testString) {
        boolean isPalindrome = false;
        String scrubbedString = testString.replaceAll("[^A-Za-z0-9]", "");
        String reverseScrubbedString = new StringBuilder(scrubbedString).reverse().toString();

        if(scrubbedString.equals(reverseScrubbedString)) {
            isPalindrome = true;
        }

        return isPalindrome;
    }
}
