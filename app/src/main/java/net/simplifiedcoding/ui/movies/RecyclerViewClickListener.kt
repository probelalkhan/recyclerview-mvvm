package net.simplifiedcoding.ui.movies

import android.view.View
import net.simplifiedcoding.data.models.Movie

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}