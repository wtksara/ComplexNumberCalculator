package pl.polsl.tm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add = findViewById<Button>(R.id.button1)
        val subtract = findViewById<Button>(R.id.button2)

        val re1 = findViewById<EditText>(R.id.editText1)
        val im1 = findViewById<EditText>(R.id.editText2)
        val re2 = findViewById<EditText>(R.id.editText3)
        val im2 = findViewById<EditText>(R.id.editText4)

        var varRe1:Double
        var varIm1:Double
        var varRe2:Double
        var varIm2:Double

        var valueOfRe:Double
        var valueOfIm:Double
        var absOfIm:Double
        var sign:String
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)

        add.setOnClickListener {
            varRe1 = if (re1.length() > 0) { (re1.text.toString()).toDouble()
            } else { 0.0; }
            varIm1 = if (im1.length() > 0) { (im1.text.toString()).toDouble()
            } else { 0.0; }

            varRe2 = if (re2.length() > 0) { (re2.text.toString()).toDouble()
            } else { 0.0; }

            varIm2 = if (im2.length() > 0) { (im2.text.toString()).toDouble()
            } else { 0.0; }

            valueOfRe = varRe1+varRe2
            valueOfIm = varIm1+varIm2
            absOfIm = abs(valueOfIm)

            sign = if (valueOfIm > 0) { "+"
            } else { "-" }

            preferences.edit().apply{
                putFloat("Re", valueOfRe.toFloat())
                putFloat("Im", valueOfIm.toFloat())
            }.apply()

            Toast.makeText(applicationContext, "$valueOfRe $sign $absOfIm i", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity2::class.java))
        }

        subtract.setOnClickListener {
            varRe1 = if (re1.length() > 0) { (re1.text.toString()).toDouble() }
            else { 0.0 }
            varIm1 = if (im1.length() > 0) { (im1.text.toString()).toDouble()
            } else { 0.0 }
            varRe2 = if (re2.length() > 0) { (re2.text.toString()).toDouble()
            } else { 0.0 }
            varIm2 = if (im2.length() > 0) { (im2.text.toString()).toDouble()
            } else { 0.0 }

            valueOfRe = varRe1-varRe2
            valueOfIm = varIm1-varIm2
            absOfIm = abs(valueOfIm)

            sign = if (valueOfIm > 0) { "+"
            } else { "-" }

            preferences.edit().apply{
                putFloat("Re", valueOfRe.toFloat())
                putFloat("Im", valueOfIm.toFloat())
            }.apply()

            Toast.makeText(applicationContext, "$valueOfRe $sign $absOfIm i", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity2::class.java))
        }

        val spin = findViewById<Spinner>(R.id.spinner)
        val options = listOf("+", "-")
        val adapter =ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, options)
        spin.adapter=adapter

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (adapterView?.getItemAtPosition(position).toString() == "+") {
                    varRe1 = if (re1.length() > 0) { (re1.text.toString()).toDouble() }
                    else { 0.0 }
                    varIm1 = if (im1.length() > 0) { (im1.text.toString()).toDouble()
                    } else { 0.0 }
                    varRe2 = if (re2.length() > 0) { (re2.text.toString()).toDouble()
                    } else { 0.0 }
                    varIm2 = if (im2.length() > 0) { (im2.text.toString()).toDouble()
                    } else { 0.0 }

                    valueOfRe = varRe1 + varRe2
                    valueOfIm = varIm1 + varIm2
                    absOfIm = abs(valueOfIm)

                    sign = if (valueOfIm > 0) { "+"
                    } else { "-" }

                    preferences.edit().apply{
                        putFloat("Re", valueOfRe.toFloat())
                        putFloat("Im", valueOfIm.toFloat())
                    }.apply()

                    Toast.makeText(
                        this@MainActivity,
                        "$valueOfRe $sign $absOfIm i",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(intent)
                }
                else {
                    varRe1 = if (re1.length() > 0) { (re1.text.toString()).toDouble() }
                    else { 0.0 }
                    varIm1 = if (im1.length() > 0) { (im1.text.toString()).toDouble()
                    } else { 0.0 }
                    varRe2 = if (re2.length() > 0) { (re2.text.toString()).toDouble()
                    } else { 0.0 }
                    varIm2 = if (im2.length() > 0) { (im2.text.toString()).toDouble()
                    } else { 0.0 }

                    valueOfRe = varRe1-varRe2
                    valueOfIm = varIm1-varIm2
                    absOfIm = abs(valueOfIm)

                    sign = if (valueOfIm > 0) { "+"
                    } else { "-" }

                    preferences.edit().apply{
                        putFloat("Re", valueOfRe.toFloat())
                        putFloat("Im", valueOfIm.toFloat())
                    }.apply()

                    Toast.makeText(
                        applicationContext,
                        "$valueOfRe $sign $absOfIm i",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(intent)
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }
}
