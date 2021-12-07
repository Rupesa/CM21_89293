package com.example.dialerapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import android.Manifest
import android.app.AlertDialog
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var btnOne: Button
    lateinit var btnTwo: Button
    lateinit var btnThree: Button
    lateinit var btnFour: Button
    lateinit var btnFive: Button
    lateinit var btnSix: Button
    lateinit var btnSeven: Button
    lateinit var btnEight: Button
    lateinit var btnNine: Button
    lateinit var btnAsterisk: Button
    lateinit var btnZero: Button
    lateinit var btnCardinal: Button
    lateinit var btnCall: Button
    lateinit var btnDelete: ImageButton
    lateinit var input: TextView

    val name = arrayOf("", "", "")
    val num = arrayOf("", "", "")

    lateinit var dialog : AlertDialog
    lateinit var dialogBuilder : AlertDialog.Builder
    lateinit var editName : EditText
    lateinit var editNumber : EditText
    lateinit var saveBut : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        // Log.e("Hey","Heyy");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne = findViewById(R.id.button2)
        btnTwo = findViewById(R.id.button3)
        btnThree = findViewById(R.id.button4)
        btnFour = findViewById(R.id.button5)
        btnFive = findViewById(R.id.button6)
        btnSix = findViewById(R.id.button7)
        btnSeven = findViewById(R.id.button8)
        btnEight = findViewById(R.id.button9)
        btnNine = findViewById(R.id.button10)
        btnAsterisk = findViewById(R.id.button11)
        btnZero = findViewById(R.id.button12)
        btnCardinal = findViewById(R.id.button13)
        btnCall = findViewById(R.id.button14)
        btnDelete = findViewById(R.id.button)

        input = findViewById(R.id.textView)

        btnOne.setOnLongClickListener {
            editShortCut(0)
            true
        }
        btnTwo.setOnLongClickListener {
            editShortCut(1)
            true
        }
        btnThree.setOnLongClickListener {
            editShortCut(2)
            true
        }

    }

    fun editShortCut(i : Int) {
        dialogBuilder = AlertDialog.Builder(this)
        val popupView = layoutInflater.inflate(R.layout.popup, null)

        editName = popupView.findViewById<EditText>(R.id.editName)
        editNumber = popupView.findViewById<EditText>(R.id.editNumber)
        saveBut = popupView.findViewById<Button>(R.id.saveButton)

        editName.setText(name[i])
        editNumber.setText(num[i])

        dialogBuilder.setView(popupView)
        dialog = dialogBuilder.create()
        dialog.show()

        saveBut.setOnClickListener {
            name[i] = editName.getText().toString()
            num[i] = editNumber.getText().toString()
            input.setText(num[i])

            dialog.dismiss()
        }

        return
    }

    fun onButtonClick(button: Button, textView: TextView, number: String) {
        // Log.e("Hey","Heyy");
        var cache: String = input.getText().toString()
        textView.setText(cache+number)
    }

    fun one(v: View) {
        Log.e("Hey","Butão 1");
        onButtonClick(btnOne, input, "1")
    }

    fun two(v: View) {
        onButtonClick(btnTwo, input, "2")
    }

    fun three(v: View) {
        onButtonClick(btnThree, input, "3")
    }

    fun four(v: View) {
        onButtonClick(btnFour, input, "4")
    }

    fun five(v: View) {
        onButtonClick(btnFive, input, "5")
    }

    fun six(v: View) {
        onButtonClick(btnSix, input, "6")
    }

    fun seven(v: View) {
        onButtonClick(btnSeven, input, "7")
    }

    fun eight(v: View) {
        onButtonClick(btnEight, input, "8")
    }

    fun nine(v: View) {
        onButtonClick(btnNine, input, "9")
    }

    fun asterisk(v: View) {
        onButtonClick(btnAsterisk, input, "*")
    }

    fun zero(v: View) {
        onButtonClick(btnZero, input, "0")
    }

    fun cardinal(v: View) {
        onButtonClick(btnCardinal, input, "#")
    }

    fun call(v: View) {
        if(input.text.length <= 3) {
            Toast.makeText(this, "Please enter the valid number", Toast.LENGTH_SHORT).show()
        } else {
            var hash : String = input.getText().toString()
            if(hash.contains("#")) {
                hash.replace("#", "%23")
            }
            // Log.e("Hey",hash)


            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Please grant permission", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
            } else {
                val intent: Intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:" + hash)
                startActivity(intent)
            }
        }
    }

    fun delete(v: View) {
        var str: String = input.getText().toString()
        input.setText(input.getText().toString().dropLast(1))
    }


}