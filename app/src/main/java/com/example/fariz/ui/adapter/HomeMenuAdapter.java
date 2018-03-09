package com.example.fariz.ui.adapter;

import com.example.fariz.ui.R;
import com.example.fariz.ui.data.HomeMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dimdimasdim on 10/03/2018.
 */

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.HomeMenuViewHolder> {

    private ArrayList<HomeMenu> homeMenus;

    private Context context;

    public HomeMenuAdapter(ArrayList<HomeMenu> homeMenus, Context context) {
        this.homeMenus = homeMenus;
        this.context = context;
    }

    @Override
    public HomeMenuAdapter.HomeMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_menu_home, parent, false);

        return new HomeMenuAdapter.HomeMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeMenuAdapter.HomeMenuViewHolder holder, int position) {
        final HomeMenu homeMenu = homeMenus.get(position);
        holder.imgMenuHome.setImageResource(homeMenu.getImgMenu());
        holder.tvTitleMenu.setText(homeMenu.getTitleMenu());
    }

    @Override
    public int getItemCount() {
        return homeMenus.size();
    }

    public class HomeMenuViewHolder extends RecyclerView.ViewHolder implements View
        .OnClickListener {

        ImageView imgMenuHome;

        TextView tvTitleMenu;

        RelativeLayout rlMenuHome;

        public HomeMenuViewHolder(View itemView) {
            super(itemView);

            imgMenuHome = itemView.findViewById(R.id.img_mrnu_homr);

            tvTitleMenu = itemView.findViewById(R.id.tv_menu_home);

            rlMenuHome = itemView.findViewById(R.id.rl_container_menu_home);

            rlMenuHome.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "klik", Toast.LENGTH_SHORT).show();
        }
    }
}
