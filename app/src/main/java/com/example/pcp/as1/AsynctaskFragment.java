package com.example.pcp.as1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.squareup.picasso.Picasso;
import java.io.InputStream;

public class AsynctaskFragment extends Fragment {
    private ImageView asyncdownloadedImg,picassodownloadedImg;
    private Button asynctaskImageDownloaderBtn;
    private Button picassoImageDownloaderBtn;
    private ProgressDialog simpleWaitDialog;
    private String imgUrl = "http://www.mememaker.net/static/images/memes/4203449.jpg";
    private String imgUrl2 = "http://tacticstime.com/wp-content/uploads/2014/07/artworks-000048548880-16yr8e-original.jpg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.asynctask_picasso_fragment,container,false);

        asyncdownloadedImg = (ImageView) view.findViewById(R.id.asynctask_image);
        picassodownloadedImg = (ImageView) view.findViewById(R.id.picasso_image);
        asynctaskImageDownloaderBtn = (Button) view.findViewById(R.id.asyncbutton);
        picassoImageDownloaderBtn = (Button) view.findViewById(R.id.picassobutton);

        asynctaskImageDownloaderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsynctaskImageDownloader().execute(imgUrl);
            }
        });

        picassoImageDownloaderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PicassoImageDownloader(imgUrl2);
            }
        });
        return view;
    }


    public  class PicassoImageDownloader{
        public PicassoImageDownloader(String url){
            Picasso.with(getContext())
                    .load(url)
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.progress_animation )
                    .into(picassodownloadedImg);
            Toast.makeText(getContext(),"Loading...",Toast.LENGTH_SHORT).show();
        }
    }

    //Asynctask class
    public class AsynctaskImageDownloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            return downloadBitmap(params[0]);
        }

        @Override
        protected void onPreExecute() {
        Log.i("Async-Example", "onPreExecute Called");
        simpleWaitDialog = ProgressDialog.show(getActivity(),
                "Wait", "Downloading Image");

        }

        @Override
        protected void onPostExecute(Bitmap result) {
            Log.i("Async-Example", "onPostExecute Called");
            asyncdownloadedImg.setImageBitmap(result);
            simpleWaitDialog.dismiss();

        }

        private Bitmap downloadBitmap(String url) {
            // initilize the default HTTP client object
            final DefaultHttpClient client = new DefaultHttpClient();
            //forming a HttoGet request
            final HttpGet getRequest = new HttpGet(url);
            try {
                HttpResponse response = client.execute(getRequest);
                //check 200 OK for success
                final int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode != HttpStatus.SC_OK) {
                    Log.w("ImageDownloader", "Error " + statusCode +
                            " while retrieving bitmap from " + url);
                    return null;

                }

                final HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream inputStream = null;
                    try {
                        // getting contents from the stream
                        inputStream = entity.getContent();

                        // decoding stream data back into image Bitmap that android understands
                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        return bitmap;
                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        entity.consumeContent();
                    }
                }
            } catch (Exception e) {
                // You Could provide a more explicit error message for IOException
                getRequest.abort();
                Log.e("ImageDownloader", "Something went wrong while" +
                        " retrieving bitmap from " + url + e.toString());
            }
            return null;
        }
    }


}
