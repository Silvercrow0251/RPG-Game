package com.example.lastchance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_screen.*

class GameScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        val story = Story(this)

        choice1.setOnClickListener{

            story.selectPosition(story.nextPosition1)
        }
        choice2.setOnClickListener{

            story.selectPosition(story.nextPosition2)
        }
        choice3.setOnClickListener{

            story.selectPosition(story.nextPosition3)
        }
        choice4.setOnClickListener{

            story.selectPosition(story.nextPosition4)
        }

        story.startingPoint()
    }
    fun goTitleScreen(){

        val titleS = Intent(this, TitleScreen::class.java)
        startActivity(titleS)
    }
}