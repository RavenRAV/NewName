package com.example.huificator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.huificator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val cons = listOf(
        "б",
        "в",
        'г',
        'д',
        'ж',
        'з',
        'й',
        'к',
        'л',
        'м',
        'н',
        'п',
        'р',
        'с',
        'т',
        'ф',
        'х',
        'ц',
        'ч',
        'ш',
        'щ'
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        with(binding) {
            nameBtn.setOnClickListener {
                var name = nameET.text.toString().decapitalize()
                val chars: List<Char> = name.toList()

//                val ch = name.get(0)
//                if (ch in cons) name = name.drop(1)
//
//                name = when (ch) {
//                    'а' -> "Xyя" + name.drop(1)
//                    'о' -> "Xyё" + name.drop(1)
//                    else -> "Xy$name"
//                }

                for (i in chars.indices) {
                    if (name.get(i) in cons) {
                        Log.e("lolo", name.get(i).toString())
                    } else {
                        name = name.drop(i)
                        name = when (name.get(0)) {
                            'а' -> "Xyя" + name.drop(1)
                            'о' -> "Xyё" + name.drop(1)
                            else -> "Xy$name"
                        }
                        Log.e("lolo", name + i.toString())
                        nameTV.text = "Поздравляем! Теперь вас зовут $name"
                        break
                    }
                }


            }
        }
    }
}
