package telkomsel.myshoppingmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailProductActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgDetail;
    private TextView tvName, tvPrice, tvDesc;
    private Button btnAddToCart;
    private Spinner spnSize;
    private ImageView imgThumbA, imgThumbB, imgThumbC, imgThumbD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        imgDetail = (ImageView) findViewById(R.id.img_detail);
        btnAddToCart = (Button)findViewById(R.id.btn_add_to_cart);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvPrice = (TextView)findViewById(R.id.tv_price);
        spnSize = (Spinner) findViewById(R.id.spn_size);
        tvDesc = (TextView)findViewById(R.id.tv_desc);

        imgThumbA = (ImageView) findViewById(R.id.img_thumb_a);
        imgThumbB = (ImageView) findViewById(R.id.img_thumb_b);
        imgThumbC = (ImageView) findViewById(R.id.img_thumb_c);
        imgThumbD = (ImageView) findViewById(R.id.img_thumb_d);

        imgThumbA.setOnClickListener(this);
        imgThumbB.setOnClickListener(this);
        imgThumbC.setOnClickListener(this);
        imgThumbD.setOnClickListener(this);

        getSupportActionBar().setTitle("Detail Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Product selectedProduct = getIntent().getParcelableExtra("product");
        tvName.setText(selectedProduct.getName());
        tvPrice.setText(selectedProduct.getPrice());
        Glide.with(DetailProductActivity.this).load(selectedProduct.getImageUrl()).into(imgDetail);
        String[] size = new String[]{
            "Pilih Ukuran", "S", "M", "L", "XL", "XXL"
        };

        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<String>(DetailProductActivity.this, android.R.layout.simple_dropdown_item_1line, android.R.id.text1, size);
        spnSize.setAdapter(sizeAdapter);


        String desc = "Sejarah Kaos Oblong\n" +
                "\n" +
                "T-shirt alias kaos oblong ini mulai dipopulerkan sewaktu dipakai oleh Marlon Brando pada tahun 1947, yaitu ketika ia memerankan tokoh Stanley Kowalsky dalam pentas teater dengan lakon “A Street Named Desire” karya Tenesse William di Broadway, AS. T-shirt berwarna abu-abu yang dikenakannya begitu pas dan lekat di tubuh Brando, serta sesuai dengan karakter tokoh yang diperankannya. dan film Rebel Without A Cause (1995) yang dibintangi James Dean. Pada waktu itu penontong langsung berdecak kagum dan terpaku. Meski demikian, ada juga penonton yang protes, yang beranggapan bahwa pemakaian kaos oblong tersebut termasuk kurang ajar dan pemberontakan. Tak pelak, muncullah polemik seputar kaos oblong.\n" +
                "\n" +
                "Polemik yang terjadi yakni, sebagian kalangan menilai pemakaian kaos oblong – undershirt – sebagai busana luar adalah tidak sopan dan tidak beretika. Namun di kalangan lainnya, terutama anak muda pasca pentas teater tahun 1947 itu, justru dilanda demam kaos oblong, bahkan menganggap benda ini sebagai lambang kebebasan anak muda. Dan, bagi anak muda itu, kaos oblong bukan semata-mada suatu mode atau tren, melainkan merupakan bagian dari keseharian mereka.\n" +
                "\n" +
                "Polemik tersebut selanjutnya justru menaikkan publisitas dan popularitas kaos oblong dalam percaturan mode. Akibatnya pula, beberapa perusahaan konveksi mulai bersemangat memproduksi benda itu, walaupun semula mereka meragukan prospek bisnis kaos oblong. Mereka mengembangkan kaos oblong dengan pelbagai bentuk dan warna serta memproduksinya secara besar-besaran. Citra kaos oblong semakin menanjak lagi manakala Marlon Brando sendiri – dengan berkaos oblong yang dipadu dengan celana jins dan jaket kulit – menjadi bintang iklan produk tersebut.\n" +
                "\n" +
                "Mungkin, dikarenakan oleh maraknya polemik dan mewabahnya demam kaos oblong di kalangan masyarakat, pada tahun 1961 sebuah organisasi yang menamakan dirinya “Underwear Institute” (Lembaga Baju Dalam) menuntut agar kaos oblong diakui sebagai baju sopan seperti halnya baju-baju lainnya. Mereka mengatakan, kaos oblong juga merupakan karya busana yang telah menjadi bagian budaya mode.\n" +
                "\n" +
                "Menjadi tren anak muda\n";
        tvDesc.setText(desc);

        Glide.with(DetailProductActivity.this).load(SampleData.thumb[0]).into(imgThumbA);
        Glide.with(DetailProductActivity.this).load(SampleData.thumb[1]).into(imgThumbB);
        Glide.with(DetailProductActivity.this).load(SampleData.thumb[2]).into(imgThumbC);
        Glide.with(DetailProductActivity.this).load(SampleData.thumb[3]).into(imgThumbD);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String imageUrl = null;
        switch (v.getId()){
            case R.id.img_thumb_a:
                imageUrl = SampleData.thumb[0];
                break;
            case R.id.img_thumb_b:
                imageUrl = SampleData.thumb[1];
                break;
            case R.id.img_thumb_c:
                imageUrl = SampleData.thumb[2];
                break;
            case R.id.img_thumb_d:
                imageUrl = SampleData.thumb[3];
                break;
            default:
                imageUrl = null;
                break;
        }

        if (imageUrl != null){
            Glide.with(DetailProductActivity.this).load(imageUrl).into(imgDetail);
        }


    }
}
