package com.example.playstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.search.SearchBar
import com.google.android.material.search.SearchView

class SearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var searchBar: SearchBar
    private lateinit var allItems : List<Game>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView = view.findViewById(R.id.searchView)
        searchBar = view.findViewById(R.id.searchBar)
        recyclerView = view.findViewById(R.id.recyclerView)

        allItems = GameData.games + GameData.apps + GameData.books

        recyclerView.adapter = VerticalAdapter(allItems)

        searchBar.setOnClickListener {
            searchView.show()
        }

        searchView.editText.addTextChangedListener {
            val query = it.toString()
            filterList(query)
        }

        searchView.editText.setOnEditorActionListener { _, _, _ ->
            searchView.hide()
            searchBar.setText(searchView.text)
            true
        }

        searchView.addTransitionListener { _, _, newState ->
            if (newState == SearchView.TransitionState.HIDDEN) {
                searchBar.setText(searchView.text)
            }
        }

    }

    private fun filterList(query: String) {
        val filtered = allItems.filter { it.title.contains(query, ignoreCase = true) }
        recyclerView.adapter = VerticalAdapter(filtered)
    }
}