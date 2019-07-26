package com.example.cs.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.cs.MainActivity;
import com.example.cs.modelos.area;
import com.example.cs.modelos.categoria;
import com.example.cs.modelos.convocatoria;
import com.example.cs.modelos.curso;
import com.example.cs.modelos.cursodetallado;
import com.example.cs.modelos.fabricante;
import com.example.cs.modelos.modalidad;
import com.example.cs.modelos.subcategoria;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class AreaHandler {

    private static final int    DATABASE_VERSION = 1;
    public static final String PACKAGE_NAME = "com.example.ca";
    private static final String DATABASE_NAME = "cas_training.db";
    private static String DB_PATH = "DdBb/";
//    String DATABASE_PATH = "/" + DB_PATH + PACKAGE_NAME + "/databases/" + DATABASE_NAME;
    // table name
    private static final String TABLE_AREA         = "area";
//    private static final String DATABASE_PATH = "/data/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME;

    // Table Columns names
    private static final String ID_A = "id_area";
    private static final String NAME_A = "area";

    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window

    //destination path (location) of our database on device
    SQLiteOpenHelper dbhandler;
    private SQLiteDatabase mDataBase;
//    private final Context mContext;

    public AreaHandler(Context context){
        dbhandler = new DatabaseHandler(context);
    }

    public void open(){
        Log.i("AREA","Database Opened");
        mDataBase = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i("AREA", "Database Closed");
        if(mDataBase != null)
            mDataBase.close();
        dbhandler.close();

    }



         // Creating Tables
    public void onCreate(SQLiteDatabase db) {
        String dbpath = db.getPath();
        DB_PATH = dbpath;
        Log.d("PATH","on create" + dbpath);
        try {
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "create table " + TABLE_AREA + "("
                    + ID_A + "           integer primary key not null, "
                    + NAME_A + "         text not null)";
            db.execSQL(CREATE_CONTACTS_TABLE);

        } catch (Exception e) {
            Log.e("ERROR_CREAR_TABLAS", "Error doInBackground():" + e);
            e.printStackTrace();

        }
    }
/*
    public void createDataBase() throws IOException
    {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if(!mDataBaseExist)
        {
            this.getReadableDatabase();
            this.close();
            try
            {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            }
            catch (IOException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
*/
/*
    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase()
    {
        String dbpath = .getDatabasePath(DATABASE_NAME).getPath();
        DB_PATH = dbpath;
        Log.d("PATH","checkDataBase" + dbpath);
        File dbFile = new File(DB_PATH + DATABASE_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mDataBase.getAssets().open(DATABASE_NAME);
        String outFileName = DB_PATH + DATABASE_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }
*/
    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPathDb = DB_PATH + DATABASE_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPathDb, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREA);
        onCreate(db);
    }

    void addHandeler(area a) {
        SQLiteDatabase db = mDataBase;

        ContentValues v = new ContentValues();
        v.put(ID_A, a.getId_area()); // Id
        v.put(NAME_A, a.getArea());   // Name

        // Inserting Row
        db.insert(TABLE_AREA, null, v);
        db.close(); // Closing database connection
    }

    public ArrayList<area> getAllvaluesAr() {
        ArrayList<area> areaArrayList = new ArrayList<area>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_AREA;
        SQLiteDatabase db = mDataBase;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                area a = new area();
                a.setId_area(Integer.parseInt(cursor.getString(0)));
                a.setArea(cursor.getString(1));
                areaArrayList.add(a);
            } while (cursor.moveToNext());
        }
        return areaArrayList;
    }
    public void load(area a,SQLiteDatabase db) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        SQLiteDatabase db = this.mDataBase;
        ContentValues args = new ContentValues();
        args.put(ID_A, a.getId_area());
        args.put(NAME_A, a.getArea());
        // updating row
        db.insert(TABLE_AREA,null, args);
        //db.close();
    }
    public void loadAllA(ArrayList<area> areaArrayList, SQLiteDatabase db ) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < areaArrayList.size();i++) {
            // updating single record
            load(areaArrayList.get(i),db);
        }
    }
    public boolean update(area a) {
        SQLiteDatabase db = mDataBase;
        ContentValues args = new ContentValues();
        args.put(ID_A, a.getId_area());
        args.put(NAME_A, a.getArea());
        // updating row
        return db.update(TABLE_AREA, args, ID_A + " = " + a.getId_area(), null) > 0;
    }
    public void updateAllA(ArrayList<area> areaArrayList) {
        SQLiteDatabase db = mDataBase;
        for (int i=0;i < areaArrayList.size();i++) {
            // updating single record
            update(areaArrayList.get(i));
        }
    }
    public boolean deleteAreaHandler(int ID) {
        boolean result = false;
        String query = "Select * FROM " + TABLE_AREA + " WHERE " + ID_A + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = mDataBase;
        Cursor cursor = db.rawQuery(query, null);
        area a = new area();
        if (cursor.moveToFirst()) {
            a.setId_area(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_AREA, ID_A + "=?", new String[] {
                    String.valueOf(a.getId_area()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}
