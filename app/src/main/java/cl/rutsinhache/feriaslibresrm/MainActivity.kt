package cl.rutsinhache.feriaslibresrm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.rutsinhache.feriaslibresrm.databinding.ActivityMainBinding
import cl.rutsinhache.feriaslibresrm.viewmodel.FeriasViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private val vm: FeriasViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        vm.getAll()
    }
}