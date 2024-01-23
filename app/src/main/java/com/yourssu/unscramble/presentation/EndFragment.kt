package com.yourssu.unscramble.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.yourssu.unscramble.databinding.FragmentEndBinding
import com.yourssu.unscramble.util.base.BindFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EndFragment : BindFragment<FragmentEndBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): FragmentEndBinding {
        return FragmentEndBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}