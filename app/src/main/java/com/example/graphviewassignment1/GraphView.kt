package com.example.graphviewassignment1

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import java.util.*
import kotlin.math.absoluteValue

@SuppressLint("AppCompatCustomView")
class GraphView(context: Context, attributeSet: AttributeSet?) : ImageView(context, attributeSet) {
    var bgLines = Paint(Paint.HINTING_OFF)
    var backgroundLinesColor = Color.CYAN

    var values: Array<Int>? = null
        set(value) {
            field = value
            invalidate()
        }
    var paint = Paint()

    init {
        bgLines.color = backgroundLinesColor
        bgLines.textSize=40F
        paint.setColor(Color.RED)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)



        if (values == null) {
            return
        }
var yAxisLine=height.toFloat()/12;
        var barWidth = width / values!!.size
        var percentageHeight = height / 100
        canvas?.drawLine(0F,height.toFloat(),width.toFloat(),height.toFloat(),bgLines)
        for (i in 0 until 12){
            canvas?.drawLine(0F,
                yAxisLine*i,
                width.toFloat(),
                yAxisLine*i,
                bgLines)
        }

        canvas?.drawText("100", 0F,25F, bgLines)
        for(i in 0 until 140 step 10) {
            canvas?.drawText(
                i.toString(),
                0F,
                height - (yAxisLine * (i/10)),
                bgLines)


        }












                var left = 0

        var random = Random()

        for (i in 0..values!!.size - 1) {

            paint.setColor(Color.rgb(random.nextInt().absoluteValue%255, random.nextInt().absoluteValue%255, random.nextInt().absoluteValue%255))

            canvas!!.drawRect(
                left.toFloat(), (height - percentageHeight * values!![i]).toFloat() ,
                left + barWidth.toFloat() -10, height.toFloat(),
                paint
            )
            left += barWidth
        }


    }

}


