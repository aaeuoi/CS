package com.example.cs.bbdd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.cs.MainActivity;
import com.example.cs.modelos.convocatoria;
import com.example.cs.modelos.curso;
import com.example.cs.modelos.fabricante;
import com.example.cs.modelos.area;
import com.example.cs.modelos.categoria;
import com.example.cs.modelos.subcategoria;
import com.example.cs.modelos.modalidad;

import static java.lang.String.valueOf;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int    DATABASE_VERSION = 1;
//    public static final String PACKAGE_NAME = "com.example.ca";
    private static final String DATABASE_NAME = "cas_training.db";
    // table name
    private static final String TABLE_FABRICANTE   = "fabricante";
    private static final String TABLE_AREA         = "area";
    private static final String TABLE_CATEGORIA    = "categoria";
    private static final String TABLE_SUBCATEGORIA = "subategoria";
    private static final String TABLE_MODALIDAD    = "modalidad";
    private static final String TABLE_CURSO        = "curso";
    private static final String TABLE_CONVOCATORIA = "convocatoria";
//    private static final String DATABASE_PATH = "/data/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME;

    // Table Columns names
    private static final String ID_F = "id_fabricante";
    private static final String NAME_F = "fabricante";
    private static final String ID_A = "id_area";
    private static final String NAME_A = "area";
    private static final String ID_C = "id_categoria";
    private static final String NAME_C = "categoria";
    private static final String ID_S = "id_subcategoria";
    private static final String NAME_S = "subcategoria";
    private static final String ID_M = "id_modalidad";
    private static final String NAME_M = "mmdalidad";
    private static final String ID_CU = "cas_sku";
    private static final String NAME_CU = "cas_nombre";
    private static final String ID_CO = "id";
    private static final String NAME_CO = "cas_sku";

    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private static String DB_PATH = "";
//    private static String DB_NAME ="YourDbName";// Database name
    private SQLiteDatabase mDataBase;
//    private final Context mContext;

    public DatabaseHandler(Context context) {
        super((Context) MainActivity.PlayerTask, DATABASE_NAME, null, DATABASE_VERSION);
//        super(context, DATABASE_NAME, null, 1);// 1? Its database Version

        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = ((Context) MainActivity.PlayerTask).getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + ((Context) MainActivity.PlayerTask).getApplicationInfo().dataDir + "/databases/";
        }
//        this.mContext = context;
    }
    /*
    public DatabaseHandler(Context context, Stringname, SQLiteDatabase.CursorFactoryfactory, intversion) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        super(context, DATABASE_NAME, null, 1);// 1? Its database Version

        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }
*/
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "create table " + TABLE_FABRICANTE + "("
                    + ID_F + "           integer primary key not null, "
                    + NAME_F + "         text not null);";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_AREA + "("
                    + ID_A + "           integer primary key not null, "
                    + NAME_A + "         text not null);";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_CATEGORIA + "("
                    + ID_C + "           integer primary key not null, "
                    + NAME_C + "         text not null,"
                    + ID_A + "           integer not null);";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_SUBCATEGORIA + "("
                    + ID_S + "           integer primary key not null, "
                    + NAME_S + "         text not null,"
                    + ID_C + "           integer not null);";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_MODALIDAD + "("
                    + ID_M + "           integer primary key not null, "
                    + NAME_M + "         text not null);";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_CURSO + "("
                    + "cas_area          integer not null, "
                    + "cas_categoria     integer not null, "
                    + "cas_subcategoria  integer not null, "
                    + ID_CU + "          integer primary key not null, "
                    + NAME_CU + "        text not null, "
                    + "cas_duracion      integer not null, "
                    + "cas_formato       text not null, "
                    + "cas_idioma        text not null, "
                    + "cas_modalidad     text not null, "
                    + "cas_fabricante    integer not null, "
                    + "cas_nivel         text not null, "
                    + "cas_oficial       text not null, "
                    + "cas_documentacion text not null, "
                    + "cas_descripcion   text not null, "
                    + "cas_objetivos     text not null, "
                    + "cas_audiencia     text not null, "
                    + "cas_contenidos    text not null, "
                    + "cas_image         text not null, "
                    + "cas_pdf_curso     text not null, "
                    + "cas_destacado     integer not null);";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_CONVOCATORIA + "("
                    + ID_CO + "         integer primary key not null, "
                    + NAME_CO + "       text not null,"
                    + "cas_inicio       date not null,"
                    + "cas_horario      text not null,"
                    + "cas_lugar        text not null,"
                    + "cas_modalidad    text not null);";
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
    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DATABASE_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }
/*
    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DATABASE_NAME);
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
        String mPath = DB_PATH + DATABASE_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close()
    {
        if(mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FABRICANTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBCATEGORIA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODALIDAD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONVOCATORIA);
        onCreate(db);
    }

    void add(fabricante f) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues v = new ContentValues();
        v.put(NAME_F, f.getFabricante()); // Contact Name

        // Inserting Row
        db.insert(TABLE_FABRICANTE, null, v);
        db.close(); // Closing database connection
    }

    // Getting single contact
    fabricante getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FABRICANTE, new String[] { ID_F,
                        NAME_F }, ID_F + "=?", new String[] { valueOf(id) },
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        fabricante f = new fabricante(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));

        return f;
    }

    // Getting All data
    public List<fabricante> getAllvaluesFa() {
        List<fabricante> fabricanteList = new ArrayList<fabricante>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FABRICANTE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                fabricante f = new fabricante();
                f.setId_fabricante(Integer.parseInt(cursor.getString(0)));
                f.setFabricante(cursor.getString(1));
                fabricanteList.add(f);
            } while (cursor.moveToNext());
        }
        return fabricanteList;
    }
    public List<area> getAllvaluesAr() {
        List<area> areaList = new ArrayList<area>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_AREA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                area a = new area();
                a.setId_area(Integer.parseInt(cursor.getString(0)));
                a.setArea(cursor.getString(1));
                areaList.add(a);
            } while (cursor.moveToNext());
        }
        return areaList;
    }
    public List<categoria> getAllvaluesCa() {
        List<categoria> categoriaList = new ArrayList<categoria>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORIA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                categoria c = new categoria();
                c.setId_categoria(Integer.parseInt(cursor.getString(0)));
                c.setCategoria(cursor.getString(1));
                c.setId_area(Integer.parseInt(cursor.getString(2)));
                categoriaList.add(c);
            } while (cursor.moveToNext());
        }
        return categoriaList;
    }
    public List<subcategoria> getAllvaluesSu() {
        List<subcategoria> subcategoriaList = new ArrayList<subcategoria>();
        // Select All Query
        String selectQuerySu = "SELECT  * FROM " + TABLE_SUBCATEGORIA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorSu = db.rawQuery(selectQuerySu, null);
        // looping through all rows and adding to list
        if (cursorSu.moveToFirst()) {
            do {
                subcategoria s = new subcategoria();
                s.setId_subcategoria(Integer.parseInt(cursorSu.getString(0)));
                s.setSubcategoria(cursorSu.getString(1));
                s.setId_categoria(Integer.parseInt(cursorSu.getString(2)));
                subcategoriaList.add(s);
            } while (cursorSu.moveToNext());
        }
        return subcategoriaList;
    }
    public List<modalidad> getAllvaluesMo() {
        List<modalidad> modalidadList = new ArrayList<modalidad>();
        // Select All Query
        String selectQueryMo = "SELECT  * FROM " + TABLE_MODALIDAD;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryMo, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                modalidad m = new modalidad();
                m.setId_modalidad(Integer.parseInt(cursor.getString(0)));
                m.setModalidad(cursor.getString(1));
                modalidadList.add(m);
            } while (cursor.moveToNext());
        }
        return modalidadList;
    }
    public List<curso> getAllvaluesCu() {
        List<curso> cursoList = new ArrayList<curso>();
        // Select All Query
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryCu, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                curso cu = new curso();
                cu.setArea(Integer.parseInt(cursor.getString(0)));
                cu.setCategoria(Integer.parseInt(cursor.getString(1)));
                cu.setSubcategoria(Integer.parseInt(cursor.getString(2)));
                cu.setSku(cursor.getString(3));
                cu.setNombre(cursor.getString(4));
                cu.setDuracion(Integer.parseInt(cursor.getString(5)));
                cu.setInicio(Date.valueOf(cursor.getString(6)));
                cu.setFormato(cursor.getString(7));
                cu.setIdioma(cursor.getString(8));
                cu.setModalidad(cursor.getString(9));
                cu.setFabricante(Integer.parseInt(cursor.getString(10)));
                cu.setNivel(cursor.getString(11));
                cu.setOficial(cursor.getString(12));
                cu.setDocumentacion(cursor.getString(13));
                cu.setDescripcion(cursor.getString(14));
                cu.setObjetivos(cursor.getString(15));
                cu.setAudiencia(cursor.getString(16));
                cu.setContenidos(cursor.getString(16));
                cu.setImage(cursor.getString(18));
                cu.setPdf_curso(cursor.getString(19));
                cu.setDestacado(Integer.parseInt(cursor.getString(20)));
                cursoList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoList;
    }
    public List<convocatoria> getAllvaluesCo() {
        List<convocatoria> convocatoriaList = new ArrayList<convocatoria>();
        // Select All Query
        String selectQueryCo = "SELECT  * FROM " + TABLE_CONVOCATORIA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryCo, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                convocatoria co = new convocatoria();
                co.setId(Integer.parseInt(cursor.getString(0)));
                co.setSku(cursor.getString(1));
                co.setInicio(Date.valueOf(cursor.getString(2)));
                co.setHorario(cursor.getString(3));
                co.setLugar(cursor.getString(4));
                co.setModalidad(cursor.getString(5));
                convocatoriaList.add(co);
            } while (cursor.moveToNext());
        }
        return convocatoriaList;
    }

    // Loading single record
    public void load(fabricante f) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_F, f.getId_fabricante());
        args.put(NAME_F, f.getFabricante());
        // updating row
        db.insert(TABLE_FABRICANTE,null, args);
        //db.close();
    }
    public void load(area a) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_A, a.getId_area());
        args.put(NAME_A, a.getArea());
        // updating row
        db.insert(TABLE_AREA,null, args);
       //db.close();
    }
    public void load(categoria c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_C, c.getId_categoria());
        args.put(NAME_C, c.getCategoria());
        args.put(ID_A, c.getId_area());
        // updating row
        db.insert(TABLE_CATEGORIA,null, args);
        //db.close();
    }
    public void load(subcategoria s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_S, s.getId_subcategoria());
        args.put(NAME_S, s.getSubcategoria());
        args.put(ID_C, s.getId_categoria());
        // updating row
        db.insert(TABLE_SUBCATEGORIA,null, args);
        //db.close();
    }
    public void load(curso cu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("cas_area", cu.getArea());
        args.put("cas_categoria", cu.getCategoria());
        args.put("cas_subcategoria", cu.getSubcategoria());
        args.put(ID_CU, cu.getSku());
        args.put(NAME_CU, cu.getNombre());
        args.put("cas_duracion", cu.getDuracion());
        args.put("cas_formato", cu.getFormato());
        args.put("cas_idioma", cu.getIdioma());
        args.put("cas_modalidad", cu.getModalidad());
        args.put("cas_fabricante", cu.getFabricante());
        args.put("cas_nivel", cu.getNivel());
        args.put("cas_oficial", cu.getOficial());
        args.put("cas_documentacion", cu.getDocumentacion());
        args.put("cas_descripcion", cu.getDescripcion());
        args.put("cas_objetivos", cu.getObjetivos());
        args.put("cas_audiencia", cu.getAudiencia());
        args.put("cas_contenidos", cu.getContenidos());
        args.put("cas_image", cu.getImage());
        args.put("cas_pdf_curso", cu.getPdf_curso());
        args.put("cas_destacado", cu.getDestacado());
        // updating row
        db.insert(TABLE_CURSO,null, args);
        //db.close();
    }
    public void load(convocatoria co) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_CO, co.getId());
        args.put(NAME_CO, co.getSku());
        args.put("cas_inicio", valueOf(co.getInicio()));
        args.put("cas_horario", co.getHorario());
        args.put("cas_lugar", co.getLugar());
        args.put("cas_modalidad", co.getModalidad());
        // updating row
        db.insert(TABLE_CONVOCATORIA,null, args);
        //db.close();
    }
    public void load(modalidad m) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_M, m.getId_modalidad());
        args.put(NAME_M, m.getModalidad());
        // updating row
        db.insert(TABLE_MODALIDAD,null, args);
        //db.close();
    }
    public void loadAllF(List<fabricante> fabricanteList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < fabricanteList.size();i++) {
            // updating single record
            load(fabricanteList.get(i));
        }
    }
    public void loadAllA(List<area> areaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < areaList.size();i++) {
            // updating single record
            load(areaList.get(i));
        }
    }
    public void loadAllC(List<categoria> categoriaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < categoriaList.size();i++) {
            // updating single record
            load(categoriaList.get(i));
        }
    }
    public void loadAllS(List<subcategoria> subcategoriaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < subcategoriaList.size();i++) {
            // updating single record
            load(subcategoriaList.get(i));
        }
    }
    public void loadAllCu(List<curso> cursoList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < cursoList.size();i++) {
            // updating single record
            load(cursoList.get(i));
        }
    }
    public void loadAllCo(List<convocatoria> convocatoriaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < convocatoriaList.size();i++) {
            // updating single record
            load(convocatoriaList.get(i));
        }
    }
    public void loadAllM(List<modalidad> modalidadList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < modalidadList.size();i++) {
            // updating single record
            load(modalidadList.get(i));
        }
    }
    // Updating single record
    public boolean update(fabricante f) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_F, f.getId_fabricante());
        args.put(NAME_F, f.getFabricante());
        // updating row
        return db.update(TABLE_FABRICANTE, args, ID_F + " = " + f.getId_fabricante(), null) > 0;
    }
    public boolean update(area a) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_A, a.getId_area());
        args.put(NAME_A, a.getArea());
        // updating row
        return db.update(TABLE_AREA, args, ID_A + " = " + a.getId_area(), null) > 0;
    }
    public boolean update(categoria c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_C, c.getId_categoria());
        args.put(NAME_C, c.getCategoria());
        args.put(ID_A, c.getId_area());
        // updating row
        return db.update(TABLE_CATEGORIA, args, ID_C + " = " + c.getId_categoria(), null) > 0;
    }
    public boolean update(subcategoria s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_S, s.getId_subcategoria());
        args.put(NAME_S, s.getSubcategoria());
        args.put(ID_C, s.getId_categoria());
        // updating row
        return db.update(TABLE_SUBCATEGORIA, args, ID_S + " = " + s.getId_subcategoria(), null) > 0;
    }
    public boolean update(curso cu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put("cas_area", cu.getArea());
        args.put("cas_categoria", cu.getCategoria());
        args.put("cas_subcategoria", cu.getSubcategoria());
        args.put(ID_CU, cu.getSku());
        args.put(NAME_CU, cu.getNombre());
        args.put("cas_duracion", cu.getDuracion());
        args.put("cas_formato", cu.getFormato());
        args.put("cas_idioma", cu.getIdioma());
        args.put("cas_modalidad", cu.getModalidad());
        args.put("cas_fabricante", cu.getFabricante());
        args.put("cas_nivel", cu.getNivel());
        args.put("cas_oficial", cu.getOficial());
        args.put("cas_documentacion", cu.getDocumentacion());
        args.put("cas_descripcion", cu.getDescripcion());
        args.put("cas_objetivos", cu.getObjetivos());
        args.put("cas_audiencia", cu.getAudiencia());
        args.put("cas_contenidos", cu.getContenidos());
        args.put("cas_image", cu.getImage());
        args.put("cas_pdf_curso", cu.getPdf_curso());
        args.put("cas_destacado", cu.getDestacado());
        // updating row
        return db.update(TABLE_CURSO, args, ID_CU + " = " + cu.getSku(), null) > 0;
    }
    public boolean update(convocatoria co) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_CO, co.getId());
        args.put(NAME_CO, co.getSku());
        args.put("cas_inicio", valueOf(co.getInicio()));
        args.put("cas_horario", co.getHorario());
        args.put("cas_lugar", co.getLugar());
        args.put("cas_modalidad", co.getModalidad());
        // updating row
        return db.update(TABLE_CONVOCATORIA, args, ID_CO + " = " + co.getId(), null) > 0;
    }
    public boolean update(modalidad m) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID_M, m.getId_modalidad());
        args.put(NAME_M, m.getModalidad());
        // updating row
        return db.update(TABLE_MODALIDAD, args, ID_M + " = " + m.getId_modalidad(), null) > 0;
    }
    // Updating every record
    public void updateAllF(List<fabricante> fabricanteList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < fabricanteList.size();i++) {
            // updating single record
            update(fabricanteList.get(i));
        }
    }
    public void updateAllA(List<area> areaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < areaList.size();i++) {
            // updating single record
            update(areaList.get(i));
        }
    }
    public void updateAllC(List<categoria> categoriaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < categoriaList.size();i++) {
            // updating single record
            update(categoriaList.get(i));
        }
    }
    public void updateAllS(List<subcategoria> subcategoriaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < subcategoriaList.size();i++) {
            // updating single record
            update(subcategoriaList.get(i));
        }
    }
    public void updateAllCu(List<curso> cursoList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < cursoList.size();i++) {
            // updating single record
            update(cursoList.get(i));
        }
    }
    public void updateAllCo(List<convocatoria> convocatoriaList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < convocatoriaList.size();i++) {
            // updating single record
            update(convocatoriaList.get(i));
        }
    }
    public void updateAllM(List<modalidad> modalidadList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < modalidadList.size();i++) {
            // updating single record
            update(modalidadList.get(i));
        }
    }
}
