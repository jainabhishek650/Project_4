package abhishek.project4;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class Mens_list extends AppCompatActivity {
    ListView l1, l2;
    int i = 0;
    ArrayAdapter<String> adapter;

    final int sports[] = {R.drawable.sport3, R.drawable.sport5, R.drawable.sport4, R.drawable.sport2};
    int formal[] = {R.drawable.formal4, R.drawable.formal3, R.drawable.formal2, R.drawable.formal1};
    int casual[] = {R.drawable.casual2, R.drawable.casual3, R.drawable.casual4, R.drawable.casual5};
    int sandal[] = {R.drawable.sandal4, R.drawable.sandal3, R.drawable.sandal2, R.drawable.sandals1};
    int flip[] = {R.drawable.flip5, R.drawable.flip4, R.drawable.flip3, R.drawable.flip2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_list);
        setTitle("Men's Footwear");
        l1 = (ListView) findViewById(R.id.list1);

        //  l2=(ListView)findViewById(R.id.searchlist);
       /* String st[]={"CASUAL SHOES","SPORTS SHOES","FORMAL SHOES","SANDALS","FLIP FLOPS"};
        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list,st);
        l2.setAdapter(adapter);
       */ l1.setAdapter(new custom_men(this));
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:

                        Toast.makeText(Mens_list.this, "Casual", Toast.LENGTH_SHORT).show();
                        Bundle b1= new Bundle();
                        b1.putIntArray("integer",casual);
                        b1.putString("title", "Casual");
                        Intent it1=new Intent(getApplicationContext(),Mens_grid.class);
                        it1.putExtra("first",b1);
                        startActivity(it1);

                        break;
                    case 1:
                        Toast.makeText(Mens_list.this, "Sports", Toast.LENGTH_SHORT).show();
                        Bundle b12= new Bundle();
                        b12.putIntArray("integer",sports);
                        b12.putString("title", "Sports");
                        Intent it12=new Intent(getApplicationContext(),Mens_grid.class);
                        it12.putExtra("first",b12);
                        startActivity(it12);

                        break;
                    case 2:
                        Toast.makeText(Mens_list.this, "Formal", Toast.LENGTH_SHORT).show();
                        Bundle b13= new Bundle();
                        b13.putIntArray("integer",formal);
                        b13.putString("title", "Formal");
                        Intent it13=new Intent(getApplicationContext(),Mens_grid.class);
                        it13.putExtra("first",b13);
                        startActivity(it13);

                        break;
                    case 3:
                        Toast.makeText(Mens_list.this, "Sandals", Toast.LENGTH_SHORT).show();
                        Bundle b14= new Bundle();
                        b14.putIntArray("integer",sandal);
                        b14.putString("title", "Sandal");
                        Intent it14=new Intent(getApplicationContext(),Mens_grid.class);
                        it14.putExtra("first",b14);
                        startActivity(it14);

                        break;
                    case 4:
                        Toast.makeText(Mens_list.this, "flip flops", Toast.LENGTH_SHORT).show();
                        Bundle b15= new Bundle();
                        b15.putIntArray("integer",flip);
                        b15.putString("title", "Flip Flop");
                        Intent it15=new Intent(getApplicationContext(),Mens_grid.class);
                        it15.putExtra("first",b15);
                        startActivity(it15);

                        break;
                }

            }
        });



    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searc,menu);
        MenuItem item=menu.findItem(R.id.searchlist);

       *//* SearchView se=(SearchView)item.getActionView();
        se.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
adapter.getFilter().filter(s);
                return false;
            }
        });

*//*

        return onCreateOptionsMenu(menu);
    }*/
}




