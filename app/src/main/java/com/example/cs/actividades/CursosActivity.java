package com.example.cs.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.Manifest;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs.MainActivity;
import com.example.cs.R;
import com.example.cs.bbdd.DatabaseHandler;
import com.example.cs.fragmentos.CursosListAdapter;
import com.example.cs.fragmentos.CursosDetalladosFragment;
import com.example.cs.fragmentos.FragmentAdapter;
import com.example.cs.modelos.area;
import com.example.cs.modelos.categoria;
import com.example.cs.modelos.convocatoria;
import com.example.cs.modelos.curso;
import com.example.cs.modelos.cursodetallado;
import com.example.cs.modelos.cursos;
import com.example.cs.modelos.fabricante;
import com.example.cs.modelos.modalidad;
import com.example.cs.modelos.subcategoria;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CursosActivity extends AppCompatActivity {

    public static DatabaseHandler dbh;
    private Context mContext;

    public Context getmContext() {
        return mContext;
    }

    private Button b_buscar;
    private Button b_anterior;
    private Button b_posterior;
    private Button b_ver;
    //    private Button b_start;
    private TextView tv_estado;
    private Spinner spinner_01;
    private Spinner spinner_02;
    private Spinner spinner_03;
    private Spinner spinner_04;
    private Spinner spinner_05;

    private Uri uri;
    //private PlayerTask buscarerTask;
    private String [] stringsFabricantes;
    private String [] stringsAreas;
    private String [] stringsCategorias;
    private String [] stringsSubcategorias;
    private String [] stringsModalidades;

    private boolean prepared = false;
    private boolean started = false;
    private boolean start = false;
    //    private boolean change = false;
    private boolean checked_01 = false;
    private boolean checked_02 = false;
    private boolean checked_03 = false;
    private boolean checked_04 = false;
    private boolean checked_05 = false;

//    private RadioGroup radioGroupButton;
//    private int radioButtonID;
//    private View vRadioButton;
//    private int idx;
//    private int idxFrequency;
//    private RadioButton mRadioButton;

    private int vis = 0;
    private String stringFabricante;
    private String stringArea;
    private String stringCategoria;
    private String stringSubcategoria;
    private String stringModalidad;
    private String inicio;
    private String detallado;
    //private String stream;
    //private String stream = "http://provisioning.streamtheworld.com/pls/M80RADIO.pls"; // M80 Pop

//    private static final String TAG = "AudioFxDemo";

    private static final float VISUALIZER_HEIGHT_DIP = 50f;


    private float density = 70f;
    //    private float volLeft = 0f;
    //   private float volRight = 0f;
//    private float vol = 0f;

    private TextView mStatusTextView;


    private Button submit;

    // BaseActivity
    private boolean botonInformacion;

    private static int ini=0;
    private static int iniAnt=0;
    private static int cont=0;
    private static String nombreBuscar ;

    private ArrayList<area> arrayArea = new ArrayList<area>();
    private ArrayList<categoria> arrayCategoria = new ArrayList<categoria>();
    private ArrayList<convocatoria> arrayConvocatoria = new ArrayList<convocatoria>();
    private ArrayList<curso> arrayCurso = new ArrayList<curso>();
    public static ArrayList<cursodetallado> arrayCursodetallado = new ArrayList<cursodetallado>();
    public static ArrayList<cursodetallado> arrayCursodetalladoView = new ArrayList<cursodetallado>();
    private ArrayList<fabricante> arrayFabricante = new ArrayList<fabricante>();
    private ArrayList<modalidad> arrayModalidad = new ArrayList<modalidad>();
    private ArrayList<subcategoria> arraySubcategoria = new ArrayList<subcategoria>();
    private List<String> arrayLabels = null;

    public static int arrayPosicion = 0;
    public static int arrayPosicionReal = 0;
    public static int arrayPosicionFin = 0;
    public static String arrayDescripcion = "";
    public static String arrayObjetivos = "";
    public static String arrayContenidos = "";
    public static String arraySku = "";
    public static String arrayNombre = "";

    public FragmentAdapter pagerAdapter;
    public ViewPager viewPager;
    public ListView lista;
    public CursosListAdapter adapterCudet;
//    Context context = null;
/*
    public static curso getCursoActual ()
    {
        return cur;
    }
    public static cursos getCursosActual ()
    {
        return curs;
    }
*/
// Fin BaseActivity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            ini = 0;
            iniAnt = 0;
            cont = 0;
            // pantalla solo horizontal OK
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setContentView(R.layout.activity_cursos);
            lista = findViewById(R.id.listView1);

//            context = this.context;
// load resources
            dbh = MainActivity.dbh;
            arrayArea = dbh.getAllvaluesAr();
            arrayCategoria = dbh.getAllvaluesCa();
            arraySubcategoria = dbh.getAllvaluesSu();
            arrayFabricante = dbh.getAllvaluesFa();
            arrayConvocatoria = dbh.getAllvaluesCo();
            arrayCurso = dbh.getAllvaluesCu();
            arrayModalidad = dbh.getAllvaluesMo();


// fin load resources
/*
// BaseActivity
            if (getLayout() != 0) {
                setContentView(getLayout());
            } else {
                throw new NullPointerException("Provide layout file for the activity");
            }
            //setActionBar();
            //initialize();
// Fin BaseActivity
*/
            //setContentView(R.layout.activity_audio_effects);
            // frequencies
            //mLinearLayoutFrequency = (LinearLayout)findViewById(R.id.linear_layout_equalizer);
            //ArrayAdapter<CharSequence> frequencyAdapter = ArrayAdapter.createFromResource(this,R.array.opciones_frequencies,android.R.layout.select_dialog_item);
            //frequencyAdapter.setDropDownViewResource(android.R.layout.expandable_list_content);
            // spinner
            // 01 fabricantes
            //ib_buscar_pause_01 = (ImageButton)findViewById(R.id.image_button_buscar_01);
            spinner_01 = (Spinner)findViewById(R.id.action_bar_spinner_fabricante);
            arrayLabels = dbh.getAllFa();
            ArrayAdapter<String> adapter01 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayLabels);
            adapter01.setDropDownViewResource(R.layout.textview_with_background);
            spinner_01.setAdapter(adapter01);
            //spinner.setOnItemSelectedListener(this) ;
            stringsFabricantes = new String[arrayLabels.size()];
            for (int i=0;i<arrayLabels.size();i++) {
                stringsFabricantes[i] = arrayLabels.get(i);
            }
//            stringsFabricantes = getResources().getStringArray(R.array.opciones_fabricantes);
            spinner_01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //Object item = parent.getItemAtPosition(position);
                    String text = parent.getItemAtPosition(position).toString();
//                    Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
                    //stream = urls[position];
                    stringFabricante = stringsFabricantes[position];
                    checked_01 = true;

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    checked_01 = false;
                }
            });
            // 02 areas
            // image button
            //ib_buscar_pause_02 = (ImageButton)findViewById(R.id.image_button_buscar_02);
            spinner_02 = (Spinner)findViewById(R.id.action_bar_spinner_area);
            arrayLabels = dbh.getAllAr();
            ArrayAdapter<String> adapter02 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayLabels);
            adapter02.setDropDownViewResource(R.layout.textview_with_background0);
            spinner_02.setAdapter(adapter02);
            //spinner.setOnItemSelectedListener(this) ;
            stringsAreas = new String[arrayLabels.size()];
            for (int i=0;i<arrayLabels.size();i++) {
                stringsAreas[i] = arrayLabels.get(i);
            }
            //stringsAreas = getResources().getStringArray(R.array.opciones_areas);
            spinner_02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //Object item = parent.getItemAtPosition(position);
                    String text = parent.getItemAtPosition(position).toString();
                    //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
                    //stream = urls[position];
                    stringArea = stringsAreas[position];
                    checked_02 = true;

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    checked_02 = false;
                }
            });
            // 03 categorias
            //ib_buscar_pause_03 = (ImageButton)findViewById(R.id.image_button_buscar_03);
            spinner_03 = (Spinner)findViewById(R.id.action_bar_spinner_categoria);
            arrayLabels = dbh.getAllCa();
            ArrayAdapter<String> adapter03 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayLabels);
//            ArrayAdapter<CharSequence> adapter03 = ArrayAdapter.createFromResource(this, R.array.opciones_categorias, R.layout.textview_with_background);
            adapter03.setDropDownViewResource(R.layout.textview_with_background);
            spinner_03.setAdapter(adapter03);
            //spinner.setOnItemSelectedListener(this) ;
            stringsCategorias = new String[arrayLabels.size()];
            for (int i=0;i<arrayLabels.size();i++) {
                stringsCategorias[i] = arrayLabels.get(i);
            }
//            stringsCategorias = getResources().getStringArray(R.array.opciones_categorias);
            spinner_03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //Object item = parent.getItemAtPosition(position);
                    String text = parent.getItemAtPosition(position).toString();
//                    Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
                    //stream = urls[position];
                    stringCategoria = stringsCategorias[position];
                    checked_03 = true;

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    checked_03 = false;
                }
            });
            // 03 subcategorias
            //ib_buscar_pause_04 = (ImageButton)findViewById(R.id.image_button_buscar_04);
            spinner_04 = (Spinner)findViewById(R.id.action_bar_spinner_subcategoria);
            arrayLabels = dbh.getAllSu();
            ArrayAdapter<String> adapter04 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayLabels);
//            ArrayAdapter<CharSequence> adapter04 = ArrayAdapter.createFromResource(this, R.array.opciones_subcategorias, R.layout.textview_with_background0);
            adapter04.setDropDownViewResource(R.layout.textview_with_background0);
            spinner_04.setAdapter(adapter04);
            //spinner.setOnItemSelectedListener(this) ;
            stringsSubcategorias = new String[arrayLabels.size()];
            for (int i=0;i<arrayLabels.size();i++) {
                stringsSubcategorias[i] = arrayLabels.get(i);
            }
//            stringsSubcategorias = getResources().getStringArray(R.array.opciones_subcategorias);
            spinner_04.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //Object item = parent.getItemAtPosition(position);
                    String text = parent.getItemAtPosition(position).toString();
//                    Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
                    //stream = urls[position];
                    stringSubcategoria = stringsSubcategorias[position];
                    checked_04 = true;

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    checked_04 = false;
                }
            });
            spinner_05 = (Spinner)findViewById(R.id.action_bar_spinner_modalidad);
            arrayLabels = dbh.getAllMo();
            ArrayAdapter<String> adapter05 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayLabels);
//            ArrayAdapter<CharSequence> adapter05 = ArrayAdapter.createFromResource(this, R.array.opciones_modalidades, R.layout.textview_with_background);
//            adapter05.setDropDownViewResource(android.R.layout.simple_spinner_item);
            adapter05.setDropDownViewResource(R.layout.textview_with_background);
            spinner_05.setAdapter(adapter05);
            //spinner.setOnItemSelectedListener(this) ;
            stringsModalidades = new String[arrayLabels.size()];
            for (int i=0;i<arrayLabels.size();i++) {
                stringsModalidades[i] = arrayLabels.get(i);
            }
//            stringsModalidades = getResources().getStringArray(R.array.opciones_modalidades);
            spinner_05.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //Object item = parent.getItemAtPosition(position);
                    String text = parent.getItemAtPosition(position).toString();
//                    Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
                    //stream = urls[position];
                    stringModalidad = stringsModalidades[position];
                    checked_05 = true;

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    checked_05 = false;
                }
            });
            // otras variables de control
            b_buscar = (Button) findViewById(R.id.button_buscar);
            b_buscar.setEnabled(true);
            b_anterior = (Button) findViewById(R.id.button_up);
            b_anterior.setEnabled(true);
            b_anterior.setVisibility(View.INVISIBLE);
            b_posterior = (Button) findViewById(R.id.button_down);
            b_posterior.setEnabled(true);
            b_posterior.setVisibility(View.INVISIBLE);
//            b_ver = (Button) findViewById(R.id.button_ver);
//            b_ver.setEnabled(true);

/*            ListView lista = (ListView) findViewById(R.id.listView1);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sugerencias);
            lista.setAdapter(adapter);
*/
            //Buscar
            b_buscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    loadFragment(new GaleriaFragment());
                    arrayCursodetallado.clear();
                    EditText user = (EditText)findViewById(R.id.in_curso_nombre);
                    nombreBuscar = user.getText().toString();
//                    curs.setCursos();

                    buscarCursoNombre(  nombreBuscar,stringFabricante,stringArea,stringCategoria,stringSubcategoria,stringModalidad);
//                    viewPager.setAdapter(pagerAdapter);
//                    arrayCursodetallado = dbh.getAllvaluesCudet();
                    //lista
                    publicarLista();
                    b_anterior.setVisibility(View.INVISIBLE);
                    b_anterior.setClickable(false);
                    if (arrayPosicionFin > -1) {
                        ListView lista = (ListView) findViewById(R.id.listView1);
                        adapterCudet = new CursosListAdapter(getApplicationContext(), R.layout.fragment_cursos1, arrayCursodetalladoView);
                        lista.setAdapter(adapterCudet);
                    }
                }
            });

//                if (destacado != "") {

            //lista
            /*
            publicarLista();
//            ListView lista = (ListView) findViewById(R.id.listView1);
            if (arrayPosicionFin > -1) {
                adapterCudet = new CursosListAdapter(this, R.layout.fragment_cursos1, arrayCursodetalladoView);
                lista.setAdapter(adapterCudet);
            }
            */
            b_posterior.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                                //Toast.makeText(arrayDescripcion,arrayDescripcion,Toast.LENGTH_LONG).show();
                                Intent myIntent = new Intent(view.getContext(), NextCursosActivity.class);
                                startActivityForResult(myIntent, 0);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ERROR", "Error onCreate: " + e.getMessage());
        }

    }
    /* BaseActivity
    private void initialize() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(WRITE_EXTERNAL_STORAGE_PERMS, AUDIO_PERMISSION_REQUEST_CODE);
        }
        else {
            setPlayer();
        }
    } */


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    protected int getLayout() {
        return R.layout.activity_cursos;
    }

    /**
     * Recorta un string dado, por lo general utilizado para que el enlace web quede mas visible
     * @param dato
     * @return
     */
    private String recortarEnlace(String dato){
        String info ;
        if(dato.length()>30){
            info = dato.substring(0,25)+"...";
        }else{
            info = dato;
        }
        return info;
    }
    public void verValor(View v){
        EditText campoTexto = (EditText) findViewById(R.id.in_curso_nombre);
        Log.d("Valor ET", campoTexto.getText().toString());
    }
    public void buscarCursoNombre(String nom,String f,String a,String c,String s,String m) {
        try {
            int con = 0;
            if (nom == null || nom == "" || nom == " " ) {
                nom = "*";
            } else {
                con++;
            }
            if (f == null || f == "" || f == "Todo") {
                f = "*";
            } else {
                con++;
            }
            if (a == null || a == "" || a == "Todo") {
                a = "*";
            } else {
                con++;
            }

            if (c == null || c == "" || c == "Todo") {
                c = "*";
            } else {
                con++;
            }

            if (s == null || s == "" || s == "Todo") {
                s = "*";
            } else {
                con++;
            }

            if (m == null || m == "" || m == "Todo") {
                m = "*";
            } else {
                con++;
            }
            if (con > 0) {
                arrayCursodetallado = dbh.getAllvaluesCudet(nom, a, c, s, f, m, con);
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
                Toast.makeText(getApplicationContext(),"No ha encontrado registros",Toast.LENGTH_LONG);
                arrayPosicionFin = -1;
            }
            arrayPosicionFin = arrayCursodetallado.size()-1;
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
