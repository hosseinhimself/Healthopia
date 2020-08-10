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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class dailytask extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailytask);

        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.addbtn);
        ImageView back = (ImageView) findViewById(R.id.backd);
        //items = FileHelper.readData(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
        items = new ArrayList<>();

        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gotoh = new Intent(dailytask.this,homepage.class);
                startActivity( gotoh );
            }
        });


    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context,"آیتم حذف شد",Toast.LENGTH_LONG).show();
                /*try {
                    FileHelper.writeData(items,dailytask.this);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                items.remove(i);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View view) {
        EditText input = (EditText) findViewById(R.id.writeitem);
        String itemText = input.getText().toString().trim();
        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("");
            Toast.makeText(getApplicationContext(),"آیتم اضافه شد",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"لطفا متنی وارد کنید",Toast.LENGTH_LONG).show();
        }
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
        Intent gotoh = new Intent(dailytask.this,homepage.class);
        startActivity( gotoh );
    }

}
