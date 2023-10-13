package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var currentIndex = 0
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)

        questionTextView = findViewById(R.id.textView)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }
        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        prevButton.setOnClickListener { view: View ->
            updateWithMinusInd()
        }
        nextButton.setOnClickListener { view: View ->
            updateWithPlusInd()
        }

        questionTextView.setOnClickListener { view: View ->
            updateWithPlusInd()
        }
        updateQuestion()
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
/*        questionBank.removeAt(currentIndex)
        currentIndex--;*/
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
    private fun updateWithPlusInd() {
        currentIndex++;

        println("questionBank.size " + questionBank.size)
        println("currentIndex " + currentIndex)
        if(currentIndex >= questionBank.size) {
            currentIndex = 0;
        }
        updateQuestion()
    }

    private fun updateWithMinusInd() {
        currentIndex--;

        println("questionBank.size " + questionBank.size)
        println("currentIndex " + currentIndex)
        if(currentIndex < 0) {
            currentIndex = questionBank.size - 1;
        }
        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId =
            questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)

    }
    private val questionBank = arrayListOf (
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
}