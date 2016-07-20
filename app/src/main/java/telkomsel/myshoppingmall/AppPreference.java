package telkomsel.myshoppingmall;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Multimatics on 20/07/2016.
 */
public class AppPreference {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String PREFS_NAME = "MyShoppingPrefsName";
    private String KEY_USERNAME = "USERNAME";


    public AppPreference (Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUsername(String username){
        editor.putString(KEY_USERNAME, username);
        editor.commit();
    }

    public String getUsername(){
        return sharedPreferences.getString(KEY_USERNAME,"");
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }
}
