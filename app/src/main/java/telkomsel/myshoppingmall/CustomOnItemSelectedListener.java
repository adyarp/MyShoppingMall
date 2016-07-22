package telkomsel.myshoppingmall;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by Multimatics on 22/07/2016.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private OnItemSelectedCallBack onItemSelectedCallBack;
    private int position;
    private TextView tvSubTotal;

    public CustomOnItemSelectedListener(int position, TextView tvSubTotal,
                                        OnItemSelectedCallBack onItemSelectedCallBack) {
        this.onItemSelectedCallBack = onItemSelectedCallBack;
        this.position = position;
        this.tvSubTotal = tvSubTotal;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        onItemSelectedCallBack.onItemSelected(view, tvSubTotal, position, i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public interface OnItemSelectedCallBack{
        void onItemSelected(View view, TextView textView, int itemRowPosition, int itemArrayPosition);
    }
}
