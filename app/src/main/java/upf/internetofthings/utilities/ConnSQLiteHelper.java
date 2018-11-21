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
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (0,'Ball','000000000000000000000000')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (1,'Helmet','000000000000000000000001')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (2,'Pants','000000000000000000000002')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (3,'Jacket','000000000000000000000003')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (4,'Hose','000000000000000000000004')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (5,'Hola1','000000000000000000000005')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (6,'Hola2','000000000000000000000006')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (7,'Hola3','000000000000000000000007')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (8,'Hola4','000000000000000000000008')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (9,'Hola5','000000000000000000000009')");
        db.execSQL("INSERT INTO " + Utilities.TABLE_ITEM + " VALUES (10,'Hola6','000000000000000000000010')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws SQLException {
        db.execSQL("DROP TABLE IF EXISTS item");
        db.execSQL(Utilities.CREATE_TABLE_ITEM);
    }
}
