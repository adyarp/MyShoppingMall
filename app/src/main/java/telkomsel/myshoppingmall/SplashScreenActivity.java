package telkomsel.myshoppingmall;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    private AppPreference appPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        appPreference = new AppPreference(SplashScreenActivity.this);
        new DelayAsync().execute();

    }

    class DelayAsync extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try{
                Thread.sleep(3000);
            }catch (Exception e){}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = null;

            if (appPreference.getUsername().equals("")){
                intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            }
            else{
                intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
            }
            startActivity(intent);
            finish();
        }
    }
}
