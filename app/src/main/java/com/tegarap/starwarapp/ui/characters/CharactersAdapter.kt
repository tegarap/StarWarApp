package com.tegarap.starwarapp.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tegarap.starwarapp.R
import com.tegarap.starwarapp.data.models.Character
import kotlinx.android.synthetic.main.item_character.view.*



class CharactersAdapter(var characters: List<Character>) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindItems(characters[position])
    }


    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(character : Character) {
            itemView.tv_character_name.text = character.name
            itemView.tv_character_gender.text = character.gender

//            itemView.list_rv_character.setOnClickListener {
//                callback.onItemClicked(character)
//            }
//
//            this.onCharacterListener = onCharacterListener
//            itemView.setOnClickListener(this)
        }
    }

//    interface OnCharacterListener {
//        fun onItemClicked(position: Int)
//    }
}