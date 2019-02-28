package com.example.bitp3453labs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadedActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaded);

        //get variabel from previous activity
        iv = (ImageView)findViewById(R.id.imgVwProfile);
        Intent intent = getIntent();
        String strMsg = intent.getStringExtra("varStr1");
        tv1 = (TextView)findViewById(R.id.txtVwHello);
        tv1.setText("Welcome to new activity \nwahai " + strMsg);

    }

    public void fnTakePic(View vw)
    {
        Runnable run = new Runnable() {

            @Override
            public void run(){
                Intent intent = new Intent (android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run(){
                        tv1.setText(tv1.getText().toString() + " .. This is your picture");
                    }
                });
            }
        };

        Thread thr = new Thread (run);
        thr.start();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);
    }
}
