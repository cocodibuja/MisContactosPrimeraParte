package api.ejemplos.mis.mascotascoursera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList <Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("pepe Grillo", "7777777","pepegrillo@gmail.com"));
        contactos.add(new Contacto("Juan peroz", "22222222","juanperoz@gmail.com"));
        contactos.add(new Contacto("Amalia Gomez", "55557777","AmaliaGomez@gmail.com"));
        contactos.add(new Contacto("Joana Lopez", "43334444443","Joanalopez@gmail.com"));


        ArrayList<String> nombresContacto = new ArrayList<>();
        for(Contacto contacto: contactos){
            nombresContacto.add(contacto.getNombre());


        }


        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresContacto));

        lstContactos.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text


              /*  Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
*/
                Intent intentAbrirContacto = new Intent(MainActivity.this,DetalleContactoActivity.class);

                intentAbrirContacto.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intentAbrirContacto.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intentAbrirContacto.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());


                 /*
                intentAbrirContacto.putExtra("Nombre",contactos.get(position).getNombre());
                intentAbrirContacto.putExtra("Telefono",contactos.get(position).getTelefono());
                intentAbrirContacto.putExtra("Email",contactos.get(position).getEmail());
                */

                startActivity(intentAbrirContacto);
                finish();
            }
        });







    }
}
