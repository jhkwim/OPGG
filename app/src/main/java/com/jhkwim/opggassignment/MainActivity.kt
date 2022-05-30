package com.jhkwim.opggassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jhkwim.opggassignment.views.GameInfoFragment
import com.jhkwim.opggassignment.views.SummonerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_summoner, SummonerFragment::class.java, null, "SummonerFragment")
            .replace(R.id.container_game_info, GameInfoFragment::class.java, null, "GameInfoFragment")
            .commit()

    }

}