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
import android.widget.TextView;
import android.widget.Toast;

public class changepass extends AppCompatActivity {
    EditText currentpass, newpass, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepass);
        Button btn = (Button) findViewById(R.id.acpt);
        currentpass = (EditText) findViewById(R.id.currentpass);
        newpass = (EditText) findViewById(R.id.newpass);
        confirm = (EditText) findViewById(R.id.confirm);
        ImageView back = (ImageView) findViewById(R.id.backk);

        final SharedPreferences register;
        register = getSharedPreferences( "Informations" , Context.MODE_PRIVATE );
        final String getpass = register.getString( "pass","" );

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoh = new Intent(changepass.this,profmain.class);
                startActivity( gotoh );
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = currentpass.getText().toString().trim();
                String n = newpass.getText().toString().trim();
                String cn = confirm.getText().toString().trim();
                if ((!(c.equals("")))&&(!(n.equals("")))&&(!(cn.equals("")))){

                    if (c.equals(getpass)){
                        if ( n.equals(cn)){
                            Intent confirmpage = new Intent(changepass.this,profmain.class);
                            SharedPreferences.Editor editor = register.edit();
                            editor.putString("pass",n);
                            editor.apply();
                            Toast.makeText(changepass.this ,
                                    "رمز با موفقیت تغییر یافت",
                                    Toast.LENGTH_SHORT ).show();
                            startActivity(confirmpage);
                        }
                        else{
                            Toast.makeText(changepass.this ,
                                    "رمز های جدید مطابقت ندارند",
                                    Toast.LENGTH_SHORT ).show();
                        }
                    }
                    else{
                        Toast.makeText(changepass.this ,
                                "رمز فعلی درست وارد نشده",
                                Toast.LENGTH_SHORT ).show();
                    }
                }
                else{
                    Toast.makeText(changepass.this ,
                            "لطفا مقادیر را کامل وارد کنید",
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
        Intent gotoh = new Intent(changepass.this,profmain.class);
        startActivity( gotoh );
    }


}