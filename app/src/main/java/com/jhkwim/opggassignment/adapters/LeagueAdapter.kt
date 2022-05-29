package com.jhkwim.opggassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhkwim.opggassignment.viewmodels.SummonerViewModel
import com.jhkwim.opggassignment.databinding.ListItemLeagueBinding
import com.jhkwim.opggassignment.info.repository.model.summoner.League

class LeagueAdapter(private val viewModel: SummonerViewModel) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(
            ListItemLeagueBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        viewModel.summoner.value?.let {
            holder.bind(it.leagues[position])
        }
    }

    override fun getItemCount(): Int {
        return viewModel.summoner.value?.leagues?.size ?: 0
    }

    class LeagueViewHolder(
        private val binding: ListItemLeagueBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(league: League?) {
            league?.let {
                binding.league = league
            }
            binding.executePendingBindings()
        }


    }

}