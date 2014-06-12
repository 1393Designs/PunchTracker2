package com.designs_1393.punchtracker2;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VictimRow extends RelativeLayout{

    private String _name;
    private String _num;
    private Button plusButton;
    private Button minusButton;
    private Cursor cursor;
    private Context context;

    public VictimRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();

        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);

        plusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                _name = ((TextView) findViewById(R.id.ShortTextMain)).getText().toString();
                _num  = ((TextView) findViewById(R.id.LongTextMain)).getText().toString();

            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _name = ((TextView) findViewById(R.id.ShortTextMain)).getText().toString();
                _num = ((TextView) findViewById(R.id.LongTextMain)).getText().toString();

            }
        });
    }
}
