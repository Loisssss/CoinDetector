package project1.lois.com.coindetector;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.io.File;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PictureActivity extends Activity{

    public static final int TAKE_PHOTO = 1;
    public static final int CROP_PHOTO = 2;
    private Button takePhotoBn;
    private ImageView showImage;

    private File mPhotoFile;
    private String mPhotoPath;
    public final static int CAMERA_RESULT = 1;

    String picPath;
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Button buttonVideo = (Button) findViewById(R.id.buttonBack);
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictureActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        takePhotoBn = (Button) findViewById(R.id.button2);
        takePhotoBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCamra(v);
            }
        });

    }
    public void startCamra(View view){
        try {
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_RESULT);

        }catch (Exception e){

        }
    }

}
