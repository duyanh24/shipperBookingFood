package com.leduyanh.bookingfoodshipper.view.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.leduyanh.bookingfoodshipper.R
import com.leduyanh.bookingfoodshipper.databinding.FragmentHistoryBinding
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
    

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyViewModel = HistoryViewModel()
        binding.viewModel = historyViewModel
        rvHistoryListOder.layoutManager = LinearLayoutManager(activity)
        historyViewModel.getDataOrder()
    }

}
