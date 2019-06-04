package com.example.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.lo_customers.view.*
import java.util.*

class CustomerAdapter(mCtx:Context,val customers: ArrayList<Customer>):RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){


    val mCtx=mCtx
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtNombre = itemView.txtNombre
        val txtRFC=itemView.txtRFC
        val txtCel=itemView.txtCel
        val txtMail=itemView.txtMail
        val txtFecha=itemView.txtFeha
        val btnUpdate=itemView.btnUpdate
        val btnDelete=itemView.btnDelete
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomerAdapter.ViewHolder {

        val v=LayoutInflater.from(p0.context).inflate(R.layout.lo_customers,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(p0: CustomerAdapter.ViewHolder, p1: Int) {

        val customer : Customer=customers[p1]
        p0.txtNombre.text=customer.customerName
        p0.txtRFC.text=customer.rfc
        p0.txtCel.text=customer.cel
        p0.txtMail.text=customer.mail
        p0.txtFecha.text=customer.fecha.toString()
    }

}