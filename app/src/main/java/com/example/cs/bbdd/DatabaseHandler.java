package com.example.cs.bbdd;

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
import com.example.cs.modelos.cursodetallado;
import com.example.cs.modelos.fabricante;
import com.example.cs.modelos.area;
import com.example.cs.modelos.categoria;
import com.example.cs.modelos.subcategoria;
import com.example.cs.modelos.modalidad;

import static java.lang.String.valueOf;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int    DATABASE_VERSION = 1;
    public static final String PACKAGE_NAME = "com.example.oi.aaeu.ca";
    //    private static final String DATABASE_NAME = "cas_training";
    private static final String DATABASE_NAME = "cas_training";
    //private static String DB_PATH = "DdBb/";
    //    String DATABASE_PATH = "/" + DB_PATH + PACKAGE_NAME + "/databases/" + DATABASE_NAME;
    // table name
    private static final String TABLE_FABRICANTE   = "fabricante";
    private static final String TABLE_AREA         = "area";
    private static final String TABLE_CATEGORIA    = "categoria";
    private static final String TABLE_SUBCATEGORIA = "subategoria";
    private static final String TABLE_MODALIDAD    = "modalidad";
    private static final String TABLE_CURSO        = "curso";
    private static final String TABLE_CURSODET     = "cursodetallado";
    private static final String TABLE_CONVOCATORIA = "convocatoria";
//  private static final String DATABASE_PATH = "/data/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME;

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
    private SQLiteDatabase mDataBase;
    private final Context myContext;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
/*        String dbpath = context.getDatabasePath(DATABASE_NAME).getPath();
        DB_PATH = dbpath;
        Log.d("PATH","1=" + dbpath); */
        this.myContext = context;
/*        try {
            context.deleteDatabase(DATABASE_NAME);
            Log.d("DELETE","deleteDatabase " + DATABASE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ERROR","on deteDatabase " + DATABASE_NAME + " = " + e.getMessage());
        }*/
        /*
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = ((Context) MainActivity.PlayerTask).getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + ((Context) MainActivity.PlayerTask).getApplicationInfo().dataDir + "/databases/";
        }
*/
//        this.mContext = context;
    }
    /*    public DatabaseHandler(Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
            super((Context) MainActivity.PlayerTask, DATABASE_NAME, factory, DATABASE_VERSION);
        }
    */
// Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbpath = db.getPath();
        ////db.beginTransaction();
        Log.d("PATH","on create" + dbpath);
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FABRICANTE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBCATEGORIA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODALIDAD);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSO);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSODET);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONVOCATORIA);
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "create table " + TABLE_FABRICANTE + "("
                    + ID_F + "           integer primary key not null, "
                    + NAME_F + "         text not null)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_AREA + "("
                    + ID_A + "           integer primary key not null, "
                    + NAME_A + "         text not null)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_CATEGORIA + "("
                    + ID_C + "           integer primary key not null, "
                    + NAME_C + "         text not null,"
                    + ID_A + "           integer not null)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_SUBCATEGORIA + "("
                    + ID_S + "           integer primary key not null, "
                    + NAME_S + "         text not null,"
                    + ID_C + "           integer not null)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_MODALIDAD + "("
                    + ID_M + "           integer primary key not null, "
                    + NAME_M + "         text)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_CURSO + "("
                    + "cas_area          integer not null, "
                    + "cas_categoria     integer not null, "
                    + "cas_subcategoria  integer not null, "
                    + ID_CU + "          text primary key not null, "
                    + NAME_CU + "        text not null, "
                    + "cas_duracion      integer, "
                    + "cas_formato       text, "
                    + "cas_idioma        text, "
                    + "cas_modalidad     text not null, "
                    + "cas_fabricante    integer not null, "
                    + "cas_nivel         text, "
                    + "cas_oficial       text, "
                    + "cas_documentacion text, "
                    + "cas_descripcion   text, "
                    + "cas_objetivos     text, "
                    + "cas_audiencia     text, "
                    + "cas_contenidos    text, "
                    + "cas_image         text, "
                    + "cas_pdf_curso     text, "
                    + "cas_destacado     integer)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_CURSODET + "("
                    + "cas_area          text not null, "
                    + "cas_categoria     text not null, "
                    + "cas_subcategoria  text not null, "
                    + ID_CU + "          text primary key not null, "
                    + NAME_CU + "        text not null, "
                    + "cas_duracion      text, "
                    + "cas_inicio        text, "
//                    + "cas_formato       text not null, "
//                    + "cas_idioma        text not null, "
                    + "cas_modalidad     text not null, "
                    + "cas_fabricante    text not null, "
//                    + "cas_nivel         text not null, "
//                    + "cas_oficial       text not null, "
//                    + "cas_documentacion text not null, "
                    + "cas_descripcion   text, "
                    + "cas_objetivos     text, "
//                    + "cas_audiencia     text not null, "
                    + "cas_contenidos    text, "
                    + "cas_image         text, "
//                    + "cas_pdf_curso     varchar(50) not null, "
                    + "cas_destacado     text)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            CREATE_CONTACTS_TABLE = "create table " + TABLE_CONVOCATORIA + "("
                    + ID_CO + "         integer primary key not null, "
                    + NAME_CO + "       text not null,"
                    + "cas_inicio       text,"
                    + "cas_horario      text,"
                    + "cas_lugar        text,"
                    + "cas_modalidad    text)";
            db.execSQL(CREATE_CONTACTS_TABLE);
            //db.endTransaction();

        } catch (Exception e) {
            Log.e("ERROR_CREAR_TABLAS", "Error doInBackground():" + e);
            e.printStackTrace();

        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        ////db.beginTransaction();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FABRICANTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBCATEGORIA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODALIDAD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSODET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONVOCATORIA);
        //db.endTransaction();
        onCreate(db);
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

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPathDb = DB_PATH;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPathDb, null, SQLiteDatabase.CREATE_IF_NECESSARY);
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
    */
    public void addHandler(area a) {
        SQLiteDatabase db = this.getWritableDatabase();
        ////db.beginTransaction();
        ContentValues v = new ContentValues();
        v.put(ID_A, a.getId_area()); // Id
        v.put(NAME_A, a.getArea());   // Name

        // Inserting Row
        db.insert(TABLE_AREA, null, v);
        //db.endTransaction();
        //db.close(); // Closing database connection
    }

    public void addHandler(categoria c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ////db.beginTransaction();
        ContentValues v = new ContentValues();
        v.put(ID_C, c.getId_categoria()); // Id
        v.put(NAME_C, c.getCategoria());   // Name
        v.put(ID_A, c.getId_area());        // Id area

        // Inserting Row
        db.insert(TABLE_CATEGORIA, null, v);
        //db.endTransaction();
//        db.close(); // Closing database connection
    }

    public void addHandler(convocatoria con) {
        SQLiteDatabase db = this.getWritableDatabase();
        ////db.beginTransaction();
        ContentValues v = new ContentValues();
        v.put(ID_CO, con.getId()); // Id
        v.put(NAME_CO, con.getSku()); // Name
        v.put("cas_inicio", con.getInicio().toString()); // Inicio date
        v.put("cas_horario", con.getHorario());
        v.put("cas_modalidad", con.getModalidad());
        // Inserting Row
        db.insert(TABLE_CONVOCATORIA, null, v);
        //db.endTransaction();
        //db.close(); // Closing database connection
    }

    public void addHandler(curso cu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ////db.beginTransaction();
        ContentValues v = new ContentValues();
        v.put("cas_area", cu.getArea()); // Id
        v.put("cas_categoria", cu.getCategoria()); // Id
        v.put("cas_subcategoria", cu.getSubcategoria()); // Id
        v.put(ID_CU, cu.getSku()); // Id
        v.put(NAME_CU, cu.getNombre()); //
        v.put("cas_duracion", cu.getDuracion()); //
        v.put("cas_formato", cu.getFormato()); //
        v.put("cas_idioma", cu.getFormato()); //
        v.put("cas_modalidad", cu.getModalidad()); //
        v.put("cas_fabricante", cu.getFabricante());   // id
        v.put("cas_nivel", cu.getNivel()); //
        v.put("cas_oficial", cu.getOficial()); //
        v.put("cas_documentacion", cu.getDocumentacion()); //
        v.put("cas_descripcion", cu.getDescripcion()); //
        v.put("cas_objetivos", cu.getObjetivos()); //
        v.put("cas_audiencia", cu.getAudiencia()); //
        v.put("cas_contenidos", cu.getContenidos()); //
        v.put("cas_pdf_curso", cu.getPdf_curso()); //
        v.put("cas_image", cu.getImage()); //
        v.put("cas_destacado", cu.getDestacado()); //

        // Inserting Row
        db.insert(TABLE_CURSO, null, v);
        //db.endTransaction();
//        db.close(); // Closing database connection
    }

    public void addHandler(cursodetallado cu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ////db.beginTransaction();
        ContentValues v = new ContentValues();
        v.put("cas_area", cu.getArea()); // Id
        v.put("cas_categoria", cu.getCategoria()); // Id
        v.put("cas_subcategoria", cu.getSubcategoria()); // Id
        v.put(ID_CU, cu.getSku()); // Id
        v.put(NAME_CU, cu.getNombre()); //
        v.put("cas_duracion", cu.getDuracion()); //
//        v.put("cas_formato", cu.getFormato()); //
//        v.put("cas_idioma", cu.getFormato()); //
        v.put("cas_modalidad", cu.getModalidad()); //
        v.put("cas_fabricante", cu.getFabricante());   // id
//        v.put("cas_nivel", cu.getNivel()); //
//        v.put("cas_oficial", cu.getOficial()); //
//        v.put("cas_documentacion", cu.getDocumentacion()); //
        v.put("cas_descripcion", cu.getDescripcion()); //
        v.put("cas_objetivos", cu.getObjetivos()); //
//        v.put("cas_audiencia", cu.getAudiencia()); //
        v.put("cas_contenidos", cu.getContenidos()); //
//        v.put("cas_pdf_curso", cu.getPdf_curso()); //
        v.put("cas_image", cu.getImage()); //
        v.put("cas_destacado", cu.getDestacado()); //

        // Inserting Row
        db.insert(TABLE_CURSODET, null, v);
        //db.endTransaction();
//        db.close(); // Closing database connection
    }

    public void addHandler(fabricante f) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues v = new ContentValues();
        v.put(ID_F, f.getId_fabricante()); // Id
        v.put(NAME_F, f.getFabricante());   // Name

        // Inserting Row
        db.insert(TABLE_FABRICANTE, null, v);
        //db.endTransaction();
//        db.close(); // Closing database connection
    }

    public void addHandler(subcategoria s) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues v = new ContentValues();
        v.put(ID_S, s.getId_subcategoria()); // Id
        v.put(NAME_S, s.getSubcategoria());   // Name
        v.put(ID_C, s.getId_categoria());        // Id

        // Inserting Row
        db.insert(TABLE_SUBCATEGORIA, null, v);
        //db.endTransaction();
        //db.close(); // Closing database connection
    }


    // Getting single contact
    // Getting single contact
    public String getFabricante(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String dato = "Fabricante";
        String CREATE_CONTACTS_TABLE;
        CREATE_CONTACTS_TABLE = "SELECT " + NAME_F + " FROM " + TABLE_FABRICANTE + " WHERE " +
                ID_F + " = " + id;
        Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
        if (cur_user.getCount() > 0) {
            cur_user.moveToFirst();
            dato = cur_user.getString(0);
        }
        return dato;
    }
    public String getArea(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String dato = "Area";
        String CREATE_CONTACTS_TABLE;
        CREATE_CONTACTS_TABLE = "SELECT " + NAME_A + " FROM " + TABLE_AREA + " WHERE " +
                ID_A + " = " + id;
        Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
        if (cur_user.getCount() > 0) {
            cur_user.moveToFirst();
            dato = cur_user.getString(0);
        }
        return dato;
    }
    public String getCategoria(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String dato = "Categoria";
        String CREATE_CONTACTS_TABLE;
        CREATE_CONTACTS_TABLE = "SELECT " + NAME_C + " FROM " + TABLE_CATEGORIA + " WHERE " +
                ID_C + " = " + id;
        Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
        if (cur_user.getCount() > 0) {
            cur_user.moveToFirst();
            dato = cur_user.getString(0);
        }
        return dato;
    }
    public String getSubcategoria(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String dato = "Subcategoria";
        String CREATE_CONTACTS_TABLE;
        CREATE_CONTACTS_TABLE = "SELECT " + NAME_S + " FROM " + TABLE_SUBCATEGORIA + " WHERE " +
                ID_S + " = " + id;
        Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
        if (cur_user.getCount() > 0) {
            cur_user.moveToFirst();
            dato = cur_user.getString(0);
        }
        return dato;
    }
    public String getConvocatoria(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String dato = "Inicio";
        String CREATE_CONTACTS_TABLE;
        CREATE_CONTACTS_TABLE = "SELECT cas_inicio FROM " + TABLE_CONVOCATORIA + " WHERE " +
                ID_CU + " = \"" + id + "\"";
        Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
        if (cur_user.getCount() > 0) {
            cur_user.moveToFirst();
            dato = cur_user.getString(0);
        }
        return dato;
    }
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
    public ArrayList<fabricante> getAllvaluesFa() {
        ArrayList<fabricante> fabricanteArrayList = new ArrayList<fabricante>();
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
                fabricanteArrayList.add(f);
            } while (cursor.moveToNext());
        }
        return fabricanteArrayList;
    }
    public ArrayList<area> getAllvaluesAr() {
        ArrayList<area> areaArrayList = new ArrayList<area>();
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
                areaArrayList.add(a);
            } while (cursor.moveToNext());
        }
        return areaArrayList;
    }
    public ArrayList<categoria> getAllvaluesCa() {
        ArrayList<categoria> categoriaArrayList = new ArrayList<categoria>();
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
                categoriaArrayList.add(c);
            } while (cursor.moveToNext());
        }
        return categoriaArrayList;
    }
    public ArrayList<subcategoria> getAllvaluesSu() {
        ArrayList<subcategoria> subcategoriaArrayList = new ArrayList<subcategoria>();
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
                subcategoriaArrayList.add(s);
            } while (cursorSu.moveToNext());
        }
        return subcategoriaArrayList;
    }
    public ArrayList<modalidad> getAllvaluesMo() {
        ArrayList<modalidad> modalidadArrayList = new ArrayList<modalidad>();
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
                modalidadArrayList.add(m);
            } while (cursor.moveToNext());
        }
        return modalidadArrayList;
    }
    public ArrayList<curso> getAllvaluesCu() {
        ArrayList<curso> cursoArrayList = new ArrayList<curso>();
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
                cu.setFormato(cursor.getString(6));
                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(8));
                cu.setFabricante(Integer.parseInt(cursor.getString(9)));
                cu.setNivel(cursor.getString(10));
                cu.setOficial(cursor.getString(11));
                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(13));
                cu.setObjetivos(cursor.getString(14));
                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(16));
                cu.setImage(cursor.getString(17));
                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(Integer.parseInt(cursor.getString(19)));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<curso> getAllvaluesCu(String nombre) {
        ArrayList<curso> cursoArrayList = new ArrayList<curso>();
        // Select All Query
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSO +
                " WHERE " + NAME_CU + " LIKE '%" + nombre + "%'";
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
                cu.setFormato(cursor.getString(6));
                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(8));
                cu.setFabricante(Integer.parseInt(cursor.getString(9)));
                cu.setNivel(cursor.getString(10));
                cu.setOficial(cursor.getString(11));
                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(13));
                cu.setObjetivos(cursor.getString(14));
                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(16));
                cu.setImage(cursor.getString(17));
                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(Integer.parseInt(cursor.getString(19)));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<curso> getAllvaluesCu(int d) {
        ArrayList<curso> cursoArrayList = new ArrayList<curso>();
        // Select All Query
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSO +
                " WHERE cas_destacado == " + d + " ";
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
                cu.setFormato(cursor.getString(6));
                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(8));
                cu.setFabricante(Integer.parseInt(cursor.getString(9)));
                cu.setNivel(cursor.getString(10));
                cu.setOficial(cursor.getString(11));
                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(13));
                cu.setObjetivos(cursor.getString(14));
                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(16));
                cu.setImage(cursor.getString(17));
                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(Integer.parseInt(cursor.getString(19)));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<cursodetallado> getAllvaluesCudet() {
        ArrayList<cursodetallado> cursoArrayList = new ArrayList<cursodetallado>();
        // Select All Query
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSODET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryCu, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                cursodetallado cu = new cursodetallado();
                cu.setArea(cursor.getString(0));
                cu.setCategoria(cursor.getString(1));
                cu.setSubcategoria(cursor.getString(2));
                cu.setSku(cursor.getString(3));
                cu.setNombre(cursor.getString(4));
                cu.setDuracion(cursor.getString(5));
                cu.setInicio(cursor.getString(6));
//                cu.setFormato(cursor.getString(6));
//                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(7));
                cu.setFabricante(cursor.getString(8));
//                cu.setNivel(cursor.getString(10));
//                cu.setOficial(cursor.getString(11));
//                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(9));
                cu.setObjetivos(cursor.getString(10));
//                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(11));
                cu.setImage(cursor.getString(12));
//                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(cursor.getString(13));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<cursodetallado> getAllvaluesCudetNom(String n) {
        ArrayList<cursodetallado> cursoArrayList = new ArrayList<cursodetallado>();
        // Select All Query
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSODET;
        selectQueryCu += " WHERE ";
        selectQueryCu += NAME_CU + " LIKE '%" + n + "%' ";
        selectQueryCu += " ORDER BY cas_inicio ASC ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryCu, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                cursodetallado cu = new cursodetallado();
                cu.setArea(cursor.getString(0));
                cu.setCategoria(cursor.getString(1));
                cu.setSubcategoria(cursor.getString(2));
                cu.setSku(cursor.getString(3));
                cu.setNombre(cursor.getString(4));
                cu.setDuracion(cursor.getString(5));
                cu.setInicio(cursor.getString(6));
//                cu.setFormato(cursor.getString(6));
//                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(7));
                cu.setFabricante(cursor.getString(8));
//                cu.setNivel(cursor.getString(10));
//                cu.setOficial(cursor.getString(11));
//                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(9));
                cu.setObjetivos(cursor.getString(10));
//                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(11));
                cu.setImage(cursor.getString(12));
//                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(cursor.getString(13));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<cursodetallado> getAllvaluesCudet(String n, String a, String c, String s, String f,
                                                       String m, int con) {
        ArrayList<cursodetallado> cursoArrayList = new ArrayList<cursodetallado>();
        // Select All Query
        int contador = 0;
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSODET;
        if (con > 0) {
            selectQueryCu += " WHERE ";
            if (n != "*") {
                selectQueryCu += NAME_CU + " LIKE '%" + n + "%' ";
                contador++;
                con--;
            }
            if (contador == 1 && con >= 1) {
                selectQueryCu = selectQueryCu + " AND ";
                contador--;
            }
            if (a != "*") {
                selectQueryCu += "cas_area = '" + a + "' ";
                contador++;
                con--;
            }
            if (contador == 1 && con >= 1) {
                selectQueryCu = selectQueryCu + " AND ";
                contador--;
            }
            if (c != "*") {
                selectQueryCu += "cas_categoria = '" + c + "' ";
                contador++;
                con--;
            }
            if (contador == 1 && con >= 1) {
                selectQueryCu = selectQueryCu + " AND ";
                contador--;
            }
            if (s != "*") {
                selectQueryCu += "cas_subcategoria = '" + s + "' ";
                contador++;
                con--;
            }
            if (contador == 1 && con >= 1) {
                selectQueryCu = selectQueryCu + " AND ";
                contador--;
            }
            if (f != "*") {
                selectQueryCu += "cas_fabricante =  '" + f + "'";
                contador++;
                con--;
            }
            if (contador == 1 && con >= 1) {
                selectQueryCu = selectQueryCu + " AND ";
            }
            if (m != "*") {
                selectQueryCu += "cas_modalidad = '" + m + "' ";
                contador++;
                con--;
            }
        }
        selectQueryCu += " ORDER BY cas_inicio ASC ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryCu, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                cursodetallado cu = new cursodetallado();
                cu.setArea(cursor.getString(0));
                cu.setCategoria(cursor.getString(1));
                cu.setSubcategoria(cursor.getString(2));
                cu.setSku(cursor.getString(3));
                cu.setNombre(cursor.getString(4));
                cu.setDuracion(cursor.getString(5));
                cu.setInicio(cursor.getString(6));
//                cu.setFormato(cursor.getString(6));
//                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(7));
                cu.setFabricante(cursor.getString(8));
//                cu.setNivel(cursor.getString(10));
//                cu.setOficial(cursor.getString(11));
//                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(9));
                cu.setObjetivos(cursor.getString(10));
//                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(11));
                cu.setImage(cursor.getString(12));
//                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(cursor.getString(13));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<cursodetallado> getAllvaluesCudet(String n, String d) {
        ArrayList<cursodetallado> cursoArrayList = new ArrayList<cursodetallado>();
        // Select All Query
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSODET + " WHERE " +
                "cas_destacado = '" + d + "' AND " +
                NAME_CU + " LIKE '%" + n + "%' ORDER BY cas_inicio ASC " ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryCu, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                cursodetallado cu = new cursodetallado();
                cu.setArea(cursor.getString(0));
                cu.setCategoria(cursor.getString(1));
                cu.setSubcategoria(cursor.getString(2));
                cu.setSku(cursor.getString(3));
                cu.setNombre(cursor.getString(4));
                cu.setDuracion(cursor.getString(5));
                cu.setInicio(cursor.getString(6));
//                cu.setFormato(cursor.getString(6));
//                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(7));
                cu.setFabricante(cursor.getString(8));
//                cu.setNivel(cursor.getString(10));
//                cu.setOficial(cursor.getString(11));
//                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(9));
                cu.setObjetivos(cursor.getString(10));
//                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(11));
                cu.setImage(cursor.getString(12));
//                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(cursor.getString(13));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<cursodetallado> getAllvaluesCudet(String d) {
        ArrayList<cursodetallado> cursoArrayList = new ArrayList<cursodetallado>();
        // Select All Query
        String selectQueryCu = "SELECT  * FROM " + TABLE_CURSODET + " WHERE " +
                "cas_destacado = \"" + d + "\" ORDER BY cas_inicio ASC ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryCu, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                cursodetallado cu = new cursodetallado();
                cu.setArea(cursor.getString(0));
                cu.setCategoria(cursor.getString(1));
                cu.setSubcategoria(cursor.getString(2));
                cu.setSku(cursor.getString(3));
                cu.setNombre(cursor.getString(4));
                cu.setDuracion(cursor.getString(5));
                cu.setInicio(cursor.getString(6));
//                cu.setFormato(cursor.getString(6));
//                cu.setIdioma(cursor.getString(7));
                cu.setModalidad(cursor.getString(7));
                cu.setFabricante(cursor.getString(8));
//                cu.setNivel(cursor.getString(10));
//                cu.setOficial(cursor.getString(11));
//                cu.setDocumentacion(cursor.getString(12));
                cu.setDescripcion(cursor.getString(9));
                cu.setObjetivos(cursor.getString(10));
//                cu.setAudiencia(cursor.getString(15));
                cu.setContenidos(cursor.getString(11));
                cu.setImage(cursor.getString(12));
//                cu.setPdf_curso(cursor.getString(18));
                cu.setDestacado(cursor.getString(13));
                cursoArrayList.add(cu);
            } while (cursor.moveToNext());
        }
        return cursoArrayList;
    }
    public ArrayList<convocatoria> getAllvaluesCo() {
        ArrayList<convocatoria> convocatoriaArrayList = new ArrayList<convocatoria>();
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
//                co.setInicio(Date.valueOf(cursor.getString(2)));
                co.setInicio(cursor.getString(2));
                co.setHorario(cursor.getString(3));
                co.setLugar(cursor.getString(4));
                co.setModalidad(cursor.getString(5));
                convocatoriaArrayList.add(co);
            } while (cursor.moveToNext());
        }
        return convocatoriaArrayList;
    }

    public List<String> getAllAr() {
        List<String> list = new ArrayList<String>();
        list.add("Todo");
        // Select All Query
        String selectQueryMo = "SELECT " + NAME_A + " FROM " + TABLE_AREA +
                " ORDER BY " + NAME_A + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryMo, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public List<String> getAllCa() {
        List<String>list = new ArrayList<String>();
        list.add("Todo");
        // Select All Query
        String selectQueryMo = "SELECT "+ NAME_C + " FROM " + TABLE_CATEGORIA +
                " ORDER BY " + NAME_C + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryMo, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public List<String> getAllSu() {
        List<String> list = new ArrayList<String>();
        list.add("Todo");
        // Select All Query
        String selectQueryMo = "SELECT " + NAME_S + " FROM " + TABLE_SUBCATEGORIA +
                " ORDER BY " + NAME_S + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryMo, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public List<String> getAllFa() {
        List<String> list = new ArrayList<String>();
        list.add("Todo");
        // Select All Query
        String selectQueryMo = "SELECT " + NAME_F + " FROM " + TABLE_FABRICANTE +
                " ORDER BY " + NAME_F + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryMo, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public List<String> getAllMo() {
        List<String> list = new ArrayList<String>();
        list.add("Todo");
        // Select All Query
        String selectQueryMo = "SELECT " + NAME_M + " FROM " + TABLE_MODALIDAD +
                " ORDER BY " + NAME_M + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQueryMo, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return list;
    }
    // Loading single record
    public void load(fabricante f) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_F + " FROM " + TABLE_FABRICANTE + " WHERE " + ID_F + " = " + f.getId_fabricante();
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(f);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_FABRICANTE + "("
                        + ID_F + "," + NAME_F + ") VALUES(" +
                        f.getId_fabricante() + ",\"" + f.getFabricante() + "\")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load fabricante =" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(area a) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_A + " FROM " + TABLE_AREA + " WHERE " + ID_A +
                    " = " + a.getId_area();
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(a);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_AREA + "("
                        + ID_A + "," + NAME_A + ") VALUES(" +
                        a.getId_area() + ",\"" + a.getArea() + "\")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                ////db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load area =" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(categoria c) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_C + " FROM " + TABLE_CATEGORIA + " WHERE " +
                    ID_C + " = " + c.getId_categoria();
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(c);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_CATEGORIA + "("
                        + ID_C + "," + NAME_C + "," + ID_A + ") VALUES(" +
                        c.getId_categoria() + ",\"" + c.getCategoria() + "\"," + c.getId_area() + ")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load categoria =" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(subcategoria s) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_S + " FROM " + TABLE_SUBCATEGORIA + " WHERE " +
                    ID_S + " = " + s.getId_subcategoria();
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(s);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_SUBCATEGORIA + "("
                        + ID_S + "," + NAME_S + "," + ID_C + ") VALUES(" +
                        s.getId_subcategoria() + ",\"" + s.getSubcategoria() + "\"," + s.getId_categoria() + ")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load subcategoria =" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(curso cu) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_CU + " FROM " + TABLE_CURSO + " WHERE " +
                    ID_CU + " = \"" + cu.getSku() + "\"";
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(cu);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_CURSO + "(cas_area, cas_categoria," +
                        " cas_subcategoria, " + ID_CU + "," + NAME_CU + ", cas_duracion, cas_formato, " +
                        "cas_idioma, cas_modalidad, cas_fabricante, cas_nivel, cas_oficial, " +
                        "cas_documentacion, cas_descripcion, cas_objetivos, cas_audiencia, " +
                        "cas_contenidos, cas_image, cas_pdf_curso, cas_destacado) VALUES(" +
                        cu.getArea() + "," + cu.getCategoria() + "," + cu.getSubcategoria() + ",\"" +
                        cu.getSku() + "\",\"" + cu.getNombre() + "\"," + cu.getDuracion() + ",\"" +
                        cu.getFormato() + "\",\"" + cu.getIdioma() + "\",\"" + cu.getModalidad() + "\"," +
                        cu.getFabricante() + ",\"" + cu.getNivel() + "\",\"" + cu.getOficial() + "\",\"" +
                        cu.getDocumentacion() + "\",\"" + cu.getDescripcion() + "\",\"" + cu.getObjetivos() + "\",\"" +
                        cu.getAudiencia() + "\",\"" + cu.getContenidos() + "\",\"" + cu.getImage() + "\",\"" +
                        cu.getPdf_curso() + "\"," + cu.getDestacado() + ")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load curso =" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(cursodetallado cudet) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_CU + " FROM " + TABLE_CURSODET + " WHERE " +
                    ID_CU + " = \"" + cudet.getSku() + "\"";
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(cudet);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_CURSODET + "(cas_area, cas_categoria," +
                        " cas_subcategoria, " + ID_CU + "," + NAME_CU + ", cas_duracion, " +
                        "cas_inicio, cas_modalidad, cas_fabricante, " +
                        "cas_descripcion, cas_objetivos, " +
                        "cas_contenidos, cas_image, cas_destacado) VALUES(\"" +
                        cudet.getArea() + "\",\"" + cudet.getCategoria() + "\",\"" +
                        cudet.getSubcategoria() + "\",\"" +
                        cudet.getSku() + "\",\"" + cudet.getNombre() + "\",\"" +
                        cudet.getDuracion() + "\",\"" + cudet.getInicio() + "\",\"" +
                        cudet.getModalidad() + "\",\"" +
                        cudet.getFabricante() + "\",\"" +
                        cudet.getDescripcion() + "\",\"" + cudet.getObjetivos() + "\",\"" +
                        cudet.getContenidos() + "\",\"" + cudet.getImage() + "\",\"" +
                        cudet.getDestacado() + "\")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load cursodetallado =" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(convocatoria co) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_CO + " FROM " + TABLE_CONVOCATORIA + " WHERE " +
                    ID_CO + " = " + co.getId();
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(co);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
/*                String date = "";
                try {
                    SimpleDateFormat curFormater = new SimpleDateFormat("yyyy/MM/dd");
                    Date dateObj = (Date) curFormater.parse((String) co.getInicio());
                    SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");
                    date = postFormater.format(dateObj);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                */
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_CONVOCATORIA + "(" +
                        ID_CO + "," + NAME_CO + ", cas_inicio, cas_horario, " +
                        "cas_lugar, cas_modalidad) VALUES(" +
//                        co.getId() + ",\"" + co.getSku() + "\"," + date + ",\"" +
                        co.getId() + ",\"" + co.getSku() + "\",\"" + co.getInicio() + "\",\"" +
                        co.getHorario() + "\",\"" + co.getLugar() + "\",\"" + co.getModalidad() + "\")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load convocatoria =" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(modalidad m) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.beginTransaction();
            String CREATE_CONTACTS_TABLE;
            CREATE_CONTACTS_TABLE = "SELECT " + ID_M + " FROM " + TABLE_MODALIDAD + " WHERE " +
                    ID_M + " = " + m.getId_modalidad();
            Cursor cur_user = db.rawQuery( CREATE_CONTACTS_TABLE, null);
            //db.endTransaction();
            if (cur_user.getCount() > 0) {
                this.update(m);
                /*
                CREATE_CONTACTS_TABLE = "UPDATE " + TABLE_AREA + " SET " +
                        NAME_A + " = " + a.getArea() + "\" WHERE " + ID_A + "=" +
                        a.getId_area();
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.close();
                */
            } else {
                //db.beginTransaction();
                CREATE_CONTACTS_TABLE = "INSERT INTO " + TABLE_MODALIDAD + "("
                        + ID_M + "," + NAME_M + ") VALUES(" +
                        m.getId_modalidad() + ",\"" + m.getModalidad() + "\")";
                db.execSQL(CREATE_CONTACTS_TABLE);
                //db.endTransaction();
                //db.close();
            }
        } catch (Exception e) {
            Log.d("ERROR", "Load modalidad =" + e.getMessage());
            e.printStackTrace();
        }
    }
    // load all
    public void loadAllF(ArrayList<fabricante> fabricanteArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < fabricanteArrayList.size();i++) {
            // updating single record
            load(fabricanteArrayList.get(i));
        }
    }
    public void loadAllA(ArrayList<area> areaArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < areaArrayList.size();i++) {
            // updating single record
            load(areaArrayList.get(i));
        }
    }
    public void loadAllC(ArrayList<categoria> categoriaArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < categoriaArrayList.size();i++) {
            // updating single record
            load(categoriaArrayList.get(i));
        }
    }
    public void loadAllS(ArrayList<subcategoria> subcategoriaArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < subcategoriaArrayList.size();i++) {
            // updating single record
            load(subcategoriaArrayList.get(i));
        }
    }
    public void loadAllCu(ArrayList<curso> cursoArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 0; i < cursoArrayList.size(); i++) {
            // updating single record
            load(cursoArrayList.get(i));
        }
    }
    public void loadAllCudet(ArrayList<cursodetallado> cursodetalladosArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < cursodetalladosArrayList.size();i++) {
            // updating single record
            load(cursodetalladosArrayList.get(i));
        }
    }
    public void loadAllCo(ArrayList<convocatoria> convocatoriaArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < convocatoriaArrayList.size();i++) {
            // updating single record
            load(convocatoriaArrayList.get(i));
        }
    }
    public void loadAllM(ArrayList<modalidad> modalidadArrayList) {
//        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < modalidadArrayList.size();i++) {
            // updating single record
            load(modalidadArrayList.get(i));
        }
    }
    // Updating single record
    public boolean update(fabricante f) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(ID_F, f.getId_fabricante());
        args.put(NAME_F, f.getFabricante());
        // updating row
        boolean r = db.update(TABLE_FABRICANTE, args, ID_F + " = " + f.getId_fabricante(), null) > 0;
        //db.endTransaction();
        return r;
    }
    public boolean update(area a) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(ID_A, a.getId_area());
        args.put(NAME_A, a.getArea());
        // updating row
        boolean r = db.update(TABLE_AREA, args, ID_A + " = " + a.getId_area(), null) > 0;
        //db.endTransaction();
        return r;
    }
    public boolean update(categoria c) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(ID_C, c.getId_categoria());
        args.put(NAME_C, c.getCategoria());
        args.put(ID_A, c.getId_area());
        // updating row
        boolean r = db.update(TABLE_CATEGORIA, args, ID_C + " = " + c.getId_categoria(), null) > 0;
        //db.endTransaction();
        return r;
    }
    public boolean update(subcategoria s) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(ID_S, s.getId_subcategoria());
        args.put(NAME_S, s.getSubcategoria());
        args.put(ID_C, s.getId_categoria());
        // updating row
        boolean r = db.update(TABLE_SUBCATEGORIA, args, ID_S + " = " + s.getId_subcategoria(), null) > 0;
        //db.endTransaction();
        return r;
    }
    public boolean update(curso cu) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
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
        boolean r = db.update(TABLE_CURSO, args, ID_CU + " = " + cu.getSku(), null) > 0;
        //db.endTransaction();
        return r;
    }
    public boolean update(cursodetallado cu) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues args = new ContentValues();
        args.put("cas_area", cu.getArea());
        args.put("cas_categoria", cu.getCategoria());
        args.put("cas_subcategoria", cu.getSubcategoria());
        args.put(ID_CU, cu.getSku());
        args.put(NAME_CU, cu.getNombre());
        args.put("cas_duracion", cu.getDuracion());
        args.put("cas_inicio", cu.getInicio());
//        args.put("cas_formato", cu.getFormato());
//        args.put("cas_idioma", cu.getIdioma());
        args.put("cas_modalidad", cu.getModalidad());
        args.put("cas_fabricante", cu.getFabricante());
//        args.put("cas_nivel", cu.getNivel());
//        args.put("cas_oficial", cu.getOficial());
//        args.put("cas_documentacion", cu.getDocumentacion());
        args.put("cas_descripcion", cu.getDescripcion());
        args.put("cas_objetivos", cu.getObjetivos());
//        args.put("cas_audiencia", cu.getAudiencia());
        args.put("cas_contenidos", cu.getContenidos());
        args.put("cas_image", cu.getImage());
//        args.put("cas_pdf_curso", cu.getPdf_curso());
        args.put("cas_destacado", cu.getDestacado());
        // updating row
        boolean r = db.update(TABLE_CURSODET, args, ID_CU + " = " + cu.getSku(), null) > 0;
        //db.endTransaction();
        return r;
    }
    public boolean update(convocatoria co) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(ID_CO, co.getId());
        args.put(NAME_CO, co.getSku());
        args.put("cas_inicio", valueOf(co.getInicio()));
        args.put("cas_horario", co.getHorario());
        args.put("cas_lugar", co.getLugar());
        args.put("cas_modalidad", co.getModalidad());
        // updating row
        boolean r = db.update(TABLE_CONVOCATORIA, args, ID_CO + " = " + co.getId(), null) > 0;
        //db.endTransaction();
        return r;
    }
    public boolean update(modalidad m) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(ID_M, m.getId_modalidad());
        args.put(NAME_M, m.getModalidad());
        // updating row
        boolean r = db.update(TABLE_MODALIDAD, args, ID_M + " = " + m.getId_modalidad(), null) > 0;
        //db.endTransaction();
        return r;
    }
    // Updating every record
    public void updateAllF(ArrayList<fabricante> fabricanteArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < fabricanteArrayList.size();i++) {
            // updating single record
            update(fabricanteArrayList.get(i));
        }
    }
    public void updateAllA(ArrayList<area> areaArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < areaArrayList.size();i++) {
            // updating single record
            update(areaArrayList.get(i));
        }
    }
    public void updateAllC(ArrayList<categoria> categoriaArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < categoriaArrayList.size();i++) {
            // updating single record
            update(categoriaArrayList.get(i));
        }
    }
    public void updateAllS(ArrayList<subcategoria> subcategoriaArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < subcategoriaArrayList.size();i++) {
            // updating single record
            update(subcategoriaArrayList.get(i));
        }
    }
    public void updateAllCu(ArrayList<curso> cursoArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < cursoArrayList.size();i++) {
            // updating single record
            update(cursoArrayList.get(i));
        }
    }
    public void updateAllCudet(ArrayList<cursodetallado> cursoArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < cursoArrayList.size();i++) {
            // updating single record
            update(cursoArrayList.get(i));
        }
    }
    public void updateAllCo(ArrayList<convocatoria> convocatoriaArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < convocatoriaArrayList.size();i++) {
            // updating single record
            update(convocatoriaArrayList.get(i));
        }
    }
    public void updateAllM(ArrayList<modalidad> modalidadArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0;i < modalidadArrayList.size();i++) {
            // updating single record
            update(modalidadArrayList.get(i));
        }
    }
    public boolean deleteAreaHandler(int ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_AREA + " WHERE " + ID_A + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        area a = new area();
        if (cursor.moveToFirst()) {
            a.setId_area(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_AREA, ID_A + "=?", new String[] {
                    String.valueOf(a.getId_area()) });
            cursor.close();
            r = true;
        }
        //db.close();
        //db.endTransaction();
        return r;
    }
    public boolean deleteCategoriaHandler(int ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_CATEGORIA + " WHERE " + ID_C + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        categoria a = new categoria();
        if (cursor.moveToFirst()) {
            a.setId_categoria(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_CATEGORIA, ID_C + "=?", new String[] {
                    String.valueOf(a.getId_categoria()) });
            cursor.close();
            r = true;
        }
        // db.close();
        //db.endTransaction();
        return r;
    }
    public boolean deleteConvocatoriaHandler(int ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_CONVOCATORIA + " WHERE " + ID_CO + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        convocatoria a = new convocatoria();
        if (cursor.moveToFirst()) {
            a.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_CONVOCATORIA, ID_CO + "=?", new String[] {
                    String.valueOf(a.getId()) });
            cursor.close();
            r = true;
        }
        //db.close();
        //db.endTransaction();
        return r;
    }
    public boolean deleteCursoHandler(String ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_CURSO + " WHERE " + ID_CU + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        curso a = new curso();
        if (cursor.moveToFirst()) {
            a.setSku(cursor.getString(3));
            db.delete(TABLE_CURSO, ID_CU + "=?", new String[] {
                    String.valueOf(a.getSku()) });
            cursor.close();
            r = true;
        }
//        db.close();
        //db.endTransaction();
        return r;
    }
    boolean deleteCursodetalladoHandler(String ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_CURSODET + " WHERE " + ID_CU + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        cursodetallado a = new cursodetallado();
        if (cursor.moveToFirst()) {
            a.setSku(cursor.getString(3));
            db.delete(TABLE_CURSODET, ID_CU + "=?", new String[] {
                    String.valueOf(a.getSku()) });
            cursor.close();
            r = true;
        }
//        db.close();
        //db.endTransaction();
        return r;
    }
    public boolean deleteFabricanteHandler(int ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_FABRICANTE + " WHERE " + ID_F + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        fabricante a = new fabricante();
        if (cursor.moveToFirst()) {
            a.setId_fabricante(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_FABRICANTE, ID_F + "=?", new String[] {
                    String.valueOf(a.getId_fabricante()) });
            cursor.close();
            r = true;
        }
        //db.close();
        //db.endTransaction();
        return r;
    }
    boolean deletemodalidadHandler(int ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_MODALIDAD + " WHERE " + ID_M + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        modalidad a = new modalidad();
        if (cursor.moveToFirst()) {
            a.setId_modalidad(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_MODALIDAD, ID_M + "=?", new String[] {
                    String.valueOf(a.getId_modalidad()) });
            cursor.close();
            r = true;
        }
//        db.close();
        //db.endTransaction();
        return r;
    }
    boolean deleteSubcategoriaHandler(int ID) {
        boolean r = false;
        String query = "Select * FROM " + TABLE_SUBCATEGORIA + " WHERE " + ID_S + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        Cursor cursor = db.rawQuery(query, null);
        subcategoria a = new subcategoria();
        if (cursor.moveToFirst()) {
            a.setId_subcategoria(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_SUBCATEGORIA, ID_S + "=?", new String[] {
                    String.valueOf(a.getId_subcategoria()) });
            cursor.close();
            r = true;
        }
        //db.close();
        //db.endTransaction();
        return r;
    }
    public void deleteAllCursodetalladoHandler() {
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();
        //db.beginTransaction();
        String query = "DELETE FROM " + TABLE_CURSODET;
        db.execSQL(query);
        //db.endTransaction();
    }
}