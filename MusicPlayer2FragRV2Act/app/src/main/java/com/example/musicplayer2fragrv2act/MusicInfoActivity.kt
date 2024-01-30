package com.example.musicplayer2fragrv2act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer2fragrv2act.databinding.ActivityMusicInfoBinding

class MusicInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val songName = intent.getStringExtra(Keys.KEY_SONG_NAME)

        binding.tvSongNameInActivity.text = songName
    }
}