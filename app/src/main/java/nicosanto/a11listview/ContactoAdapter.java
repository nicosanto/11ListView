package nicosanto.a11listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
/**
 * Created by nicol on 31/08/2017.
 */
//Extiende de la clase BaseAdapter, necesario los 4 Metodos
public class ContactoAdapter  extends BaseAdapter {
    //Constante
    static final int largoCadena = 10;
    //Dentro de la lista colocamos la clase de tipo Contacto.java
    private List<Contacto> contactos;
    //Constructor
    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    //Click derecho gererar->Implement Metods
    @Override
    public int getCount() {  //Obtenemos el tamaño de celdas que manejara de contactos
        return contactos.size();
    }

    @Override
    public Object getItem(int position) {  //Obtenemos la posicion de contactos
        return contactos.get(position);
    }

    @Override
    public long getItemId(int position) {  //Obtenemos el id de una posicion determinada
        return contactos.get(position).getTelefono();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {  //Se ejecuta para cada secuencia que quiera cargar el contenido del listview
        View view;
        //Solo muestra los items necesarios.
        //optimizacion de reutilizacion de recursos
            if(convertView == null){
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contacto,parent,false);
            }else{ //si ya existe
                view = convertView;
        }

        Contacto contacto = (Contacto)getItem(position);
        //adapter_contacto.xml
        TextView txtColor = (TextView) view.findViewById(R.id.txtColor);
        TextView txtRemitente = (TextView) view.findViewById(R.id.txtRemitente);
        TextView txtAsunto = (TextView) view.findViewById(R.id.txtAsunto);
        TextView txtFecha = (TextView) view.findViewById(R.id.txtFecha);
        TextView txtMensaje = (TextView) view.findViewById(R.id.txtMensaje);

        // txtIcono.getBackground()setColorFilter(Color.parseColor(mensaje.getColor()),PorterDuff,Mode)

        txtColor.setText(contacto.getRemitente().substring(0,1));
        txtRemitente.setText(String.valueOf(contacto.getRemitente()));
        txtAsunto.setText(String.valueOf(contacto.getAsunto()));
        txtFecha.setText(String.valueOf(contacto.getFecha()));
       // txtColor.setText(String.valueOf(contacto.getColor()));

        if (contacto.getMensaje().length()>largoCadena){
            txtMensaje.setText(contacto.getMensaje().substring(0,largoCadena)+"...");
        }else{
            txtMensaje.setText(contacto.getMensaje());
        }

        return view;
    }
}
