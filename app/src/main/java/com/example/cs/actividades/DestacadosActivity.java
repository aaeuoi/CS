package com.example.cs.actividades;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cs.R;
import com.example.cs.fragmentos.DestacadosDetailFragment;
import com.example.cs.fragmentos.FragmentAdapter;
import com.example.cs.modelos.curso;
import com.example.cs.modelos.cursos;

public class DestacadosActivity extends AppCompatActivity {

    private Context mContext;

    public Context getmContext() {
        return mContext;
    }

    private Button b_play;
    //    private Button b_start;
    private ImageButton ib_play_pause;
    private ImageButton ib_play_pause_01;
    private ImageButton ib_play_pause_02;
    private ImageButton ib_play_pause_03;
    private ImageButton ib_play_pause_04;
    private ImageButton ib_play_pause_05;
    private Button b_end;
    private TextView tv_estado;

    private Uri uri;
    //private PlayerTask playerTask;
    private String[] fabricantes;
    private String[] areas;
    private String[] categorias;
    private String[] subcategorias;
    private String[] modalidades;

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
    private String fabricante;
    private String area;
    private String categoria;
    private String subcategoria;
    private String modalidad;
    //private String stream;
    //private String stream = "http://provisioning.streamtheworld.com/pls/M80RADIO.pls"; // M80 Pop

//    private static final String TAG = "AudioFxDemo";

    private static final float VISUALIZER_HEIGHT_DIP = 50f;

    private LinearLayout mLinearLayoutEqualizer;
    //    private LinearLayout mLinearLayoutFrequency;
//    private LinearLayout mLinearLayoutVisualizer;
    private Visualizer mVisualizer;
//    private VisualizerView mVisualizerView;

    private float density = 70f;
    //    private float volLeft = 0f;
    //   private float volRight = 0f;
//    private float vol = 0f;

    private TextView mStatusTextView;


    // private View myView;
    //private View eqview;
    //private View fftview;
    //private ImageButton imageButton;
    private Button submit;

    // BaseActivity
    public static final int AUDIO_PERMISSION_REQUEST_CODE = 102;

    public static final String[] WRITE_EXTERNAL_STORAGE_PERMS = {
            Manifest.permission.RECORD_AUDIO
    };
    private boolean botonInformacion;

    private static curso cur;
    private static cursos curs;

    String[] sugerencias = {
            "Los más destacados:",
            "Últimas convocatorias:",
            "Certificaciones en:",
            "Consultoría y Servicios disponibles:"
    };

    String[] v00 = {
            "Destacados 01",
            "Destacados 02",
            "Destacados 03"
    };

    String[] v01 = {
            "tiburon11",
            "tiburon12",
            "tiburon21"
    };

    String[] v02 = {
            "tiburon11",
            "tiburon12",
            "tiburon21"
    };

    String[] v03 = {
            "tiburon11",
            "tiburon12",
            "tiburon21"
    };

    String[] v04 = {
            "tiburon11",
            "tiburon12",
            "tiburon21"
    };

    String[] v05 = {
            "tiburon11",
            "tiburon12",
            "tiburon21"
    };

    String[] v06 = {
            "tiburon11",
            "tiburon12",
            "tiburon21"
    };
    String[] v07 = {
            "formato11",
            "formato12",
            "formato21"
    };
    String[] v08 = {
            "idioma11",
            "idioma12",
            "idioma21"
    };
    String[] v09 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v10 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v11 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v12 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v13 = {
            "documentacion11_kmjggfgg_kmfmrfm_ddfgtkmgvmmgf_mgbmvbmgvbb_mvgbmgvmvfvmed_mmmmm_" +
                    "_mv_m_m_,mlfflgfewgergoearpgrog_kvvfkvovkvvkvkvkopxk_bkbkbkbkbkbkbkb__" +
                    "knnsknkbnks.",
            "documentacion12_quhgeu__hgbwooikb_jgoqi_jgftgioq_ifoe_ikjgvigjg_jiosjgb_igoas_" +
                    "a_nn__oggbnn_gngwbo_ggfng_whhhwhrwrtn_nthbowsnb_ngbgohohghhhi_nnnnnnnn.",
            "documentacion21_bjbwjbjbj_jegbrtjwihog_jgoiwbhjg_gbwjiiiiiiohb_jgjsoij_gboihbgh" +
                    "ms_gogn_n_itoa_jio_ii_j_ioi_ooooooooo_io_iji_oooooooooooooooooooooo_ikio_" +
                    "nnio_io_iio_ioooooooooooooooooooooooooooo_jiooooooooooooooooooooooo_iooooooo" +
                    "jiooooooooooooio"
    };
    String[] v14 = {
            "descripcion11_kmjggfgg_kmfmrfm_ddfgtkmgvmmgf_mgbmvbmgvbb_mvgbmgvmvfvmed_mmmmm_" +
                    "_mv_m_m_,mlfflgfewgergoearpgrog_kvvfkvovkvvkvkvkopxk_bkbkbkbkbkbkbkb__" +
                    "knnsknkbnks.",
            "descripcion12_quhgeu__hgbwooikb_jgoqi_jgftgioq_ifoe_ikjgvigjg_jiosjgb_igoas_" +
                    "a_nn__oggbnn_gngwbo_ggfng_whhhwhrwrtn_nthbowsnb_ngbgohohghhhi_nnnnnnnn.",
            "descripcion21_bjbwjbjbj_jegbrtjwihog_jgoiwbhjg_gbwjiiiiiiohb_jgjsoij_gboihbgh" +
                    "ms_gogn_n_itoa_jio_ii_j_ioi_ooooooooo_io_iji_oooooooooooooooooooooo_ikio_" +
                    "nnio_io_iio_ioooooooooooooooooooooooooooo_jiooooooooooooooooooooooo_iooooooo" +
                    "jiooooooooooooio"
    };
    String[] v15 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v16 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v17 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v18 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v19 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };
    String[] v20 = {
            "nivel11",
            "nivel12",
            "nivel21"
    };

    public FragmentAdapter adapterCursos;
    public ViewPager mViewPager;

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
            // pantalla solo horizontal OK
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setContentView(R.layout.activity_destacados);
//            context = this.context;
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
            // otras variables de control
            /*
            b_play = (Button) findViewById(R.id.button_buscar);
            b_play.setEnabled(true);
*/
/*            ListView lista = (ListView) findViewById(R.id.listView1);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sugerencias);
            lista.setAdapter(adapter);
*/
            //galeria de imagenes y nombres
            adapterCursos = new FragmentAdapter(getSupportFragmentManager());

            mViewPager = findViewById(R.id.pagerdestacados);
            adapterCursos.agregarFragmentos(DestacadosDetailFragment.newInstance(v00[0], v01[0], v02[0],
                    v03[0], v04[0], v05[0], v06[0], v07[0], v08[0], v09[0], v10[0], v11[0], v12[0], v13[0],
                    v14[0], v15[0], v16[0], v17[0], v18[0], v19[0], v20[0]));
            adapterCursos.agregarFragmentos(DestacadosDetailFragment.newInstance(v00[1], v01[1], v02[1],
                    v03[1], v04[1], v05[1], v06[1], v07[1], v08[1], v09[1], v10[1], v11[1], v12[1], v13[1],
                    v14[1], v15[1], v16[1], v17[1], v18[1], v19[1], v20[1]));
            adapterCursos.agregarFragmentos(DestacadosDetailFragment.newInstance(v00[2], v01[2], v02[2],
                    v03[2], v04[2], v05[2], v06[2], v07[2], v08[2], v09[2], v10[2], v11[2], v12[2], v13[2],
                    v14[2], v15[2], v16[2], v17[2], v18[2], v19[2], v20[2]));

            mViewPager.setAdapter(adapterCursos);
/*
            b_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    curs.setCursos();
//                    rellenarTextviews(cursos);

                    //lista
                    ListView lista = (ListView) findViewById(R.id.listView1);
                    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sugerencias);
                    lista.setAdapter(adapter);

                    //galeria de imagenes y nombres

                    adapterCursos = new FragmentAdapter(getSupportFragmentManager());

                    mViewPager = (ViewPager) findViewById(R.id.pager);
                    adapterCursos.agregarFragmentos(CursosDetailFragment.newInstance(v00[0],v01[0],
                    v02[0],v03[0],v04[0],v05[0],v06[0],v07[0],v08[0],v09[0],v10[0],v11[0],v12[0],
                    v13[0],v14[0],v15[0],v16[0],v17[0],v18[0],v19[0],v20[0]));
                    adapterCursos.agregarFragmentos(CursosDetailFragment.newInstance(v00[1],v01[1],
                    v02[1],v03[1],v04[1],v05[1],v06[1],v07[1],v08[1],v09[1],v10[1],v11[1],v12[1],
                    v13[1],v14[1],v15[1],v16[1],v17[1],v18[1],v19[1],v20[1]));
                    adapterCursos.agregarFragmentos(CursosDetailFragment.newInstance(v00[2],v01[2],
                    v02[2],v03[2],v04[2],v05[2],v06[2],v07[2],v08[2],v09[2],v10[2],v11[2],v12[2],
                    v13[2],v14[2],v15[2],v16[2],v17[2],v18[2],v19[2],v20[2]));

                    mViewPager.setAdapter(adapterCursos);
                }
            });
*/
        } catch (Exception e) {
            Log.e("ERROR", "Error onCreate: " + e);
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
/*
    private void setActionBar() {
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setPlayer(MediaPlayer mediaPlayer) {
        //mediaPlayer = MediaPlayer.create(this, R.raw.i_t_amapola);
        if (mediaPlayer != null ) {
            mediaPlayer.setLooping(false);
            //init();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        switch (requestCode) {
            case AUDIO_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //setPlayer(mediaPlayer);
                } else {
                    this.finish();
                }
        }
    }
*/
// Fin BaseActivity
/*
    //@Override
    protected void onDraw(Canvas canvas) {

    }
*/
    /*
    class PlayerTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                prepared = true;
                return prepared;
            } catch(IOException e) {
                Log.e("ERROR", "Error doInBackground():" + e);
                e.printStackTrace();
                return false;
            }
        }

    }

    @Override
    protected void onPause() {
        try {
            super.onPause();

            if (isFinishing() && mediaPlayer != null) {
                mVisualizer.release();
                mEqualizer.release();
                mediaPlayer.release();
                mediaPlayer = null;
                System.exit(0);
            }

        } catch (Exception e) {
            Log.e("ERROR", "Error onPause: " + e);
        }
    }
        */

    @Override
    protected void onResume() {
        super.onResume();
/*
        if(started) {
            mediaPlayer.start();
        }
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) getView().findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);
        //initialize views
        initializeViews();
        setInstrumentNames();

        mediaPlayer1.start();
        mediaPlayer2.start();
        mediaPlayer3.start();
        mediaPlayer4.start();
        // Start the songtime thread and remember its object so it can be stopped legally
        play();
        setEqualizer();
        setupKnobButtons();
        */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // mVisualizer.release();
        //mEcualizador.release();
        //mediaPlayer.stop();
        //mediaPlayer.release();
        //mediaPlayer = null;
        //playerTask.cancel(true);
        //playerTask = null;
    }


    protected int getLayout() {
        return R.layout.activity_cursos;
    }

    /*protected int getLayout() {
        return R.layout.activity_bar_visualizer;
    }*/
// Fin BaseVisulizerActivity
/*
    public void playPause_01(View v) {
//        playPauseBtnClicked_01((ImageButton) ib_play_pause_01 , v);
    }
    */
    public void getCursosActual() {
        curs.getCursos();
    }
/*    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.pager, fragment);
        fragmentTransaction.commit(); // save the changes
    }
    */
    /*
    //Este metodo rellena los textviews del documento xml
    public void rellenarTextviews(cursos curs) {
        curso[] cuArray = curs.getCurso();
        String[] campos = {cas_area,cas_categoria,cas_subcategoria,cas_sku,cas_nombre,cas_duracion,
                cas_inicio,cas_formato,cas_idioma,cas_modalidad,cas_fabricante,cas_nivel,
                cas_oficial,cas_documentacion,cas_descripcion,cas_objetivos,cas_audiencia,
                cas_contenidos,cas_image,cas_pdf_curso,cas_destacado};
        for (int i = 0; i < cuArray.length; i++) {
            curso cu = cuArray[i];
            rellenarArea(cu);
            rellenarCategoria(cu);
            rellenarSubcategoria(cu);
            rellenarSku(cu);
            rellenarNombre(cu);
            rellenarDuracion(cu);
            rellenarInicio(cu);
            rellenarFormato(cu);
            rellenarIdioma(cu);
            rellenarModalidad(cu);
            rellenarFabricante(cu);
            rellenarNivel(cu);
            rellenarOficial(cu);
            rellenarDocumentacion(cu);
            rellenarDescripcion(cu);
            rellenarObjetivos(cu);
            rellenarAudiencia(cu);
            rellenarContenidos(cu);
            rellenarImage(cu);
            rellenarPdf(cu);
            rellenarDestacado(cu);
        }
    }

    public void rellenarCategoria(cursos curs){
        TextView text = null;
        String dato = "";
        cursos.CATEGORIA categorias[] = curs.getCategorias();

        text = findViewById(R.id.detalles_categoria);
        if(categorias!=null) {
            for (int i = 0; i < categorias.length; i++) {
                if (i == categorias.length - 1)
                    dato += categorias[i];
                else
                    dato += categorias[i] + " / ";
            }
            if (dato != "null") {
                text.setText(dato);
            }
        }else{
            LinearLayout li = findViewById(R.id.linearcategoria);
            li.setVisibility(View.GONE);
        }
    }



    // Esto metodos rellenan los textviews (cada uno el suyo) del documento xml ademas se comprueba si el dato es null o no.
    //TODO rellenar los else, y borrar los layouts si estan vacios
    public void rellenarArea(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_area);
        dato = IntToString(cu.getArea());
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.lineararea);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarCategoria(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_categoria);
        dato = cu.getCategoria();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearcategoria);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarSubcategoria(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_subcategoria);
        dato = cu.getSubcategoria();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearsubcategoria);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarSku(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_sku);
        dato = cu.getSku();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearsku);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarNombre(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_nombre);
        dato = cu.getNombre();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearnombre);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarDuracion(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_duracion);
        dato = cu.getDuracion();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearduracion);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarInicio(curso curs){
        TextView text;
        String dato;
        Date fecha;

        text = findViewById(R.id.detalles_inicio);
        fecha = curs.getInicio();
        dato = fecha.toString();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearinicio);
            li.setVisibility(View.GONE);
        }

    }
    public void rellenarFormato(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_formato);
        dato = cu.getFormato();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearformato);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarIdioma(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_idioma);
        dato = cu.getIdioma();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearidioma);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarModalidad(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_modalidad);
        dato = cu.getModalidad();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearmodalidad);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarFabricante(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_fabricante);
        dato = cu.getFabricante();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearfabriacante);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarNivel(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_nivel);
        dato = cu.getNivel();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearnivel);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarOficial(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_oficial);
        dato = cu.getOficial();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearoficial);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarDocumentacion(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_documenacion);
        dato = cu.getDocumentacion();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.lineardocumetacion);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarDescripcion(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_descripcion);
        dato = cu.getDescripcion();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.lineardescripcion);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarObjetivos(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_objetivos);
        dato = cu.getObjetivos();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearobjetivos);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarAudiencia(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_audiencia);
        dato = cu.getAudiencia();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearaudiencia);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarContenidos(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_contenidos);
        dato = cu.getContenidos()e();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearcontenidos);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarImage(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_image);
        dato = cu.getImage();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearimage);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarPdf(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_pdf);
        dato = cu.getPdf_curso();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.linearpdf);
            li.setVisibility(View.GONE);
        }
    }
    public void rellenarDestacado(curso cu){
        TextView text;
        String dato;

        text = findViewById(R.id.detalles_destacado);
        dato = cu.getDestacado();
        if(dato!=null) {
            text.setText(dato);
        }else{
            LinearLayout li = findViewById(R.id.lineardestacado);
            li.setVisibility(View.GONE);
        }
    }
*/
// FIN RELLENAR


    /**
     * Este metodo recibe una vista y lanza un intent con el enlace Web del cursos de la clase
     * @param view
     */
    /*
    public void irAEnlaceweb(View view)
    {
        //TODO HAY QUE PROBARLO BIEN, SI NO EXISTE EL ENLACE NO SE QUE PASA, MIRAR ENLACE POR DEFECTO
        String enlace;
        TextView textView = findViewById(R.id.detalles_enlaceweb);
        enlace = textView.getText().toString();
        enlace = curso.getEnlace_web();
        if(enlace!=null) {
            try {
                Uri uri = Uri.parse(enlace);//y Su URI
                Intent intent = new Intent(Intent.ACTION_VIEW, uri); //creo el intent
                startActivity(intent);

            } catch (Throwable t) {
                Log.e("MIAPP", "ERROR", t);
            }
        }
    }

*/

    /**
     * Recorta un string dado, por lo general utilizado para que el enlace web quede mas visible
     *
     * @param dato
     * @return
     */
    private String recortarEnlace(String dato) {
        String info;
        if (dato.length() > 30) {
            info = dato.substring(0, 25) + "...";
        } else {
            info = dato;
        }
        return info;
    }
/*
    // Version antigua de rellenarTextViews();
    public void mostrarCurso(curso curs){
        TextView text;

        text = findViewById(R.id.detalles_area);
        text.setText(curs.getArea());
        text = findViewById(R.id.detalles_categoria);
        text.setText(curs.getCategoria());
        text = findViewById(R.id.detalles_subcategoria);
        text.setText(curs.getSubcategoria());
        text = findViewById(R.id.detalles_sku);
        text.setText(curs.getSku());
        text = findViewById(R.id.detalles_nombre);
        text.setText(curs.getNombre());
        text = findViewById(R.id.detalles_duracion);
        text.setText(curs.getDuracion());
        text = findViewById(R.id.detalles_inicio);
        text.setText(curs.getInicio());


        text = findViewById(R.id.detalles_contenidos);
        text.setText(curs.getContenidos());

        text = findViewById(R.id.detalles_audiencia);
        text.setText(curs.getAudiencia());

        text = findViewById(R.id.detalles_documenacion);
        text.setText(curs.getDocumentacion());

        text = findViewById(R.id.detalles_destacado);
        text.setText(curs.isDestacado()+"");

        text = findViewById(R.id.detalles_pdf);
        text.setText(curs.getPdf_curso());

        text = findViewById(R.id.detalles_enlaceweb);
        text.setText(curs.getEnlace_web());

        text = findViewById(R.id.detalles_horario);
        text.setText(curs.getHorario());

        text = findViewById(R.id.detalles_coste);
        text.setText(curs.getCoste()+"");

        text = findViewById(R.id.detalles_infobasica);
        text.setText(curs.getInfo_basica());
    }

*/

    /**
     * Metodo utilizado para el boton de ver mas detalles
     *
     * @ param view El botón de más información pulsado
     */
    /*
    public void sacarInfoDetalle(View view) {
        TextView text;
        text = findViewById(R.id.detalles_infobasica);
        Button boton =(Button)view;
        TextView titulo =findViewById(R.id.textviewinfobasica);
        if(botonInformacion == false){
            text.setText(puntoDeInteres.getInfo_detallada());

            boton.setText("menos información");
            int colorGris = getResources().getColor(R.color.colorGris);
            boton.setBackgroundColor(colorGris);

            titulo.setText(R.string.info_detallada);

            botonInformacion=true;
        }else{
            int rojoRivas=getResources().getColor(R.color.rojoRivas);
            text.setText(puntoDeInteres.getInfo_basica());

            boton.setText("más información");
            boton.setBackgroundColor(rojoRivas);

            titulo.setText(R.string.info_basica);
            botonInformacion=false;

        }

    }
*/
    public void verValor(View v) {
        EditText campoTexto = (EditText) findViewById(R.id.in_curso_nombre);
        Log.d("Valor ET", campoTexto.getText().toString());
    }
}