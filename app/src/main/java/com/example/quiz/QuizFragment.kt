package com.example.quiz

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.quiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private val questionList = Questions().getQuestions()
    private lateinit var backAndForwardMp: MediaPlayer
    private lateinit var noobMp: MediaPlayer
    private lateinit var submitAllMp: MediaPlayer
    private lateinit var selectMp: MediaPlayer

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        backAndForwardMp = MediaPlayer.create(this.activity, R.raw.backandforward)
        noobMp = MediaPlayer.create(this.activity, R.raw.noob)
        submitAllMp = MediaPlayer.create(this.activity, R.raw.submitall)
        selectMp = MediaPlayer.create(this.activity, R.raw.selectclick)

        var i = 0
        setQuestion(0)
        getResponse(0)

        binding.fabNext.setOnClickListener {
            if (i < questionList.size - 1) {
                backAndForwardMp.start()
                i++
                setQuestion(i)
                binding.apply {
                    if(tvOp1.text == questionList[i].response)
                        tvOp1.setBackgroundColor(Color.parseColor("#add8e6"))
                    else if(tvOp2.text == questionList[i].response)
                        tvOp2.setBackgroundColor(Color.parseColor("#add8e6"))
                    else if(tvOp3.text == questionList[i].response)
                        tvOp3.setBackgroundColor(Color.parseColor("#add8e6"))
                    else if(tvOp4.text == questionList[i].response)
                        tvOp4.setBackgroundColor(Color.parseColor("#add8e6"))
                }
                getResponse(i)
            }
        }

        binding.fabPrevious.setOnClickListener {
            if (i > 0) {
                backAndForwardMp.start()
                i--
                setQuestion(i)
                binding.apply {
                    if(tvOp1.text == questionList[i].response)
                        tvOp1.setBackgroundColor(Color.parseColor("#add8e6"))
                    else if(tvOp2.text == questionList[i].response)
                        tvOp2.setBackgroundColor(Color.parseColor("#add8e6"))
                    else if(tvOp3.text == questionList[i].response)
                        tvOp3.setBackgroundColor(Color.parseColor("#add8e6"))
                    else if(tvOp4.text == questionList[i].response)
                        tvOp4.setBackgroundColor(Color.parseColor("#add8e6"))
                }
                getResponse(i)
            }
        }

        binding.btnSubmit.setOnClickListener {
            if(binding.btnSubmit.text == "SURRENDER")
                noobMp.start()
            else
                submitAllMp.start()
            Thread.sleep(1500)
            findScore()
        }

        return binding.root
    }

    private fun setQuestion(i: Int) {
        binding.apply {
            tvQues.text = questionList[i].question
            tvOp1.text = questionList[i].opOne
            tvOp2.text  = questionList[i].opTwo
            tvOp3.text = questionList[i].opThree
            tvOp4.text = questionList[i].opFour
            tvOp1.setBackgroundColor(Color.parseColor("white"))
            tvOp2.setBackgroundColor(Color.parseColor("white"))
            tvOp3.setBackgroundColor(Color.parseColor("white"))
            tvOp4.setBackgroundColor(Color.parseColor("white"))
            tvQuesNo.text = "Question : ${i+1}/${questionList.size}"
        }
    }

    private fun getResponse(i: Int) {
        binding.apply {
            tvOp1.setOnClickListener {
                selectMp.start()
                questionList[i].response = tvOp1.text.toString()
                tvOp2.setBackgroundColor(Color.parseColor("white"))
                tvOp3.setBackgroundColor(Color.parseColor("white"))
                tvOp4.setBackgroundColor(Color.parseColor("white"))
                tvOp1.setBackgroundColor(Color.parseColor("#add8e6"))
                surrOrSubmit()
            }

            tvOp2.setOnClickListener {
                selectMp.start()
                questionList[i].response = tvOp2.text.toString()
                tvOp1.setBackgroundColor(Color.parseColor("white"))
                tvOp3.setBackgroundColor(Color.parseColor("white"))
                tvOp4.setBackgroundColor(Color.parseColor("white"))
                tvOp2.setBackgroundColor(Color.parseColor("#add8e6"))
                surrOrSubmit()
            }

            tvOp3.setOnClickListener {
                selectMp.start()
                questionList[i].response = tvOp3.text.toString()
                tvOp1.setBackgroundColor(Color.parseColor("white"))
                tvOp2.setBackgroundColor(Color.parseColor("white"))
                tvOp4.setBackgroundColor(Color.parseColor("white"))
                tvOp3.setBackgroundColor(Color.parseColor("#add8e6"))
                surrOrSubmit()
            }

            tvOp4.setOnClickListener {
                selectMp.start()
                questionList[i].response = tvOp4.text.toString()
                tvOp1.setBackgroundColor(Color.parseColor("white"))
                tvOp2.setBackgroundColor(Color.parseColor("white"))
                tvOp3.setBackgroundColor(Color.parseColor("white"))
                tvOp4.setBackgroundColor(Color.parseColor("#add8e6"))
                surrOrSubmit()
            }
        }
    }

    private fun findScore() {
        var count = 0
        for (j in 0..<questionList.size) {
            if (questionList[j].response == questionList[j].correctAns)
                count++
        }
        val bundle = bundleOf("Score" to count.toString(), "resultList" to ArrayList(questionList))
        binding.btnSubmit.findNavController().navigate(R.id.action_quizFragment_to_resultFragment, bundle)
    }

    private fun surrOrSubmit() {
        var count = 0
        for (j in 0..<questionList.size) {
            if (questionList[j].response != "") {
                count++
            }
        }
        if (count == questionList.size) {
            binding.btnSubmit.text = "SUBMIT"
            binding.btnSubmit.setBackgroundColor(Color.parseColor("green"))
        }
    }
}