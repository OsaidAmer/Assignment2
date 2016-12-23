package com.example.pcp.as1;

/**
 * Created by Pcp on 18/12/2016.
 */
import java.util.HashMap;

public class Model {

    HashMap<String,String> topics = new HashMap<String,String>();

    public Model(){
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

    }
    public HashMap<String, String> getTopics() {
        return topics;
    }

    public void setTopics(HashMap<String, String> topics) {
        this.topics = topics;
    }


}
