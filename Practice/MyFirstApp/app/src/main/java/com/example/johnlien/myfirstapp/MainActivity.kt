package com.example.johnlien.myfirstapp

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.JohnLien.UserData.*
import com.Utility.*

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //在這個函式中，宣告或建立需要的監聽物件，處理所有需要註冊的工作
        processControllers()


    }

    private fun processControllers(){
        //region 這裡是為了Button事件
        //var btn=findViewById<Button>(R.id.btnShow)
        //使用lazy by 方式延遲初始化，記得 Lazy by 一 定要用 val
        //latinit只能用 var
        val btn:Button by bind<Button>(R.id.btnShow)

        btn.setOnClickListener({
            Toast.makeText(this,R.string.app_name,Toast.LENGTH_LONG).show()
        })
        /* 匿名方式 1
        val btn=findViewById<Button>(R.id.btnShow)
         btn.setOnClickListener({
            Toast.makeText(this,R.string.app_name,Toast.LENGTH_LONG)
        })
        */
        //endregion

        //region 建立ListView控制項
        var listView=findViewById<ListView>(R.id.lvDetail)
        var list= arrayListOf<String>("John Lien1","John Line2","John Lien3")

        listView.adapter=MyCustomAdapter(list,this)
/*
        listView.setOnItemClickListener({parent,view,position,id->{
            Toast.makeText(this,R.string.app_name,Toast.LENGTH_LONG).show()
        }})
*/
        //建立Item長按的事件
        listView.setOnItemLongClickListener({parent, view, position, id ->
            Toast.makeText(this,"您常按了選單",Toast.LENGTH_LONG).show()
            true
        })
        //endregion
    }

    //region 這是給Menu使用
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menuFirst->{
                Toast.makeText(this,"您按的是:第一個選單",Toast.LENGTH_LONG).show()

            }
            R.id.menuSecond->{
                Toast.makeText(this,"您按的是:第二個選單",Toast.LENGTH_LONG).show()
            }
            R.id.menuThird->{
                val diaglog=AlertDialog.Builder(this)
                diaglog.setTitle("顯示")
                        .setMessage("您按的是:第三個選單")
                        .show()
            }
        }
        return true
    }
    //endregion
}
