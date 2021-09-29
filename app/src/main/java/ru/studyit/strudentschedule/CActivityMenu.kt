package ru.studyit.strudentschedule

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import ru.studyit.strudentschedule.databinding.ActivityLoginBinding
import ru.studyit.strudentschedule.databinding.ActivityMenuBinding
import ru.studyit.strudentschedule.view.CustomAdapter
import ru.studyit.strudentschedule.view.Lesson

class CActivityMenu : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            val x = data?.getIntExtra("PARAM_123", 0)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val lessons = ArrayList<Lesson>()
        var formatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm")
        lessons.add(Lesson("Математика",LocalDateTime.parse("2021-09-30 08:00",formatter)))
        lessons.add(Lesson("Русский",LocalDateTime.parse("2021-09-30 09:35",formatter)))
        lessons.add(Lesson("Литература",LocalDateTime.parse("2021-09-30 11:30",formatter)))
        val adapter = CustomAdapter(lessons);
        binding.lessons.adapter=adapter;




    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.activity_lessonlist_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.My_account_details -> {
                val intent = Intent(this, CActivityStudentInfo::class.java)

                resultLauncher.launch(intent)
                true
            }
            R.id.menu_item_exit -> {
               finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}