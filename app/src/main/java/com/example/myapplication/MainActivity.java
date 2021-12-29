package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements F1.i1 {
TextView t1;
String [] s1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Locale l=new Locale("hi");
        Locale.setDefault(l);
        getResources().updateConfiguration(new Configuration(),getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);
t1=findViewById(R.id.t1);
b1=findViewById(R.id.b1);

       // Configuration co=new Configuration();
      //  co.locale=l;

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),Dashboard1Activity.class));
    }
});
s1=getResources().getStringArray(R.array.descriptions);

if(findViewById(R.id.port)!=null)
{
    FragmentManager mg= this.getSupportFragmentManager();
    mg.beginTransaction().show(mg.findFragmentById(R.id.f1)).hide(mg.findFragmentById(R.id.f2)).commit();


}
        if(findViewById(R.id.port)!=null)
        {
            FragmentManager mg= this.getSupportFragmentManager();
            mg.beginTransaction().show(mg.findFragmentById(R.id.f1))
                    .show(mg.findFragmentById(R.id.f2)).commit();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(findViewById(R.id.port)!=null)
        {
            FragmentManager mg= this.getSupportFragmentManager();
            mg.beginTransaction().show(mg.findFragmentById(R.id.f1)).hide(mg.findFragmentById(R.id.f2)).commit();


        }

    }

    @Override
    public void onItemselected(int index) {
        t1.setText(s1[index]);
        if(findViewById(R.id.port)!=null)
        { FragmentManager mg= this.getSupportFragmentManager();
            mg.beginTransaction().show(mg.findFragmentById(R.id.f2)).hide(mg.findFragmentById(R.id.f1)).commit();

        }
    }
}