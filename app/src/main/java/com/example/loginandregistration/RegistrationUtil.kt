package com.example.loginandregistration

// object keyword makes it so all the functions
// are static functions
object RegistrationUtil {

    fun validateName(name : String) : Boolean{
        return true
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
        return true
    }





    // make sure it isn't empty
    // make sure the email isn't used
    // make sure it's in the proper email format user@domain.tld
    fun validateEmail(email : String) : Boolean {
        return true
    }


}