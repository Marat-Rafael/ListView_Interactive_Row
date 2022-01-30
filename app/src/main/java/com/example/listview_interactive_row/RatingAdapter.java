package com.example.listview_interactive_row;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RatingAdapter extends ArrayAdapter<RowModel> {

    // -------- ATRIBUTOS -----------------
    private Context context;
    private int resource;
    String TAG = "LISTA";

    // constructor con 3 parametros                              // cambiamos a arraylist<rawmodel>
    public RatingAdapter(@NonNull Context context, int resource, @NonNull ArrayList<RowModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    /**
     * metodo que devuelve una fila de la lista
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // creamos un objeto de LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(resource, parent, false);

        // identificamos objetos
        TextView textView = convertView.findViewById(R.id.textview_item);
        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);

        textView.setText(getItem(position).getLabel());
        ratingBar.setRating(getItem(position).getRating());

        // colocamos OnRatingBarChange
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.d(TAG, "entra onRatingChange");
                if (ratingBar.getRating() == 3) {
                    String string = (String) textView.getText();
                    textView.setText(string.toUpperCase());
                }
                if (ratingBar.getRating() < 3) {
                    String string = (String) textView.getText();
                    String cap = string.substring(0, 1).toUpperCase()+string.substring(1).toLowerCase();
                    textView.setText(cap);
                }
            }
        });
        return convertView;
    }
}
