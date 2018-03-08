package com.example.tonyo.pokeapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    private val url = "https://pokeapi.co/api/v2/pokemon/"
    private val pokeList = arrayListOf<PokeObject>()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            recyclerView_pokemon.layoutManager = LinearLayoutManager(this)
            for (i in 1..20) {
                doAsync {
                    val resultJson = URL(url + i).readText()
                    uiThread {
                        val jsonObj = JSONObject(resultJson)

                        val pokeid = jsonObj.getInt("id")
                        val pokename = jsonObj.getString("name")
                        val sprites = jsonObj.getString("sprites")
                        val jsonObj2 = JSONObject(sprites)
                        val front_default = jsonObj2.getString("front_default")

                        pokeList.add(PokeObject(id, pname, Sprites(front_default)))

                        recyclerView_pokemon.adapter = MainAdapter(pokeList)
                        if (pokeList.size != 0) {
                            txtViewPokemon.text = "You have new" + pokeList.size.toString() + " Pokemons"
                        }
                        if (pokeList.size == 20) {
                            progressBar.visibility = View.GONE
                        }
                    }
                }
            }

        }

}
