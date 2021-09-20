package com.example.employeelist.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.employeelist.R
import com.example.employeelist.ui.adapter.EmployeesAdapter
import com.example.employeelist.viewmodel.EmployeesViewModel
import com.example.employeelist.viewmodel.EmployeesViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var employeesViewModel: EmployeesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        observeViewModel()
    }

    private fun observeViewModel() {
        employeesViewModel.employeesResponse.observe(this, Observer{
            showResult(it)
        })

        employeesViewModel.errorResponse.observe(this, Observer {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun showResult(it: List<Employees>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = EmployeesAdapter(it)
    }

    private fun setupViewModel() {
        employeesViewModel = ViewModelProvider(
            this,
            EmployeesViewModelFactory()
        )[EmployeesViewModel::class.java]
        employeesViewModel.onCreate()
    }
}