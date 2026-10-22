package com.example.tp1;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.tp1.data.Donnees;
import com.example.tp1.model.Activite;

public class Calendrier extends BaseActivity {

    int textsize = 9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);

        TableLayout table = findViewById(R.id.table);

        for (Activite activite : Donnees.getActivites()) {

            TableRow row = new TableRow(this);

            TextView date = new TextView(this);
            date.setTextSize(textsize);
            date.setText(activite.getDate());

            TextView titre = new TextView(this);
            titre.setTextSize(textsize);
            titre.setText(activite.getTitre());

            TextView lieu = new TextView(this);
            lieu.setTextSize(textsize);
            lieu.setText(activite.getLieu());

            TextView domicile = new TextView(this);
            domicile.setTextSize(textsize);
            if(activite.isDomicile()) domicile.setText("DOMICILE");
            else domicile.setText("VISITEUR");

            TextView confirme = new TextView(this);
            confirme.setTextSize(textsize);
            confirme.setText(String.valueOf(activite.getNombrePresences()));

            row.addView(date);
            row.addView(titre);
            row.addView(lieu);
            row.addView(domicile);
            row.addView(confirme);

            table.addView(row);
        }
    }
}