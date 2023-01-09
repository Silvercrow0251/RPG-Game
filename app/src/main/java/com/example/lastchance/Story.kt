package com.example.lastchance

import android.view.View
import kotlinx.android.synthetic.main.activity_game_screen.*

class Story (val gs: GameScreen){

    var nextPosition1 = ""
    var nextPosition2 = ""
    var nextPosition3 = ""
    var nextPosition4 = ""
    var masterKey = false
    var killedSadako = false

    fun selectPosition(position: String){

        when(position){
            "startingPoint" -> startingPoint()
            "clue" -> clue()
            "message" -> message()
            "video" -> video()
            "notebook" -> notebook()
            "door" -> door()
            "Open_door" -> Open_door()
            "dead" -> dead()
            "goTitleScreen" -> gs.goTitleScreen()
        }
    }
    fun showAllButtons(){
        gs.choice1.setVisibility(View.VISIBLE)
        gs.choice2.setVisibility(View.VISIBLE)
        gs.choice3.setVisibility(View.VISIBLE)
        gs.choice4.setVisibility(View.VISIBLE)
    }


    fun startingPoint(){

        gs.gameImageView.setImageResource(R.drawable.door)
        gs.gameTextView.setText("You just woke up in a strange place. There is a door nearby.\n\nWhat will you do?")

        gs.choice1.setText("Go to the door")
        gs.choice2.setText("Look Around")
        gs.choice3.setText("Check your phone")
        gs.choice4.setText("Try to recall what\n just happened")

        showAllButtons()


        nextPosition1 = "door"
        nextPosition2 = "notebook"
        nextPosition3 = "message"
        nextPosition4 = "clue"
    }
    fun clue(){

        gs.gameImageView.setImageResource(R.drawable.remember)
        gs.gameTextView.setText("Nothing")
//        gs.gameTextView.setText("You hear voices on the other side")

        gs.choice1.setText("Think")
        gs.choice2.setText("")
        gs.choice3.setText("")
        gs.choice4.setText("")
        gs.choice2.setVisibility(View.INVISIBLE)
        gs.choice3.setVisibility(View.INVISIBLE)
        gs.choice4.setVisibility(View.INVISIBLE)

        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }
    fun message(){
        gs.gameImageView.setImageResource(R.drawable.msg)
        gs.gameTextView.setText("You find a video recording")

        gs.choice1.setText("Play video")
        gs.choice2.setText("Ignore message")
        gs.choice3.setText("")
        gs.choice4.setText("")
        gs.choice3.setVisibility(View.INVISIBLE)
        gs.choice4.setVisibility(View.INVISIBLE)

        nextPosition1 = "video"
        nextPosition2 = "startingPoint"
        nextPosition3 = ""
        nextPosition4 = ""
    }
    fun video(){

        if(masterKey==false){
            gs.gameImageView.setImageResource(R.drawable.sadako)
            gs.gameTextView.setText("You watched the Ring!!!\nSadako appeared in front of you and you died")

            gs.choice1.setText(">")
            gs.choice2.setText("")
            gs.choice3.setText("")
            gs.choice4.setText("")
            gs.choice2.setVisibility(View.INVISIBLE)
            gs.choice3.setVisibility(View.INVISIBLE)
            gs.choice4.setVisibility(View.INVISIBLE)

            nextPosition1 = "dead"
            nextPosition2 = ""
            nextPosition3 = ""
            nextPosition4 = ""
        }
        if(masterKey==true){
            gs.gameImageView.setImageResource(R.drawable.sadako)
            gs.gameTextView.setText("You defeat sadako with a talisman")

            killedSadako = true

            gs.choice1.setText(">")
            gs.choice2.setText("")
            gs.choice3.setText("")
            gs.choice4.setText("")
            gs.choice2.setVisibility(View.INVISIBLE)
            gs.choice3.setVisibility(View.INVISIBLE)
            gs.choice4.setVisibility(View.INVISIBLE)

            nextPosition1 = "startingPoint"
            nextPosition2 = ""
            nextPosition3 = ""
            nextPosition4 = ""
        }
    }
    fun notebook(){
        gs.gameImageView.setImageResource(R.drawable.notebook)
        gs.gameTextView.setText("You found a notebook, it contains a talisman and a key")

        masterKey = true


        gs.choice1.setText("Back")
        gs.choice2.setText("")
        gs.choice3.setText("")
        gs.choice4.setText("")
        gs.choice2.setVisibility(View.INVISIBLE)
        gs.choice3.setVisibility(View.INVISIBLE)
        gs.choice4.setVisibility(View.INVISIBLE)

        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }
    fun door(){
        gs.gameImageView.setImageResource(R.drawable.message)
        gs.gameTextView.setText("You need a key to open this door.")

        gs.choice1.setText("Open_door")
        gs.choice2.setText("Back")
        gs.choice3.setText("")
        gs.choice4.setText("")
        gs.choice3.setVisibility(View.INVISIBLE)
        gs.choice4.setVisibility(View.INVISIBLE)

        nextPosition1 = "Open_door"
        nextPosition2 = "startingPoint"
        nextPosition3 = ""
        nextPosition4 = ""
    }
    fun Open_door(){
        if(masterKey==true && killedSadako){

            gs.gameImageView.setImageResource(R.drawable.epilogue)
            gs.gameTextView.setText("You haven't gotten out yet, so I'll \njust leave it here as a cliffhanger." +
                    "\n\nI forgot to mention that this was just the prologue. Oh well...")

            gs.choice1.setText("Go to the title screen")
            gs.choice2.setText("")
            gs.choice3.setText("")
            gs.choice4.setText("")
            gs.choice2.setVisibility(View.INVISIBLE)
            gs.choice3.setVisibility(View.INVISIBLE)
            gs.choice4.setVisibility(View.INVISIBLE)

            nextPosition1 = "goTitleScreen"
            nextPosition2 = ""
            nextPosition3 = ""
            nextPosition4 = ""
        }
        else{
            gs.gameImageView.setImageResource(R.drawable.sadako)
            gs.gameTextView.setText("Going to the door was a trap!!! Sadako kills you")

            gs.choice1.setText(">")
            gs.choice2.setText("")
            gs.choice3.setText("")
            gs.choice4.setText("")
            gs.choice2.setVisibility(View.INVISIBLE)
            gs.choice3.setVisibility(View.INVISIBLE)
            gs.choice4.setVisibility(View.INVISIBLE)

            nextPosition1 = "dead"
            nextPosition2 = ""
            nextPosition3 = ""
            nextPosition4 = ""
        }
    }
    fun dead(){
        gs.gameImageView.setImageResource(R.drawable.gameover)
        gs.gameTextView.setText("You are dead. You didn't see that coming did you?\n\n")

        gs.choice1.setText("Go to the title \nscreen")
        gs.choice2.setText("")
        gs.choice3.setText("")
        gs.choice4.setText("")
        gs.choice2.setVisibility(View.INVISIBLE)
        gs.choice3.setVisibility(View.INVISIBLE)
        gs.choice4.setVisibility(View.INVISIBLE)

        nextPosition1 = "goTitleScreen"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }
}