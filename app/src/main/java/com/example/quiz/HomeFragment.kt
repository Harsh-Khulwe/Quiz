package com.example.quiz

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.quiz.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var startMp: MediaPlayer
    private lateinit var settingsMp: MediaPlayer

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        startMp = MediaPlayer.create(this.activity, R.raw.startclick)
        settingsMp = MediaPlayer.create(this.activity, R.raw.errorclick)

        binding.btnStart.setOnClickListener {
            startMp.start()
            it.findNavController().navigate(R.id.action_homeFragment_to_quizFragment)
        }

        binding.btnSettings.setOnClickListener {
            settingsMp.start()
            Toast.makeText(
                activity,
                "This option is currently under development",
                Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }
}