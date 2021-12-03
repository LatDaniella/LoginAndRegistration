package com.example.loginandregistration

import androidx.core.text.isDigitsOnly
import java.util.*
import java.util.function.ToDoubleBiFunction

// object keyword makes it so all the functions
// are static functions
object RegistrationUtil {
    // use this in
    var existingUsers = listOf("cosmicF", "cosmicY", "bob", "alice")
    //you can use listOf<type>() instead of making the list and adding induvidually

    fun validateName(name : String) : Boolean{
        return name.isNotEmpty()
    }

    // curse word fliter
    // already taken
    // other requirements
    // real name can't be in it
    // minimum number of characters
    fun validateUsername(username : String) : Boolean{
        return true
    }

    // meets security requirements
        // min 8 characters
        // at least one digit
        // at least one capital letter
    // both passwords match
    fun validatePassword(password : String, confirmPassword : String) : Boolean{
        if((password == confirmPassword) &&
            password.isNotEmpty() &&
            confirmPassword.isNotEmpty())

            {
            if(password.length >= 8){
                var index = 0
                var hasDigit = false
                var hasUpperCase = false

                while(index < password.length){
                    var currentLetter = password.substring(index,index+1)
                    if(!hasUpperCase) {
                        /*
                        if (currentLetter.isUpperCase()) {
                            hasUpperCase = true
                        }
                         */
                    }
                    if(!hasDigit) {
                        password?.toIntOrNull()?.let { hasDigit = true } ?: false
                    }
                    index++
                }
                if(hasDigit && hasUpperCase){
                    return true
                }
            }
        }
        return false

    }
    // isAnyOf()





    // make sure it isn't empty
    // make sure the email isn't used
    // make sure it's in the proper email format user@domain.tld
    fun validateEmail(email : String) : Boolean {
        return true
    }


}