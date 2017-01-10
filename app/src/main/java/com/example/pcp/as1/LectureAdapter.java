package com.example.pcp.as1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.MyViewHolder>{
    private List<Lecture> lecturesList = new ArrayList<Lecture>();
    static int recyclerViewClickedPosition = 0;
    Context context;
    Model model ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView lecture_topic,lecture_number , lecture_date;
        public ImageView lecture_iv;

        public MyViewHolder(View view) {
            super(view);
            lecture_topic = (TextView) view.findViewById(R.id.lectTopicId);
            lecture_number = (TextView) view.findViewById(R.id.lectNumberId);
            lecture_date = (TextView) view.findViewById(R.id.lectDateId);
            lecture_iv = (ImageView) view.findViewById(R.id.profile_pic_id);
        }
    }

    public LectureAdapter(List<Lecture> lecturesList,Context context,Model model) {
        this.lecturesList = lecturesList;
        this.context = context;
        this.model = model;

    }
    //private LayoutInflater inflater;
    @Override
    public LectureAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lecture_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LectureAdapter.MyViewHolder holder,final int position) {
        Lecture lecture = lecturesList.get(position);
        holder.lecture_topic.setText(lecture.getTopic());
        holder.lecture_number.setText(String.valueOf(lecture.getLectureNumber()));
        holder.lecture_date.setText(lecture.getDate());
        holder.lecture_iv.setImageResource(lecture.iconId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                recyclerViewClickedPosition = position;
                if(position == 29){
                    Intent intent = new Intent(context.getApplicationContext(),fragmentContainerActivity.class);
                    context.startActivity(intent);
                }else {
                    //Java
                    if (position > 0 && position < 13) {
                        Lecture lecture = getLecturesList().get(position);
                        Toast.makeText(context.getApplicationContext(), "gmail and google drive required!", Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getTopics().get(model.getDatesList()[position])));
                    context.startActivity(intent);
                }
            }
        });
    }

    public List<Lecture> getLecturesList() {
        return lecturesList;
    }

    @Override
    public int getItemCount() {
        return lecturesList.size();
        }

}
