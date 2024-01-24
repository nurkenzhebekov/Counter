package com.example.counter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.counter.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btCountPlus.setOnClickListener {
            if (count < 10) {
                count ++
            } else if (count == 10) {
                binding.btCountPlus.visibility = View.GONE
                binding.btCountMinus.visibility = View.VISIBLE
                count --
            }
            binding.tvCount.text = count.toString()
        }

        binding.btCountMinus.setOnClickListener {
            if (count > 0) {
                count --
                if (count == 0) {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SecondFragment())
                        .addToBackStack(null).commit()
                }
            }
            binding.tvCount.text = count.toString()
        }
    }
}