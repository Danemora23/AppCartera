package com.example.appcartera

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appcartera.Database.User
import com.example.appcartera.Database.UserDataBase
import com.example.appcartera.Database.UserViewModel
import com.example.appcartera.dummy.DummyContent
import kotlinx.android.synthetic.main.fragment_list_list.view.*

/**
 * A fragment representing a list of Items.
 */
class FragmentList : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_list, container, false)

        // Set the adapter
        val adapter = MyItemRecyclerViewAdapter()
        val recyclerView = view.list
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllUser.observe(viewLifecycleOwner, Observer {
            users -> adapter.setData(users)
        })
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            FragmentList().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}