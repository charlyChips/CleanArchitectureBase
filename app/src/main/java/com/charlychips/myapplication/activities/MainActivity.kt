package com.charlychips.myapplication.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.charlychips.domain.models.User
import com.charlychips.myapplication.R
import com.charlychips.presentation.MainContract
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {

    override val presenter: MainContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.subscribe(this)
        presenter.getUsers()
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

    override fun showUsers(list: List<User>) {
        list.forEach {
            Log.d("Charly", it.name + " - " + it.company.name)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}