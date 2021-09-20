package com.example.employeelist.model.repository

import com.example.employeelist.ui.Employees

interface EmployeeRepository {
    fun fetchMovies(onSuccess:(List<Employees>) -> Unit, onError:(String) -> Unit)
}