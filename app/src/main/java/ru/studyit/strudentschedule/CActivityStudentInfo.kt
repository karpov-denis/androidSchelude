package ru.studyit.strudentschedule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.studyit.strudentschedule.databinding.ActivityLoginBinding
import ru.studyit.strudentschedule.databinding.ActivityStudentInfoBinding

class CActivityStudentInfo : AppCompatActivity() {

    private lateinit var binding: ActivityStudentInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("PARAM_123", 123)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}