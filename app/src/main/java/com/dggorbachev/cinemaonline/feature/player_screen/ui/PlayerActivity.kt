package com.dggorbachev.cinemaonline.feature.player_screen.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dggorbachev.cinemaonline.R
import com.dggorbachev.cinemaonline.base.common.Constants
import com.dggorbachev.cinemaonline.databinding.ActivityPlayerBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class PlayerActivity : YouTubeBaseActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras
        val value: String = b?.getString("videoKey") ?: "dQw4w9WgXcQ"


        val ytPlayer = binding.playerView
        ytPlayer.initialize(
            Constants.YT_API_KEY,
            object : YouTubePlayer.OnInitializedListener {
                // Implement two methods by clicking on red
                // error bulb inside onInitializationSuccess
                // method add the video link or the playlist
                // link that you want to play In here we
                // also handle the play and pause
                // functionality
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider,
                    youTubePlayer: YouTubePlayer, b: Boolean
                ) {
                    youTubePlayer.loadVideo(value)
                    youTubePlayer.play()
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {

                }
            })
    }
}