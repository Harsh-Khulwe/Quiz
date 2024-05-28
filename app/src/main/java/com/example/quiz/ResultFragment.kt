package com.example.quiz

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var wompMp: MediaPlayer
    private lateinit var congratsMp: MediaPlayer
    private lateinit var wonMp: MediaPlayer

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        wompMp = MediaPlayer.create(this.activity, R.raw.womp)
        congratsMp = MediaPlayer.create(this.activity, R.raw.congratulations)
        wonMp = MediaPlayer.create(this.activity, R.raw.winclick)

        val score = requireArguments().getString("Score")
        val resultList = requireArguments().getSerializable("resultList") as ArrayList<Question>

        if (score != null) {
            if (score.toInt() < 5) {
                binding.tvMessage.text = "Improve Yourself!!"
                wompMp.start()
            }
            else if (score.toInt() < 8) {
                congratsMp.start()
                binding.tvMessage.text = "You can do better!!"
            }
            else if (score.toInt() < 10) {
                congratsMp.start()
                binding.tvMessage.text = "Just a bit more effort!!"
            }
            else {
                binding.tvMessage.text = "You banged it!!"
                wonMp.start()
            }
        }
        binding.tvScore.append("$score / ${resultList.size}")

        binding.rvResult.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        binding.rvResult.adapter = ResultRecyclerViewAdapter(resultList)

        return binding.root
    }
}