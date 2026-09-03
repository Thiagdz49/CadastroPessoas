package com.example.cadastropessoas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    private lateinit var txtEdit: EditText
    private lateinit var btnEdit: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        txtEdit.setOnClickListener {
            val nome = txtEdit.text.toString().trim()


        }
    }

}