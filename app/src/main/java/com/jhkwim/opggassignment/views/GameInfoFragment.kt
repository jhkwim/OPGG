package com.jhkwim.opggassignment.views

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhkwim.opggassignment.R
import com.jhkwim.opggassignment.adapters.GameAdapter
import com.jhkwim.opggassignment.adapters.LeagueAdapter
import com.jhkwim.opggassignment.adapters.SpaceDecoration
import com.jhkwim.opggassignment.databinding.FragmentGameInfoBinding
import com.jhkwim.opggassignment.info.repository.OPGGRepositoryImpl
import com.jhkwim.opggassignment.info.repository.db.OPGGDatabase
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import com.jhkwim.opggassignment.info.repository.network.OPGGApiService
import com.jhkwim.opggassignment.viewmodels.GameInfoViewModel
import com.jhkwim.opggassignment.viewmodels.SummonerViewModel

class GameInfoFragment : Fragment() {

    companion object {
        fun newInstance() = GameInfoFragment()
    }

    private lateinit var binding: FragmentGameInfoBinding
    private lateinit var viewModel: GameInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game_info,
            container,
            false
        )

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return if (modelClass.isAssignableFrom(GameInfoViewModel::class.java)) {

                    val opggDatabase = OPGGDatabase.getInstance(requireContext()) ?: throw NullPointerException("Error not open opgg database.")

                    GameInfoViewModel(
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

        }).get(GameInfoViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.listGame.adapter = GameAdapter(viewModel)
        binding.listGame.layoutManager = LinearLayoutManager(requireContext())
        binding.listGame.addItemDecoration(SpaceDecoration(resources.getDimensionPixelSize(R.dimen.margin_game_item)))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gameInfo.observe(viewLifecycleOwner, gameInfoObserver)
        viewModel.fetchGameInfo()
    }

    private val gameInfoObserver = object : Observer<GameInfo> {
        override fun onChanged(gameInfo: GameInfo?) {
            gameInfo ?: return

            val adapter = binding.listGame.adapter

            adapter ?: return

            val games = gameInfo.games
            if (games.isEmpty() && adapter.itemCount > 0) {
                adapter.notifyItemRangeRemoved(0, adapter.itemCount)
            } else {
                val preItemCount = adapter.itemCount
                val newItemCount = games.size

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