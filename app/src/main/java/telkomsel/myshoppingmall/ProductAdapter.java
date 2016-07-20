package telkomsel.myshoppingmall;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Multimatics on 19/07/2016.
 */
public class ProductAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Product> listItem;

    public ArrayList<Product> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Product> listItem) {
        this.listItem = listItem;
    }

    public ProductAdapter(Activity activity){
        this.activity=activity;
    }
    @Override
    public int getCount() {
        return getListItem().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View convertView = view;
        ViewHolder holder = null;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_product, null);
            holder = new ViewHolder();
            holder.imgItem = (ImageView)convertView.findViewById(R.id.img_item_product);
            holder.tvName = (TextView) convertView.findViewById(R.id.item_name);
            holder.tvPrice = (TextView)convertView.findViewById(R.id.item_price);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }


        Product item = getListItem().get(position);
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(item.getPrice());

        Glide.with(activity).load(item.getImageUrl()).into(holder.imgItem);

        return convertView;
    }

    static class ViewHolder{
        ImageView imgItem;
        TextView tvName, tvPrice;
    }
}
