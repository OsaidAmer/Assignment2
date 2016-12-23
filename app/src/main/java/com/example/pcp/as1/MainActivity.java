package com.example.pcp.as1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Lecture> lectureList = new ArrayList<>(); // model
    RecyclerView recyclerView;   // view
    private LectureAdapter mAdapter;     // controller
    String[] datesList = new String[66];
    Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view); // binding by id

        mAdapter = new LectureAdapter(lectureList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //skipping lectures according to loz that aren't android!
                if(position > 0 && position < 13){
                    Lecture lecture = lectureList.get(position);
                    Toast.makeText(getApplicationContext(), "google drive required!", Toast.LENGTH_SHORT).show();
                }
//                Lecture lecture = lectureList.get(position);
//                Toast.makeText(getApplicationContext(), position+" selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getTopics().get(datesList[position])));
                startActivity(intent);
           }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        processLectures();
        getData(model);
    }

    // this is a littel bit complex , it's according to loz
    private void processLectures(){
        int[] months_end = {30,31,31,28,31};
        int[] months =     {11,12,1,2,3};
        int in = 0;
        int counter = 1;
        int d = 1;
        // course started 31/10/2016
        int day = 31;
        datesList[0] = "31/10";

        day = 2;
        counter = 2; // number of times we learn a week , 2 -> wednesday
        //November
        while(in <= months.length-1) {
            int last_day_of_month = months_end[in];
            while(day <= last_day_of_month) {
                if (counter % 3 == 0) {
                    datesList[d++] = day+"/"+months[in];
                    day += 3;
                    counter = 1;
                }else {
                    ++counter;
                    datesList[d++] = day+"/"+months[in];
                    day += 2;
                }
            }
            ++in;
            day = day % months_end[in-1];
        }

    }
    // prepare data for java and android lectures.
    private void getData(Model model) {
        //java part
        int i = 0;
        int java_lec = 1;
        int web_lec= 1;
        int android_lect = 1;

        //Java
        for (; i < 13 ; i++){
            Lecture l = new Lecture("Java - Elena","lecture "+(java_lec++),datesList[i]+"/2016",R.drawable.matusevichelena);
            lectureList.add(l);

        }

        //WEB
        Lecture l = new Lecture("Web - ilan","lecture "+(web_lec++),datesList[i]+"/2016",R.drawable.ilan);
        lectureList.add(l);
        ++i;

        //android part
        while(i < 16){
            l = new Lecture("Android - Or","lecture "+(android_lect++),datesList[i]+"/2016",R.drawable.oressel);
            lectureList.add(l);
            ++i;
        }

        //WEB
        l = new Lecture("Web - ilan","lecture "+(web_lec++),datesList[i]+"/2016",R.drawable.ilan);
        lectureList.add(l);
        ++i;

        while(i < 19){
            l = new Lecture("Android - Or","lecture "+(android_lect++),datesList[i]+"/2016",R.drawable.oressel);
            lectureList.add(l);
            ++i;
        }

        //WEB
        l = new Lecture("Web - ilan","lecture "+(web_lec++),datesList[i]+"/2016",R.drawable.ilan);
        lectureList.add(l);
        ++i;

        //android
        l = new Lecture("Android - Or","lecture "+(android_lect++),datesList[i]+"/2016",R.drawable.oressel);
        lectureList.add(l);

        ++i;
        l = new Lecture("Android - Or","lecture "+(android_lect++),datesList[i]+"/2016",R.drawable.oressel);
        lectureList.add(l);


        mAdapter.notifyDataSetChanged();
    }
}
