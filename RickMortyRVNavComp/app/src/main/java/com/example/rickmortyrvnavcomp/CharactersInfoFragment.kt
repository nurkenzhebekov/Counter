package com.example.rickmortyrvnavcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickmortyrvnavcomp.databinding.FragmentCharactersInfoBinding

class CharactersInfoFragment : Fragment() {

    private lateinit var binding: FragmentCharactersInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharactersInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = arguments?.getSerializable(Keys.KEY_CHARACTER_INFO) as Characters
        binding.ivCharacter.setImageResource(character.image)
        binding.tvCharacterLifeStatus.text = character.lifeStatus
        binding.tvCharacterName.text = character.name
    }
}