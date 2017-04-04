package mx.amazingapps.petagram;

/**
 * Created by Juan Acosta on 29/03/2017.
 */
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
public class DetalleMascota extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
            super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.mascota_detalle);
    }
}
