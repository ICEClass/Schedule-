package com.example.hitwhcampusapp.querycredits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hitwhcampusapp.R;

import java.util.Arrays;
import java.util.List;

public class QueryCreditsFragment extends Fragment {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private List<Credit> creditList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_query_credits, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 设置spinner
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.query_credits_spinner);
        List<String> options = Arrays.asList("option1", "option2", "option3");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectItem = options.get(position);

                // 选择selectItem时的操作
                selectOptions(selectItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 什么都不选的逻辑
                selectOptions("option1");
            }
        });

        // 设置列表的RecyclerView
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.query_credits_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
//        adapter = new RecordAdapter(getActivity(), selectRecordList);
//        recyclerView.setAdapter(adapter);


        // 设置下拉刷新功能
        swipeRefreshLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.query_credits_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateList();
            }
        });
    }


    // 设置刷新逻辑
    public void updateList() {
        // 以下为刷新动画期间代码逻辑


        // 控制刷新动画结束
        swipeRefreshLayout.setRefreshing(false);
    }


    // 设置选择逻辑
    public void selectOptions(String selectItem) {
        if (selectItem.equals("option1")) {

        }
        else if (selectItem.equals("option2")) {

        }
        else if (selectItem.equals("option3")) {

        }
    }
}