package com.example.rickmortyrvnavcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.rickmortyrvnavcomp.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private val charactersList = arrayListOf(
        Characters(R.drawable.img, "Alive", "Rick Sanchez"),
        Characters(R.drawable.img_1, "Alive", "Morty Smith"),
        Characters(R.drawable.img_2, "Dead", "Albert Einstein"),
        Characters(R.drawable.img_3, "Alive", "Jerry Smith")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharactersAdapter(charactersList, object : CharactersAdapter.OnCharacterClickListener {
            override fun onCharacterClick(character: Characters) {
                val charactersInfo = bundleOf(Keys.KEY_CHARACTER_INFO to character)
                findNavController().navigate(R.id.charactersInfoFragment, charactersInfo)
            }
        })
        binding.rvCharacters.adapter = adapter

    }
}