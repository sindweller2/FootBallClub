package submission1.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import submission1.footballclub.R.array.*
import submission1.footballclub.R.layout.activity_main

class MainActivity : AppCompatActivity()
{
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items)

        {
            startActivity<DetailActivity>("image" to it.image, "name" to it.name, "description" to it.description)
        }
    }

    private fun initData()
    {
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val description = resources.getStringArray(club_description)

        items.clear()

        for (i in name.indices)
        {
            items.add(Item(name[i], image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }
}
