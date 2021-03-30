package lv.rtu.id_191rdb114.project1_tic_tac_toe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {

    private var player1Turn: Boolean = true
    private lateinit var startnew: Button
    private lateinit var menu: Button
    private var starts = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )
    private lateinit var result: TextView
    private var buttons = arrayOf<Array<Button>>()
    private var xoro: String = ""
    private lateinit var playerOneScore: TextView
    private lateinit var playerTwoScore: TextView
    private var p1score = 0
    private var p2score = 0
    private var a: Int = 1
    private var c: Int = 0
    private lateinit var playerOne: EditText
    private lateinit var playerTwo: EditText
    private lateinit var ok: Button
    private lateinit var entername: TextView
    private lateinit var textplayer1: String
    private lateinit var textplayer2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        playerOneScore = findViewById(R.id.playerOneScore)
        playerTwoScore = findViewById(R.id.playerTwoScore)
        playerOne = findViewById(R.id.playerOne)
        playerTwo = findViewById(R.id.playerTwo)
        result = findViewById(R.id.result)
        startnew = findViewById(R.id.reset)
        menu = findViewById(R.id.menu)
        ok = findViewById(R.id.ok)
        entername = findViewById(R.id.entername)

        this.buttons = arrayOf(
            arrayOf(
                (findViewById(R.id.button1)),
                (findViewById(R.id.button2)),
                (findViewById(R.id.button3))
            ),
            arrayOf(
                (findViewById(R.id.button4)),
                (findViewById(R.id.button5)),
                (findViewById(R.id.button6))
            ),
            arrayOf(
                (findViewById(R.id.button7)),
                (findViewById(R.id.button8)),
                (findViewById(R.id.button9))
            )
        )

        result.visibility = View.INVISIBLE
        for (array in buttons)
            for (button in array)
                button.visibility = View.INVISIBLE
        startnew.visibility = View.INVISIBLE

        buttons[0][0].setOnClickListener { checkclicked(0, 0) }
        buttons[0][1].setOnClickListener { checkclicked(0, 1) }
        buttons[0][2].setOnClickListener { checkclicked(0, 2) }

        buttons[1][0].setOnClickListener { checkclicked(1, 0) }
        buttons[1][1].setOnClickListener { checkclicked(1, 1) }
        buttons[1][2].setOnClickListener { checkclicked(1, 2) }

        buttons[2][0].setOnClickListener { checkclicked(2, 0) }
        buttons[2][1].setOnClickListener { checkclicked(2, 1) }
        buttons[2][2].setOnClickListener { checkclicked(2, 2) }

        startnew.setOnClickListener { reset() }
        ok.setOnClickListener { okfun() }
        menu.setOnClickListener {
            startActivity(Intent(this, StartScreen::class.java))
        }
    }

    @SuppressLint("SetTextI18n")
    fun checkclicked(i: Int, j: Int) {
        if (buttons[i][j].text.toString() == "") {
            c += 1
            if (player1Turn) {
                xoro = "X"
                a = 1
                player1Turn = false
                result.text = "$textplayer2 turn"
            } else {
                xoro = "O"
                a = 2
                player1Turn = true
                result.text = "$textplayer1 turn"
            }
            buttons[i][j].text = xoro
            starts[i][j] = a
            buttons[i][j].isEnabled = false
            if (endofgame() == 1) {
                result.setTextColor(Color.parseColor("#00b33c"))
                result.textSize = 35F

                disable()
                if (a == 1) {
                    result.visibility = View.VISIBLE
                    result.text = "$textplayer1 won!"
                    p1score += 1
                    playerOneScore.text = p1score.toString()
                } else if (a == 2) {
                    result.visibility = View.VISIBLE
                    result.text = "$textplayer2 won!"
                    p2score += 1
                    playerTwoScore.text = p2score.toString()
                }
            } else if (c == 9) {
                result.visibility = View.VISIBLE
                result.text = "Nobody won!"
            }
        }
    }

    private fun disable() {
        for (array in buttons) {
            for (button in array) {
                button.isEnabled = false
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun okfun() {
        playerOne.isEnabled = false
        playerTwo.isEnabled = false
        entername.text = "TIC - TAC - TOE"
        ok.visibility = View.INVISIBLE
        textplayer1 = playerOne.text.toString()
        textplayer2 = playerTwo.text.toString()
        result.visibility = View.VISIBLE
        result.text = "$textplayer1 turn"
        playerOne.background = null
        playerTwo.background = null
        for (array in buttons)
            for (button in array)
                button.visibility = View.VISIBLE
        startnew.visibility = View.VISIBLE
    }

    private fun endofgame(): Int {
        if (starts[0][0] == a && starts[0][1] == a && starts[0][2] == a) {
            return 1
        } else if (starts[1][0] == a && starts[1][1] == a && starts[1][2] == a) {
            return 1
        } else if (starts[2][0] == a && starts[2][1] == a && starts[2][2] == a) {
            return 1
        } else if (starts[0][0] == a && starts[1][0] == a && starts[2][0] == a) {
            return 1
        } else if (starts[0][1] == a && starts[1][1] == a && starts[2][1] == a) {
            return 1
        } else if (starts[0][2] == a && starts[1][2] == a && starts[2][2] == a) {
            return 1
        } else if (starts[0][0] == a && starts[1][1] == a && starts[2][2] == a) {
            return 1
        } else if (starts[0][2] == a && starts[1][1] == a && starts[2][0] == a) {
            return 1
        }
        return 0
    }

    @SuppressLint("SetTextI18n")
    private fun reset() {
        for (array in buttons) {
            for (button in array) {
                button.text = ""
                button.isEnabled = true
                result.setTextColor(Color.parseColor("#00b386"))
                result.textSize = 25F
                result.text = "$textplayer1 turn"
            }
        }
        starts = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        player1Turn = true
        a = 1
        c = 0
    }
}
//https://github.com/usmaanz/Tic-Tac-Toe paraugs pēc kā taisīju visu tic-tac-toe




