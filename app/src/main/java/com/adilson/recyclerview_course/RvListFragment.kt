package com.adilson.recyclerview_course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.adilson.recyclerview_course.databinding.FragmentRvListBinding
import com.dummy.MockItensList
import layout.UserItem
import java.util.UUID

class RvListFragment : Fragment(R.layout.fragment_rv_list) {

    private var _binding : FragmentRvListBinding? = null
    private  val binding get() = _binding!!

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = UserAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRvListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUser.adapter = adapter
        binding.rvUser.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        adapter.upDateUser(MockItensList.UserItemItemLists)

        binding.fabSelectUsers.setOnClickListener {

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}