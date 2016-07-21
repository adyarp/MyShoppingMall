package telkomsel.myshoppingmall.api.request;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import telkomsel.myshoppingmall.Product;
import telkomsel.myshoppingmall.api.BaseApi;

/**
 * Created by Multimatics on 21/07/2016.
 */
public class GetAllProductsRequest extends BaseApi {
    private  OnGetAllProductsRequestListener onGetAllProductsRequestListener;
    private AsyncHttpClient client;

    public GetAllProductsRequest(){
        client = getHttpClient();
    }

    public OnGetAllProductsRequestListener getOnGetAllProductsRequestListener() {
        return onGetAllProductsRequestListener;
    }

    public void setOnGetAllProductsRequestListener(OnGetAllProductsRequestListener onGetAllProductsRequestListener) {
        this.onGetAllProductsRequestListener = onGetAllProductsRequestListener;
    }

    @Override
    public void callApi() {
        super.callApi();
        client.get(GET_ALL_PRODUCTS, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                ArrayList<Product> list = GetAllProducts(response);
                if (list != null){
                    if (list.size() > 0){
                        getOnGetAllProductsRequestListener().onGetAllRequestSuccess(list);
                    }
                    else {
                        getOnGetAllProductsRequestListener().onGetAllRequestFailure("No data found");
                    }
                }
                else{
                    getOnGetAllProductsRequestListener().onGetAllRequestFailure("No data found");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                getOnGetAllProductsRequestListener().onGetAllRequestFailure("Could not connect to server");
            }
        });
    }

    @Override
    public void cancelRequest() {
        super.cancelRequest();
        if (client != null){
            client.cancelAllRequests(true);
        }
    }

    private ArrayList<Product> GetAllProducts(String response){
        ArrayList<Product> list = null;
        try{
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("200")){
                JSONArray productItems = jsonObject.getJSONArray("products");
                if (productItems.length() > 0){
                    list = new ArrayList<>();
                    Product mProduct = null;
                    for (int i = 0; i < productItems.length(); i++){
                        JSONObject item = productItems.getJSONObject(i);
                        mProduct = new Product();
                        mProduct.setId(Long.parseLong(item.getString("product_id")));
                        mProduct.setImageUrl(item.getString("img_url"));
                        mProduct.setName(item.getString("name"));
                        mProduct.setPrice(item.getString("price"));

                        list.add(mProduct);
                    }
                }
                else {
                    return null;
                }
            }
            else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
        return list;
    }

    public interface OnGetAllProductsRequestListener{
        void onGetAllRequestSuccess(ArrayList<Product> listProduct);
        void onGetAllRequestFailure(String errorMessage);
    }
}
