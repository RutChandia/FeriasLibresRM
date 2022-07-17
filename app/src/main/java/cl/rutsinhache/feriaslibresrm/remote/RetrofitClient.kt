package cl.rutsinhache.feriaslibresrm.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        const val base_url: String = "https://my-json-server.typicode.com/RutChandia/feriasDBTest/"
        private var client: Retrofit? = null

        fun getService(url : String): APIService {
            if (client == null) {
                client = Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return client!!.create(APIService::class.java)
        }
    }
}