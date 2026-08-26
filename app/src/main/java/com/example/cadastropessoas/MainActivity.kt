package com.example.cadastropessoas
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtEditname: EditText
    private lateinit var addButton: Button
    private lateinit var removeButton: Button
    private lateinit var LVPeople: ListView
    private val people = mutableListOf<String>();
    private lateinit var adapter: ArrayAdapter<String>
    private var Onpeople = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEditname = findViewById(R.id.txtnameEdit)
        addButton = findViewById(R.id.btnAdd)
        removeButton = findViewById(R.id.removerButton)
        LVPeople = findViewById(R.id.LVpessoas)
        people.add("Carlos Enrique")
        people.add("Thiago Lopes")
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_single_choice,
            people
        )

        LVPeople.choiceMode = ListView.CHOICE_MODE_SINGLE
        LVPeople.adapter = adapter

        LVPeople.setOnItemClickListener { _, _, position, _ ->
            Onpeople = position
        }
        addButton.setOnClickListener {

            val nome = txtEditname.text.toString().trim()

            if (nome.isNotEmpty()) {
                people.add(nome)
                adapter.notifyDataSetChanged()
                txtEditnanme.text.clear()

                Toast.makeText(
                    this,
                    "Pessoa adicionada!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Digite um nome.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        removeButton.setOnClickListener {

            if (Onpeople != -1) {
                people.removeAt(Onpeople)
                Onpeople = -1
                adapter.notifyDataSetChanged()
                Toast.makeText(
                    this,
                    "Pessoa removida!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Selecione uma pessoa.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
