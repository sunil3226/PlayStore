package com.example.playstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class AppsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val horizontalRecycler = view.findViewById<RecyclerView>(R.id.HorizontallyRecyclerView)
        val verticalRecycler = view.findViewById<RecyclerView>(R.id.verticalRecyclerView)

        horizontalRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        horizontalRecycler.adapter = HorizontalAdapter(GameData.apps)

        val psh = PagerSnapHelper()
        psh.attachToRecyclerView(horizontalRecycler)

        verticalRecycler.layoutManager = LinearLayoutManager(requireContext())
        verticalRecycler.adapter = VerticalAdapter(GameData.apps)
    }
}