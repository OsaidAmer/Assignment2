package com.example.pcp.as1;

/**
 * Created by Pcp on 18/12/2016.
 */
import java.util.HashMap;

public class Model {
    private String[] datesList = new String[67];
    HashMap<String,String> topics = new HashMap<String,String>();
    public String[] getDatesList() {
        return datesList;
    }
    public void setDatesList(String[] datesList) {
        this.datesList = datesList;
    }

    public Model(){
        processLectures();
        // java
        topics.put("31/10","https://www.tutorialspoint.com/java/java_basic_syntax.htm");
        topics.put("2/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOU3dYOFdDTm1vdWM");
        topics.put("4/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOM2ZmRWlDazFzOE0");
        topics.put("7/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOVk1RdjJQOEFQcDg");
        topics.put("9/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOVDNtNlVzUllaREU");
        topics.put("11/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOQ0plQk9KQzBIOXM");
        topics.put("14/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOaGgtbEVoUldFS3c");
        topics.put("16/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOeEVlRWZ5c1l6RE0");
        topics.put("18/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOeUVRZnkzNklZcnc");
        topics.put("21/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFObFhSUWhULV9md2c");
        topics.put("23/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOWUVNQThQQUxuTUU");
        topics.put("25/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFObU0wenk3WEpiY3c");
        topics.put("28/11","https://drive.google.com/drive/folders/0B_k1kr1VgVFOZ2VoSUd5YnJjMlk");
        //WEB
        topics.put("30/11","http://www.w3schools.com/");
        topics.put("7/12","http://www.w3schools.com/jquery/default.asp");
        topics.put("14/12","http://www.w3schools.com/html/html5_canvas.asp");
        //Android
        topics.put("2/12","https://developer.android.com/studio/index.html?gclid=CIyG4Obq_tACFSEM0wodm1AMlw"); // lecture1
        topics.put("5/12","https://developer.android.com/reference/android/text/Layout.html"); // lecture2
        topics.put("9/12","https://i.stack.imgur.com/Jk8de.png"); // lecture3
        topics.put("12/12","https://developer.android.com/reference/android/widget/ScrollView.html"); // lecture4
        topics.put("16/12","https://moringaschool.files.wordpress.com/2015/05/capture1.png"); // lecture5
        topics.put("19/12","http://www.vogella.com/tutorials/Git/article.html#what-is-git"); // lecture 6
        topics.put("2/1","http://www.vogella.com/tutorials/AndroidFragments/article.html"); // lecture 7
        topics.put("6/1","http://www.vogella.com/tutorials/AndroidBackgroundProcessing/article.html#background-processing-in-android"); // lecture 8
        //Project
        topics.put("4/1","https://s30.postimg.org/hkm108g29/project_structure.png");
        //SQL
        topics.put("21/12","https://dev.mysql.com/downloads/workbench/"); // lecture 1
        topics.put("23/12","http://www.w3schools.com/sql/sql_syntax.asp");  // lecture 2
        topics.put("26/12","http://www.w3schools.com/sql/sql_join.asp");  // lecture 3
        topics.put("28/12","http://www.w3schools.com/sql/sql_insert.asp");  // lecture 4

    }
    public HashMap<String, String> getTopics() {
        return topics;
    }
    public void setTopics(HashMap<String, String> topics) {
        this.topics = topics;
    }

    //create an array of course's loz
    public  void processLectures(){
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
}
