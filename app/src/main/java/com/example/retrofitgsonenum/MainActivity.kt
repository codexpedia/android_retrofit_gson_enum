package com.example.retrofitgsonenum

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            fetchClothes()
        }

    }

    private fun fetchClothes() {
        tv_clothes.text = ""

        val client = RestUtil.instance.retrofit.create(ApiClient::class.java)
        val call = client.getClothes()
        call.enqueue(object : Callback<List<Cloth>> {
            override fun onResponse(call: Call<List<Cloth>>, response: Response<List<Cloth>>) {
                if (response.body() != null) {

                    val clothes = response.body()
                    var stringBuilder = StringBuilder("")
                    clothes?.forEach {
                        stringBuilder.append(it.cloth)
                        stringBuilder.append(" ")
                        stringBuilder.append(it.clothSize)
                        stringBuilder.append("\n")
                    }

                    tv_clothes.text = stringBuilder.toString()
                }
            }
            override fun onFailure(call: Call<List<Cloth>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}
