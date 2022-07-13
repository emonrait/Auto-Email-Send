package com.emon.raihan.autoemailsend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.mail.internet.InternetAddress

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = EmailService.UserPassAuthenticator("positivetu@gmail.com", "test")
        val to = listOf(InternetAddress("emonrait@gmail.com","emonraihan2021@gmail.com"))
        val from = InternetAddress("positivetu@gmail.com")
        val email = EmailService.Email(auth, to, from, "Test Subject", "Hello Body Worldtzkfmywzgruamnah")
        val emailService = EmailService("smtp.gmail.com", 587)

        GlobalScope.launch { // or however you do background threads
            emailService.send(email)
        }
    }
}