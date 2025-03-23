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

/**
 * 2025.3.17
 * 王鑫菲
 * 这个adapter没有需要更改的地方
 */

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.ViewHolder> {
    private Context mContext;
    private List<Credit> mCreditList;
    private int mSelectTerm;
    private FragmentManager mFragmentManager;

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
    public CreditAdapter(Context context, FragmentManager fragmentManager, List<Credit> creditList, int selectTerm) {
        mContext = context;
        mCreditList = creditList;
        mSelectTerm = selectTerm;
        mFragmentManager = fragmentManager;
    }

    public void setSelectTerm(int selectTerm) {
        mSelectTerm = selectTerm;
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
                int position = holder.getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Credit credit = mCreditList.get(position);
                    MoreDialogFragment moreDialogFragment = new MoreDialogFragment(credit);
                    moreDialogFragment.show(mFragmentManager, "MoreDialogFragment");
                }
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Credit credit = mCreditList.get(position);

        holder.creditName.setText(credit.getName());
        holder.creditSum.setText("" + credit.getSum());
        if (mSelectTerm >= 1 && mSelectTerm <= 11)
            holder.creditTerm.setText("" + credit.getTermCredit(mSelectTerm));
        holder.creditNeed.setText("" + credit.getNeed());
        holder.creditProgress.setText("" + credit.getProgress() + "%");
    }

    @Override
    public int getItemCount() {
        return mCreditList.size();
    }
}
