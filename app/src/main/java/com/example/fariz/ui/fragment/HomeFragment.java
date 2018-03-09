package com.example.fariz.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.portal.Portal;
import com.esri.arcgisruntime.portal.PortalItem;
import com.example.fariz.ui.R;
import com.example.fariz.ui.adapter.HomeMenuAdapter;
import com.example.fariz.ui.data.HomeMenu;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private RecyclerView rvMenuHome;

    private ArrayList<HomeMenu> homeMenus;

    private HomeMenuAdapter homeMenuAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvMenuHome = view.findViewById(R.id.rv_menu_home);

        setupMenuHome();


        return view;
    }

    private void setupMenuHome() {
        homeMenus = new ArrayList<>();
        homeMenus.add(new HomeMenu(R.drawable.ic_map_layer, "GIS Map"));
        homeMenus.add(new HomeMenu(R.drawable.ic_percon_pin, "Demografi"));
        homeMenus.add(new HomeMenu(R.drawable.ic_flower, "Pertanian"));
        homeMenus.add(new HomeMenu(R.drawable.ic_library_book, "Detail Data"));

        homeMenuAdapter = new HomeMenuAdapter(homeMenus, getContext());
        rvMenuHome.setLayoutManager(new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL,false));
        rvMenuHome.setAdapter(homeMenuAdapter);
    }


    @Override
    public void onClick(View view) {
    }

}
