package com.example.johnlien.chenday2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.*
import com.JohnLien.Utility.bind
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val etInput:EditText by bind<EditText>(R.id.etInput)
    private val tvPercent:TextView by bind<TextView>(R.id.tvPercent)
    private val seekbar:SeekBar by bind<SeekBar>(R.id.seekBar)
    private val tvResult:TextView by bind<TextView>(R.id.tvResult)
    private val btnShow: Button by bind<Button>(R.id.btnShowDialog)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        processControllers()
    }

    fun processControllers(){
        seekbar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvPercent.text=progress.toString()
                var inputValue:String=etInput.text.toString()
                if(!inputValue.isNullOrEmpty())
                {
                    val input:Int= inputValue.toString().toInt()
                    tvResult.text="${input*(100-progress)/100}"
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        btnShow.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                var dialog=AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("顯示")
                        .setMessage("您按了按鈕嚕，幹的好!!")
                        .show()
            }
        })
    }
}
