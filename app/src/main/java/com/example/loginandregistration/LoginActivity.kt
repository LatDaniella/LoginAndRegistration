package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // any time you need what would have been "static" variable in java, you use
    // companion object in Kotlin. You access with ClassName.VARIABLE_NAME like Math.PI
    companion object {
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    // starting an activity for a result
    // Step 1: Register the Activity with a contract
    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        // decide what to do if the result is ok (if it was successful)
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent
            // note: editTexts are different from textViews in that you have to call setText
            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }
        // decide what to do if it was unsuccessful with a RESULT_CANCELED
        if(result.resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Registration Canceled", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewLoginCreateAccount.setOnClickListener {
            // launch the registration activity
            // pass the values of the username and password along to the new activity
            // look up "android intent content"
            // will find "start another activity"
            // "build an intent"

            //1. extract anu information you might need from edit texts
            val username = binding.editTextLoginUsername.toString()
            val password = binding.editTextLoginPassword.toString()

            // 2. create the intent and package the extras
            // the context is the activity you are in (here we can use this)
            //                 return address (package content), place we are going to(class)
            val registrationIntent = Intent(this, RegistrationActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }

            // 3. launch the activity
//            startActivity(registrationIntent)

            // 3b. Alternate: Could launch the activity for a result instead
            // use the variable from the register for the result contract above
            startRegistrationForResult.launch(registrationIntent)


        }
    }
}