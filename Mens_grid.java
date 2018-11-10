package abhishek.project4;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import static abhishek.project4.R.anim.zoom;

public class Mens_grid extends AppCompatActivity {
GridView g1;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_grid);

        Bundle bn1 = getIntent().getBundleExtra("first");

        final int ar[] = bn1.getIntArray("integer");
        final String str = bn1.getString("title");
        setTitle(str);
        g1 = (GridView) findViewById(R.id.grid);

        g1.setAdapter(new custom_mengrid(this, ar));

        g1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Bundle bn=new Bundle();
                bn.putIntArray("array",ar);
                bn.putString("str",str);

                Intent it = new Intent(getApplicationContext(), Main2Activity.class);


                it.putExtra("bundle", position);

                it.putExtra("bundle2",bn);
                startActivity(it);


            }
        });
    }}
