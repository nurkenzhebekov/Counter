package com.example.musicplayer2fragrv2act

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicplayer2fragrv2act.databinding.FragmentMusicPlaylistBinding

class MusicPlaylistFragment : Fragment() {

    private lateinit var binding: FragmentMusicPlaylistBinding
    private var songNumberCounter = 1   
    private val musicPlayList = arrayListOf(
        MusicPlaylist(getNextSongNumber(), "Blank Space", "Taylor Swift", "3:22"),
        MusicPlaylist(getNextSongNumber(), "Watch Me", "Silento", "5:36"),
        MusicPlaylist(getNextSongNumber(), "Earned It", "The Weekend", "4:51"),
        MusicPlaylist(getNextSongNumber(), "The Hills", "The Weekend", "3:41"),
        MusicPlaylist(getNextSongNumber(), "Writing's On The Wall", "Sam Smith", "5:33"),
        MusicPlaylist(getNextSongNumber(), "You Are My Destiny", "Mirbek Atabekov", "4:00"),
        MusicPlaylist(getNextSongNumber(), "Self Control", "Laura Branigan", "4:07"),
        MusicPlaylist(getNextSongNumber(), "Songbird", "Kenny G", "5:05"),
        MusicPlaylist(getNextSongNumber(), "Denzel W.", "Ulukmanapo", "3:28"),
        MusicPlaylist(getNextSongNumber(), "Dreams", "ZHU & Nero", "3:42")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMusicPlaylistBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MusicAdapter(musicPlayList, object : MusicAdapter.OnItemClickListener {
            override fun onItemClick(songName: String) {
                val intent = Intent(activity, MusicInfoActivity::class.java)
                intent.putExtra(Keys.KEY_SONG_NAME, songName)
                startActivity(intent)
            }
        })
        binding.rvMusicPlaylist.adapter = adapter
    }

    private fun getNextSongNumber(): Int {
        return songNumberCounter++
    }
}