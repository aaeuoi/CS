package com.example.cs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.cs.actividades.CertificadorActivity;
import com.example.cs.actividades.ConsultoriaActivity;
import com.example.cs.actividades.ContactoActivity;
import com.example.cs.actividades.ConvocatoriaActivity;
import com.example.cs.actividades.CursosActivity;
import com.example.cs.actividades.DestacadosActivity;
import com.example.cs.actividades.InfoActivity;
import com.example.cs.actividades.RRSSActivity;
import com.example.cs.bbdd.DatabaseHandler;
import com.example.cs.bbdd.BBDDAdaptador;
import com.example.cs.fragmentos.CursosDetailFragment;
import com.example.cs.fragmentos.FragmentAdapter;
import com.example.cs.fragmentos.MainDetailFragment;
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

import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static Object PlayerTask;
    //    private final Context mContext;
    public DatabaseHandler dbh;
//    BBDDAdaptador mDbHelper = new BBDDAdaptador(this.mContext);
//    mDbHelper.createDatabase();
//    mDbHelper.open();

    //Cursor testdata = mDbHelper.getTestData();

/*    public MainActivity(Context mContext) {
        this.mContext = mContext;
    }
*/
    //mDbHelper.close();
String[] sugerencias = {
        "Los más destacados:",
        "Últimas convocatorias:",
        "Certificaciones en:",
        "Consultoría y Servicios disponibles:"
};
    String[] sArrayAreas = getResources().getStringArray(R.array.opciones_areas);
    String[] sArrayFafricanes = getResources().getStringArray(R.array.opciones_fabricantes);
    String[] sArrayModalidades = getResources().getStringArray(R.array.opciones_modalidades);
    String[] sArrayCategorias = getResources().getStringArray(R.array.opciones_categorias);
    String[] sArraySubcategorias = getResources().getStringArray(R.array.opciones_subcategorias);
    String[] sArray0 = getResources().getStringArray(R.array.cu_0);
    String[] sArray1 = getResources().getStringArray(R.array.cu_1);
    String[] sArray2 = getResources().getStringArray(R.array.cu_2);
    String[] sArray3 = getResources().getStringArray(R.array.cu_3);
    String[] sArray4 = getResources().getStringArray(R.array.cu_4);
    String[] sArray5 = getResources().getStringArray(R.array.cu_5);
    String[] sArray6 = getResources().getStringArray(R.array.cu_6);
    String[] sArray7 = getResources().getStringArray(R.array.cu_7);
    String[] sArray8 = getResources().getStringArray(R.array.cu_8);
    String[] sArray9 = getResources().getStringArray(R.array.cu_9);
    String[] sArray10 = getResources().getStringArray(R.array.cu_10);
    String[][] cursos;
    /*= {
            sArray0; sArray1; sArray2; sArray3; sArray4; sArray5;
            sArray7; sArray8; sArray9; sArray10
    };
*/
    String[] v00 = {
            "Los más destacados:",
            "Últimas convocatorias:",
            "Certificaciones en:"
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
                    "nnio_io_iio_ioooooooooooooooooooooooooooo_jiooooooooooooooooooooooo_iooooooo"+
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
                    "nnio_io_iio_ioooooooooooooooooooooooooooo_jiooooooooooooooooooooooo_iooooooo"+
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
    public DatabaseHandler ddbbHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        // carga del ViewPager de prueba
        adapterCursos = new FragmentAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.pagermain);
        adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(v00[0],v01[0],v02[0],
                v03[0],v04[0],v05[0],v06[0],v07[0],v08[0],v09[0],v10[0],v11[0],v12[0],v13[0],
                v14[0],v15[0],v16[0],v17[0],v18[0],v19[0],v20[0]));
        adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(v00[1],v01[1],v02[1],
                v03[1],v04[1],v05[1],v06[1],v07[1],v08[1],v09[1],v10[1],v11[1],v12[1],v13[1],
                v14[1],v15[1],v16[1],v17[1],v18[1],v19[1],v20[1]));
        adapterCursos.agregarFragmentos(MainDetailFragment.newInstance(v00[2],v01[2],v02[2],
                v03[2],v04[2],v05[2],v06[2],v07[2],v08[2],v09[2],v10[2],v11[2],v12[2],v13[2],
                v14[2],v15[2],v16[2],v17[2],v18[2],v19[2],v20[2]));
        mViewPager.setAdapter(adapterCursos);
        // fin carga del ViewPager de prueba

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
/*
    public class PlayerTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                ddbbHandler = new DatabaseHandler(this);
                ddbbHandler.load(a);
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
}
