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

class Fragment3 : Fragment() {
    lateinit var v: View
    lateinit var btnGoToHome: Button
    lateinit var btnGoToCars: Button
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
        v = inflater.inflate(R.layout.fragment_3, container, false)
        btnGoToHome = v.findViewById(R.id.btnBackHome2)
        btnGoToCars = v.findViewById(R.id.btnToCars2)
        txtView = v.findViewById(R.id.textViewUsuarios)
        return v
    }

    override fun onStart() {
        super.onStart()

        txtView.text = Fragment3Args.fromBundle(requireArguments()).user?.dato.toString()

        btnGoToHome.setOnClickListener {
            val action = Fragment3Directions.actionFragment3ToFragment12()
            v.findNavController().navigate(action)
        }

        btnGoToCars.setOnClickListener {
            val action = Fragment3Directions.actionFragment3ToFragment2(null)
            v.findNavController().navigate(action)
        }
    }


}