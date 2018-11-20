package upf.internetofthings.utilities;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import upf.internetofthings.utilities.Utilities;

public class ConnSQLiteHelper extends SQLiteOpenHelper {

    public ConnSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) throws SQLException {
        db.execSQL(Utilities.CREATE_TABLE_ITEM);
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (1,'Casco','000000000000000000000001')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (2,'Pantalon','000000000000000000000001')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (3,'Guante','000000000000000000000001')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (4,'Manguera','000000000000000000000001')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws SQLException {
        db.execSQL("DROP TABLE IF EXISTS item");
        db.execSQL(Utilities.CREATE_TABLE_ITEM);
    }
}
