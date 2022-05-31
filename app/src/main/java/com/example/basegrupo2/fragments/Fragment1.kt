package com.example.basegrupo2.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.preference.PreferenceManager
import com.example.basegrupo2.R
import com.example.basegrupo2.entities.User
import com.example.basegrupo2.model.viewmodel.Fragment1VM
import com.google.android.material.snackbar.Snackbar

class Fragment1 : Fragment() {

    companion object {
        fun newInstance() = Fragment1()
    }

    lateinit var v: View
    lateinit var btnGoToCars: Button
    lateinit var btnGoToUsers: Button
    lateinit var txtInput: EditText
    lateinit var txtInput2: EditText
    lateinit var txtHome : TextView
    private lateinit var viewModel: Fragment1VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_1, container, false)
        setHasOptionsMenu(true)
        btnGoToCars = v.findViewById(R.id.btnToCars)
        btnGoToUsers = v.findViewById(R.id.btnToUsers)
        txtInput = v.findViewById(R.id.editTextHome)
        txtInput2 = v.findViewById(R.id.editTextHome2)
        txtHome = v.findViewById(R.id.textViewHome2)
        txtInput2.setText("holaaaa")

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(Fragment1VM::class.java)

        viewModel.name.observe(viewLifecycleOwner, Observer { result ->
            txtHome.text = result.toString()
        })

        txtInput2.setText(viewModel.name.value)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val action = Fragment1Directions.actionFragment1ToSettingsActivity()
        val id = when(item.itemId) {
            R.id.settings ->
                v.findNavController().navigate(action)
                //Snackbar.make(v, "Yendo a las Settings", Snackbar.LENGTH_SHORT).show()
            else -> Snackbar.make(v, "else", Snackbar.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        requireActivity().title = "Grupo 2"

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())

        Log.d("Test",prefs.getBoolean("sync1",true).toString())
        Log.d("Test",prefs.getBoolean("sync2",false).toString())
        Log.d("Test", prefs.getString("signature_string","default signature").toString())
        Log.d("Test", prefs.getString("email_string","aca no hay nada").toString())

        btnGoToCars.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment22(txtInput.text.toString())
            v.findNavController().navigate(action)
        }

        btnGoToUsers.setOnClickListener {
            val paramAEnviar = User(txtInput.text.toString())
            val action = Fragment1Directions.actionFragment1ToFragment32(paramAEnviar)
            v.findNavController().navigate(action)
        }
    }

}