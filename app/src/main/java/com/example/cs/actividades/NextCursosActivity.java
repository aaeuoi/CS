package com.example.cs.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.example.cs.R;
import com.example.cs.fragmentos.FragmentAdapter;

import com.example.cs.fragmentos.CursosTextosDetailFragment;

public class NextCursosActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private FragmentAdapter pagerAdapter;
    private TextView tv;
    private String [] textos = {
            "Descripción",
            "Objetivos",
            "Contenido"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_next);

// BaseActivity
        if (getLayout() != 0) {
            setContentView(getLayout());
        } else {
            throw new NullPointerException("Provide layout file for the activity");
        }
        //setActionBar();
        //initialize();
// Fin BaseActivity
        String des = CursosActivity.arrayDescripcion;
        String obj = CursosActivity.arrayObjetivos;
        String con = CursosActivity.arrayContenidos;
        String pos = String.valueOf(CursosActivity.arrayPosicionReal + 1);
        String fin = String.valueOf(CursosActivity.arrayPosicionFin + 1);
        String sku = CursosActivity.arraySku;
        String nom = CursosActivity.arrayNombre;
        textos[0] = des;
        textos[1] = obj;
        textos[2] = con;

        pagerAdapter = new FragmentAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.pagertexto);
        pagerAdapter.agregarFragmentos(CursosTextosDetailFragment.newInstance(nom, pos, "_de_",fin, "DESCRIPCION -> Objetivos -> Contenidos",textos[0]));
        pagerAdapter.agregarFragmentos(CursosTextosDetailFragment.newInstance(nom, pos, "_de_",fin, "Descripción <- OBJETIVOS -> Contenidos",textos[1]));
        pagerAdapter.agregarFragmentos(CursosTextosDetailFragment.newInstance(nom, pos, "_de_",fin, "Descripción <- Objetivos <- CONTENIDOS",textos[2]));

        viewPager.setAdapter(pagerAdapter);
    }
    // BaseActivity
    private void initialize() {
/*        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(WRITE_EXTERNAL_STORAGE_PERMS, AUDIO_PERMISSION_REQUEST_CODE);
        }
        else {
            setPlayer();
        } */
    }

    private void setActionBar() {
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        */
    }

    /*    @Override
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
    */
    @Override
    protected void onPause() {
        try {
            super.onPause();
/*
            if (isFinishing() && mediaPlayer != null) {
                mVisualizer.release();
                mEqualizer.release();
                mediaPlayer.release();
                mediaPlayer = null;
                System.exit(0);
            }
*/
        } catch (Exception e) {
            Log.e("ERROR", "Error onPause: " + e);
        }
    }

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
        return R.layout.activity_cursos_next;
    }
    /*protected int getLayout() {
        return R.layout.activity_bar_visualizer;
    }*/
// Fin BaseVisulizerActivity
}
