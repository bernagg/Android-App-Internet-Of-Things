package upf.internetofthings.utilities;

public class Utilities {
    public static final String TABLE_ITEM = "item";
    public static final String TABLE_ITEM_GROUP = "itemgroup";
    public static final String F_ID = "id";
    public static final String F_DESCRIPTION = "description";
    public static final String F_TAG = "tag";


    public static final String CREATE_TABLE_ITEM  = "CREATE TABLE " + TABLE_ITEM +
            " (" + F_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + F_DESCRIPTION + " TEXT, " + F_TAG + " TEXT)";

}
