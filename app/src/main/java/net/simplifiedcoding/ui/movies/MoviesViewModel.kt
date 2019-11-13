package net.simplifiedcoding.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.simplifiedcoding.util.Coroutines
import net.simplifiedcoding.data.models.Movie
import net.simplifiedcoding.data.repositories.MoviesRepository

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
