package com.example.linechartapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class MainActivity : AppCompatActivity() {

    lateinit var lineChart: LineChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lineChart = findViewById(R.id.lineChart)

        setLineChartData()

    }

    private fun setLineChartData() {

        val xValue = ArrayList<String>()

        xValue.add("JUl")
        xValue.add("Aug")
        xValue.add("Sep")
        xValue.add("Oct")
        xValue.add("Nov")



        val lineEntry = ArrayList<Entry>()
        lineEntry.add(Entry(200f,0))
        lineEntry.add(Entry(500f,1))
        lineEntry.add(Entry(600f,2))
        lineEntry.add(Entry(300f,3))
        lineEntry.add(Entry(100f,4))


        val lineEntry1 = ArrayList<Entry>()
        lineEntry1.add(Entry(100f,0))
        lineEntry1.add(Entry(400f,1))
        lineEntry1.add(Entry(700f,2))
        lineEntry1.add(Entry(300f,3))
        lineEntry1.add(Entry(200f,4))

        val lineDataSet = LineDataSet(lineEntry,"Product 1")
        lineDataSet.color = ContextCompat.getColor(this,R.color.purple_700)

        val lineDataSet1 = LineDataSet(lineEntry1,"Product 2")
        lineDataSet1.color = ContextCompat.getColor(this,R.color.purple_200)


        val finalDataSet = ArrayList<LineDataSet>()
        finalDataSet.add(lineDataSet)
        finalDataSet.add(lineDataSet1)

        val data = LineData(xValue, finalDataSet as List<ILineDataSet>?)
        lineChart.data = data
        lineChart.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
        lineChart.animateXY(2000,2000)






    }
}