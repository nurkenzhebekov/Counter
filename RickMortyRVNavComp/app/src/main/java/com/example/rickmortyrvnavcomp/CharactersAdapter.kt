package com.example.rickmortyrvnavcomp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmortyrvnavcomp.databinding.ItemCharactersBinding

class CharactersAdapter(
    private val charactersList: List<Characters>,
    private val clickListener: OnCharacterClickListener
) : RecyclerView.Adapter<CharactersViewHolder>() {

    interface OnCharacterClickListener {
        fun onCharacterClick(character: Characters)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int = charactersList.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(charactersList[position])
    }

}

class CharactersViewHolder(private val binding: ItemCharactersBinding, private val clickListener:
    CharactersAdapter.OnCharacterClickListener): RecyclerView.ViewHolder(binding.root) {
    fun bind(character: Characters) {
        binding.ivCharacter.setImageResource(character.image)
        binding.tvCharacterLifeStatus.text = character.lifeStatus
        binding.tvCharacterName.text = character.name

        itemView.setOnClickListener {
            clickListener.onCharacterClick(character)
        }
    }
}