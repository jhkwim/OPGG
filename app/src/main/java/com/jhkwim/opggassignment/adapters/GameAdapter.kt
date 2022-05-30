package com.jhkwim.opggassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhkwim.opggassignment.databinding.ListItemGameBinding
import com.jhkwim.opggassignment.info.repository.model.game.Game
import com.jhkwim.opggassignment.viewmodels.GameInfoViewModel

class GameAdapter(private val viewModel: GameInfoViewModel) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            ListItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        viewModel.gameInfo.value?.let {
            holder.bind(it.games[position])
        }
    }

    override fun getItemCount(): Int {
        return viewModel.gameInfo.value?.games?.size ?: 0
    }

    class GameViewHolder(
        private val binding: ListItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game?) {
            game?.let {
                binding.game = game
            }
            binding.executePendingBindings()
        }

    }

}