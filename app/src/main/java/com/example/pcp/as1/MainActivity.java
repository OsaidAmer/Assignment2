package com.example.pcp.as1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;        //view
    private LectureAdapter mAdapter; //controller
    Button fragmentBtn;
    Model model = new Model();
    private static List<Lecture> lectureList = new ArrayList<>();
    DataManipulation dm = new DataManipulation(lectureList,model);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // binding by id
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fragmentBtn = (Button) findViewById(R.id.fragment_button) ;
        mAdapter = new LectureAdapter(lectureList,getApplicationContext(),model);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        dm.getData(mAdapter);
        fragmentBtnHandler();
    }
    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }
    public void fragmentBtnHandler(){
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fragmentContainerActivity.class);
                startActivity(intent);
            }
        });
    }
}
