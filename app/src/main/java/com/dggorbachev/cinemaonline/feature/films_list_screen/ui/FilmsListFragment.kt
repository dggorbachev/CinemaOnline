package com.dggorbachev.cinemaonline.feature.films_list_screen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dggorbachev.cinemaonline.R
import com.dggorbachev.cinemaonline.feature.films_list_screen.ui.adapter.FilmsAdapter
import com.dggorbachev.cinemaonline.feature.films_list_screen.ui.adapter.GenresAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmsListFragment : Fragment(R.layout.fragment_films_list) {

    private val viewModel by viewModel<FilmsListViewModel>()
    private val filmsAdapter by lazy {
        FilmsAdapter(listOf())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filmsRecyclerView = view.findViewById<RecyclerView>(R.id.rvFilms)
        filmsRecyclerView.adapter = filmsAdapter
        filmsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.viewState.observe(
            viewLifecycleOwner, Observer(::render)
        )
    }

    private fun render(viewState: ViewState) {
        filmsAdapter.updateFilms(viewState.filmsList)
    }
}