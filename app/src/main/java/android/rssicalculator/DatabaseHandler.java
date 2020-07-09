package android.rssicalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;*/

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "locationSignalStrength";
    private static final String TABLE_LOCATION_RSSI = "locationRSSI";
    private static final String KEY_ID = "id";
    private static final String LAT = "latitude";
    private static final String LONG = "longitude";
    private static final String SSID = "ssid";
    private static final String RSSI = "rssi";
    private static final String TIMESTAMP = "timestamp";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOCATION_RSSI_TABLE = "CREATE TABLE " + TABLE_LOCATION_RSSI + "(" + KEY_ID +
                " INTEGER PRIMARY KEY," + LAT + " REAL," + LONG + " REAL," + SSID + " TEXT," +
                RSSI + " INTEGER," + TIMESTAMP + " TEXT)";
        db.execSQL(CREATE_LOCATION_RSSI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION_RSSI);
        onCreate(db);
    }

    public void addLocationRSSI(double latitude, double longitude, String ssid, int rssi, long ts) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LAT, latitude);
        values.put(LONG, longitude);
        values.put(SSID, ssid);
        values.put(RSSI, rssi);
        values.put(TIMESTAMP, Long.toString(ts));
        db.insert(TABLE_LOCATION_RSSI, null, values);
        db.close();
    }
}
