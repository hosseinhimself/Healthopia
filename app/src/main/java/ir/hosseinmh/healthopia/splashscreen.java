package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class splashscreen extends AppCompatActivity {
    /*SharedPreferences checker = PreferenceManager.getDefaultSharedPreferences( this );*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*
                Boolean secure =  checker.getBoolean( "privacy" , false);

                if (secure==true){
                    Intent gotologin = new Intent(splashscreen.this,homepage.class);
                    startActivity( gotologin );
                }
                else{
                    Intent nextPage = new Intent(splashscreen.this,MainActivity.class);
                    startActivity(nextPage);
                }
                */
                Intent nextPage = new Intent(splashscreen.this,MainActivity.class);
                startActivity(nextPage);
                finish();


            }
        } , 3000);
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        Intent gotoh = new Intent(splashscreen.this,splashscreen.class);
        startActivity( gotoh );
    }
}