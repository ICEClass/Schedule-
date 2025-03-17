package com.example.hitwhcampusapp.querycredits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hitwhcampusapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2025.3.17
 * 王鑫菲
 * 注意里面的注释
 * 注释里有标出哪些地方需要更改，哪些地方不需要更改，没有注释的地方不需要更改
 */

public class QueryCreditsFragment extends Fragment {
    private SwipeRefreshLayout swipeRefreshLayout;
    private CreditAdapter creditAdapter;
    private RecyclerView recyclerView;
    private int selectTerm;
    /* selectTerm用于控制是哪个学期，
        1为大一上学期，2为大一下学期，3为大一夏季学期，
        4为大二上学期，5为大二下学期，6为大二夏季学期，
        7为大三上学期，8为大三下学期，9为大三夏季学期，
        10为大四上学期，11为大四下学期，不需要更改
     */
    private int currentTerm;
    // currentTerm指的是现在所在的学期（如2024春，2025秋等等），需要将selectTerm与currentTerm对应起来，不需要更改
    private List<Credit> creditList = new ArrayList<>();

    // 以下是固定定义，需要随时间改变，只记录了四个学期，不需要更改
    final static String CURRENT_TERM = "2025春季学期";
    final static String LAST_TERM = "2024秋季学期";
    final static String L_LAST_TERM = "2024夏季学期";
    final static String L_L_LAST_TERM = "2024春季学期";

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

        // 初始化学分数据，这个函数内部需要更改
        initCreditList();

        // 设置spinner，不需要更改
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.query_credits_spinner);
        List<String> options = new ArrayList<>(); // 倒序，不需要更改
        options.add(CURRENT_TERM);
        if (currentTerm - 1 >= 1) options.add(LAST_TERM);
        if (currentTerm - 2 >= 1) options.add(L_LAST_TERM);
        if (currentTerm - 3 >= 1) options.add(L_L_LAST_TERM);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectItem = options.get(position);

                // 选择selectItem时的操作，不需要更改
                selectOptions(selectItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 什么都不选的逻辑，不需要更改
                selectOptions(CURRENT_TERM);
            }
        });

        // 设置列表的RecyclerView，不需要更改
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.query_credits_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        creditAdapter = new CreditAdapter(getActivity(), creditList, selectTerm);
        recyclerView.setAdapter(creditAdapter);

        // 设置下拉刷新功能，不需要更改
        swipeRefreshLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.query_credits_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateList();
            }
        });
    }


    // 设置刷新逻辑，不需要更改
    public void updateList() {
        // 以下为刷新动画期间代码逻辑，不需要更改

        // 更新adapter，不需要更改
        creditAdapter.setSelectTerm(selectTerm);
        creditAdapter.notifyDataSetChanged();
        // 控制刷新动画结束，不需要更改
        swipeRefreshLayout.setRefreshing(false);
    }


    // 设置选择逻辑，不需要更改
    public void selectOptions(String selectItem) {
        swipeRefreshLayout.setRefreshing(true);

        if (selectItem.equals(CURRENT_TERM)) {
            selectTerm = currentTerm;
        }
        else if (selectItem.equals(LAST_TERM)) {
            selectTerm = currentTerm - 1;
        }
        else if (selectItem.equals(L_LAST_TERM)) {
            selectTerm = currentTerm - 2;
        }
        else if (selectItem.equals(L_L_LAST_TERM)) {
            selectTerm = currentTerm - 3;
        }
        updateList();
    }

    // 初始化学分，需要更改
    public void initCreditList() {
        // 将selectTerm与currentTerm对应起来，以23级为例，目前是2025春，对于我们来说是大二下学期，即5，需要根据用户更改
        currentTerm = 5;

        /* setTermCredit的第一个参数用于控制是哪个学期，
            1为大一上学期，2为大一下学期，3为大一夏季学期，
            4为大二上学期，5为大二下学期，6为大二夏季学期，
            7为大三上学期，8为大三下学期，9为大三夏季学期，
            10为大四上学期，11为大四下学期
            为了调试，我这里用for把所有学期修的该分数都设为1.0，到时候需要从服务器上拿取数据，需要更改
        */
        // 设置日常行为学分，需要更改
        Credit creditDaily = new Credit("日常行为学分", 10);
        for (int i = 1; i <= 11; ++i)
            creditDaily.setTermCredit(i, 1.0);

        // 设置创新创业学分，需要更改
        Credit creditInnovative = new Credit("创新创业学分", 10);
        for (int i = 1; i <= 11; ++i)
            creditInnovative.setTermCredit(i, 1.0);

        // 设置社会实践学分，需要更改
        Credit creditSociety = new Credit("社会实践学分", 10);
        for (int i = 1; i <= 11; ++i)
            creditSociety.setTermCredit(i, 1.0);

        // 设置文化素质学分，需要更改
        Credit creditCulture = new Credit("文化素质学分", 10);
        for (int i = 1; i <= 11; ++i)
            creditCulture.setTermCredit(i, 1.0);

        // 设置外专业选修学分，需要更改
        Credit creditOther = new Credit("外专业选修学分", 10);
        for (int i = 1; i <= 11; ++i)
            creditOther.setTermCredit(i, 1.0);

        // 将学分加入List，不需要更改
        creditList.add(creditDaily);
        creditList.add(creditInnovative);
        creditList.add(creditSociety);
        creditList.add(creditCulture);
        creditList.add(creditOther);
    }
}