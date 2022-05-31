package com.example.basegrupo2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.basegrupo2.R
import com.example.basegrupo2.entities.User


class Fragment2 : Fragment() {
    lateinit var v: View
    lateinit var btnGoToHome: Button
    lateinit var btnGoToCarsList: Button
    lateinit var btnGoToUsers: Button
    lateinit var txtView: TextView
    lateinit var txtInputHome: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_2, container, false)
        btnGoToHome = v.findViewById(R.id.btnBackHome1)
        btnGoToUsers = v.findViewById(R.id.btnToUsers2)
        btnGoToCarsList = v.findViewById(R.id.btnGoToCarsList)
        txtView = v.findViewById(R.id.textViewAutos)
        return v
    }

    override fun onStart() {
        super.onStart()

        txtView.text = Fragment2Args.fromBundle(requireArguments()).txtFrag2

        btnGoToHome.setOnClickListener {
            val action = Fragment2Directions.actionFragment2ToFragment12()
            v.findNavController().navigate(action)
        }

        btnGoToUsers.setOnClickListener {
            val action = Fragment2Directions.actionFragment2ToFragment3(null)
            v.findNavController().navigate(action)
        }

        btnGoToCarsList.setOnClickListener {
            val action = Fragment2Directions.actionFragment2ToListFragment()
            v.findNavController().navigate(action)
        }
    }

}