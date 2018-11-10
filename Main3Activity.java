package abhishek.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class Main3Activity extends Activity {
ImageView im;
TextView t6,t7,t8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    im=(ImageView)findViewById(R.id.imageView9);
    t6=(TextView)findViewById(R.id.textView6);
    t7=(TextView)findViewById(R.id.textView7);
    t8=(TextView)findViewById(R.id.textView8);

final Bundle b=getIntent().getBundleExtra("bundle_image");

Picasso.with(this).load(b.getString("image_get")).resize(178,350).into(im);
String a=b.getString("brand_name");
String b2=b.getString("mrp_name");
String c=b.getString("description_name");
t6.setText("  "+"" + a);
t7.setText("  "+"\u20B9"+b2);
t8.setText(" "+c);
im.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Bundle bundle=new Bundle();
        bundle.putString("image_get",b.getString("image_get"));
        Intent it=new Intent(Main3Activity.this,Image.class);
        it.putExtra("bundle_image",bundle);
        startActivity(it);
    }
});

    }
}
