package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        TextView brkfst = (TextView) findViewById(R.id.breakfast);
        TextView lnch = (TextView) findViewById(R.id.lunch);
        TextView dnr = (TextView) findViewById(R.id.dinner);
        ImageView back = (ImageView) findViewById(R.id.backff);



        String[] brk = new String[7];
        brk[0] = "تخم مرغ با قارچ و بلغور جو دوسر";
        brk[1] = "پنکک پروتئین با مقداری کربوهیدرات ، کره بادام زمینی و رزبری";
        brk[2] = "سوسیس مرغ با تخم مرغ و سیب زمینی کبابی";
        brk[3] = " تخم مرغ، مقداری پنیر";
        brk[4] = " تخم مرغ با ذرت، فلفل دلمه ای، پنیر";
        brk[5] = "تخم مرغ و آووکادو روی نان تست";
        brk[6] = "بلوبری و توت فرنگی ( یا یکی از آنها ) را از شب قبل با ماست یونانی وانیلی و جو مخلوط کرده و میل کنید.";

        String[] luch = new String[7];
        luch[0] = "برگر گوشت، برنج سفید و کلم بروکلی";
        luch[1] = "استیک با سالاد سیب زمینی شیرین و اسفناج";
        luch[2] = "سینه بوقلمون، برنج و قارچ";
        luch[3] = "سینه مرغ، سیب زمینی پخته شده، خامه ترش و بروکلی";
        luch[4] = "فیله ماهی تیلاپیا با آبلیمو، لوبیای سیاه و لوبیا چیتی با سبزیجات فصلی";
        luch[5] = "فیله تیلاپیا، سیب زمینی و فلفل دلمه ای";
        luch[6] = "گوشت قرمز با سیر و سیب زمینی کبابی و لوبیا سبز";


        String[] dinr = new String[7];
        dinr[0] = "ماهی سالمون";
        dinr[1] = "گوشت بوقلمون با سس پاستا";
        dinr[2] = "ماهی خال مخالی یا سالمون ، برنج قهوه ای با سالاد برگ";
        dinr[3] = "مخلوطی از مرغ، تخم مرغ، برنج قهوه ای، بروکلی، نخود فرنگی و هویج";
        dinr[4] = "گوشت گاو با ذرت، برنج قهوه ای، نخود سبز و لوبیا سبز";
        dinr[5] = "گوشت کبابی با برنج، لوبیای سیاه، پنیر، فلفل دلمه ای با سالاد شیرازی";
        dinr[6] = "کوفته ترکی با سس پاستا و پنیر پارمزان";

        //finding a random number
        int min = 0;
        int max = 6;
        Random ra = new Random();
        int i = ra.nextInt(max - min + 1) + min;

        //show the foods in app
        brkfst.setText(brk[i]);
        lnch.setText(luch[i]);
        dnr.setText(dinr[i]);

        //back icon
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoh = new Intent(food.this,physical.class);
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
        Intent gotoh = new Intent(food.this,physical.class);
        startActivity( gotoh );
    }

}