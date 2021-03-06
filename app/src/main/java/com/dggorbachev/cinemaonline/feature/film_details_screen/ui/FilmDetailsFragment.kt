package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.dggorbachev.cinemaonline.MainActivity
import com.dggorbachev.cinemaonline.R
import com.dggorbachev.cinemaonline.base.common.Constants
import com.dggorbachev.cinemaonline.base.common.Screen
import com.dggorbachev.cinemaonline.base.navigation.BackButtonListener
import com.dggorbachev.cinemaonline.base.utils.setThrottledClickListener
import com.dggorbachev.cinemaonline.databinding.FragmentFilmDetailsBinding
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.VideosInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.dggorbachev.cinemaonline.feature.player_screen.ui.PlayerActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FilmDetailsFragment : Fragment(R.layout.fragment_film_details), BackButtonListener {

    companion object {
        private const val EXTRA_MOVIE = "extra_movie"
        private const val PREVIOUS_SCREEN = "previous_screen"

        fun newInstance(
            movieModel: FilmDomainModel,
            screen: Screen
        ): FilmDetailsFragment {
            return FilmDetailsFragment().apply {
                arguments = bundleOf(
                    EXTRA_MOVIE to movieModel,
                    PREVIOUS_SCREEN to screen
                )
            }
        }
    }

    private lateinit var binding: FragmentFilmDetailsBinding
    private val movieModel: FilmDomainModel
        get() = requireArguments().getParcelable(EXTRA_MOVIE)!!
    private val previousScreen: Screen
        get() = (requireArguments().getSerializable(PREVIOUS_SCREEN)!! as Screen)

    private val viewModel by viewModel<FilmDetailsViewModel>() {
        parametersOf(
            movieModel,
            previousScreen
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmDetailsBinding.inflate(inflater, container, false)
        (requireActivity() as MainActivity).controlBar(View.GONE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, Observer(::render))
        viewModel.openFilm.observe(viewLifecycleOwner, Observer(::openFilm))
    }

    private fun render(state: ViewState) {
        binding.tvFilmTitle.text = movieModel.title
        binding.tvDescInfo.text = movieModel.overview

        Glide.with(binding.root)
            .load(Constants.IMG_URL + movieModel.posterPath)
            .centerCrop()
            .into(binding.ivPoster)

        binding.btnPlay.setThrottledClickListener {
            viewModel.processUiEvent(UiEvent.OnWatchClick(state.videoKey))
        }
        binding.cbSave.setThrottledClickListener {
            viewModel.processUiEvent(UiEvent.OnBookmarkClick)
        }
        binding.cbSave.apply {
            if (state.filmDomainModel.isFavorite) {
                binding.cbSave.setButtonDrawable(R.drawable.save)
            } else {
                binding.cbSave.setButtonDrawable(R.drawable.save_border)
            }
        }
    }

    private fun openFilm(event: UiEvent.OnWatchClick) {
        val intent = Intent(context, PlayerActivity::class.java)
        val b = Bundle()
        b.putString("videoKey", event.videoKey) //Your id

        intent.putExtras(b) //Put your id to your next Intent
        startActivity(intent);
    }

    override fun onBackPressed(): Boolean {
        if (previousScreen == Screen.BOOKMARKS) {
            viewModel.processUiEvent(UiEvent.OnBackPressed)
            return true
        }
        return false
    }
}