package abhishek.project4;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Wragon extends AppCompatActivity {
    GridView l;
RelativeLayout ly;
    ProgressBar pp;
    jason_parser jp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wragon);
        l = (GridView) findViewById(R.id.list_wragon);
        setTitle("50-80% OFF");
        ly=(RelativeLayout)findViewById(R.id.ll);
        pp=(ProgressBar)findViewById(R.id.pb);

    if (isconnected(Wragon.this)) {

        pp.setVisibility(View.VISIBLE);
        sendrequest();

    }
    else if (!isconnected(Wragon.this)){
        Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
    }

    l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

          }
    });






    }


    public void sendrequest() {
        StringRequest sr = new StringRequest("https://wwwajin.000webhostapp.com/project4_1.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showjson(response);
                pp.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar sc=Snackbar.make(ly,"No Internet",Snackbar.LENGTH_SHORT);
                sc.show();
            }
        });
        RequestQueue rq= Volley.newRequestQueue(getApplicationContext());
        rq.add(sr);

    }

    public void showjson(String js) {
        jp=new jason_parser(js);
        jp.parsejson();
        custom_wragon cw=new custom_wragon(this,jp.brand,jp.mrp,jp.description,jp.image);
         l.setAdapter(cw);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b2=new Bundle();
                b2.putString("image_get",jp.image[position]);
                Intent it=new Intent(Wragon.this,Image.class);
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
