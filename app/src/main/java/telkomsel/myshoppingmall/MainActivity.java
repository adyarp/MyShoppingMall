package telkomsel.myshoppingmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvCategory;
    private String[] categories = new String[]{
      "Football Club T-Shirt", "National Team T-Shirt"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Home");

        lvCategory = (ListView)findViewById(R.id.lv_category);
        lvCategory.setOnItemClickListener(this);
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, categories);
        lvCategory.setAdapter(categoryAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(MainActivity.this, "Item Clicked "+categories[position], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ProductActivity.class);
        intent.putExtra("category",categories[position]);
        //if(intent != null){
            startActivity(intent);
        //}
    }
}
