package com.example.employeelist.model.retrofit

import com.example.employeelist.ui.Employees
import com.example.employeelist.model.repository.EmployeeRepository
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeService : EmployeeRepository {

    @GET("/users")
    fun getEmployeesList(): Call<List<Employees>>
}