package com.example.witold.android4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;

public class ActionBarActivity extends Activity implements ActionBar.TabListener {

    Fragment11 f11;
    Fragment12 f12;
    Fragment13 f13;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_action_bar);

        f11 = new Fragment11();
        f12 = new Fragment12();
        f13 = new Fragment13();
        transakcja = getFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener2, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener2, f12);
        transakcja.detach(f12);
        transakcja.add(R.id.kontener2, f13);
        transakcja.detach(f13);

        ActionBar myAB = getActionBar();
        myAB.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = myAB.newTab().setText("tab1").setTabListener(this);
        ActionBar.Tab tab2 = myAB.newTab().setText("tab2").setTabListener(this);
        ActionBar.Tab tab3 = myAB.newTab().setText("tab3").setTabListener(this);
        myAB.addTab(tab1);
        myAB.addTab(tab2);
        myAB.addTab(tab3);
        myAB.selectTab(tab1);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        transakcja = getFragmentManager().beginTransaction();
        int tabNumber = tab.getPosition();
        switch (tabNumber) {
            case 0:
                transakcja.attach(f11);
                break;
            case 1:
                transakcja.attach(f12);
                break;
            case 2:
                transakcja.attach(f13);
                break;
        }
        transakcja.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        int tabNumber = tab.getPosition();
        transakcja = getFragmentManager().beginTransaction();
        switch (tabNumber) {
            case 0:
                transakcja.detach(f11);
                break;
            case 1:
                transakcja.detach(f12);
                break;
            case 2:
                transakcja.detach(f13);
                break;
        }
        transakcja.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }
}
