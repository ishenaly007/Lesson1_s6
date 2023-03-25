package com.abit8.lesson1_s6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abit8.lesson1_s6.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val urls = arrayListOf(
            "https://sourceplay.ru/uploads/posts/2009-03/1238421420_41qktfjyz1l._aa280_.jpg",
            "https://phonoteka.org/uploads/posts/2022-09/1663705223_1-phonoteka-org-p-avtomat-bez-fona-vkontakte-1.jpg",
            "https://hitman.com.ua/image/catalog/products/A_K/FB2200_30_.jpg",
            "https://arsenal-info.ru/images/weapon_8/novaya_vintovka_cz_bren_4.jpg",
            "https://www.pneumopistols.ru/pictures/ru/catalog/kai64.jpg",
        )

        binding.btnAdd.setOnClickListener {
            if (binding.etUrl.text.isNotEmpty() && binding.etUrl.text.toString() !in urls) {
                urls.add(binding.etUrl.text.toString())
                binding.etUrl.text.clear()
            }
        }

        binding.btnRandom.setOnClickListener {
            val random: Int = (0 until urls.size).random()
            Glide.with(binding.ivGuns).load(urls[random]).into(binding.ivGuns)
        }

    }

}