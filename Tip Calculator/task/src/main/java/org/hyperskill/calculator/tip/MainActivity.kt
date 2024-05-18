package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)
        val billValueTv = findViewById<TextView>(R.id.bill_value_tv)
        val tipPercentTv = findViewById<TextView>(R.id.tip_percent_tv)
        val tipAmountTv = findViewById<TextView>(R.id.tip_amount_tv)
        val totalAmount = findViewById<TextView>(R.id.total_amount)
        val seekBar = findViewById<SeekBar>(R.id.seek_bar)

        fun updateTipAmount(billAmount: BigDecimal, tipPercent: Int) {
            val tipAmount = billAmount.multiply(BigDecimal(tipPercent)).divide(BigDecimal(100))
            tipAmountTv.text = "Tip Amount: \$${tipAmount.setScale(2, RoundingMode.HALF_UP)}"
            totalAmount.text = "Total Amount: \$${(tipAmount + billAmount).setScale(2, RoundingMode.HALF_UP)}"
        }

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    val billAmount = it.toString().toBigDecimalOrNull() ?: BigDecimal.ZERO
                    if (billAmount > BigDecimal.ZERO) {
                        billValueTv.text = "Bill Value: $${billAmount.setScale(2, RoundingMode.HALF_UP)}"
                        val tipPercent = seekBar.progress
                        tipPercentTv.text = "Tip: $tipPercent%"
                        updateTipAmount(billAmount, tipPercent)
                    } else {
                        billValueTv.text = ""
                        tipPercentTv.text = ""
                        tipAmountTv.text = ""
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val billAmount = editText.text.toString().toBigDecimalOrNull() ?: BigDecimal.ZERO
                if (billAmount > BigDecimal.ZERO) {
                    Log.d("MainActivity", "Updating tip percent to: $progress%")
                    tipPercentTv.text = "Tip: $progress%"
                    updateTipAmount(billAmount, progress)
                }
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
