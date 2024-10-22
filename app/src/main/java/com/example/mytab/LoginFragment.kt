package com.example.mytab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytab.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    // Using lazy to initialize the binding
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the binding layout
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the data from arguments
        val username = arguments?.getString("username")
        val email = arguments?.getString("email")
        val password = arguments?.getString("password")

        // Logic
        with(binding) {
            btnSubmit.setOnClickListener {
                if (binding.editText1.text.toString().isEmpty() || binding.editText2.text.toString().isEmpty()){
                    binding.editText1.error = "Email Tidak Boleh Kosong"
                    binding.editText2.error = "Password Tidak Boleh Kosong"
                    return@setOnClickListener
                }
                else if(binding.editText2.text.toString() != password || binding.editText1.text.toString() != email){
                    binding.editText1.error = "Password atau Email Salah"
                    binding.editText2.error = "Password atau Email Salah"
                    return@setOnClickListener
                }
                else{
                    val intentToSecondActivity = Intent(activity,DashboardActivity::class.java)
                    intentToSecondActivity.putExtra("username",username)
                    intentToSecondActivity.putExtra("email",email)
                    intentToSecondActivity.putExtra("password",password)
                    startActivity(intentToSecondActivity)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding when the view is destroyed to prevent memory leaks
        _binding = null
    }
}