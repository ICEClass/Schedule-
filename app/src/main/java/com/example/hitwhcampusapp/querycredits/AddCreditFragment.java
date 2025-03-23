package com.example.hitwhcampusapp.querycredits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hitwhcampusapp.R;

public class AddCreditFragment extends DialogFragment {
    private static final String REQUEST_KEY = "dialog_result_key"; // 请求键
    private Credit mCredit;

    AddCreditFragment(Credit credit) {
        mCredit = credit;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_credit_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 设置UI
        TextView name = (TextView) view.findViewById(R.id.query_credits_more_add_credit_name);
        name.setText(mCredit.getName());

        ImageView back = (ImageView) view.findViewById(R.id.query_credits_more_add_credit_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 设置提交按钮
        Button addButton = (Button) view.findViewById(R.id.query_credits_more_add_credit_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入
                TextView sourceTextView = (TextView) view.findViewById(R.id.query_credits_more_add_credit_source);
                TextView timeTextView = (TextView) view.findViewById(R.id.query_credits_more_add_credit_time);
                TextView creditTextView = (TextView) view.findViewById(R.id.query_credits_more_add_credit_credit);

                String source = sourceTextView.getText().toString().trim();
                String time = timeTextView.getText().toString().trim();
                String creditString = creditTextView.getText().toString().trim();
                double credit = 0.0;
                boolean flag = true;

                try {
                    credit = Double.parseDouble(creditString);
                } catch (NumberFormatException e) {
                    // 处理无效输入
                    flag = false;
                }

                if (source.isEmpty()) Toast.makeText(getActivity(), "请输入学分来源", Toast.LENGTH_SHORT).show();
                else if (time.isEmpty()) Toast.makeText(getActivity(), "请输入时间", Toast.LENGTH_SHORT).show();
                else if (creditString.isEmpty()) Toast.makeText(getActivity(), "请输入学分", Toast.LENGTH_SHORT).show();
                else if (!flag) Toast.makeText(getActivity(), "学分请输入数字", Toast.LENGTH_SHORT).show();
                else {
                    // 输入正确，将数据传递回 MoreDialogFragment
                    Bundle result = new Bundle();
                    result.putString("input_source", source);
                    result.putString("input_time", time);
                    result.putDouble("input_credit", credit);
                    getParentFragmentManager().setFragmentResult(REQUEST_KEY, result);

                    Toast.makeText(getActivity(), "添加学分成功", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });
    }
    private void onFragmentResult(int requestKey, Bundle arguments) {

    }
}