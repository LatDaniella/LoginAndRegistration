package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginandregistration.databinding.ActivityLoginBinding
import com.example.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // access any values that were sent to us from the intent that launched this activity
        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        Toast.makeText(this, "user: $username pwd $password", Toast. LENGTH_SHORT).show()

        binding.buttonRegistrationRegisterButton.setOnClickListener {
            // TODO: verify that the information is valid

            // in a real app, we'd talk to a database here and save the new user

            // return to the Login Screen and send back the user & pass to prefill
            var returnToLoginIntent = Intent().apply {
                putExtra(LoginActivity.EXTRA_USERNAME,
                    binding.editTextRegistrationUsername.text.toString())
                putExtra(LoginActivity.EXTRA_PASSWORD,
                    binding.editTextRegistrationPassword.text.toString())
            }
            if (password != null && username != null) {
                if(username.isEmpty() || password.isEmpty()) {
                    setResult(Activity.RESULT_CANCELED, returnToLoginIntent)
                } else {
                    setResult(Activity.RESULT_OK, returnToLoginIntent)
                    finish() //closes the activity
                }
            }
        }


    }
}