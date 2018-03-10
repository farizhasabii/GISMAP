package com.example.fariz.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.portal.Portal;
import com.esri.arcgisruntime.portal.PortalItem;
import com.example.fariz.ui.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private MapView mMapView;

    private String itemId = "";

    private FloatingActionButton fabFilterDialog;

    private String caseFilter = "";

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mMapView = view.findViewById(R.id.mapView);
        fabFilterDialog = view.findViewById(R.id.fab_filter_dialog);

        fabFilterDialog.setOnClickListener(this);


        return view;
    }

    private void setupMap() {
        Portal portal = new Portal("http://www.arcgis.com");
            PortalItem mapPortalItem = new PortalItem(portal, getItemId());
            ArcGISMap map = new ArcGISMap(mapPortalItem);
            mMapView.setMap(map);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_filter_dialog:
                FilterDialogFragment filterDialogFragment = new FilterDialogFragment();
                filterDialogFragment.setOnOptionDialogListener(new FilterDialogFragment.OnOptionDialogListener() {
                    @Override
                    public void onOptionSelect(String caseOption) {
                        caseFilter = caseOption;
                        setupMap();
                    }
                });
                filterDialogFragment.show(getChildFragmentManager(), FilterDialogFragment.class.getSimpleName());
                break;
        }
    }



    public String getItemId() {
        if (caseFilter.equals("home")) {
           return itemId = "9c6cdd7e5f6c41f38dad36316664ec24";
        } else if (caseFilter.equals("other")) {
           return itemId = "fae8f0819738446281c60e00fb2de8b8";
        } else {
            return itemId = "";
        }
    }
}
