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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class mental extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental);

        Button advice = (Button) findViewById(R.id.madvice);
        Button bored = (Button) findViewById(R.id.bored);

        Button plus = (Button) findViewById(R.id.add1);
        Button minus = (Button) findViewById(R.id.minus1);
        ImageView back = (ImageView) findViewById(R.id.backm);

        final TextView sleep = (TextView)findViewById(R.id.sleepnum);
        final TextView warning = (TextView)findViewById(R.id.warning);

        final SharedPreferences register = getSharedPreferences("Informations", Context.MODE_PRIVATE);
        final String ss = register.getString( "sleep","0" );

        sleep.setText(ss);
        int ii = Integer.parseInt(ss);
        if (ii <= 5)
            warning.setText("خواب شما از حد نرمال کمتر بوده");
        if (ii> 5 && ii <8)
            warning.setText("خواب شما نرمال بوده");
        if (ii > 8)
            warning.setText("خواب شما کافی بوده");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoh = new Intent(mental.this,homepage.class);

                SharedPreferences.Editor editor = register.edit();

                editor.putString("sleep",sleep.getText().toString().trim());

                editor.apply();

                startActivity( gotoh );
            }
        });



        bored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 0;
                int max = 19;
                Random ra = new Random();
                int i2 = ra.nextInt(max - min + 1) + min;

                String[] b = new String[20];
                b[0] = "جدول حل کنید";
                b[1] = "یکی از کشوها یا کمدها رو مرتب کنید";
                b[2] = "بستنی یخی خانگی درست کنید";
                b[3] = "از ایمیل ها و صفحاتی که در شبکه های اجتماعی دنبال نمیکنید خارج بشید";
                b[4] = "یک پادکست یا کتاب صوتی گوش کنید";
                b[5] = "۷ دقیقه ورزش انجام بدید. مثلا دراز نشست، شنا رفتن یا طناب زدن";
                b[6] = "یک کاردستی بسازید";
                b[7] = " برای ۵ دقیقه ویدئو خنده دار تماشا کنید";
                b[8] = "به یک دوست قدیمی زنگ بزنید";
                b[9] = "یه پلی لیست از موسیقی های بی کلام بسازید";
                b[10] = "فایل های روی گوشی یا کامپیوتر رو مرتب کنید";
                b[11] = "برنامه های روی گوشی یا کامپیوتر رو آپدیت کنید";
                b[12] = "چند حرکت کششی یوگا انجام بدید، اگر بلد نیستید از اینترنت کمک بگیرید";
                b[13] = "برای ۵ نفر ۵ پیام تشکر بنویسید و به دستشون برسونید";
                b[14] = "به گلدون ها رسیدگی کنید";
                b[15] = "یک غذای خوشمزه و جدید بپزید";
                b[16] = "به کتابخونه برید";
                b[17] = "برای ۳ صفحه اینستاگرام، سایت یا اپلیکیشن مورد علاقه تون کامنت بذارید.";
                b[18] = "چند نقل قول از افراد بزرگ بخونید.";
                b[19] = "برای یکی از اقوام یا دوستان کارت پستال پست کنید.";

                AlertDialog.Builder builder = new AlertDialog.Builder(mental.this);
                builder.setMessage(b[i2])
                        .setCancelable(false)
                        .setNeutralButton("بازگشت", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });



        advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int min = 0;
                int max = 9;
                Random r = new Random();
                int i1 = r.nextInt(max - min + 1) + min;

                String[] q = new String[10];
                q[0] = "هر روز ۱۰ تا ۳۰ دقیقه پیاده\u200Cروی کنید و هنگام راه رفتن، لبخند بزنید. این بهترین داروی ضدافسردگی است.";
                q[1] = "هرگز از خوابتان نزنید. یک دستگاه ضبط فیلم بخرید و برنامه\u200Cهای تلویزیونی مورد علاقه\u200Cتان که شب\u200Cها دیروقت پخش می\u200Cشوند را ضبط کنید و روز بعد ببینید.";
                q[2] = "نسبت به سال قبل کتاب\u200Cهای بیشتری بخوانید و بازی\u200Cهای بیشتری انجام دهید.";
                q[3] = "هنگام بیداری، رویا\u200Cپردازی کنید.";
                q[4] = "چای سبز، مقداری زیادی آب، کلم، بادام و فندق را در رژیم غذایی روزانه\u200Cتان بگنجانید.";
                q[5] = "ریخت و پاش و آشفتگی را از خانه، ماشین و میز کارتان دور سازید.";
                q[6] = "خودتان را جدّی نگیرید، هیچکس دیگر هم این کار را نمی\u200Cکند.";
                q[7] = "هنگام بیماری، کارتان از شما مراقبت نمی\u200Cکند، دوستانتان از شما مراقبت می\u200Cکنند. تماس خود را با آن\u200Cها حفظ کنید.";
                q[8] = "هر روز زمانی را برای دعا، مدیتیشن، یوگا و یا نظایر آن بگذارید.";
                q[9] = "هر روز حداقل ۱۰ دقیقه در یک مکان کاملاً ساکت و بی\u200Cسر و صدا بنشینید.";

                AlertDialog.Builder builder = new AlertDialog.Builder(mental.this);
                builder.setMessage(q[i1])
                        .setCancelable(false)
                        .setNeutralButton("بازگشت", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });




        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sp = (String) sleep.getText();
                int inum = Integer.parseInt(sp);
                if(inum <24) {
                    inum = inum + 1;
                    sleep.setText(Integer.toString(inum));
                }
                if (inum <= 5)
                    warning.setText("خواب شما از حد نرمال کمتر بوده");
                if (inum > 5 && inum <8)
                    warning.setText("خواب شما نرمال بوده");
                if (inum > 8)
                    warning.setText("خواب شما کافی بوده");
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sp = (String) sleep.getText();
                int inum = Integer.parseInt(sp);
                if(inum > 0){
                    inum = inum - 1;
                    sleep.setText(Integer.toString(inum));
                }
                    if (inum <= 5)
                        warning.setText("خواب شما از حد نرمال کمتر بوده");
                    if (inum > 5 && inum < 8)
                        warning.setText("خواب شما نرمال بوده");
                    if (inum > 8)
                        warning.setText("خواب شما کافی بوده");

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
        Intent gotoh = new Intent(mental.this,homepage.class);
        startActivity( gotoh );
    }
}