package kr.ac.kookmin.exer3_2.exer3_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button web_bt;
    Button dial_bt;
    Button picture_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.web).setOnClickListener(clickListener);
        findViewById(R.id.dial).setOnClickListener(clickListener);
        findViewById(R.id.picture).setOnClickListener(clickListener);

    }
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.web:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                    startActivity(intent);
                    break;
                case R.id.dial:
                    Toast.makeText(getApplicationContext(),"dial",Toast.LENGTH_SHORT).show();
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:/01050942480"));
                    startActivity(intent);
                    break;
                case R.id.picture:
                    intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.fromFile(new File("/sdcard/test.jpg"));
                    intent.setDataAndType(uri, "image/jpeg");
                    startActivity(intent);
            }

        }
    };
}
