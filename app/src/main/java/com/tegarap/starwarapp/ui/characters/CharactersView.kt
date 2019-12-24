package com.tegarap.starwarapp.ui.characters

import com.tegarap.starwarapp.ui.common.BaseView
import com.tegarap.starwarapp.data.models.Character

interface CharactersView: BaseView {
    fun updateCharacterList(characters: List<Character>, nextPage: Int?)
}