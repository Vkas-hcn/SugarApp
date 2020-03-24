package com.vkas.sugarapp.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vkas.sugarapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;

/**
 * Created by HCN on 2020/3/24.
 */
public class SystemFragment extends Fragment {
    public static SystemFragment newInstance(String param1) {
        SystemFragment fragment = new SystemFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public SystemFragment() {

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_system, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        TextView tv = (TextView)view.findViewById(R.id.system_textView);
        tv.setText(agrs1);
        return view;
    }
}
