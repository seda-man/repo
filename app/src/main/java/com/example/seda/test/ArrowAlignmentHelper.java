package com.example.seda.test;

import android.graphics.RectF;
import android.view.View;

/**
 * Created by seda on 5/20/16.
 */
public final class ArrowAlignmentHelper {
    public static float calculateArrowMidPoint(ToolTipView view, RectF rectF) {
        int offset = view.getAlignmentOffset();
        float middle = 0f;
        int arrowPosition = view.getArrowPosition();
        if (arrowPosition == 0 || arrowPosition == 1) {
            switch (view.getArrowAlignment()) {
                case START:
                    middle = offset == 0 ? rectF.width() / 4 : offset;
                    break;
                case CENTER:
                    middle = rectF.width() / 2;
                    if (offset > 0)
                        throw new IllegalArgumentException(
                                "Offsets are not support when the tooltip arrow is anchored in the middle of the view.");
                    break;
                case END:
                    middle = rectF.width();
                    middle -= (offset == 0 ? rectF.width() / 4 : offset);
                    break;
                case ANCHORED_VIEW:
                    middle = rectF.width() / 2;
                    if (view.getAnchoredViewId() != View.NO_ID) {
                        View anchoredView = ((View) view.getParent())
                                .findViewById(view.getAnchoredViewId());
                        middle += anchoredView.getX() + anchoredView.getWidth() / 2 - view.getX()
                                - view.getWidth() / 2;
                    }
                    break;
            }

        } else {
            switch (view.getArrowAlignment()) {
                case START:
                    middle = offset == 0 ? rectF.height() / 4 : offset;
                    break;
                case CENTER:
                    middle = rectF.height() / 2;
                    if (offset > 0)
                        throw new IllegalArgumentException(
                                "Offsets are not support when the tooltip arrow is anchored in the middle of the view.");
                    break;
                case END:
                    middle = rectF.height();
                    middle -= (offset == 0 ? rectF.height() / 4 : offset);
                    break;
                case ANCHORED_VIEW:
                    middle = rectF.height() / 2;
                    if (view.getAnchoredViewId() != View.NO_ID) {
                        View anchoredView = ((View) view.getParent())
                                .findViewById(view.getAnchoredViewId());
                        middle += anchoredView.getY() + anchoredView.getHeight() / 2 - view.getY()
                                - view.getHeight() / 2;
                    }
                    break;
            }
        }
        return middle;
    }
}
