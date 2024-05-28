package com.example.quiz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.quiz.databinding.ListItemBinding

class ResultRecyclerViewAdapter(private val resultList: ArrayList<Question>): RecyclerView.Adapter<ResultRecyclerViewAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(resultList[position])
    }

    inner class ResultViewHolder(private val binding: ListItemBinding) : ViewHolder(binding.root) {
        fun bind(question: Question) {
            "Question: ${question.id}/${resultList.size}".also { binding.tvDisplayQuesNo.text = it }
            binding.tvDisplayQues.text = question.question
            "CORRECT ANSWER: ${question.correctAns}\nYOUR ANSWER: ${question.response}".also {
                binding.tvDisplayAns.text = it
            }

            if (question.response == question.correctAns) {
                binding.clResult.setBackgroundResource(R.drawable.correctans)
            }
            else
                binding.clResult.setBackgroundResource(R.drawable.wrongans)
        }
    }
}