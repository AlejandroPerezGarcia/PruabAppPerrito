package cl.desafiolatam.pruebaappperrito.api;

import cl.desafiolatam.pruebaappperrito.model.RazasLista;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataBaseDog {
    @GET("api/breeds/lits/all")
    Call<RazasLista> listaRazas();
}
