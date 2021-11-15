package my.edu.tarc.mybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.mybmi.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            if (binding.editTextHeight.text.isEmpty()) {
                binding.editTextHeight.error = "Value required" //getString(R.string.error_input)
                return@setOnClickListener
            }

            if (binding.editTextWeight.text.isEmpty()) {
                binding.editTextWeight.error = "Value required" //getString(R.string.error_input)
                return@setOnClickListener
            }
            val height: Double = binding.editTextHeight.text.toString().toDouble()
            val weight: Double = binding.editTextWeight.text.toString().toDouble()


            val bmi: Double = weight / (height / 100).pow(2)

            if (bmi < 18.5) {
                binding.imageView.setImageResource(R.drawable.under)
                binding.textViewBMI.text = String.format("%.2f", bmi)
                binding.textViewStatus.text = getString(R.string.under)
            } else if (bmi > 25) {
                binding.imageView.setImageResource(R.drawable.over)
                binding.textViewBMI.text = String.format("%.2f", bmi)
                binding.textViewStatus.text = getString(R.string.over)
            } else {
                binding.imageView.setImageResource(R.drawable.normal)
                binding.textViewBMI.text = String.format("%.2f", bmi)
                binding.textViewStatus.text = getString(R.string.normal)
            }


        }

        binding.buttonReset.setOnClickListener {
            //TODO: Reset all views and output
            binding.editTextWeight.text.clear()
            binding.editTextHeight.text.clear()
            binding.textViewStatus.text = null
            binding.textViewBMI.text = null
            binding.imageView.setImageResource(R.drawable.empty)

        }

    }
}