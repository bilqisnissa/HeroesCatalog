package com.bilqis.lol.catalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //global variable
    private var list: ArrayList<Hero> = arrayListOf()
    private var title = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_main.setHasFixedSize(true)
        list.addAll(DataHero.listHero)

        addRecyclerViewList()

    }

    private fun addRecyclerViewList() {
        rv_main.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = HeroAdapter(list)
        rv_main.adapter = listHeroAdapter

    }
    private fun addRecyclerCard() {
        rv_main.layoutManager = LinearLayoutManager(this)
        val cardHeroAdapter = CardHeroAdapter(list)
        rv_main.adapter = cardHeroAdapter
    }

    private fun addRecyclerViewGrid() {
        rv_main.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rv_main.adapter = gridHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode){
            R.id.action_list ->{addRecyclerViewList()
            }
            R.id.action_grid ->{addRecyclerViewGrid()
            }
            R.id.action_card -> {addRecyclerCard()
            }
        }
    }
}