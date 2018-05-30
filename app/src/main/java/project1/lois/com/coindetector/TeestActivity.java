package project1.lois.com.coindetector;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class TeestActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
    }

    private static final String TAG = "testActivity";
    private static final String MODEL_FILE = "file:///android_asset/model.pb"; //模型存放路径
    TextView txt;
    ImageView imageView;
    Bitmap bitmap;
    PredictionTF preTF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        txt=(TextView)findViewById(R.id.txt_id);
        imageView =(ImageView)findViewById(R.id.imageView1);
//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cent);
//        Bitmap  bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.test);
//        bitmap=BitmapFactory.decodeStream(getClass().getResourceAsStream("res/drawable/cent.jpg"));
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cent);
        imageView.setImageBitmap(bitmap);
        preTF =new PredictionTF(getAssets(),MODEL_FILE);//输入模型存放路径，并加载TensoFlow模型
    }

    public void click01(View v){
        String res="the prediction result is";
        int[] result= preTF.getPredict(bitmap);
        for (int i=0;i<result.length;i++){
            Log.i(TAG, res+result[i] );
            res=res+String.valueOf(result[i])+" ";
        }
        txt.setText(res);
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
}
