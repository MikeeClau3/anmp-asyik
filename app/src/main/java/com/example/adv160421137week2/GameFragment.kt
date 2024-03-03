package com.example.adv160421137week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.adv160421137week2.databinding.FragmentGameBinding
import com.example.adv160421137week2.databinding.FragmentMainBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private  lateinit var binding: FragmentGameBinding
    private var angka1 : Int = 0
    private var angka2 : Int = 0
    public var nilai = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root

    }

    private fun randomNumberGenerator(){
        angka1 = Random.nextInt(101)
        angka2 = Random.nextInt(101)

    }
    private fun displayQuest(){
        binding.txtQuestionMath.text = "${angka1} + ${angka2}"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        if(arguments != null){
//            val playerName =
//                GameFragmentArgs.fromBundle(requireArguments()).playerName
//            binding.txtTurn.text = "$playerName's Turn"
//        }
        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }
        randomNumberGenerator()
        displayQuest()


        binding.btnSubmit.setOnClickListener(){
            val answer = binding.txtAnswer.text.toString()
            if(answer == (angka1 + angka2).toString()){
                nilai += 1
                randomNumberGenerator()
                displayQuest()
            }
            else{
                val action = GameFragmentDirections.actionGameFragmentToGameOverFragment(nilai)
                Navigation.findNavController(it).navigate(action)
            }


        }


    }


}