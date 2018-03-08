package com.example.tonyo.pokeapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_layout.view.*
/**
 * Created by TONYO on 3/8/2018.
 */
class MainAdapter(val pokeList: ArrayList<PokeObject>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.pokemon_layout, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val pokemon: PokeObject = pokeList[position]
        holder?.view?.txtPokeName?.text = pokemon.name
        val pokemonImage = holder?.view?.imgView
        Picasso.with(holder?.view?.context).load(pokemon.sprites.front_default).into(pokemonImage)
    }

    override fun getItemCount(): Int {
        return pokeList.size    }
}

 class CustomViewHolder (val view: View): RecyclerView.ViewHolder(view) {

}
