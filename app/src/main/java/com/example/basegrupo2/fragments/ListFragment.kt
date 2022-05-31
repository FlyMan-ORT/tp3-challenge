package com.example.basegrupo2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basegrupo2.R
import com.example.basegrupo2.adapters.AutoListAdapter
import com.example.basegrupo2.entities.Auto
import com.google.android.material.snackbar.Snackbar


class ListFragment : Fragment() {
    lateinit var v: View
    lateinit var recyclerAutos : RecyclerView
    var autos : MutableList<Auto> = ArrayList<Auto>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var autoListAdapter: AutoListAdapter
    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerAutos = v.findViewById(R.id.recycler_autos)
        return v
    }

    override fun onStart() {
        super.onStart()

        //Creo la Lista de Autos
        for (i in 1..5) {
            autos.add(Auto("Audi A.$i", 2000, "Rojo"))
            autos.add(Auto("BMW S.$i", 4000, "Verde"))
            autos.add(Auto("Mercedes E.$i", 5000, "Negro"))
        }

        //Configuración Obligatoria
        recyclerAutos.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recyclerAutos.layoutManager = linearLayoutManager

        autoListAdapter = AutoListAdapter(autos) { x ->
            onItemClick(x)
        }
        recyclerAutos.adapter = autoListAdapter

    }

    fun onItemClick ( position : Int) : Boolean{
        Snackbar.make(v,position.toString(),Snackbar.LENGTH_SHORT).show()
        return true
    }
}