package com.example.securitymaterial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.securitymaterial.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //abre conexão com banco de dados.
        sqlite = openOrCreateDatabase("database_sm", Context.MODE_PRIVATE, null);
        //bottom nav
        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationview);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        //setting home fragment as main fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,new HomeFragment(sqlite)).commit();
    }

    //listener nav bar
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.miAdd:
                            selectedFragment = new AddFragment();
                            break;
                    }

                    //begin transaction
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_layout
                                    ,selectedFragment).commit();

                    return true;
                }
            };


    /*public void Transit(){
        Intent intent = new Intent(this, splash.class);
        startActivity(intent);
    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    public void telaUpdate(int dataInt){
        Intent intent = new Intent(MainActivity.this, update_activity.class);
        intent.putExtra("idRegister", dataInt);
        startActivity(intent);
        sqlite.close();
        finish();
    }
    public void telaRecuperar(int dataInt){
        Intent intent = new Intent(MainActivity.this, reportarPerda.class);
        intent.putExtra("IdReg", dataInt);
        startActivity(intent);
        sqlite.close();
        finish();
    }
    public void telaEmprestar(int dataInt){
        Intent intent = new Intent(MainActivity.this, Lembrete.class);
        intent.putExtra("IdR", dataInt);
        startActivity(intent);
        sqlite.close();
        finish();
    }

}