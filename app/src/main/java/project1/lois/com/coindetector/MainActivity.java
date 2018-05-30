package project1.lois.com.coindetector;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPic = (Button) findViewById(R.id.buttonPicture);
        buttonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentPic=new Intent(MainActivity.this,PictureActivity.class);
                startActivity(intentPic);
                finish();
            }
        });


        Button buttonVideo = (Button) findViewById(R.id.buttonVideo);
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VideoActivity.class);
                startActivity(intent);
            }
        });


        Button buttonAlbum = (Button) findViewById(R.id.buttonAlbum);
        buttonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TeestActivity.class);
                startActivity(intent);
            }
        });
    }

}

