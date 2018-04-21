package initishbhatt.com.espressosample

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


const val InMemoryStore = "inMemoryStore"
const val Name = "nameKey"

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        sharedPref = getSharedPreferences(InMemoryStore, Context.MODE_PRIVATE)
        RxTextView.textChanges(edit_text_name).subscribe { enableAddButton() }
        button_add.setOnClickListener { addToStore() }
        button_show.setOnClickListener { showStoreValue() }
        fab.setOnClickListener { reset() }
    }

    private fun enableAddButton() {
        button_add.isEnabled = !edit_text_name.text.isEmpty()
    }

    private fun reset() {
        edit_text_name.setText("")
        button_add.isEnabled = false
        button_show.isEnabled = false
        sharedPref.edit().clear().apply()
        text_store_value.setText(R.string.stored_value_is_displayed_here)
    }

    private fun addToStore() {
        sharedPref.edit().putString(Name, edit_text_name.text.toString()).apply()
        button_show.isEnabled = true
        edit_text_name.setText("")
    }

    private fun showStoreValue() {
        /*  sharedPref = getSharedPreferences(InMemoryStore,
                  Context.MODE_PRIVATE)*/
        if (sharedPref.contains(Name)) {
            text_store_value.text = sharedPref.getString(Name, "")
        }
    }
}
