package com.humam.samplechapter5.activity


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.humam.samplechapter5.R
import com.humam.samplechapter5.databinding.ActivitySecondBinding
import com.humam.samplechapter5.dialog.CustomSampleDialog
import com.humam.samplechapter5.model.UserParcelize

class SecondActivity : AppCompatActivity() {

    companion object {
        val KEY_NAME_DATA = "dataFromMainPage"
        val KEY_USER = "user"
        val KEY_USER_PARCELIZE = "userParcelize"
    } // companion object untuk apa yang di dalamnya bisa diakses di luar kelasnya

    var binding : ActivitySecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//        val data = intent.getStringExtra(KEY_NAME_DATA)
//        val user = intent.getSerializableExtra(KEY_USER) as User

        val bundle = intent.extras
        val data = bundle?.getString(KEY_NAME_DATA).orEmpty()

        val userParcelize = intent.getParcelableExtra<UserParcelize>(KEY_USER_PARCELIZE)

        binding?.apply {
            tvShowData.text = data
            btnStandardDialog.setOnClickListener {
                showDialogStandard()
            }
            btnCustomDialog.setOnClickListener {

                showCustomDialogFragment()
            }

            btnShowToast.setOnClickListener {
                Toast.makeText(this@SecondActivity, "Sample Message Toast", Toast.LENGTH_LONG).show()
                //fragment makenya context bukan this, karena fragment tidak bisa diakses di luar kelasnya. kalau diakses di luar kelasnya, maka harus menggunakan context
            }

            btnShowSnackbar.setOnClickListener { it -> // it -> view yang di klik, karena snackbar tidak bisa diakses di luar kelasnya, maka harus menggunakan context
                val snackbar = Snackbar.make(it, "Sample Message Snackbar", Snackbar.LENGTH_INDEFINITE)

//                  .setAction("Close", null).show() // setAction -> mengatur action pada snackbar, null -> tidak ada action
                    snackbar.setAction("Close") {
                        snackbar.dismiss()
                    }
                snackbar.show()
            }
        }
        Log.d("TESSLIFCYCLE", "onCreate")
    }

    fun showDialogStandard(){
        val dialog = AlertDialog.Builder(this@SecondActivity)
        dialog.setTitle("Sample Dialog")
        dialog.setMessage("Sedang Memuncul Sample Dilaog Standart")
        dialog.setCancelable(true)
        dialog.setPositiveButton("Oke"
        ) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        dialog.setNegativeButton("Tidak"
        ) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        dialog.setNeutralButton("Mungkin"
        ) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        dialog.show()
    }

    fun shoCustomDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.layout_dialog_sample)
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window?.setLayout(width,height)

        val btnClose = dialog.findViewById<Button>(R.id.btnClose)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    fun showCustomDialogFragment(){
        val dialog = CustomSampleDialog("Tess")
        dialog.show(supportFragmentManager,"CustomSampleDialog")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TESSLIFCYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TESSLIFCYCLE", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("TESSLIFCYCLE", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("TESSLIFCYCLE", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TESSLIFCYCLE", "onDestroy")
    }
}