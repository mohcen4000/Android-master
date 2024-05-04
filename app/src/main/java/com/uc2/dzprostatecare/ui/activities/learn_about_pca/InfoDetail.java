package com.uc2.dzprostatecare.ui.activities.learn_about_pca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uc2.dzprostatecare.R;
import com.uc2.dzprostatecare.pojo.Article;

public class InfoDetail extends AppCompatActivity {

    TextView tag,detail,secondtitle,title;
    ImageView img;
    NestedScrollView scrollView;
    YouTubePlayerView yt;
    YouTubePlayer yv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_detail);
        Intent intent=getIntent();
     Article a=(Article) intent.getSerializableExtra("art");
    //Toast.makeText(this, a.getArticleName()+" Hello", Toast.LENGTH_SHORT).show();
        tag=findViewById(R.id.tag);
        detail=findViewById(R.id.text);
        secondtitle=findViewById(R.id.secondtitle);
        img=findViewById(R.id.picture);
        title=findViewById(R.id.title);

        yt=findViewById(R.id.vid);





        scrollView=findViewById(R.id.scrollView);

        detail.setText(a.getArticleContent());
        secondtitle.setText(a.getArticleSummary());
        img.setImageResource(a.getImageUrl());
        title.setText(a.getArticleName());



        getLifecycle().addObserver(yt);


    }



    @Override
    protected void onPause() {
        super.onPause();


        yt.enableBackgroundPlayback(false);

    }

    @Override
    protected void onStop() {
        super.onStop();
       yt.enableBackgroundPlayback(false);
    }


}