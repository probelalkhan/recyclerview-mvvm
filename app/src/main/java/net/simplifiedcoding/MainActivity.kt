package net.simplifiedcoding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MoviesRepository(MoviesApi())

        GlobalScope.launch(Dispatchers.Main) {
            val movies = repository.getMovies()
            Toast.makeText(this@MainActivity, movies.toString(), Toast.LENGTH_LONG).show()
        }

    }
}
