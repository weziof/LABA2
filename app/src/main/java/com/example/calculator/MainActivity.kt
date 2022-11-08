package com.example.calculator
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var first: EditText? = null
    var second: EditText? = null
    var btnadd: Button? = null
    var btnminus: Button? = null
    var btnmultiply: Button? = null
    var btndivision: Button? = null
    var result: TextView? = null
    var num1: Float? = null
    var num2: Float? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first = findViewById(R.id.firstvalue)
        second = findViewById(R.id.secondvalue)
        btnadd = findViewById(R.id.btnadd)
        btnminus = findViewById(R.id.btnminus)
        btnmultiply = findViewById(R.id.btnmultiply)
        btndivision = findViewById(R.id.btndivision)
        otvet = findViewById(R.id.otvet)
        clear = findViewById(R.id.clear)
        Clicklistener()
    }
    private lateinit var otvet: Button
    private lateinit var clear: Button
    fun Clicklistener() {
        val intent = Intent(this, ResultActivity::class.java)
        btnadd!!.setOnClickListener {
            num1 = first!!.text.toString().toFloat()
            num2 = second!!.text.toString().toFloat()
            val sum: Float = num1!! + num2!!
            result?.text = sum.toString()
            intent.putExtra("answer", sum.toString())

        }
        btnminus!!.setOnClickListener {
            num1 = first!!.text.toString().toFloat()
            num2 = second!!.text.toString().toFloat()
            val sum: Float = num1!! - num2!!
            result?.text = sum.toString()
            intent.putExtra("answer", sum.toString())

        }
        btnmultiply!!.setOnClickListener {
            num1 = first!!.text.toString().toFloat()
            num2 = second!!.text.toString().toFloat()
            val sum: Float = num1!! * num2!!
            result?.text = sum.toString()
            intent.putExtra("answer", sum.toString())

        }
        btndivision!!.setOnClickListener {
            num1 = first!!.text.toString().toFloat()
            num2 = second!!.text.toString().toFloat()
            val sum: Float = num1!! / num2!!
            result?.text = sum.toString()
            intent.putExtra("answer", sum.toString())

        }
        otvet.setOnClickListener {
            if (first!!.text.toString().isEmpty() || second!!.text.toString().isEmpty()){
                intent.putExtra("answer","Немає відповіді")
            }
            startActivity(intent)
        }
        clear.setOnClickListener{
            val empty = ""
            first!!.setText(empty)
            second!!.setText(empty)
        }
    }
}