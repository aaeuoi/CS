package com.example.cs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.cs.actividades.CertificadorActivity;
import com.example.cs.actividades.ConsultoriaActivity;
import com.example.cs.actividades.ContactoActivity;
import com.example.cs.actividades.NextMainActivity;
import com.example.cs.bbdd.DatabaseHandler;
import com.example.cs.fragmentos.CursosListAdapter;
import com.example.cs.fragmentos.FragmentAdapter;
import com.example.cs.fragmentos.MainDetailFragment;
import com.example.cs.actividades.ConvocatoriaActivity;
import com.example.cs.actividades.CursosActivity;
import com.example.cs.actividades.DestacadosActivity;
import com.example.cs.actividades.InfoActivity;
import com.example.cs.actividades.RRSSActivity;
import com.example.cs.modelos.area;
import com.example.cs.modelos.curso;
import com.example.cs.modelos.cursodetallado;
import com.example.cs.modelos.categoria;
import com.example.cs.modelos.subcategoria;
import com.example.cs.modelos.fabricante;
import com.example.cs.modelos.modalidad;
import com.example.cs.modelos.convocatoria;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;


import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static Object PlayerTask;
    private Context mContext = null;
    public static DatabaseHandler dbh;

    //mDbHelper.close();
    String[] sugerencias = {
            "Los más destacados:",
            "Últimas convocatorias:",
            "Certificaciones en:",
            "Consultoría y Servicios disponibles:"
    };
    private static int ini = 0;
    private static int iniAnt = 0;
    private static int contTotal = 0;
    private static int contParcial = 0;
    private static int cont = 0;
    private static cursodetallado curdet;
    private Button b_buscar;
    private Button b_anterior;
    private Button b_posterior;
    private ListView lista;

    private ArrayList<area> arrayArea = new ArrayList<area>();
    private ArrayList<categoria> arrayCategoria = new ArrayList<categoria>();
    private ArrayList<convocatoria> arrayConvocatoria = new ArrayList<convocatoria>();
    private ArrayList<curso> arrayCurso = new ArrayList<curso>();
    public static ArrayList<cursodetallado> arrayCursodetallado = new ArrayList<cursodetallado>();
    public static ArrayList<cursodetallado> arrayCursodetalladoView = new ArrayList<cursodetallado>();
    private ArrayList<fabricante> arrayFabricante = new ArrayList<fabricante>();
    private ArrayList<modalidad> arrayModalidad = new ArrayList<modalidad>();
    private ArrayList<subcategoria> arraySubcategoria = new ArrayList<subcategoria>();
    public static int arrayPosicion = 0;
    public static int arrayPosicionReal = 0;
    public static int arrayPosicionFin = 0;
    public static String arrayDescripcion = "";
    public static String arrayObjetivos = "";
    public static String arrayContenidos = "";
    public static String arraySku = "";
    public static String arrayNombre = "";
    public static String nombreBuscar = "";

    public static int[] v00 = {R.drawable.banner01,R.drawable.banner02,R.drawable.banner03};

    public CursosListAdapter adapterCudet;

    public FragmentAdapter adapterCursos;
    public ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
            mContext = getApplicationContext();
// lista a presentar
            b_buscar = (Button) findViewById(R.id.button_buscar_main);
            b_anterior = (Button) findViewById(R.id.button_up_main);
            b_posterior = (Button) findViewById(R.id.button_down_main);
            final EditText editText = (EditText) findViewById(R.id.in_curso_nombre_main);
// Navegación de opciones

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
// load resources
            for (int i = 0; i < 7; i++) {
                String[] res = getStrArrWithId("a_" + i, getApplicationContext());
                area ar = new area(i, res[1]);
                arrayArea.add(ar);
            }
            for (int i = 0; i < 10; i++) {
                String[] res = getStrArrWithId("ca_" + i, getApplicationContext());
                categoria ca = new categoria(i, res[1], parseInt(res[2]));
                arrayCategoria.add(ca);
            }
            for (int i = 0; i < 4; i++) {
                String[] res = getStrArrWithId("con_" + i, getApplicationContext());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = null;
                try {
                    date = dateFormat.parse(res[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
//            Date date = dateFormat.parse(res[2]);
                convocatoria con = new convocatoria(i, res[1], res[2], res[3], res[4], res[5]);
                arrayConvocatoria.add(con);
            }

            for (int i = 0; i < 10; i++) {
                String[] res = getStrArrWithId("cu_" + i, getApplicationContext());
                curso cu = new curso(parseInt(res[0]), parseInt(res[1]), parseInt(res[2]), res[3],
                        res[4], parseInt(res[5]), res[6], res[7], res[8], parseInt(res[9]),
                        res[10], res[11], res[12], res[13], res[14], res[15], res[16], res[17], res[18],
                        parseInt(res[19]));
                arrayCurso.add(cu);
                cursodetallado cudet = new cursodetallado(res[0], res[1], res[2], res[3],
                        res[4], res[5], "", res[8], res[9], res[13], res[14], res[16], res[17], res[19]);
                arrayCursodetallado.add(cudet);
                arrayCursodetalladoView.add(cudet);
            }

            for (int i = 0; i < 18; i++) {
                String[] res = getStrArrWithId("f_" + i, getApplicationContext());
                fabricante fa = new fabricante(i, res[1]);
                arrayFabricante.add(fa);
            }
            for (int i = 0; i < 2; i++) {
                String[] res = getStrArrWithId("m_" + i, getApplicationContext());
                modalidad mo = new modalidad(i, res[1]);
                arrayModalidad.add(mo);
            }
            for (int i = 0; i < 13; i++) {
                String[] res = getStrArrWithId("sca_" + i, getApplicationContext());
                subcategoria sca = new subcategoria(i, res[1], parseInt(res[2]));
                arraySubcategoria.add(sca);
            }
            for (int i = 0;i<arrayCursodetallado.size();i++) {
                curso cu= arrayCurso.get(i);
                cursodetallado cudet= arrayCursodetallado.get(i);
                String stringA = cu.getArea()+" area";
                for (int j = 0;j<arrayArea.size();j++) {
                    area classA = arrayArea.get(j);
                    if (cu.getArea() == classA.getId_area()) {
                        j = arrayArea.size();
                        cudet.setArea(classA.getArea());
                        stringA = classA.getArea();
                    }
                }
                cudet.setArea(stringA);
                String stringC = cu.getCategoria()+" cat";
                for (int j = 0;j<arrayCategoria.size();j++) {
                    categoria classC = arrayCategoria.get(j);
                    if (cu.getCategoria() == classC.getId_categoria()) {
                        j = arrayCategoria.size();
                        cudet.setCategoria(classC.getCategoria());
                        stringC = classC.getCategoria();
                    }
                }
                cudet.setCategoria(stringC);
                String stringS = cu.getSubcategoria()+" subcat";
                for (int j = 0;j<arraySubcategoria.size();j++) {
                    subcategoria classS = arraySubcategoria.get(j);
                    if (cu.getSubcategoria() == classS.getId_subcategoria()) {
                        j = arraySubcategoria.size();
                        cudet.setSubcategoria(classS.getSubcategoria());
                        stringS = classS.getSubcategoria();
                    }
                }
                cudet.setSubcategoria(stringS);
                String stringF = cu.getFabricante()+" fab";
                for (int j = 0;j<arrayFabricante.size();j++) {
                    fabricante classF = arrayFabricante.get(j);
                    if (cu.getFabricante() == classF.getId_fabricante()) {
                        j = arrayFabricante.size();
                        cudet.setFabricante(classF.getFabricante());
                        stringF = classF.getFabricante();
                    }
                }
                cudet.setFabricante(stringF);
                String stringI = "2019/08/25";
                for (int j = 0;j<arrayConvocatoria.size();j++) {
                    convocatoria classCon = arrayConvocatoria.get(j);
                    if (cu.getSku() == classCon.getSku()) {
                        j = arrayFabricante.size();
                        stringI = classCon.getInicio().toString();
                    }
                }
                cudet.setInicio(stringI);
                String destacado = "";
                if (cu.getDestacado()==1) { destacado = "DESTACADO"; }
                cudet.setDestacado(destacado);
                cudet.setDuracion(String.valueOf(cu.getDuracion()));
//                if (destacado != "") {
            }
// fin load resources
            // DDBB

            try {
                dbh = new DatabaseHandler(MainActivity.this);
            } catch (Exception e1) {
                Log.d("EXCEPTION", "Error 1 ="+e1.getMessage());
                e1.printStackTrace();
            }
//      BBDDAdaptador bbddAdaptador = new BBDDAdaptador(this);
//            dbh.close();
//            dbh.onOpen(dbh.getWritableDatabase());
            try {
//                dbh = this.ddbbHandler;
//                dbh.openDataBase();
                if (dbh != null) {
                    dbh.loadAllA(arrayArea);
                    dbh.loadAllC(arrayCategoria);
                    dbh.loadAllS(arraySubcategoria);
                    dbh.loadAllF(arrayFabricante);
                    dbh.loadAllCo(arrayConvocatoria);
                    dbh.loadAllCu(arrayCurso);
                    dbh.loadAllCudet(arrayCursodetallado);
                    dbh.loadAllM(arrayModalidad);
//                    dbh.close();
                } else {
                    Log.d("DATABASE", "DataBase is null");
                }

            } catch (Exception e0) {
                Log.d("EXCEPTION", "Error 0 ="+e0.getMessage());
                e0.printStackTrace();
            }
            try {
//    mDbHelper.createDatabase();
//    mDbHelper.open();

                // carga del ViewPager de jpg de prueba
                adaptarDibujosCabecera();
/*                adapterCursos = new FragmentAdapter(getSupportFragmentManager());

                mViewPager = findViewById(R.id.pagermain);
                adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(v00[0]));
                adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(v00[1]));
                adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(v00[2]));
                mViewPager.setAdapter(adapterCursos);
                */
                // fin carga del ViewPager de prueba
                // que no se vea el teclado
                // prevent system keyboard from appearing
                /*
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
                editText.setTextIsSelectable(true);
//            editText.setShowSoftInputOnFocus(false);
            } else {
                editText.setRawInputType(InputType.TYPE_NULL);
                editText.setFocusable(true);
            }
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
            */
// cargar valores en cursodetallado
            } catch (Exception e4) {
                Log.d("EXCEPTION", "Error 4 ="+e4.getMessage());
                e4.printStackTrace();
            }

            //Buscar
            b_buscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    loadFragment(new GaleriaFragment());
                adaptarDibujosCabecera();
                arrayCursodetallado.clear();
                    EditText user = (EditText)findViewById(R.id.in_curso_nombre_main);
                    nombreBuscar = user.getText().toString();
//                    curs.setCursos();

                    if (nombreBuscar != null && nombreBuscar != "") {
                        buscarCursoNombre(nombreBuscar);
                    } else {
                        buscarCursoNombre("");
                    }
                    ini = 0;
                    iniAnt = 0;
                    setContentView(R.layout.activity_main);
                    publicarLista();
                    b_anterior.setVisibility(View.INVISIBLE);
                    b_anterior.setClickable(false);
                    if (arrayPosicionFin > -1) {
                        lista = (ListView) findViewById(R.id.listView1);
                        adapterCudet = new CursosListAdapter(mContext, R.layout.fragment_content_main, arrayCursodetalladoView);
                        lista.setAdapter(adapterCudet);
                    }
                }
            });

            //lista
            buscarCursoNombre("");
            publicarLista();
            lista = (ListView) findViewById(R.id.listView1);
            adapterCudet = new CursosListAdapter(this, R.layout.fragment_content_main, arrayCursodetalladoView);
            lista.setAdapter(adapterCudet);
            // Ver detalles en la búsqueda

            b_posterior.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adaptarDibujosCabecera();
                    cont = 0;
                    arrayCursodetalladoView.clear();
                    iniAnt = ini;
                    for (int i = iniAnt;i<arrayCursodetallado.size();i++) {
                        arrayCursodetalladoView.add(arrayCursodetallado.get(i));
                        cont ++;
                        if (cont == 5) {
                            i = arrayCursodetallado.size();
                        }
                    }
                    ini = ini + cont;
//                    iniAnt = iniAnt - 5;
                    b_anterior.setVisibility(View.VISIBLE);
                    b_anterior.setClickable(true);
                    if (ini >= arrayPosicionFin) {
                        b_posterior.setVisibility(View.INVISIBLE);
                        b_posterior.setClickable(false);
                    } else {
                        b_posterior.setVisibility(View.VISIBLE);
                        b_posterior.setClickable(true);
                    }
                    if (arrayPosicionFin > -1) {
                        ListView lista = (ListView) findViewById(R.id.listView1);
                        adapterCudet = new CursosListAdapter(getApplicationContext(), R.layout.fragment_cursos1, arrayCursodetalladoView);
                        lista.setAdapter(adapterCudet);
                    }

                }
            });
            b_anterior.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adaptarDibujosCabecera();
                    cont = 0;
                    arrayCursodetalladoView.clear();
                    ini = iniAnt;
                    for (int i = ini;i<arrayCursodetallado.size();i++) {
                        cursodetallado cudet = arrayCursodetallado.get(i);
                        arrayCursodetalladoView.add(cudet);
                        cont ++;
                        if (cont == 5) {
                            i = arrayCursodetallado.size();
                        }
                    }
                    ini = ini + cont;
                    b_posterior.setVisibility(View.VISIBLE);
                    b_posterior.setClickable(true);
                    if (iniAnt <= 0) {
                        b_anterior.setVisibility(View.INVISIBLE);
                        b_anterior.setClickable(false);
                    } else {
                        b_anterior.setVisibility(View.VISIBLE);
                        b_anterior.setClickable(true);
                        iniAnt = iniAnt - 5;
                    }
                    if (arrayPosicionFin > -1) {
                        ListView lista = (ListView) findViewById(R.id.listView1);
                        adapterCudet = new CursosListAdapter(getApplicationContext(), R.layout.fragment_cursos1, arrayCursodetalladoView);
                        lista.setAdapter(adapterCudet);
                    }
                }
            });

            lista.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            try {
                                cursodetallado mycurso = (cursodetallado) parent.getItemAtPosition(position);
//                                Cursor mycursor = (Cursor) parent.getItemAtPosition(position);
                                arrayDescripcion = mycurso.getDescripcion();
                                arrayObjetivos = mycurso.getObjetivos();
                                arrayContenidos = mycurso.getContenidos();
                                arraySku = mycurso.getSku();
                                arrayNombre = mycurso.getNombre();
                                arrayContenidos = mycurso.getContenidos();
                                arrayPosicion = position;
                                arrayPosicionReal = iniAnt + position;
                                //Toast.makeText(parent.getContext(), arrayContenidos,Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(view.getContext(), NextMainActivity.class);
                                startActivityForResult(myIntent, 0);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                Log.d("EXCEPTION", "Error 3 ="+e3.getMessage());
                            }
                        }
                    }
            );
        } catch (Exception e2) {
            Log.d("EXCEPTION", "Error 2 ="+e2.getMessage());
            e2.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_cursos) {
            startActivity(new Intent(this, CursosActivity.class));
        } else if (id == R.id.nav_destacados) {
            startActivity(new Intent(this, DestacadosActivity.class));
        } else if (id == R.id.nav_convocatoria) {
            startActivity(new Intent(this, ConvocatoriaActivity.class));
        } else if (id == R.id.nav_consultoria_servicios) {
            startActivity(new Intent(this, ConsultoriaActivity.class));
        } else if (id == R.id.nav_centro_certificador) {
            startActivity(new Intent(this, CertificadorActivity.class));
        } else if (id == R.id.nav_rrss) {
            startActivity(new Intent(this, RRSSActivity.class));
        } else if (id == R.id.nav_contacto) {
            startActivity(new Intent(this, ContactoActivity.class));
        } else if (id == R.id.nav_info) {
            startActivity(new Intent(this, InfoActivity.class));


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onResume(){
        super.onResume();
        //will be executed onResume
    }
    public void verAnterior(){
    }
    public void verPosterior(){
    }
    /*
        public class LoadAreasTask extends AsyncTask<Void, Void, ArrayList<area> {
            @Override
            protected ArrayList<area> doInBackground(String... strings) {
                    area.open();
                    arrayArea = area.getAll();
                    ddbbHandler = new DatabaseHandler(this);
                    ddbbHandler.load(area);
                    if (arrayArea.size() == 0) {
                        for (int i = 0; i < 50; i++) {
                            area a = new area();
                            a.setId_area(id[i]);
                            a.setArea(nombre[i]);
                            arrayArea.add(a);
                            area.create(a);
    //                        Log.d(TAG, "area created with id " + a.getId_area() +
    //                                        ", name " + a.getArea() );
                        }
                    }
                    return arrayArea;
                }

                @Override
                protected void onPostExecute(ArrayList<area> cards) {
                    super.onPostExecute(area);
                    adapter = new SampleMaterialAdapter(SampleMaterialActivity.this,
                            cardsList, cardsData);
                    recyclerView.setAdapter(adapter);
                }
            }

        }
        */

    public  void adaptarDibujosCabecera() {
        adapterCursos = new FragmentAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.pagermain);
        adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(MainActivity.v00[0]));
        adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(MainActivity.v00[1]));
        adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(MainActivity.v00[2]));
        mViewPager.setAdapter(adapterCursos);

    }

    public void buscarCursoNombre(String nom) {
        try {
            if (nom == null || nom == "") {
                arrayCursodetallado = dbh.getAllvaluesCudet("DESTACADO");
            } else {
                arrayCursodetallado = dbh.getAllvaluesCudet(nom,"DESTACADO");
            }
            arrayPosicionFin = arrayCursodetallado.size()-1;
            ini = 0;
            iniAnt = 0;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ERROR", "Buscar = " + e.getMessage());
        }

    }
    public void publicarLista() {
        //lista
        try {
            b_anterior.setVisibility(View.INVISIBLE);
            b_anterior.setClickable(false);
            int inicio = 0;
            ini = 0;
            iniAnt = 0;
            arrayPosicionFin = arrayCursodetallado.size()-1;
            if (arrayCursodetallado.size() > 0) {
                arrayCursodetalladoView.clear();
                //lista encontrada de 5 en 5
                cont = 0;
                for (int i = inicio; i < arrayCursodetallado.size(); i++) {
                    cursodetallado cudet = arrayCursodetallado.get(i);
                    arrayCursodetalladoView.add(cudet);
                    cont++;
                    if (cont == 5) {
                        i = arrayCursodetallado.size();
                    }
                }
                ini = cont;
            } else {
                Toast.makeText(getApplicationContext(),"No ha encontrado registros", Toast.LENGTH_LONG);
                arrayPosicionFin = -1;
            }
            if (arrayCursodetallado.size() < 6) {
                b_posterior.setVisibility(View.INVISIBLE);
                b_posterior.setClickable(false);
            } else {
                if (ini <= arrayPosicionFin) {
                    b_posterior.setVisibility(View.VISIBLE);
                    b_posterior.setClickable(true);
                } else {
                    b_posterior.setVisibility(View.INVISIBLE);
                    b_posterior.setClickable(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ERROR", "publicarLista = " + e.getMessage());
        }
    }
    public String [] getStrArrWithId (String id, Context context) {
        int arrId = context.getResources().getIdentifier(id, "array", context.getPackageName());
        String[] strArr = context.getResources().getStringArray(arrId);
        return strArr;
    }
}
