package ru.studyit.strudentschedule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.studyit.strudentschedule.databinding.ActivityLoginBinding

class CActivityLogin : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btLogin.setOnClickListener {
            //binding.pbLogin.visibility = View.VISIBLE
            val intent = Intent(this, CActivityMenu::class.java)
            intent.putExtra("LOGIN", binding.etLogin.text.toString())

            startActivity(intent)
        }
    }
}