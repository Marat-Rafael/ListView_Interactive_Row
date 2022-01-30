package com.example.listview_interactive_row;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RatingList_Demo extends AppCompatActivity {

    String TAG = "LISTA";
    TextView selection;
    ListView listView;
    public final String[] items = {"Madrid", "Lugo", "Ibiza",
            "Palma de Mallorca", "Barcelona", "Valencia", "Valladolid", "Leon", "Burgos",
            "Ciudad Real", "Gijon", "Sevilla", "Alicante", "Malaga", "Murcia", "Cadiz",
            "Asturias", "Zaragoza", "Santiago", "Jaen"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "entra onCreate");

        // identificamos listView y textView
        listView = findViewById(R.id.listView);
        selection = findViewById(R.id.tv_mostrar_selecionado);

        ArrayList<RowModel> arrayList = new ArrayList<RowModel>();

        // rellenamos arraylist con datos
        for (int i = 0; i < items.length; i++) {
            arrayList.add(new RowModel(items[i],2.0f));
        }

        RatingAdapter ratingAdapter = new RatingAdapter(this,R.layout.row,arrayList);

        listView.setAdapter(ratingAdapter);

        // porque no entra en onclick?
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "entra onClick");
                String string = arrayList.get(i).getLabel();
                selection.setText(string);
            }
        });
    }
}