package com.example.quiz

import java.io.Serializable

data class Question(
    val id: Int,
    val question: String,
    val opOne: String,
    val opTwo: String,
    val opThree: String,
    val opFour: String,
    val correctAns: String,
    var response: String
): Serializable
