package com.anveshreddyt.fifththirdcodetest.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anveshreddyt.fifththirdcodetest.R
import com.anveshreddyt.fifththirdcodetest.adapters.CityRecyclerAdapter
import com.anveshreddyt.fifththirdcodetest.model.City
import com.anveshreddyt.fifththirdcodetest.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CityRecyclerAdapter(
            listOf(City("New York"),City("Dallas"),City("Chicago"),
                City("Miami"), City("Detroit"),City("San Francisco"),City("Anchorage")), mOnClickListener = fun(it) {
                mainActivityViewModel.getTemperature(it.tag)!!.observe(this,
                    { serviceSetterGetter ->
                        val msg = serviceSetterGetter.message
                        (it as TextView).text = msg
//                        findViewById<TextView>(R.id.weatherTextView).text = msg
                        val toast = Toast.makeText(applicationContext, "Updated data", Toast.LENGTH_SHORT)
                        toast.show()
                    })
            })
    }
}