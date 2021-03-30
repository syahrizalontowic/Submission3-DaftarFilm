package com.syahrizal.submission3daftarfilm.ui.home

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.syahrizal.submission3daftarfilm.R
import com.syahrizal.submission3daftarfilm.databinding.FragmentHomeBinding
import com.syahrizal.submission3daftarfilm.ui.home.adapter.SectionsPagerAdapter

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBar()
        setPagerAdapter()
        val navView: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navView.visibility = View.VISIBLE
    }

    private fun setActionBar() {
        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_zfilm, null)
        val bitmap = drawable?.toBitmap()
        val scaledDrawable = BitmapDrawable(resources,
            bitmap?.let { Bitmap.createScaledBitmap(it, 60, 60, true) })
        (activity as? AppCompatActivity?)?.supportActionBar?.apply {
            setHomeAsUpIndicator(scaledDrawable)
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.app_title)
        }
    }

    private fun setPagerAdapter() {
        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), childFragmentManager)
        fragmentHomeBinding.apply {
            viewPager.adapter = sectionsPagerAdapter
            tabLayout.setupWithViewPager(fragmentHomeBinding.viewPager)
        }
    }
}