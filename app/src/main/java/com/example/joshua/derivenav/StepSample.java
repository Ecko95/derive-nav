package com.example.joshua.derivenav;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.fcannizzaro.materialstepper.AbstractStep;

/**
 * Created by Joshua on 18/11/2017.
 */

public class StepSample extends AbstractStep {

    private int i = 1;
    private Button button;
    private final static String CLICK = "click";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.step, container, false);
        button = (Button) v.findViewById(R.id.button);

        if (savedInstanceState != null)
            i = savedInstanceState.getInt(CLICK, 0);

        button.setText(Html.fromHtml("Tap <b>" + i + "</b>"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Button) view).setText(Html.fromHtml("Tap <b>" + (++i) + "</b>"));
                mStepper.getExtras().putInt(CLICK, i);
            }
        });

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(CLICK, i);
    }

    @Override
    public String name() {
        return "Step! " + getArguments().getInt("position", 0);
    }

    @Override
    public boolean isOptional() {
        return true;
    }


    @Override
    public void onStepVisible() {
    }

    @Override
    public void onNext() {
        System.out.println("onNext");
    }

    @Override
    public void onPrevious() {
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
        int tabId = getArguments().getInt("position",getId());
        if (tabId == 1)
        {
            return "subtitle 1";
        }else if(tabId == 2){
            return "subtitle 2";
        }else if(tabId == 3) {
            return "subtitle 3";
        }else if(tabId == 4) {
            return "subtitle 4";
        }else if(tabId == 5) {
            return "subtitle 5";
        }else{
            return String.valueOf(false);
        }

    }

    @Override
    public boolean nextIf() {
        return i > 1;
    }

    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }

}
