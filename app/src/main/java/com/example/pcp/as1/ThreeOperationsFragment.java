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
import android.widget.Toast;


import UI.Fragments.AddUIFragment;
import UI.Fragments.RemoveUIFragment;
import UI.Fragments.ReplaceUIFragment;


public class ThreeOperationsFragment extends Fragment {
    Button addFragmentBtn, repFragmentBtn, rmFragmentBtn;
    FragmentTransaction ft;
    FragmentManager fm;
    AddUIFragment addUIFragment;
    ReplaceUIFragment replaceUIFragment;
    RemoveUIFragment removeUIFragment;

    static Fragment fr;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_three_operations_fragment, container, false);
        fm = getFragmentManager();
        addFragmentBtn = (Button) view.findViewById(R.id.addfrag_btnId);
        rmFragmentBtn = (Button) view.findViewById(R.id.rmfrag_btnId);
        repFragmentBtn = (Button) view.findViewById(R.id.repfrag_btnId);

         addFragmentOnClickHandler();
         repFragmentOnClickHandler();
         removeFragmentOnClickHandler();
         return view;
    }

    public void addFragmentOnClickHandler() {
        addFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                addUIFragment = new AddUIFragment();
                fr = addUIFragment;
                ft.setCustomAnimations(R.anim.enter_from_left,R.anim.enter_from_right);
                ft.add(R.id.activity_fragment_container,fr);
                ft.commit();
            }
        });
    }
    public void repFragmentOnClickHandler() {
        repFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.replace(R.id.activity_fragment_container,new ReplaceUIFragment());
                ft.commit();
            }
        });
    }
    public void removeFragmentOnClickHandler() {
        rmFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.remove(fr);
                ft.commit();
            }
        });
    }

}
