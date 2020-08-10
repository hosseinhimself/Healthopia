package ir.hosseinmh.healthopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText name , family, username, pass, cpass;
    boolean namestatus = true;
    int gender = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.rname);
        family = (EditText) findViewById(R.id.rfamily);
        username = (EditText) findViewById(R.id.rusername);
        pass = (EditText) findViewById(R.id.rpass);
        cpass = (EditText) findViewById(R.id.rconfirmpass);
        final RadioButton woman = (RadioButton) findViewById(R.id.rwomanbtn);
        final RadioButton man = (RadioButton) findViewById(R.id.rmanbtn);
        Button confirm = (Button) findViewById(R.id.reg);
        final SharedPreferences register;



        register = getSharedPreferences( "Informations" , Context.MODE_PRIVATE );
        /*name.isEmpty();*/
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_str = name.getText().toString().trim();
                String family_str = family.getText().toString().trim();
                String username_str = username.getText().toString().trim();
                String pass_str = pass.getText().toString().trim();
                String cpass_str = cpass.getText().toString().trim();

                if (woman.isChecked())
                    gender = 1;
                if(man.isChecked())
                    gender = 2;

                if (name_str.length() == 0 || name_str.equals("") || name_str == null ||cpass_str.length() == 0 || cpass_str.equals("") || cpass_str == null || family_str.length() == 0 || family_str.equals("") || family_str == null || username_str.length() == 0 || username_str.equals("") || username_str == null ||pass_str.length() == 0 || pass_str.equals("") || pass_str == null|| gender == 0){
                    namestatus = false;
                }

                if (namestatus) {
                    if (!pass_str.equals(cpass_str)){
                        Toast.makeText(signup.this ,
                                "مقدار وارده رمز ها برابر نیست",
                                Toast.LENGTH_SHORT ).show();
                    }
                    else {
                        Intent confirmpage = new Intent(signup.this,MainActivity.class);
                        SharedPreferences.Editor editor = register.edit();
                        editor.putString("name",name_str);
                        editor.putString("family",family_str);
                        editor.putString("username",username_str);
                        editor.putString("pass",pass_str);
                        editor.putInt("sex",gender);
                        editor.apply();
                        Toast.makeText(signup.this ,
                                "ثبت نام با موفقیت انجام شد",
                                Toast.LENGTH_SHORT ).show();
                        startActivity(confirmpage);
                    }
                }
                else{
                    Toast.makeText(signup.this ,
                            "مقدار ها وارد نشده",
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
        Intent gotoh = new Intent(signup.this,MainActivity.class);
        startActivity( gotoh );
    }
}