package com.example.employeelist.model.repository

import com.example.employeelist.ui.Employees
import com.example.employeelist.model.retrofit.EmployeeService
import com.example.employeelist.model.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepositoryImpl(): EmployeeRepository {
    private val request: EmployeeService = RetrofitBuilder.buildService()

    override fun fetchMovies(onSuccess: (List<Employees>) -> Unit, onError: (String) -> Unit) {
        val call = request.getEmployeesList()
        call.enqueue(object : Callback<List<Employees>> {
            override fun onFailure(call: Call<List<Employees>>, t: Throwable) {
                onError("Network 404 Failure!!!")
            }

            override fun onResponse(
                    call: Call<List<Employees>>,
                    response: Response<List<Employees>>
            ) {
                if(response.isSuccessful && response.body() != null) {
                    onSuccess(response.body()!!)
                } else {
                    onError("Data Not found!!!")
                }
            }
        })
    }
}