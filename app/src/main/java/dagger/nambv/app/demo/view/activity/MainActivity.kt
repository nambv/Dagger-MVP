package dagger.nambv.app.demo.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.nambv.app.demo.R
import dagger.nambv.app.demo.view.fragment.PromotionsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameContainer, PromotionsFragment())
        transaction.commit()
    }
}
