package com.irem.bilgisaklamak

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.irem.bilgisaklamak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //SharedPreferences
    lateinit var sharedPreferences : SharedPreferences
    var alninanKullaniciAdi : String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.irem.bilgisaklamak", MODE_PRIVATE)

        alninanKullaniciAdi = sharedPreferences.getString("isim","")
        if (alninanKullaniciAdi==""){
            binding.textView.text = "Kullanıcı ismi:"
        }
        else{
            binding.textView.text = "Kaydedilen isim: ${alninanKullaniciAdi}"
        }
    }

    fun kaydet(view: View){

        val kullanıcıIsmi = binding.editTextText.text.toString()
        if(kullanıcıIsmi == ""){
            Toast.makeText(this@MainActivity,"İsminizi boş bıraktınız!",Toast.LENGTH_LONG).show()
        }
        else{
            sharedPreferences.edit().putString("isim",kullanıcıIsmi).apply()
            binding.textView.text = "Kaydedilen isim: ${kullanıcıIsmi}"
        }

    }

    fun sil(view: View){
        alninanKullaniciAdi =sharedPreferences.getString("isim","")
        if (alninanKullaniciAdi!=""){
            sharedPreferences.edit().remove("isim").apply()
        }
        binding.textView.text = "Kaydedilen isim:"
    }
}