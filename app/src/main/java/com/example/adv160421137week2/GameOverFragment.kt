package com.example.adv160421137week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160421137week2.databinding.FragmentGameOverBinding


class GameOverFragment : Fragment() {
    private lateinit var binding : FragmentGameOverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameOverBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener(){
            val action = GameOverFragmentDirections.actionGameOverFragmentToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
        arguments?.let {
            val score = GameOverFragmentArgs.fromBundle(requireArguments()).score
            binding.txtPlayerScore.text = "Your score is $score"
        }
    }


}