package com.example.hitwhcampusapp.querycredits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hitwhcampusapp.R;

import java.util.List;

public class CreditMoreAdapter extends RecyclerView.Adapter<CreditMoreAdapter.ViewHolder> {
    private Context mContext;
    private List<CreditMore> mCreditMoreList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View creditMoreView;
        TextView creditMoreSource;
        TextView creditMoreTime;
        TextView creditMoreCredit;

        public ViewHolder(View view) {
            super(view);
            creditMoreView = view;
            creditMoreSource = (TextView) view.findViewById(R.id.credit_more_item_source);
            creditMoreTime = (TextView) view.findViewById(R.id.credit_more_item_time);
            creditMoreCredit = (TextView) view.findViewById(R.id.credit_more_item_credit);
        }
    }
    public CreditMoreAdapter(Context context, List<CreditMore> creditMoreList) {
        mContext = context;
        mCreditMoreList = creditMoreList;
    }

    public void setCreditMoreList(List<CreditMore> creditMoreList) {
        mCreditMoreList = creditMoreList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_more_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CreditMore creditMore = mCreditMoreList.get(position);

        holder.creditMoreSource.setText(creditMore.getSource());
        holder.creditMoreTime.setText("" + creditMore.getTime());
        holder.creditMoreCredit.setText("" + creditMore.getCredit());
    }

    @Override
    public int getItemCount() {
        return mCreditMoreList.size();
    }
}
