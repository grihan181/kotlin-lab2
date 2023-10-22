package com.example.lab2

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private val TAG = "QuizViewModel"
    var currentIndex = 0
    var isCheater = false
    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex++

        println("questionBank.size " + questionBank.size)
        println("currentIndex $currentIndex")
        if(currentIndex >= questionBank.size) {
            currentIndex = 0;
        }
    }

    fun moveToPrev() {
        currentIndex--;

        println("questionBank.size " + questionBank.size)
        println("currentIndex $currentIndex")
        if(currentIndex < 0) {
            currentIndex = questionBank.size - 1;
        }
    }
    private val questionBank = arrayListOf (
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
}