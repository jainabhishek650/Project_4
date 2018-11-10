package abhishek.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        im=(ImageView)findViewById(R.id.imageView7);
        im.setImageResource(R.drawable.myntra);
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);

                }
                catch (Exception ex) {}

                finally
                {
                    Intent it = new Intent(Splash.this, MainActivity.class);
                    startActivity(it);
                    finish();
                }
            }
        };
        t.start();




    }
}
