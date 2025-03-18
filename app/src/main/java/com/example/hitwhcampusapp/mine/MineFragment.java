package com.example.hitwhcampusapp.mine;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hitwhcampusapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 2025.3.17
 * 王鑫菲
 */

public class MineFragment extends Fragment {

    public List<Mine> mineList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initMines();
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.mine_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        MineAdapter mineAdapter = new MineAdapter(getActivity(), mineList);
        recyclerView.setAdapter(mineAdapter);
    }

    void initMines() {
        Mine myPoints = new Mine(R.drawable.points, "我的积分");
        mineList.add(myPoints);
        Mine myFavorites = new Mine(R.drawable.folder, "资源收藏夹");
        mineList.add(myFavorites);
        Mine helps = new Mine(R.drawable.help, "帮助");
        mineList.add(helps);
        Mine bugFeed = new Mine(R.drawable.bug, "bug反馈");
        mineList.add(bugFeed);
        Mine about = new Mine(R.drawable.about, "关于");
        mineList.add(about);
    }
}