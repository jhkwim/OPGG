package com.jhkwim.opggassignment.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jhkwim.opggassignment.R
import com.jhkwim.opggassignment.adapters.LeagueAdapter
import com.jhkwim.opggassignment.databinding.FragmentSummonerBinding
import com.jhkwim.opggassignment.info.repository.OPGGRepositoryImpl
import com.jhkwim.opggassignment.info.repository.db.OPGGDatabase
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner
import com.jhkwim.opggassignment.info.repository.network.OPGGApiService
import com.jhkwim.opggassignment.viewmodels.SummonerViewModel

class SummonerFragment : Fragment() {

    companion object {
        fun newInstance() = SummonerFragment()
    }

    private lateinit var binding: FragmentSummonerBinding
    private lateinit var viewModel: SummonerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_summoner,
            container,
            false
        )

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return if (modelClass.isAssignableFrom(SummonerViewModel::class.java)) {

                    val opggDatabase = OPGGDatabase.getInstance(requireContext()) ?: throw NullPointerException("Error not open opgg database.")

                    SummonerViewModel(
                        OPGGRepositoryImpl(
                            OPGGApiService.opggService,
                            opggDatabase.summonerDao(),
                            opggDatabase.gameInfoDao()
                        )
                    ) as T
                } else {
                    throw IllegalArgumentException()
                }
            }

        }).get(SummonerViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.leaguePager.adapter = LeagueAdapter(viewModel)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.summoner.observe(viewLifecycleOwner, summonerObserver)
        viewModel.fetchSummoner()

    }

    private val summonerObserver = object : Observer<Summoner> {
        override fun onChanged(summoner: Summoner?) {
            summoner ?: return

            val adapter = binding.leaguePager.adapter

            adapter ?: return

            val leagues = summoner.leagues
            if (leagues.isEmpty() && adapter.itemCount > 0) {
                adapter.notifyItemRangeRemoved(0, adapter.itemCount)
            } else {
                val preItemCount = adapter.itemCount
                val newItemCount = leagues.size

                when {
                    preItemCount > newItemCount -> {
                        adapter.notifyItemRangeChanged(0, newItemCount - 1)
                        adapter.notifyItemRangeRemoved(newItemCount, preItemCount - 1)
                    }
                    newItemCount > preItemCount -> {
                        adapter.notifyItemRangeChanged(0, preItemCount - 1)
                        adapter.notifyItemRangeInserted(preItemCount, newItemCount)
                    }
                    else -> {
                        adapter.notifyItemRangeChanged(0, preItemCount - 1)
                    }
                }
            }
        }

    }

}