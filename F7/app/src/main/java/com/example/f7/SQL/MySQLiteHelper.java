package com.example.f7.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";
    private static final String DATABASE_NAME = "commentaires.db";
    private static final int DATABASE_VERSION = 1;
    // Commande SQL pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Mise à niveau de la base de données à partir de la version " +
                        oldVersion + " à "
                        + newVersion + ", qui détruira toutes les anciennes données");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }
}
