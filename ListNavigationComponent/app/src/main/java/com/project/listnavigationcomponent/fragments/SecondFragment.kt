package com.project.listnavigationcomponent.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.listnavigationcomponent.MainActivity
import com.project.listnavigationcomponent.R
import com.project.listnavigationcomponent.adapters.TextAdapter
import com.project.listnavigationcomponent.databinding.FragmentFirstBinding
import com.project.listnavigationcomponent.databinding.FragmentSecondBinding
import com.project.listnavigationcomponent.utils.Constants
import com.project.listnavigationcomponent.viewmodel.MainViewModel

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val clickedChar by lazy { arguments?.getString(EXTRA_ALPHABET) ?: "" }

    private val textAdapter = TextAdapter()
    private val textList = arrayListOf<String>()

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        viewModel = (requireActivity() as MainActivity).viewModel

        viewModel.isListView.observe(viewLifecycleOwner) {
            if (it) {
                binding.rvBtn.layoutManager = LinearLayoutManager(requireContext())
            } else {
                binding.rvBtn.layoutManager = GridLayoutManager(requireContext(), 2)
            }
        }

        textList.clear()

        Constants.wordMap()[clickedChar[0]]?.forEach {
            textList.add(it)
        }

        binding.rvBtn.apply {
            textAdapter.submitList(textList)
            textAdapter.onBtnClick = {
                val url = "https://www.google.com/search?q=${Uri.encode(it)}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                requireActivity().startActivity(intent)
            }
            adapter = textAdapter
        }

        return binding.root
    }

    companion object {
        const val EXTRA_ALPHABET = "extra_alphabet"
    }
}