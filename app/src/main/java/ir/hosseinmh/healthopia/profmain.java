package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class profmain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profmain);



        final EditText name = (EditText) findViewById(R.id.aname);
        final EditText family = (EditText) findViewById(R.id.afamily);

        final RadioButton woman = (RadioButton) findViewById(R.id.awomanbtn);
        final RadioButton man = (RadioButton) findViewById(R.id.amanbtn);

        ImageView back = (ImageView) findViewById(R.id.back);

        Button reg = (Button) findViewById(R.id.regg);
        Button chngpass = (Button) findViewById(R.id.chngpass);

        final SharedPreferences register;
        register = getSharedPreferences( "Informations" , Context.MODE_PRIVATE );

        final String getname = register.getString( "name","nn" );
        final String getfamily = register.getString( "family","aa" );
        final int getgender = register.getInt( "sex",0 );


        name.setText(getname);
        family.setText(getfamily);
        if (getgender==2)
            man.setChecked(true);
        if (getgender==1)
            woman.setChecked(true);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gender = 0;
                Intent confirmpage = new Intent(profmain.this,profile.class);
                SharedPreferences.Editor editor = register.edit();
                String name_str = name.getText().toString().trim();
                String family_str = family.getText().toString().trim();

                if (name_str.length() == 0 || name_str.equals("") || name_str == null ||family_str.length() == 0 || family_str.equals("") || family_str == null){
                    Toast.makeText(profmain.this ,
                            "مقدار ها وارد نشده",
                            Toast.LENGTH_SHORT ).show();
                }
                else{
                    editor.putString("name", name_str);
                    editor.putString("family", family_str);
                    if (woman.isChecked())
                        gender = 1;
                    if(man.isChecked())
                        gender = 2;
                    editor.putInt("sex",gender);
                    editor.apply();
                    startActivity(confirmpage);
                }


            }
        });

        chngpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmpage = new Intent(profmain.this,changepass.class);
                startActivity(confirmpage);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gender = 0;
                Intent confirmpage = new Intent(profmain.this,profile.class);
                SharedPreferences.Editor editor = register.edit();
                String name_str = name.getText().toString().trim();
                String family_str = family.getText().toString().trim();

                if (name_str.length() == 0 || name_str.equals("") || name_str == null ||family_str.length() == 0 || family_str.equals("") || family_str == null){
                    Toast.makeText(profmain.this ,
                            "مقدار ها وارد نشده",
                            Toast.LENGTH_SHORT ).show();
                }
                else{
                    editor.putString("name", name_str);
                    editor.putString("family", family_str);
                    if (woman.isChecked())
                        gender = 1;
                    if(man.isChecked())
                        gender = 2;
                    editor.putInt("sex",gender);
                    editor.apply();
                    startActivity(confirmpage);
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
        Intent gotoh = new Intent(profmain.this,profile.class);
        startActivity( gotoh );
    }
}