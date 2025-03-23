package com.example.hitwhcampusapp.querycredits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hitwhcampusapp.R;

import java.util.ArrayList;
import java.util.List;

public class MoreDialogFragment extends DialogFragment {
    private SwipeRefreshLayout swipeRefreshLayout;
    private CreditMoreAdapter creditMoreAdapter;
    private RecyclerView recyclerView;
    private Credit mCredit;
    private List<CreditMore> creditMoreList = new ArrayList<>();

    MoreDialogFragment(Credit credit) {
        mCredit = credit;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 加载自定义布局
        return inflater.inflate(R.layout.fragment_more_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 设置UI
        TextView moreName = (TextView) view.findViewById(R.id.query_credits_more_name);
        moreName.setText(mCredit.getName());

        // 初始化明细数据，这个函数内部需要更改
        initCreditMoreList();

        // 设置按钮
        // 添加明细，需要更改
        TextView addButton = (TextView) view.findViewById(R.id.query_credits_more_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // back图表
        ImageView back = (ImageView) view.findViewById(R.id.query_credits_more_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 设置recyclerview，不需要更改
        recyclerView = (RecyclerView) view.findViewById(R.id.query_credits_more_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        creditMoreAdapter = new CreditMoreAdapter(getActivity(), creditMoreList);
        recyclerView.setAdapter(creditMoreAdapter);

        // 设置下拉刷新功能，不需要更改
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.query_credits_more_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateList();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // 设置弹窗的宽度和高度
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT, // 宽度根据内容自适应
                    ViewGroup.LayoutParams.WRAP_CONTENT // 高度根据内容自适应
            );
        }
    }

    // 设置刷新逻辑，需要更改
    public void updateList() {
        // 以下为刷新动画期间代码逻辑，更新列表，需要更改

        // 更新adapter，不需要更改
        creditMoreAdapter.setCreditMoreList(creditMoreList);
        creditMoreAdapter.notifyDataSetChanged();
        // 控制刷新动画结束，不需要更改
        swipeRefreshLayout.setRefreshing(false);
    }

    // 初始化明细列表，需要更改
    void initCreditMoreList() {
        CreditMore creditMore = new CreditMore("创业基础", "2025-01-02", 2.0);
        for (int i = 1; i <= 10; ++i) {
            creditMoreList.add(creditMore);
        }
    }
}