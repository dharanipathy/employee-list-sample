package com.example.employeelist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.employeelist.ui.Employees
import com.example.employeelist.model.repository.EmployeeRepository
import com.example.employeelist.model.repository.EmployeeRepositoryImpl

class EmployeesViewModel(): ViewModel() {
    private val employeeRepository: EmployeeRepository = EmployeeRepositoryImpl()

    private val _employeesResponse = MutableLiveData<List<Employees>>()
    val employeesResponse: LiveData<List<Employees>>
    get() = _employeesResponse

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String>
    get() = _errorResponse

    fun onCreate(){
        employeeRepository.fetchMovies({
            _employeesResponse.postValue(it)
        }, {
            _errorResponse.postValue(it)
        })
    }
}