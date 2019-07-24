package com.example.myawesomemenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(imageView)

        imageView.setOnClickListener{
            var popUp = PopupMenu(this,it)
            popUp.inflate(R.menu.openpicture_menu)
            popUp.show()

            popUp.setOnMenuItemClickListener { menuItem ->
                val i = Intent(this, Main2Activity::class.java)
                when(menuItem.itemId)
                {
                    R.id.open -> {
                        startActivity(i)
                        true
                    }
                    else -> {
                        false
                    }
                }

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.quit -> {
                Toast.makeText(this, "Quiting", Toast.LENGTH_LONG).show()
            }
            R.id.sharing -> {
                Toast.makeText(this, "Sharing", Toast.LENGTH_LONG).show()
            }
            R.id.setting -> {
                Toast.makeText(this, "Opening setting", Toast.LENGTH_LONG).show()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.openpicture_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.open -> {
                val i = Intent(this, Main2Activity::class.java)
                startActivity(i)
            }
        }

        return super.onContextItemSelected(item)
    }



}
