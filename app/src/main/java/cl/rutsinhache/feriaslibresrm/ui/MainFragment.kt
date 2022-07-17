package cl.rutsinhache.feriaslibresrm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cl.rutsinhache.feriaslibresrm.R
import cl.rutsinhache.feriaslibresrm.adapter.FeriasAdapter
import cl.rutsinhache.feriaslibresrm.databinding.FragmentMainBinding
import cl.rutsinhache.feriaslibresrm.viewmodel.FeriasViewModel

class MainFragment : Fragment() {
    private lateinit var b: FragmentMainBinding
    private val vm: FeriasViewModel by activityViewModels()
    private val adapter = FeriasAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentMainBinding.inflate(layoutInflater)
        loadList()
        return b.root
    }

    private fun loadList() {
        val manager = LinearLayoutManager(requireContext())
        b.recycler.adapter = adapter
        b.recycler.layoutManager = manager
        vm.liveDataDetail().observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })
    }

}