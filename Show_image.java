package abhishek.project4;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Show_image extends AppCompatActivity {
GridView im;
    RelativeLayout ly;
    ProgressBar pp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        im=(GridView)findViewById(R.id.list_recycle);
        ly=(RelativeLayout)findViewById(R.id.ll);
        pp=(ProgressBar)findViewById(R.id.pb2);
        Bundle iti=getIntent().getBundleExtra("bundle1");
        String string=iti.getString("data");
        String tit=iti.getString("title");
        setTitle(tit);


        if (isconnected(Show_image.this)) {

            pp.setVisibility(View.VISIBLE);
            sendrequest(string);

        }
        else if (!isconnected(Show_image.this)){
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }

        im.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });






    }

    public void sendrequest(String sr){

        StringRequest st=new StringRequest(sr, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                          showjson(response);
                pp.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue eq= Volley.newRequestQueue(getApplicationContext());
        eq.add(st);

    }


    public void showjson(String js) {
        final jason_parser jp=new jason_parser(js);
        jp.parsejson();
        custom_wragon cw=new custom_wragon(this,jp.brand,jp.mrp,jp.description,jp.image);
        im.setAdapter(cw);
        im.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b2=new Bundle();
                b2.putString("image_get",jp.image[position]);
                 Intent it=new Intent(Show_image.this,Image.class);
                it.putExtra("bundle_image",b2);
                startActivity(it);
            }
        });

    }

    public boolean isconnected(Context c)
    {
        ConnectivityManager cm= (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nm=cm.getActiveNetworkInfo();

        if (nm !=null && nm.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (mobile != null && mobile.isConnectedOrConnecting() || wifi != null && wifi.isConnectedOrConnecting()) {
                return true;

            } else return false;
        }else return false;

    }
}
