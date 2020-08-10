package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView name = (TextView) findViewById(R.id.name);
        TextView family = (TextView) findViewById(R.id.family);
        TextView gender = (TextView) findViewById(R.id.gender);
        TextView username = (TextView) findViewById(R.id.username);
        ImageView setting = (ImageView)findViewById(R.id.imageView7);

        ImageView back = (ImageView) findViewById(R.id.bback);

        Button returns = (Button) findViewById(R.id.returns);

        final SharedPreferences register;
        register = getSharedPreferences( "Informations" , Context.MODE_PRIVATE );

        final String getname = register.getString( "name","nn" );
        final String getfamily = register.getString( "family","aa" );
        final int getgender = register.getInt( "sex",0 );
        final String getuser = register.getString( "username","aa" );

        name.setText(getname);
        family.setText(getfamily);
        if (getgender==2)
            gender.setText("مرد");
        if (getgender==1)
            gender.setText("زن");
        username.setText(getuser);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosetting = new Intent(profile.this,profmain.class);
                startActivity( gotosetting );
            }
        });

        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotohome = new Intent(profile.this,homepage.class);
                startActivity( gotohome );
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoh = new Intent(profile.this,homepage.class);

                startActivity( gotoh );
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        Intent gotoh = new Intent(profile.this,homepage.class);
        startActivity( gotoh );
    }
}
