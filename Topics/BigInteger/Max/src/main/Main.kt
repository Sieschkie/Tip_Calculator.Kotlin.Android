package com.example.myapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)
        val billValueTv = findViewById<TextView>(R.id.bill_value_tv)
        val tipPercentTv = findViewById<TextView>(R.id.tip_percent_tv)
        val seekBar = findViewById<SeekBar>(R.id.seek_bar)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called to notify you that the text is about to change.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    val amount = it.toString().toDouble() ?: 0.0
                    if (amount > 0.0) {
                        val formattedAmount = String.format("%.2f", amount)
                        billValueTv.text = "Bill Value: $$formattedAmount"

                        val tipPercent = seekBar.progress
                        tipPercentTv.text = "Tip: $tipPercent%"
                    } else {
                        billValueTv.text = ""
                        tipPercentTv.text = ""
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This method is called to notify you that the text has just changed.
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val billAmount = editText.text.toString().toDouble() ?: 0.0
               // if (billAmount > 0.0) {
                    tipPercentTv.text = "Tip: $progress%"
                //}
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Do nothing
            }
        })

    }
}
