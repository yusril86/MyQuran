package com.yusril.myquran.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.yusril.myquran.adapter.SurahAdapter
import com.yusril.myquran.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val dashboardViewModel: DashboardViewModel by activityViewModels()
    private val adapterSurah: SurahAdapter = SurahAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getSurah()
    }

    private fun getSurah() {
       /* dashboardViewModel.fetchDataSurah()
        dashboardViewModel.getListSurah().observe(viewLifecycleOwner) {
            it.also {
                binding.rvSurah.apply {
                    adapter = adapterSurah
                    setHasFixedSize(true)
                }
//                adapterSurah.updateAdapter(ArrayList(it!!))
            }
        }*/

    }

}