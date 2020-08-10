package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username , pass;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.getuser);
        pass = (EditText) findViewById(R.id.getpass);
        Button go = (Button) findViewById(R.id.got);
        final SharedPreferences register;
        signup = (TextView) findViewById(R.id.signup1);

        register = getSharedPreferences( "Informations" , Context.MODE_PRIVATE );

        final String getname = register.getString( "username","" );
        final String getpass = register.getString( "pass","" );



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosignup = new Intent(MainActivity.this,signup.class);
                startActivity(gotosignup);
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_str = username.getText().toString().trim();
                String pass_str = pass.getText().toString().trim();

                if (username_str.equals(getname) && pass_str.equals(getpass)){
                    Intent confirmpage = new Intent(MainActivity.this,homepage.class);
                    Toast.makeText(MainActivity.this ,
                            "ورود با موفقیت انجام شد",
                            Toast.LENGTH_SHORT ).show();
                    startActivity(confirmpage);

                }
                else {

                    Toast.makeText(MainActivity.this ,
                            "اطلاعات به درستی وارد نشده",
                            Toast.LENGTH_SHORT ).show();

                }
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("آیا از خروج اطمینان دارید؟")
                .setCancelable(false)
                .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent gotologin = new Intent(MainActivity.this,MainActivity.class);
                        startActivity( gotologin );
                    }
                })
                .setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}