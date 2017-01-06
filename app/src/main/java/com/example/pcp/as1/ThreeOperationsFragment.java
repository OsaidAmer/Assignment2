package com.example.pcp.as1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import UI.Fragments.AddUIFragment;
import UI.Fragments.RemoveUIFragment;
import UI.Fragments.ReplaceUIFragment;


public class ThreeOperationsFragment extends Fragment {
    Button addFragmentBtn, repFragmentBtn, rmFragmentBtn;
    FragmentTransaction ft;
    FragmentManager fm = getFragmentManager();
    AddUIFragment addUIFragment;

    private FragmentActivity c;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_three_operations_fragment, container, false);
        addFragmentBtn = (Button) view.findViewById(R.id.addfrag_btnId);
        // rmFragmentBtn = (Button) view.findViewById(R.id.rmfrag_btnId);
        // repFragmentBtn = (Button) view.findViewById(R.id.repfrag_btnId);

        fm = getFragmentManager();
        ft = fm.beginTransaction();
        addFragmentOnClick();

        return view;
    }

    public void addFragmentOnClick() {
        addFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUIFragment = new AddUIFragment();
                ft.add(R.id.activity_fragment_container, addUIFragment);
                ft.commit();
            }
        });
    }

}
