package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class homepage extends AppCompatActivity {
    public class Array {
        public void main(String[] args) {

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        Button mental = (Button) findViewById(R.id.mental);
        Button body = (Button) findViewById(R.id.body);
        Button profile = (Button) findViewById(R.id.profile);
        Button aboutus = (Button) findViewById(R.id.aboutus);
        Button exit = (Button) findViewById(R.id.exit);
        Button todo = (Button) findViewById(R.id.todo);

        TextView quote = (TextView) findViewById(R.id.quote);
        TextView welcome = (TextView)findViewById(R.id.welcomename);

        final SharedPreferences register;
        register = getSharedPreferences( "Informations" , Context.MODE_PRIVATE );
        final String getname = register.getString( "name","nn" );
        String wlc = "خوش آمدی، " + getname;
        welcome.setText(wlc);

        String[] q = new String[10];
        q[0] = "با این سه «الف» زندگی کنید: انرژی، اشتیاق و احساس یگانگی";
        q[1] = "هنگام بیداری، رویا\u200Cپردازی کنید.";
        q[2] = "سعی کنید هر روز بر روی لب حداقل سه نفر لبخند بیاورید.";
        q[3] = "لزومی ندارد که در هر بحثی برنده شوید، اختلاف نظر\u200Cها را بپذیرید.";
        q[4] = "هر وضعیتی، چه خوب و چه بد، تغییر خواهد کرد.";
        q[5] = "بهترین اتفاق برای شما هنوز روی نداده است.";
        q[6] = "گاهی اوقات موفقیت یعنی این که فقط اشتباهات دیگران را تکرار نکنیم";
        q[7] = "انجامش نده ...\n" +
                "اگه میبینی این کار دنیا رو بهتر نمیکنه...";
        q[8] = "پرندگانی که در قفس به دنیا آمده اند پرواز را بیماری می پندارند!";
        q[9] = "به خاطر سختی کارها نیست که ما جرات نمی کنیم، چون ما جرات نمی کنیم کارها سخت می شوند...";

        int min = 0;
        int max = 9;

        Random r = new Random();
        int i1 = r.nextInt(max - min + 1) + min;
        quote.setText(q[i1]);


        mental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotologin = new Intent(homepage.this,mental.class);
                startActivity( gotologin );
            }
        });

        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotologin = new Intent(homepage.this,physical.class);
                startActivity( gotologin );
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotologin = new Intent(homepage.this,profile.class);
                startActivity( gotologin );
            }
        });

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotologin = new Intent(homepage.this,dailytask.class);
                startActivity( gotologin );
            }
        });


        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(homepage.this);
                builder.setMessage("اپلیکیشن خودمراقبتی (Healthopia)\nحسین محسنی - 39713161061")
                        .setCancelable(false)
                        .setNeutralButton("بازگشت", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("اینستاگرام", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Uri uri = Uri.parse("http://instagram.com/_u/hosseinhimself");
                                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                                likeIng.setPackage("com.instagram.android");

                                try {
                                    startActivity(likeIng);
                                } catch (ActivityNotFoundException e) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://instagram.com/hosseinhimself")));
                                }
                            }
                        })
                        .setNegativeButton("وب سایت", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText( homepage.this, "وبسایت" , Toast.LENGTH_SHORT ).show();
                                Uri uriUrl = Uri.parse("https://hosseinmh1.github.io/");
                                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(launchBrowser);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(homepage.this);
                builder.setMessage("آیا از خروج اطمینان دارید؟")
                        .setCancelable(false)
                        .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                /*Intent gotologin = new Intent(homepage.this,MainActivity.class);
                                startActivity( gotologin );*/
                                Intent exit = new Intent(Intent.ACTION_MAIN);
                                exit.addCategory(Intent.CATEGORY_HOME);
                                exit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(exit);
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
        //Display alert message when back button has been pressed
        AlertDialog.Builder builder = new AlertDialog.Builder(homepage.this);
        builder.setMessage("آیا از خروج اطمینان دارید؟")
                .setCancelable(false)
                .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent exit = new Intent(Intent.ACTION_MAIN);
                        exit.addCategory(Intent.CATEGORY_HOME);
                        exit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(exit);
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
