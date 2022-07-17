package cl.rutsinhache.feriaslibresrm.remote

import cl.rutsinhache.feriaslibresrm.model.Ferias
import retrofit2.Call

class RetrofitRepository {
    private val client = RetrofitClient.getService(RetrofitClient.base_url)

    fun showFerias(): Call<Ferias> {
        return client.getFerias()
    }
}