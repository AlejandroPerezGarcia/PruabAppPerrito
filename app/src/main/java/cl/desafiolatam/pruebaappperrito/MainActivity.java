package cl.desafiolatam.pruebaappperrito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentDog.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override

    public void onListFragmentInteraction(List<String> lista) {

    }

    //cambio para que suba de nuevo
}