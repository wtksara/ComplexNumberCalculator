package pl.polsl.tm

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.PointsGraphSeries

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val database = getSharedPreferences("data", Context.MODE_PRIVATE)
        val re:Float = database.getFloat("Re",0.0f)
        val im:Float = database.getFloat("Im",0.0f)

        val graph = findViewById<GraphView>(R.id.graph)
        val series = PointsGraphSeries(arrayOf(
            DataPoint(re.toDouble(), im.toDouble())
        ))

        graph.gridLabelRenderer.horizontalAxisTitle="Re"
        graph.gridLabelRenderer.verticalAxisTitle="Im"
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.setMinY(-15.0)
        graph.viewport.setMaxY(15.0)

        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.setMinX(-15.0)
        graph.viewport.setMaxX(15.0)

        graph.addSeries(series)
        series.shape = PointsGraphSeries.Shape.POINT
        series.color = Color.RED
    }
}