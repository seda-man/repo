package com.example.seda.test;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by seda on 5/20/16.
 */
public class RightArrowLocation implements ArrowLocation {

    @Override
    public void ConfigureDraw(ToolTipView view, Canvas canvas) {
        view.setTooltipPath(new Path());
        RectF rectF = new RectF(canvas.getClipBounds());
        rectF.right -= view.getArrowWidth();
        view.getTooltipPath()
                .addRoundRect(rectF, view.getCornerRadius(), view.getCornerRadius(), Path.Direction.CW);

        float middle = ArrowAlignmentHelper.calculateArrowMidPoint(view, rectF);

        view.getTooltipPath().moveTo(view.getWidth(), middle);
        int arrowDy = view.getArrowHeight() / 2;
        view.getTooltipPath().lineTo( rectF.right, middle - arrowDy);
        view.getTooltipPath().lineTo(rectF.right, middle + arrowDy);
        view.getTooltipPath().close();

        view.setPaint(new Paint(Paint.ANTI_ALIAS_FLAG));
        view.getTooltipPaint().setColor(view.getTooltipColor());
    }
}
