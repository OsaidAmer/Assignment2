package com.example.pcp.as1;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class fragmentContainerActivity extends AppCompatActivity {
    FragmentManager fm; // fragment manager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        fm = getSupportFragmentManager();
        if(MainActivity.recyclerViewClickedPosition == 29){
            acynctasnAndpicassoFragment();
        }else {
            buttonsOperationsFragment(); // display 3 buttons
        }
    }

    public void acynctasnAndpicassoFragment(){
        AsynctaskFragment asynctaskFragment = new AsynctaskFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.activity_fragment_container,asynctaskFragment);
        ft.commit();
    }
    // 3 Buttons fragment
    public void buttonsOperationsFragment(){
        ThreeOperationsFragment threeOperationsFragment = new ThreeOperationsFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.activity_fragment_container,threeOperationsFragment);
        ft.commit();
    }


}
