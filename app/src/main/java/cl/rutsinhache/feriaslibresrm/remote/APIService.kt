package cl.rutsinhache.feriaslibresrm.remote

import cl.rutsinhache.feriaslibresrm.model.Ferias
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("ferias")
    fun getFerias(): Call<Ferias>
}