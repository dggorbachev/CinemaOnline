package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dggorbachev.cinemaonline.MainActivity
import com.dggorbachev.cinemaonline.R
import com.dggorbachev.cinemaonline.base.navigation.BackButtonListener
import com.dggorbachev.cinemaonline.databinding.FragmentBookmarksBinding
import com.dggorbachev.cinemaonline.feature.films_list_screen.ui.adapter.FilmsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {
    companion object {
        fun newInstance(): BookmarksFragment = BookmarksFragment()
    }

    private lateinit var binding: FragmentBookmarksBinding
    private val viewModel by viewModel<BookmarksViewModel>()
    private val filmsAdapter by lazy {
        FilmsAdapter(listOf(),
            onFilmClick = { film ->
                viewModel.processUiEvent(UiEvent.OnFilmClick(film))
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        (requireActivity() as MainActivity).controlBar(View.VISIBLE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filmsRecyclerView = view.findViewById<RecyclerView>(R.id.rvFilms)
        filmsRecyclerView.adapter = filmsAdapter
        filmsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.viewState.observe(viewLifecycleOwner, Observer(::render))
    }

    private fun render(viewState: ViewState) {
        filmsAdapter.updateFilms(viewState.filmsList)
    }
}