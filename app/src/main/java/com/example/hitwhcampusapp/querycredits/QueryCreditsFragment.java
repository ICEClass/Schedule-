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
    private CreditAdapter creditAdapter;

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


        initCreditList();

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
        creditAdapter = new CreditAdapter(getActivity(), creditList, 1.0);
        recyclerView.setAdapter(creditAdapter);


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
        double selectTerm = 1.0;
        // selectTerm用于控制是哪个学期，1.0为大一上学期，1.5为大一下学期，2.0为大二上学期……4.0为大四上学期，4.5为大四下学期

        // 更新adapter
        creditAdapter.setSelectTerm(selectTerm);
        creditAdapter.notifyDataSetChanged();
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

    // 初始化学分
    public void initCreditList() {
        // 设置日常行为学分
        Credit creditDaily = new Credit("日常行为学分", 10);
        creditDaily.setFirstTermFirst(1.0); // 大一上学期
        creditDaily.setFirstTermSecond(2.0); // 大一下学期
        creditDaily.setSecondTermFirst(2.5); // 大二上学期
        creditDaily.setSecondTermSecond(2.0); // 大二下学期
        creditDaily.setThirdTermFirst(2.0); // 大三上学期
        creditDaily.setThirdTermSecond(1.0); // 大三下学期
        creditDaily.setForthTermFirst(1.0); // 大四上学期
        creditDaily.setForthTermSecond(1.0); // 大四下学期

        // 设置创新创业学分
        Credit creditInnovative = new Credit("创新创业学分", 10);
        creditInnovative.setFirstTermFirst(1.0); // 大一上学期
        creditInnovative.setFirstTermSecond(2.0); // 大一下学期
        creditInnovative.setSecondTermFirst(2.5); // 大二上学期
        creditInnovative.setSecondTermSecond(2.0); // 大二下学期
        creditInnovative.setThirdTermFirst(2.0); // 大三上学期
        creditInnovative.setThirdTermSecond(1.0); // 大三下学期
        creditInnovative.setForthTermFirst(1.0); // 大四上学期
        creditInnovative.setForthTermSecond(1.0); // 大四下学期

        // 设置社会实践学分
        Credit creditSociety = new Credit("社会实践学分", 10);
        creditSociety.setFirstTermFirst(1.0); // 大一上学期
        creditSociety.setFirstTermSecond(2.0); // 大一下学期
        creditSociety.setSecondTermFirst(2.5); // 大二上学期
        creditSociety.setSecondTermSecond(2.0); // 大二下学期
        creditSociety.setThirdTermFirst(2.0); // 大三上学期
        creditSociety.setThirdTermSecond(1.0); // 大三下学期
        creditSociety.setForthTermFirst(1.0); // 大四上学期
        creditSociety.setForthTermSecond(1.0); // 大四下学期

        // 设置文化素质学分
        Credit creditCulture = new Credit("文化素质学分", 10);
        creditCulture.setFirstTermFirst(1.0); // 大一上学期
        creditCulture.setFirstTermSecond(2.0); // 大一下学期
        creditCulture.setSecondTermFirst(2.5); // 大二上学期
        creditCulture.setSecondTermSecond(2.0); // 大二下学期
        creditCulture.setThirdTermFirst(2.0); // 大三上学期
        creditCulture.setThirdTermSecond(1.0); // 大三下学期
        creditCulture.setForthTermFirst(1.0); // 大四上学期
        creditCulture.setForthTermSecond(1.0); // 大四下学期

        // 设置外专业选修学分
        Credit creditOther = new Credit("外专业选修学分", 10);
        creditOther.setFirstTermFirst(1.0); // 大一上学期
        creditOther.setFirstTermSecond(2.0); // 大一下学期
        creditOther.setSecondTermFirst(2.5); // 大二上学期
        creditOther.setSecondTermSecond(2.0); // 大二下学期
        creditOther.setThirdTermFirst(2.0); // 大三上学期
        creditOther.setThirdTermSecond(1.0); // 大三下学期
        creditOther.setForthTermFirst(1.0); // 大四上学期
        creditOther.setForthTermSecond(1.0); // 大四下学期

        creditList.add(creditDaily);
        creditList.add(creditInnovative);
        creditList.add(creditSociety);
        creditList.add(creditCulture);
        creditList.add(creditOther);
    }
}