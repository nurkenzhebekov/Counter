package com.example.musicplayer2fragrv2act

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer2fragrv2act.databinding.ItemMusicPlaylistBinding

class MusicAdapter(
    val musicPlayList: List<MusicPlaylist>,
    val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MusicViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(songName: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(ItemMusicPlaylistBinding.inflate(LayoutInflater
            .from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = musicPlayList.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicPlayList[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(musicPlayList[position].songName)
        }
    }
}

class MusicViewHolder(private val binding: ItemMusicPlaylistBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(musicPlaylist: MusicPlaylist) {
        binding.tvSongNumber.text = musicPlaylist.songNumber.toString()
        binding.tvSongName.text = musicPlaylist.songName
        binding.tvSingerName.text = musicPlaylist.singerName
        binding.tvSongDuration.text = musicPlaylist.songDuration
    }
}