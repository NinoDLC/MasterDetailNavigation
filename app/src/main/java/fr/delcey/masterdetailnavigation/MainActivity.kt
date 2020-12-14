package fr.delcey.masterdetailnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        detail_fragment_host?.let {
            // We are in landscape
            supportFragmentManager.beginTransaction()
                .replace(R.id.detail_fragment_host, DetailFragment())
                .commitNow()
        }
    }
}