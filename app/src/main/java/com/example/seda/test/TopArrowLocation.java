package com.example.seda.test;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by seda on 5/20/16.
 */
public class TopArrowLocation implements ArrowLocation {

    @Override
    public void ConfigureDraw(ToolTipView view, Canvas canvas) {
        view.setTooltipPath(new Path());
        RectF rectF = new RectF(canvas.getClipBounds());
        rectF.top += view.getArrowHeight();

        view.getTooltipPath().addRoundRect(rectF, view.getCornerRadius(), view.getCornerRadius(),
                Path.Direction.CW);

        float middle = ArrowAlignmentHelper.calculateArrowMidPoint(view, rectF);

        view.getTooltipPath().moveTo(middle, 0f);
        int arrowDx = view.getArrowWidth() / 2;
        view.getTooltipPath().lineTo(middle - arrowDx, rectF.top);
        view.getTooltipPath().lineTo(middle + arrowDx, rectF.top);
        view.getTooltipPath().close();

        view.setPaint(new Paint(Paint.ANTI_ALIAS_FLAG));
        view.getTooltipPaint().setColor(view.getTooltipColor());
    }
}