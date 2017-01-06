package com.example.pcp.as1;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.MyViewHolder>{
    private List<Lecture> lecturesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView lecture_topic,lecture_number , lecture_date;
        public ImageView lecture_iv;
        public Button lecture_btn;

        public MyViewHolder(View view) {
            super(view);
            lecture_topic = (TextView) view.findViewById(R.id.lectTopicId);
            lecture_number = (TextView) view.findViewById(R.id.lectNumberId);
            lecture_date = (TextView) view.findViewById(R.id.lectDateId);
            lecture_iv = (ImageView) view.findViewById(R.id.profile_pic_id);

        }
    }

    public LectureAdapter(List<Lecture> lecturesList) {
        this.lecturesList = lecturesList;
    }

    //private LayoutInflater inflater;
    @Override
    public LectureAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lecture_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LectureAdapter.MyViewHolder holder, int position) {
        Lecture lecture = lecturesList.get(position);
        holder.lecture_topic.setText(lecture.getTopic());
        holder.lecture_number.setText(String.valueOf(lecture.getLectureNumber()));
        holder.lecture_date.setText(lecture.getDate());
        holder.lecture_iv.setImageResource(lecture.iconId);
    }

    @Override
    public int getItemCount() {
        return lecturesList.size();
        }

}
