package com.example.hitwhcampusapp.querycredits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hitwhcampusapp.R;

import java.util.List;

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.ViewHolder> {
    private Context mContext;
    private List<Credit> mCreditList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View creditView;
        TextView creditName;
        TextView creditNumber;

        public ViewHolder(View view) {
            super(view);

        }
    }
    public CreditAdapter(Context context, List<Credit> creditList) {
        mContext = context;
        mCreditList = creditList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout, parent, false);
        final ViewHolder holder = new ViewHolder(view);
    }
}
