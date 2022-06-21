package task.number.valid.passwords

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import task.number.valid.passwords.passwords_validation.ValidPasswordsCounter
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordsFile = readFileWithPasswords()
        val numberValidPasswords = ValidPasswordsCounter.count(passwordsFile)
        displayNumberOfInvalidPasswords(numberValidPasswords)

    }

    private fun readFileWithPasswords(): BufferedReader {
        val inputStream = resources.openRawResource(R.raw.passwords_with_conditions)
        return BufferedReader(InputStreamReader(inputStream))
    }

    private fun displayNumberOfInvalidPasswords(numberInvalidNumbers: Int) {
        val displayTextView = findViewById<TextView>(R.id.number_invalid_passwords)
        displayTextView.text = "${getString(R.string.number_invalid_passwords_title)} $numberInvalidNumbers"
    }
}