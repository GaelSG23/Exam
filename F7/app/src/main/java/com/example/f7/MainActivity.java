package com.example.f7;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.f7.Models.Comment;
import com.example.f7.SQL.CommentsDataSource;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private CommentsDataSource datasource;
    ArrayAdapter adapter;
    ListView listView;
    String[] commentaires = new String[] { "Excellent", "TBien", "Bien" ,
            "ABien", "Moyen","Faible"};
    List<Comment> valeurs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datasource = new CommentsDataSource(this);
        datasource.open();
        valeurs = datasource.getAllComments();
        adapter = new ArrayAdapter<Comment>(this,R.layout.activity_listview, valeurs);
        listView = (ListView) findViewById(R.id.liste);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent,view,position, id) -> {
            Comment c = (Comment) parent.getItemAtPosition(position);
            AlertDialog.Builder alert = createAlert(c.getComment());
            alert.create().show();
            datasource.deleteComment(c);
            valeurs.remove(c);
            adapter.remove(c);
            listView.setAdapter(adapter);
        });
    }
    public void ajouter(View v) {
        Comment comment = null;
        int nextInt = new Random().nextInt(3);
        // enregistrer le nouveau commentaire choisi au hasard dans la base de données
        comment = datasource.createComment(commentaires[nextInt]);
        //Ajouter le nouveau commentaire à la liste
        valeurs.add(comment);
        listView.setAdapter(adapter);
    }
    private AlertDialog.Builder createAlert(String titre) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Suppression");
        alert.setMessage("Le commentaire, " + titre+ ", est supprimé de la liste");
        alert.setPositiveButton("OK", null);
        return alert;
    }
    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }
    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}