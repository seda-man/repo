package com.example.seda.test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class TooltipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltip);

        Button button = (Button) findViewById(R.id.header_1);


        if (button != null) {
            final ToolTipView tooltip = new ToolTipView(TooltipActivity.this);
            tooltip.setTooltipColor(Color.BLUE);
            tooltip.setArrowAlignment(ArrowAlignment.ANCHORED_VIEW);
            tooltip.setArrowPositioning(3);
            tooltip.setArrowHeight(20);
            tooltip.setArrowWidth(30);
            tooltip.setAnchoredViewId(button.getId());
            tooltip.setText("meooooow");
            tooltip.setVisibility(View.GONE);

            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);
            relativeLayout.addView(tooltip);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    ToolTipView tooltip1 = (ToolTipView) findViewById(R.id.tooltip_1);
                    if (tooltip.getVisibility() == View.GONE) {
                        tooltip.setVisibility(View.VISIBLE);
                    } else {
                        tooltip.setVisibility(View.GONE);
                    }


                }
            });
        }
    }
}
