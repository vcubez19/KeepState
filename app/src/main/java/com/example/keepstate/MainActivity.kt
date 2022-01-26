package com.example.keepstate

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var countButtonTextView: TextView
    private lateinit var countButton: Button
    private lateinit var colorButtonTextView: TextView
    private lateinit var randomColors: Array<Int>
    private var randomColor: Int = 0
    private var count: Int = 0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.textView = findViewById(R.id.idTextView)
        this.button = findViewById(R.id.idButton)
        this.countButtonTextView = findViewById(R.id.idCountTextView)
        this.countButton = findViewById(R.id.idCountButton)
        this.colorButtonTextView = findViewById(R.id.idColorTextView)


        this.randomColors = arrayOf(Color.YELLOW,
            Color.BLUE,
            Color.CYAN,
            Color.GRAY,
            Color.GREEN,
        )


        this.randomColor = this.randomColors.random()


        button.setOnClickListener {
            "Some new text".also { textView.text = it }
            button.text = "Text changed"
        }


        countButton.setOnClickListener {


            this.count += 1
            this.countButtonTextView.text = "Clicked button $count times"
            this.countButton.text = count.toString()
            this.countButton.setBackgroundColor(this.randomColor)
            this.colorButtonTextView.text = "Made the button ${this.randomColor}"
        }


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_text", this.textView.text.toString())
        outState.putString("saved_button_text", this.button.text.toString())
        outState.putInt("count", this.count)
        outState.putInt("random_color", this.randomColor)
    }


    @SuppressLint("SetTextI18n")
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.textView.text = savedInstanceState.getString("saved_text")
        this.button.text = savedInstanceState.getString("saved_button_text")
        this.countButtonTextView.text = "Clicked button ${savedInstanceState.getInt("count")} times"
        this.countButton.text = savedInstanceState.getInt("count").toString()
        this.countButton.setBackgroundColor(savedInstanceState.getInt("random_color"))
        this.colorButtonTextView.text = "Made the button ${savedInstanceState.getInt("random_color")}"
    }


}

