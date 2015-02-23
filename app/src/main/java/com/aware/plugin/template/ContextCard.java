package com.aware.plugin.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import com.aware.Magnetometer;

import com.aware.Aware;
import com.aware.Aware_Preferences;
import com.aware.utils.Aware_Plugin;
import com.aware.utils.IContextCard;

public class ContextCard implements IContextCard, View.OnClickListener {

    //Empty constructor used to instantiate this card
    private final String INSIDE = "IN";
    private final String OUTSIDE = "OUT";
    private Context context;

    private String label = null;

    public ContextCard(){};

    @Override
    public View getContextCard(Context context) {


        //Inflate and return your card's layout. See LayoutInflater documentation.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View card = (View) inflater.inflate(R.layout.card, null);

        this.context = context;

        //Modify card's content

        Button in = (Button)card.findViewById(R.id.inbutton);
        in.setOnClickListener(this);
        Button out = (Button)card.findViewById(R.id.outbutton2);
        out.setOnClickListener(this);

        return card;

    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.inbutton:
                /*Intent newLabel = new Intent(Magnetometer.ACTION_AWARE_MAGNETOMETER_LABEL);
                newLabel.putExtra(Magnetometer.EXTRA_LABEL, INSIDE);
                context.sendBroadcast(newLabel);*/
                break;
            case R.id.outbutton2:
                break;
            default:
                break;
        }

    }

}
