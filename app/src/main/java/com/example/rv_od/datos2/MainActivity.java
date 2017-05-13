package com.example.rv_od.datos2;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    String jugador1;
    int vidas, monedas;
    Long score;
    Float world;
    Boolean activo;
    TextView encabezado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encabezado = (TextView) findViewById(R.id.encabezado);

        //esta manera de guardar datos es INTERNA en la app, se queda enpaquetado DENTRO de la app
/*        SharedPreferences preferencias = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        //Este es objeto que escibe las variables con sus datos
        SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("jugador1", "Oscar Vivia");
                editor.putInt("vidas", 3);
                editor.putLong("score", 7750);
                editor.putInt("monedas", 14);
                editor.putFloat("world", (float) 1.1);
                editor.putBoolean("activo", true);
        //este escribe las variables con sus datos
        editor.commit();

        //aqui lee las variables almacenadas con el editor.commit
        String jugador1 = preferencias.getString("jugador1", "error, autodestruccion en 3 seg");
        int vidas = preferencias.getInt("vidas", 0);
        Long score = preferencias.getLong("score", 0);
        int monedas = preferencias.getInt("monedas", 0);
        Float world = preferencias.getFloat("world", (float) 1.1);
        Boolean activo = preferencias.getBoolean("activo", true);

        //este muestra las variables
        Toast.makeText(this,    "Juagdor 1: " + jugador1 +
                                " Vidas: "    + vidas    +
                                " Score: "    + score    +
                                " Monedas: "  + monedas  +
                                " World: "    + world    +
                                " Activo: "   + activo,
                        Toast.LENGTH_LONG).show();
*/
        try{
            //esta linea es para crear un archivo txt interno en la app, llamado archivoInterno.txt
            OutputStreamWriter archivoEscritura = new OutputStreamWriter(
                    openFileOutput("archivoInterno.txt", Context.MODE_PRIVATE));
            //estas lineas esciben en el archivo
            archivoEscritura.write("Escribiendo datos en archivos");
            archivoEscritura.write("\n Otra linea");
            archivoEscritura.write("\n Escribiendo mas lineas");
            archivoEscritura.write("\n Escribiendo mas lineas");
            archivoEscritura.write("\n Escribiendo mas lineas");
            archivoEscritura.write("\n Escribiendo mas lineas");
            archivoEscritura.write("\n Escribiendo mas lineas");
            archivoEscritura.write("\n Escribiendo mas lineas");

            //esta linea cierra el archivo
            archivoEscritura.close();

            //esta linea lee el archivo interno, llamado archivoInterno.txt
            BufferedReader archivoLectura = new BufferedReader(new InputStreamReader(
                     openFileInput("archivoInterno.txt")));

            String linea;
            encabezado.setText("Archivos");
            //este while muestra lo que esta escrito en el archivo
            while((linea = archivoLectura.readLine()) != null)
                        encabezado.append("\n" + linea);

        } catch (Exception e) {
            encabezado.setText("Se produjo un error al escribir: " + e.getMessage());
        }
    }
}
