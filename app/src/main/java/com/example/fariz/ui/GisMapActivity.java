package com.example.fariz.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.portal.Portal;
import com.esri.arcgisruntime.portal.PortalItem;
import com.example.fariz.ui.fragment.FilterDialogFragment;

public class GisMapActivity extends AppCompatActivity   {
    private MapView mmapView;
    private FloatingActionButton fabFilterDialog1;
    private String caseFilter = "";
    private String itemId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gis_map);
        fabFilterDialog1 = findViewById(R.id.fab_filter_dialog1);
        mmapView = findViewById(R.id.MapView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setTitle("GIS MAP");
        getSupportActionBar().setSubtitle("Ayo Investasi di jogja");

        fabFilterDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fab_filter_dialog1:
                        FilterDialogFragment filterDialogFragment = new FilterDialogFragment();
                        filterDialogFragment.setOnOptionDialogListener(new FilterDialogFragment.OnOptionDialogListener() {
                            @Override
                            public void onOptionSelect(String caseOption) {
                                caseFilter = caseOption;
                                setupMap();
                            }
                        });
                        filterDialogFragment.show(getSupportFragmentManager(), FilterDialogFragment.class.getSimpleName());
                        break;
                }
            }

        });

    }
    private void setupMap() {
        Portal portal = new Portal("http://www.arcgis.com");
        PortalItem mapPortalItem = new PortalItem(portal, getItemId());
        ArcGISMap map = new ArcGISMap(mapPortalItem);
        mmapView.setMap(map);
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