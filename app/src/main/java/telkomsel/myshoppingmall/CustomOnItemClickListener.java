package telkomsel.myshoppingmall;

import android.view.View;

/**
 * Created by Multimatics on 22/07/2016.
 */
public class CustomOnItemClickListener implements View.OnClickListener {
    private OnItemClickCallBack mOnItemClickCallBack;
    private int position;

    public CustomOnItemClickListener(int position, OnItemClickCallBack mOnItemClickCallBack) {
        this.position = position;
        this.mOnItemClickCallBack = mOnItemClickCallBack;
    }

    @Override
    public void onClick(View v) {
        mOnItemClickCallBack.onItemClicked(v, position);
    }

    public interface OnItemClickCallBack {
        void onItemClicked(View view, int position);
    }
}
