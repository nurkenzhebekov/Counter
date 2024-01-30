package com.example.musicplayer2fragrv2act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer2fragrv2act.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_music_info_container, MusicInfoFragment()).commit()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_music_playlist_container, MusicPlaylistFragment()).commit()
        }
    }
}