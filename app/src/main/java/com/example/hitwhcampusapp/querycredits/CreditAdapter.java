package com.example.hitwhcampusapp.querycredits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hitwhcampusapp.R;

import java.util.List;

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.ViewHolder> {
    private Context mContext;
    private List<Credit> mCreditList;
    private double selectTerm;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View creditView;
        TextView creditName;
        TextView creditSum;
        TextView creditTerm;
        TextView creditNeed;
        TextView creditProgress;

        public ViewHolder(View view) {
            super(view);
            creditView = view;
            creditName = (TextView) view.findViewById(R.id.credit_item_name);
            creditSum = (TextView) view.findViewById(R.id.credit_item_sum);
            creditTerm = (TextView) view.findViewById(R.id.credit_item_term);
            creditNeed = (TextView) view.findViewById(R.id.credit_item_need);
            creditProgress = (TextView) view.findViewById(R.id.credit_item_progress);
        }
    }
    public CreditAdapter(Context context, List<Credit> creditList) {
        mContext = context;
        mCreditList = creditList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        // 设置更多按钮的点击事件
        ImageButton moreButton = (ImageButton) view.findViewById(R.id.credit_item_more);
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Credit credit = mCreditList.get(position);

        holder.creditName.setText(credit.getName());
        holder.creditSum.setText("" + credit.getSum());

        if (selectTerm == 1.0) holder.creditTerm.setText("" + credit.getFirstTermFirst());
        else if (selectTerm == 1.5) holder.creditTerm.setText("" + credit.getFirstTermSecond());
        else if (selectTerm == 2.0) holder.creditTerm.setText("" + credit.getSecondTermFirst());
        else if (selectTerm == 2.5) holder.creditTerm.setText("" + credit.getSecondTermSecond());
        else if (selectTerm == 3.0) holder.creditTerm.setText("" + credit.getThirdTermFirst());
        else if (selectTerm == 3.5) holder.creditTerm.setText("" + credit.getThirdTermSecond());
        else if (selectTerm == 4.0) holder.creditTerm.setText("" + credit.getForthTermFirst());
        else if (selectTerm == 4.5) holder.creditTerm.setText("" + credit.getForthTermSecond());

        holder.creditNeed.setText("" + credit.getNeed());
        holder.creditProgress.setText("" + credit.getProgress());
    }

    @Override
    public int getItemCount() {
        return mCreditList.size();
    }
}
