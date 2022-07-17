package cl.rutsinhache.feriaslibresrm.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.rutsinhache.feriaslibresrm.model.Ferias
import cl.rutsinhache.feriaslibresrm.remote.RetrofitRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeriasViewModel(application: Application) : AndroidViewModel(application) {
    private val repoRetrofit = RetrofitRepository()

    private val errorTag = "ERROR CALL"

    private var mutableFeriaList: MutableLiveData<Ferias> = MutableLiveData()
    fun liveDataDetail(): LiveData<Ferias> = mutableFeriaList

    fun getAll() {
        repoRetrofit.showFerias().enqueue(object : Callback<Ferias> {
            override fun onResponse(call: Call<Ferias>, response: Response<Ferias>) {
                if (response.isSuccessful) {
                    mutableFeriaList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Ferias>, t: Throwable) {
                Log.e(errorTag, t.message.toString())
            }

        })
    }
}