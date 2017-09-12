package nicosanto.a11listview;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //Creo 3 campos
    private ListView listaContactos;
    private SwipeRefreshLayout sflLista;
    private Context context;

    // MENU OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    // MENU OPCIONES
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuRefresh:

                sflLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        cargarLista();
                        sflLista.setRefreshing(false);
                    }
                });

                Toast.makeText(context,"Click en Refresh!!",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuExit:
                Toast.makeText(MainActivity.this,"Click en Cerrar",Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cargarLista(){
        //List de la clase Contacto:12
        final List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Remitente","Asunto","0123456789-Esto es el cuerpo del mensaje del email. =D ","Fecha: 04-09-17","remitente@gmail.com"));
        contactos.add(new Contacto("Nico Santomartino","Secundary Text","Mensaje: Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500","Fecha: 05-09-17","nicosantomartino@gmail.com"));
        contactos.add(new Contacto("Javier Santomartino","Tercer Texto 13 texto","Mensaje: programando ","Fecha: 04-09-17","Javier@gmail.com"));
        contactos.add(new Contacto("Juan Pablo","4º Texto","Este es el cuarto texto","Fecha: 05-09-17","Juan@gmail.com"));
        contactos.add(new Contacto("Martin Allende","Quinto Texto","Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.","Fecha: 04-09-17","MartinElLoco1@gmail.com"));
        contactos.add(new Contacto("Nico Campos","Septimo Text","Al contrario del pensamiento popular, el texto de Lorem Ipsum no es simplemente texto aleatorio. Tiene sus raices en una pieza cl´sica de la literatura del Latin, que data del año 45 antes de Cristo, haciendo que este adquiera mas de 2000 años de antiguedad. ","Fecha: 05-09-17","NicoCampos48@gmail.com"));
        contactos.add(new Contacto("David Gonzalez","Octavo Text","El trozo de texto estándar de Lorem Ipsum usado desde el año 1500 es reproducido debajo para aquellos interesados.","Fecha: 05-09-17","DavidGonzalez@gmail.com"));
        contactos.add(new Contacto("Esteban Alonso","Noveno Text","Las secciones 1.10.32 y 1.10.33 de \"de Finibus Bonorum et Malorum\" por Cicero son también reproducidas en su forma original exacta, acompañadas por versiones en Inglés de la traducción realizada en 1914 por H. Rackham.","Fecha: 04-09-17","AlonzoEsteban12@gmail.com"));
        contactos.add(new Contacto("Cristina Flores","10 Text","Haciendo el trabajo de app movil","Fecha: 05-09-17","notengocorreo@gmail.com"));
        contactos.add(new Contacto("Yesi Quiroga","11 textp","Cuerpo del mensaje","Fecha: 09-09-17","Yesi02Q@gmail.com"));
        contactos.add(new Contacto("Nicolas Santomartino","12 texto y mas texto","Mensaje:\n" +
                "▒▒▒▓▓\n" +
                "▒▒▒▒▒▓\n" +
                "▒▒▒▒▒▒▓\n" +
                "▒▒▒▒▒▒▓\n" +
                "▒▒▒▒▒▒▒▓\n" +
                "▒▒▒▒▒▒▒▓▓▓\n" +
                "▒▓▓▓▓▓▓░░░▓\n" +
                "▒▓░░░░▓░░░░▓\n" +
                "▓░░░░░░▓░▓░▓\n" +
                "▓░░░░░░▓░░░▓\n" +
                "▓░░▓░░░▓▓▓▓\n" +
                "▒▓░░░░▓▒▒▒▒▓\n" +
                "▒▒▓▓▓▓▒▒▒▒▒▓\n" +
                "▒▒▒▒▒▒▒▒▓▓▓▓\n" +
                "▒▒▒▒▒▓▓▓▒▒▒▒▓\n" +
                "▒▒▒▒▓▒▒▒▒▒▒▒▒▓\n" +
                "▒▒▒▓▒▒▒▒▒▒▒▒▒▓\n" +
                "▒▒▓▒▒▒▒▒▒▒▒▒▒▒▓\n" +
                "▒▓▒▓▒▒▒▒▒▒▒▒▒▓\n" +
                "▒▓▒▓▓▓▓▓▓▓▓▓▓\n" +
                "▒▓▒▒▒▒▒▒▒▓\n" +
                "▒▒▓▒▒▒▒▒▓\n","Fecha: 05-09-17","NicoSantomartino@hotmail.com"));

        //Recibe como parametro el array del mensaje.
        listaContactos.setAdapter(new ContactoAdapter(contactos));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //2 lineas se crean solas
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (ListView)findViewById(R.id.lista_contactos);
        sflLista = (SwipeRefreshLayout) findViewById(R.id.sflLista);
        context = MainActivity.this;

        cargarLista();

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Contacto item = (Contacto) listaContactos.getItemAtPosition(position);
               // String leyenda = "Telefono: "+ item.getTelefono()+" - Nombre: " + item.getNombre() + ", "+item.getApellido();
               // Toast.makeText(context,leyenda,Toast.LENGTH_SHORT).show();
                //Snackbar.make(view,leyenda,Snackbar.LENGTH_SHORT).show();

              //El obj tendra el objeto seleccionado del listView con toda la info.
               Contacto obj = (Contacto) parent.getItemAtPosition(position);

                Intent paso = new Intent(getApplicationContext(),DetalleActivity.class);
                paso.putExtra("objeto",(Serializable) obj);
                startActivity(paso);
            //Setcolor..
            }
        });

        sflLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarLista();
                sflLista.setRefreshing(false);
            }
        });
    }

}

