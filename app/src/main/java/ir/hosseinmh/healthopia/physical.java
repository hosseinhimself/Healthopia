package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class physical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical);

        Button plus = (Button) findViewById(R.id.add);
        Button minus = (Button) findViewById(R.id.menha);

        Button bmi = (Button) findViewById(R.id.bmi);

        Button sport = (Button) findViewById(R.id.sport);
        Button food = (Button) findViewById(R.id.food);

        final EditText qad = (EditText) findViewById(R.id.qad);
        final EditText vazn = (EditText) findViewById(R.id.vazn);

        final TextView water = (TextView)findViewById(R.id.wnum);
        final TextView warning = (TextView)findViewById(R.id.wwarning);

        final SharedPreferences register = getSharedPreferences("Informations", Context.MODE_PRIVATE);
        final String getqad = register.getString( "qad","" );
        final String getvazn = register.getString( "vazn","" );
        final String ww = register.getString( "water","0" );
        ImageView backs = (ImageView) findViewById(R.id.backph);


        qad.setText(getqad);
        vazn.setText(getvazn);
        water.setText(ww);
        int ii = Integer.parseInt(ww);
        if (ii <= 3)
            warning.setText("مقدار آب مصرفی کم است. بیشتر بنوشید");
        if (ii > 3 && ii <6)
            warning.setText("مقدار آب مصرفی نرمال است.");
        if (ii > 6)
            warning.setText("مقدار آب مصرفی خوب است");

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://www.aparat.com/v/XwEJH/%D8%A8%D8%B1%D9%86%D8%A7%D9%85%D9%87_%D9%88%D8%B1%D8%B2%D8%B4%D9%8A_%D9%83%D8%A7%D9%85%D9%84_%D8%A8%D9%87_%D9%87%D9%85%D8%B1%D8%A7%D9%87_%D8%A8%D9%87%D8%AA%D8%B1%D9%8A%D9%86_%D9%85%D8%B1%D8%A8%D9%8A_%D9%81%D9%8A%D8%AA%D9%86%D8%B3");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoh = new Intent(physical.this,food.class);
                startActivity( gotoh );
            }
        });


        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent gotoh = new Intent(physical.this,homepage.class);



                SharedPreferences.Editor editor = register.edit();
                editor.putString("qad",qad.getText().toString().trim());
                editor.putString("vazn",vazn.getText().toString().trim());
                editor.putString("water",water.getText().toString().trim());
                editor.apply();

                startActivity( gotoh );
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String sp = (String) water.getText();
                int inum = Integer.parseInt(sp);
                inum = inum+1;
                water.setText(Integer.toString(inum));
                if (inum <= 3)
                    warning.setText("مقدار آب مصرفی کم است. بیشتر بنوشید");
                if (inum > 3 && inum <6)
                    warning.setText("مقدار آب مصرفی نرمال است.");
                if (inum > 6)
                    warning.setText("مقدار آب مصرفی خوب است");
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String sp = (String) water.getText();
                int inum = Integer.parseInt(sp);
                if(inum > 0){
                    inum = inum - 1;
                    water.setText(Integer.toString(inum));
                    if (inum <= 3)
                        warning.setText("مقدار آب مصرفی کم است. بیشتر بنوشید");
                    if (inum > 3 && inum <6)
                        warning.setText("مقدار آب مصرفی نرمال است.");
                    if (inum > 6)
                        warning.setText("مقدار آب مصرفی خوب است");
                }
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qq = qad.getText().toString().trim();
                String vv = vazn.getText().toString().trim();
                
                if (qq.length() == 0 || qq.equals("") || qq == null ||vv.length() == 0 || vv.equals("") || vv == null ){
                    Toast.makeText(physical.this ,
                            "جاهای خالی را پر کنید!",
                            Toast.LENGTH_SHORT ).show();
                }
                else{
                    float q = Float.parseFloat(qq);
                    float v = Float.parseFloat(vv);
                    q = q/100;
                    float bmi = v/(q*q);
                    String msg = "";

                    if (bmi < 18.5)
                        msg = "کمبود وزن";
                    if (bmi >= 18.5 && bmi <= 24.9)
                        msg="طبیعی";
                    if (bmi >= 25 && bmi < 30)
                        msg="اضافه وزن";
                    if (bmi >= 30)
                        msg = "چاقی";


                    String txt = "BMI= " + bmi +"\n" + msg;

                    AlertDialog.Builder builder = new AlertDialog.Builder(physical.this);
                    builder.setMessage(txt)
                            .setCancelable(false)
                            .setNeutralButton("بازگشت", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }


            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        Intent gotoh = new Intent(physical.this,homepage.class);
        startActivity( gotoh );
    }

}