package submission1.footballclub

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity()
{

    private var image: Int = 0
    private lateinit var imageView: ImageView

    private var name: String = ""
    private lateinit var nameTextView: TextView

    private var description: String = ""
    private lateinit var descriptionTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        verticalLayout {
            lparams {
                width = matchParent
                height = wrapContent
                gravity = Gravity.CENTER
            }

            imageView = imageView().lparams(dip(70), dip(70))
            {
                padding = dip(10)
                gravity = Gravity.CENTER
            }


            nameTextView = textView()
            {
                padding = dip(10)
                setTypeface(null, Typeface.BOLD)
                gravity = Gravity.CENTER
            }

            descriptionTextView = textView()
            {
                padding = dip(10)
                gravity = Gravity.FILL
            }

        }

        val intent = intent

        image = intent.getIntExtra("image", 0)
        Picasso.get().load(image).into(imageView)

        name = intent.getStringExtra("name")
        nameTextView.text = name

        description = intent.getStringExtra("description")
        descriptionTextView.text = description

    }

}