package com.poran.mvvmapp.ui.home.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.poran.mvvmapp.R
import com.poran.mvvmapp.databinding.ProfileFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class profileFragment : Fragment(),KodeinAware {
    override val kodein by kodein()

    private lateinit var viewModel: ProfileViewModel
    private val factory :ProfileViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: ProfileFragmentBinding=
            DataBindingUtil.inflate(inflater,R.layout.profile_fragment,container,false)
        viewModel=ViewModelProviders.of(this,factory).get(ProfileViewModel::class.java)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        return binding.root
    }



}
