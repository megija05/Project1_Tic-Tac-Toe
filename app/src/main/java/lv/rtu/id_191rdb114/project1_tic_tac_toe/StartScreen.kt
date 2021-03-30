package lv.rtu.id_191rdb114.project1_tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.system.exitProcess

class StartScreen : AppCompatActivity() {
    lateinit var singleplayer: Button
    lateinit var multiplayer: Button
    lateinit var exit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)//activity_main)


        singleplayer = findViewById(R.id.single_player)
        multiplayer = findViewById(R.id.multi_player)
        exit = findViewById(R.id.exit)

        singleplayer.setOnClickListener {
            startActivity(Intent(this, SecondScreen1::class.java))
        }
        multiplayer.setOnClickListener {
            startActivity(Intent(this, SecondScreen::class.java))
        }
        exit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}