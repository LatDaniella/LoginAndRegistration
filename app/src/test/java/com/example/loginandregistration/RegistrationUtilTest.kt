package com.example.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    //methodName_sameCondition_expectedResult
    @Test
    fun validatePassword_emptyPassword_returnsFalse() {
        val result = RegistrationUtil.validatePassword("","")
        // assertThat(testCase).isEqual(desiredValue)
        assertThat(result).isFalse()
    }

    // test that the passwords match and if not the same return false
    @Test
    fun validatePassword_passwordsDontMatch_returnFalse(){
        val result = RegistrationUtil.validatePassword("hello","world")
        assertThat(result).isFalse()
    }

    // Make tests for

        // min 8 characters
        // at least one digit
        // at least one capital letter
    // Make a test for good matching password works

    // Once all the test are made, implement the validatePassword function in the Util class

    @Test
    fun validatePassword_lengthUnderEight_returnFalse() {
        val result = RegistrationUtil.validatePassword("1Abcdef","1Abcdef")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_withoutDigits_returnFalse() {
        val result = RegistrationUtil.validatePassword("Abcdefgh","Abcdefgh")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_withoutCapitalLetter_returnFalse() {
        val result = RegistrationUtil.validatePassword("abcdefgh","abcdefgh")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_goodMatchingPassword_returnTrue() {
        val result = RegistrationUtil.validatePassword("1Abcdefg","1Abcdefg")
        assertThat(result).isTrue()
    }
}