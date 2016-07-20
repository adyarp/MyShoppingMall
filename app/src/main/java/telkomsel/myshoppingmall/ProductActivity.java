package telkomsel.myshoppingmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lvItem;
    private ProductAdapter adapter;
    private ArrayList<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        String selectCategory = getIntent().getStringExtra("category");
        getSupportActionBar().setTitle(selectCategory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvItem = (ListView)findViewById(R.id.lv_item);
        listProduct = new ArrayList<>();
        adapter = new ProductAdapter(ProductActivity.this);
        adapter.setListItem(listProduct);

        Product nProduct=null;
        for (int i=1; i < SampleData.club.length; i++){
            nProduct = new Product();
            nProduct.setId(System.currentTimeMillis());
            nProduct.setName(SampleData.club[i][0]);
            nProduct.setPrice(SampleData.club[i][2]);
            nProduct.setImageUrl(SampleData.club[i][1]);

            listProduct.add(nProduct);
        }

        adapter.setListItem(listProduct);
        adapter.notifyDataSetChanged();
        lvItem.setAdapter(adapter);
        lvItem.setOnItemClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ProductActivity.this, DetailProductActivity.class);
        intent.putExtra("product", listProduct.get(position));
        startActivity(intent);
    }
}
