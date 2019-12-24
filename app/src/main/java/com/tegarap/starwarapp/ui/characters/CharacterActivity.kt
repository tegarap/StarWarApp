package com.tegarap.starwarapp.ui.characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tegarap.starwarapp.data.models.Character
import com.tegarap.starwarapp.R
import com.tegarap.starwarapp.ui.utils.InfiniteScrollListener
import kotlinx.android.synthetic.main.activity_character.*

class CharacterActivity : AppCompatActivity(), CharactersView {

    private val charactersPresenter : CharactersPresenter = CharactersPresenter(this, CharactersInteractor())
    private var characters: MutableList<Character> = ArrayList()
    private var nextPage: Int? = null

    override fun onStart() {
        super.onStart()
        setAdapter(rv_characters, characters)
        charactersPresenter.loadCharacters(1)

    }

    override fun onDestroy() {
        super.onDestroy()
        charactersPresenter.onDestroy()
    }

    private fun setAdapter(recyclerView: RecyclerView, characters: List<Character>) {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = CharactersAdapter(characters)
        recyclerView.addOnScrollListener(InfiniteScrollListener({ loadMore() }, linearLayoutManager))
    }

    private fun loadMore() {
        charactersPresenter.loadCharacters(nextPage)
    }

    override fun updateCharacterList(characters: List<Character>, nextPage: Int?) {
        this.characters.addAll(characters)
        rv_characters.adapter?.notifyDataSetChanged()
        this.nextPage = nextPage
    }

    override fun showProgress() {
        progress_characters.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_characters.visibility = View.GONE
    }

    override fun showProgressLoadMore() {
        progress_characters_load_more.visibility = View.VISIBLE
    }

    override fun hideProgressLoadMore() {
        progress_characters_load_more.visibility = View.GONE
    }

    override fun showError() {
        Toast.makeText(applicationContext,"Error loading characters...",Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
    }
}
