package com.example.employeelist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelist.R
import com.example.employeelist.ui.Employees
import kotlinx.android.synthetic.main.item_list.view.*

class EmployeesAdapter(private val employees: List<Employees>):
    RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return EmployeesViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        holder.bind(employees[position])
    }


    class EmployeesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(employee: Employees){
            itemView.name.text = employee.name
            itemView.email.text = employee.email
            itemView.phone.text = employee.phone
        }
    }
}