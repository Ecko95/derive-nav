package com.example.joshua.derivenav;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.DotStepper;
import com.github.fcannizzaro.materialstepper.style.TabStepper;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

/**
 * Created by Joshua on 18/11/2017.
 */

public class tabsUI extends DotStepper{
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Toolbar activityToolbar = findViewById(R.id.toolbar);

        //set toolbar appearance
//        activityToolbar.setTitle("Fragment 1");
        setSupportActionBar(activityToolbar);

//        getSupportActionBar().hide();



//
        setErrorTimeout(1500);
        setTitle("Tab UI activity");

        addStep(createFragment(new StepSample()));
        addStep(createFragment(new StepSample()));
        addStep(createFragment(new StepSample()));
        addStep(createFragment(new StepSample()));
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


    }



    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;

    }

    @Override
    public void onComplete(Bundle data) {
        Toast.makeText(this, "Complete!", Toast.LENGTH_SHORT).show();
        finish();
        super.onComplete(data);
    }


}
