package mx.amazingapps.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srfIndicator;
    ListView lstLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        srfIndicator = (SwipeRefreshLayout) findViewById(R.id.srfIndicator);
        lstLista =(ListView) findViewById(R.id.lstLista);

        String[] planetas = getResources().getStringArray(R.array.ListaPlanetas);
        lstLista.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas));


        srfIndicator.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // EN esta parte se mete codigo para refrescar contenido
                RefrescandoContenido();

            }
        });
    }
public void RefrescandoContenido(){
    String[] planetas = getResources().getStringArray(R.array.ListaPlanetas);
    lstLista.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas));

    srfIndicator.setRefreshing(false);
}
    public void agregarFAB(){
        FloatingActionButton miFAB =(FloatingActionButton) findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.Mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(v,getResources().getString(R.string.Mensaje),Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.MensajeAccion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                android.util.Log.i("SNACKBAR","Mensaje de Log en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}
