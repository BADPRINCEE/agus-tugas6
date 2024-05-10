package com.example.tugas

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas.databinding.ActivityContentBinding
import com.google.firebase.database.*
import com.google.firebase.database.R
import com.google.firebase.storage.FirebaseStorage

class ContentActivity : AppCompatActivity() {
    private lateinit var BilliardRecyclerView: RecyclerView
    private lateinit var BilliardList:MutableList<Billiard>
    private lateinit var BilliardAdapter: BilliardAdapter
    private lateinit var binding: ActivityContentBinding
    private var mStorage: FirebaseStorage? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var mDBListener: ValueEventListener? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.tugas.R.layout.activity_content)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        BilliardRecyclerView = findViewById(R.id.end)
        BilliardRecyclerView.setHasFixedSize(true)
        BilliardRecyclerView.layoutManager = LinearLayoutManager(this@ContentActivity)
        binding.myDataLoaderProgressBar
        BilliardList = ArrayList()
        BilliardAdapter = BilliardAdapter(this@ContentActivity, BilliardList)
        BilliardRecyclerView.adapter = BilliardAdapter

        mStorage = FirebaseStorage.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("movie")
        mDBListener = mDatabaseRef!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ContentActivity, error.message, Toast.LENGTH_SHORT).show()
                binding.myDataLoaderProgressBar.visibility = View.GONE
            }
        })
    }
}