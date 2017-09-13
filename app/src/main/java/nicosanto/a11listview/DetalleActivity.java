package nicosanto.a11listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity {

    TextView email;
    TextView remitente;
    TextView asunto;
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        email= (TextView)findViewById(R.id.txtEmail);
        remitente = (TextView)findViewById(R.id.txtRemitente);
        asunto= (TextView)findViewById(R.id.txtAsunto);
        mensaje= (TextView)findViewById(R.id.txtMensaje);

        Contacto obj = (Contacto)getIntent().getExtras().getSerializable("objeto");

        email.setText("De: "+obj.getEmail());
        remitente.setText("Remitente: "+obj.getRemitente());
        asunto.setText("Asunto: "+obj.getAsunto());
        mensaje.setText(obj.getMensaje());
    }

    // MENU OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    // MENU OPCIONES
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSincr:
                Toast.makeText(DetalleActivity.this,"Opcion1.",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuVolver:
                Toast.makeText(DetalleActivity.this,"Click en Cerrar Actividad",Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}