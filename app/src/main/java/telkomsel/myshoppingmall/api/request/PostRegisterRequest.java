package telkomsel.myshoppingmall.api.request;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import telkomsel.myshoppingmall.api.BaseApi;
import telkomsel.myshoppingmall.api.response.BaseResponse;

/**
 * Created by Multimatics on 21/07/2016.
 */
public class PostRegisterRequest extends BaseApi {
    private OnPostRegisterRequestListener onPostRegisterRequestListener;
    private RequestParams postRequestParams;
    private AsyncHttpClient client;

    public PostRegisterRequest(){
        client = getHttpClient();
    }

    public OnPostRegisterRequestListener getOnPostRegisterRequestListener() {
        return onPostRegisterRequestListener;
    }

    public void setOnPostRegisterRequestListener(OnPostRegisterRequestListener mOnPostRegisterRequestListener) {
        this.onPostRegisterRequestListener = mOnPostRegisterRequestListener;
    }

    public RequestParams getPostRequestParams() {
        return postRequestParams;
    }

    public void setPostRequestParams(RequestParams postRequestParams) {
        this.postRequestParams = postRequestParams;
    }

    @Override
    public void callApi() {
        super.callApi();
        client.post(POST_REGISTER, getPostRequestParams(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                BaseResponse mBaseResponse = getBaseResponse(response);
                if (mBaseResponse != null){
                    if (mBaseResponse.getStatus().equals("200")){
                        getOnPostRegisterRequestListener().onPostRegisterSuccess(mBaseResponse);
                    }
                    else {
                        getOnPostRegisterRequestListener().onPostRegisterFailure(mBaseResponse.getMessage());
                    }
                }
                else {
                    getOnPostRegisterRequestListener().onPostRegisterFailure("Invalid Response");
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                getOnPostRegisterRequestListener().onPostRegisterFailure("Could not connect to server");
            }
        });
    }

    private BaseResponse getBaseResponse(String response){
        BaseResponse baseResponse = null;
        try{
            JSONObject jsonObject = new JSONObject(response);
            baseResponse = new BaseResponse();
            baseResponse.setStatus(jsonObject.getString("status"));
            baseResponse.setMessage(jsonObject.getString("message"));

        }catch (Exception e){
            return null;
        }
        return baseResponse;
    }

    @Override
    public void cancelRequest() {
        super.cancelRequest();
        if (client != null){
            client.cancelAllRequests(true);
        }
    }

    public interface OnPostRegisterRequestListener{
        void onPostRegisterSuccess(BaseResponse response);
        void onPostRegisterFailure(String errorMessage);
    }
}
