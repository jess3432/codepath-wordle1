package com.example.wordle

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var counter = 0

    var wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    var guessOutput = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = wordToGuess

        val editText = findViewById<EditText>(R.id.editText)

        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView6 = findViewById<TextView>(R.id.textView6)
        val textView7 = findViewById<TextView>(R.id.textView7)

        button.setOnClickListener {

            val userGuess = editText.text.toString().uppercase()

            Toast.makeText(it.context, "Guess submitted for $userGuess!", Toast.LENGTH_SHORT).show()
            counter++

            guessOutput = checkGuess(userGuess) //checking user's guess

            if(counter==1) {
                //Displaying user's guess
                textView2.text = "Guess 1: $userGuess"
                textView2.visibility = View.VISIBLE

                //Checking guess against word
                textView3.text = "Guess 1 Check: $guessOutput"
                textView3.visibility = View.VISIBLE
            }

            if(counter==2) {
                //Displaying user's guess
                textView4.text = "Guess 2: $userGuess"
                textView4.visibility = View.VISIBLE

                //Checking guess against word
                textView5.text = "Guess 2 Check: $guessOutput"
                textView5.visibility = View.VISIBLE
            }

            if(counter==3) {
                textView6.text = "Guess 3: $userGuess"
                textView6.visibility = View.VISIBLE

                //Checking guess against word
                textView7.text = "Guess 3 Check: $guessOutput"
                textView7.visibility = View.VISIBLE

                //Max guesses (3), button disappears
                Toast.makeText(it.context, "You have exceeded your max number of guesses (3)!", Toast.LENGTH_SHORT).show()
                button.visibility=View.INVISIBLE
                }

            }
        }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""

        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}

