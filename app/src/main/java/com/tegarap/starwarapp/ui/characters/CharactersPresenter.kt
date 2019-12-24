package com.tegarap.starwarapp.ui.characters

import com.tegarap.starwarapp.data.models.Character

class CharactersPresenter(var charactersView: CharactersView?, var charactersInteractor: CharactersInteractor) :
    CharactersInteractor.onLoadCharacters {

    fun loadCharacters(nextPage: Int?) {
        if(nextPage != null) {
            if(nextPage == 1) {
                charactersView?.showProgress()
            } else {
                charactersView?.showProgressLoadMore()
            }
            charactersInteractor.getCharacters(this, nextPage)
        }
    }

    fun onDestroy() {
        charactersView = null
    }

    override fun onLoadCharactersSuccess(characters: List<Character>?, nextPage: Int?) {
        charactersView?.hideProgress()
        charactersView?.hideProgressLoadMore()
        if(characters != null) {
            charactersView?.updateCharacterList(characters, nextPage)
        } else {
            onLoadCharactersError()
        }
    }

    override fun onLoadCharactersError() {
        charactersView?.hideProgress()
        charactersView?.hideProgressLoadMore()
        charactersView?.showError()
    }
}