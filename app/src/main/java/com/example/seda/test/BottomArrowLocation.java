package com.example.seda.test;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by seda on 5/20/16.
 */
public class BottomArrowLocation implements ArrowLocation {

    @Override
    public void ConfigureDraw(ToolTipView view, Canvas canvas) {
        view.setTooltipPath(new Path());
        RectF rectF = new RectF(canvas.getClipBounds());
        rectF.bottom -= view.getArrowHeight();
        view.getTooltipPath()
                .addRoundRect(rectF, view.getCornerRadius(), view.getCornerRadius(), Path.Direction.CW);

        float middle = ArrowAlignmentHelper.calculateArrowMidPoint(view, rectF);

        view.getTooltipPath().moveTo(middle, view.getHeight());
        int arrowDx = view.getArrowWidth() / 2;
        view.getTooltipPath().lineTo(middle - arrowDx, rectF.bottom);
        view.getTooltipPath().lineTo(middle + arrowDx, rectF.bottom);
        view.getTooltipPath().close();

        view.setPaint(new Paint(Paint.ANTI_ALIAS_FLAG));
        view.getTooltipPaint().setColor(view.getTooltipColor());
    }
}
