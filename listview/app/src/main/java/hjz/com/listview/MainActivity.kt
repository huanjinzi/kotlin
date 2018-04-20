package hjz.com.listview

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Xml
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private lateinit var text: TextView
    private lateinit var button: Button
    private lateinit var list: ListView
    private lateinit var handler: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linearlayout)

        val container: LinearLayout = findViewById(R.id.container)
        val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        list = inflater.inflate(R.layout.listview, null) as ListView
        button = inflater.inflate(R.layout.button, null) as Button
        text = inflater.inflate(R.layout.textview, null) as TextView

        handler = Handler(Looper.getMainLooper())

        val istrem: InputStream = assets.open("activity_main.xml")
        val parser :XmlPullParser = Xml.newPullParser()
        parser.setInput(istrem.reader(Charset.defaultCharset()))

        val attrs = Xml.asAttributeSet(parser)
        var sb  = StringBuilder()

        var type = parser.next()
        while (type != XmlPullParser.START_TAG && type != XmlPullParser.END_DOCUMENT) type = parser.next()
        sb.append(parser.name+"\n")

        for (index in 0 until attrs.attributeCount) {
            sb.append(attrs.getAttributeName(index))
            sb.append(" = ")
            sb.append(attrs.getAttributeValue(index))
            sb.append("\n")
        }
        sb.append("namespace:"+attrs.getAttributeValue("http://schemas.android.com/apk/res/android","id"))

        text.text = sb

        istrem.close()
        container.addView(list)
        container.addView(button)
        container.addView(text)
    }


}
