package net.simplifiedcoding.data.repositories

import net.simplifiedcoding.data.network.MoviesApi

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }

}