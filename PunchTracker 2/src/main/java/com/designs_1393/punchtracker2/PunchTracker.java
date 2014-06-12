package com.designs_1393.punchtracker2;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PunchTracker extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch_tracker);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.punch_tracker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.add_victim:
                addVictim();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addVictim() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_dialog);
        dialog.setCancelable(true);
        dialog.setTitle(R.string.adding_a_victim);

        final EditText victimNameInput = (EditText) dialog.findViewById(R.id.addVictimEntry);

        Button cancelButton = (Button) dialog.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button confirmButton = (Button) dialog.findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String victimName = victimNameInput.getText().toString();
                Victim newVictim = new Victim(victimName, 0);

            }
        });

        dialog.show();
    }
}
