package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas.databinding.ActivityPwBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class PwActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPwBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private fun registerUser(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            } else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pw)
        binding = ActivityPwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener{

            val password: String = binding.editTextText.text.toString().trim()
            val repassword: String = binding.editTextText2.text.toString().trim()


            if (password.isEmpty() || password.length < 6){
                binding.editTextText.error = "password must be more than 6 characters"
                binding.editTextText.requestFocus()
                return@setOnClickListener
            }

            if (password != repassword){
                binding.editTextText2.error = "password must be match"
                binding.editTextText2.requestFocus()
                return@setOnClickListener
            }
            registerUser(password, password)
        }

        binding.Login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}





