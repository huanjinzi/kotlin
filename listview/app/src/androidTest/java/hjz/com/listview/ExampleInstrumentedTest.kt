package hjz.com.listview

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.AttributeSet
import android.util.Xml
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.xmlpull.v1.XmlPullParser
import java.nio.charset.Charset

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val android = "http://schemas.android.com/apk/res/android"
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("hjz.com.listview", appContext.packageName)
    }

    @Test
    fun inflate(){
        val appContext = InstrumentationRegistry.getTargetContext()
        val assert = appContext.assets
        val input = assert.open("inflate.xml")

        val parser = Xml.newPullParser()
        parser.setInput(input.reader(Charset.forName("utf-8")))

        val attrs = Xml.asAttributeSet(parser)
        val type = parser.next()
        while (type != XmlPullParser.START_TAG && type != XmlPullParser.END_DOCUMENT) parser.next()

        val name = parser.name
        val id = parser.getAttributeValue("http://schemas.android.com/apk/res/android","id")

        val view = if (name == "LinearLayout") LinearLayout(appContext)
        else View(appContext)

        view.contentDescription = "$name : $id"

        rInflateChildren(parser,view,attrs)

        input.close()

    }

    fun rInflate(parser: XmlPullParser, parent: View, attrs: AttributeSet, context: Context) {

        val depth = parser.depth
        var type = parser.next()

        while (type != XmlPullParser.END_TAG || depth < parser.depth && type != XmlPullParser.END_DOCUMENT) {

            if (type != XmlPullParser.START_TAG) {
                type = parser.next()
                continue
            }

            val name = parser.name
            val id = attrs.getAttributeValue("http://schemas.android.com/apk/res/android","id")

            val view = if (name == "LinearLayout") LinearLayout(context)
            else View(context)

            view.contentDescription = "$name : $id"

            (parent as? ViewGroup)?.addView(view)

            rInflateChildren(parser,view,attrs)

        }

    }

    fun rInflateChildren(parser: XmlPullParser, parent: View, attrs: AttributeSet){

        rInflate(parser,parent,attrs,parent.context)
    }

    @Test
    fun xmlPull(){
        val context = InstrumentationRegistry.getTargetContext()

        val input = context.assets.open("inflate.xml")

        val parser =  Xml.newPullParser()
        parser.setInput(input.reader(Charset.forName("utf-8")))

        var type = parser.next()

        while (type != XmlPullParser.END_DOCUMENT) {
            if (type == XmlPullParser.START_TAG) {println(parser.name + ":${parser.getAttributeValue(android,"id")}")}
            type = parser.next()
        }
    }
}
