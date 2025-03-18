package com.example.hitwhcampusapp.mine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hitwhcampusapp.R;

import java.util.List;

public class MineAdapter extends RecyclerView.Adapter<MineAdapter.ViewHolder> {
    private List<Mine> mMineList;
    private Context mContext;
    static class ViewHolder extends RecyclerView.ViewHolder {
        View mineView;
        TextView mineName;
        ImageView mineImage;
        public ViewHolder(View view) {
            super(view);
            mineView = view;
            mineName = (TextView) view.findViewById(R.id.mine_item_name);
            mineImage = (ImageView) view.findViewById(R.id.mine_item_image);
        }
    }
    public MineAdapter(Context context, List<Mine> mineList) {
        mMineList = mineList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.mineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Mine mine = mMineList.get(position);
                    String option = mine.getName();
                    if (option.equals("我的积分")) {

                    }
                    else if (option.equals("资源收藏夹")) {

                    }
                    else if (option.equals("帮助")) {

                    }
                    else if (option.equals("bug反馈")) {

                    }
                    else if (option.equals("关于")) {

                    }
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mine mine = mMineList.get(position);
        holder.mineName.setText(mine.getName());
        holder.mineImage.setImageResource(mine.getImage());
    }

    @Override
    public int getItemCount() {
        return mMineList.size();
    }
}
