package cl.desafiolatam.pruebaappperrito;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.desafiolatam.pruebaappperrito.api.DataBaseDog;
import cl.desafiolatam.pruebaappperrito.api.RetrofitClient;
import cl.desafiolatam.pruebaappperrito.model.RazasLista;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {

    Notificador notificador;

    public Presenter(Notificador notificador) {
        this.notificador = notificador;
    }

    public List<String> llamado(){
        DataBaseDog servicio = RetrofitClient.getRetrofitInstance().create(DataBaseDog.class);

        Call<RazasLista> listCall = servicio.listaRazas();
        List<String> listaPerros = new ArrayList<>();

        listCall.enqueue(new Callback<RazasLista>() {
            @Override
            public void onResponse(Call<RazasLista> call, Response<RazasLista> response) {
                RazasLista listaRazas = response.body();
                Map<String, List<String>> mapa =  listaRazas.getMessage();

                for (String key: mapa.keySet()) {
                    if (mapa.get(key).isEmpty()){
                        listaPerros.add(key);
                    }else{
                        for (String subRaza: mapa.get(key)){
                            listaPerros.add(key + " " + subRaza);
                        }
                    }

                }
                //Log.i("Valor", ""+listaPerros);
                notificador.notificar(listaPerros);
            }

            @Override
            public void onFailure(Call<RazasLista> call, Throwable t) {

            }
        });
        return listaPerros;
    }
    interface Notificador{
        void notificar(List<String> lista);
    }
}
