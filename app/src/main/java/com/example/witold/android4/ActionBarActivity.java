package com.example.witold.android4;

import android.app.ActionBar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActionBarActivity extends AppCompatActivity implements ActionBar.TabListener {

    Fragment11 f11;
    Fragment12 f12;
    Fragment13 f13;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        f11 = new Fragment11();
        f12 = new Fragment12();
        f13 = new Fragment13();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener, f12);
        transakcja.detach(f12);
        transakcja.add(R.id.kontener, f13);
        transakcja.detach(f13);

        ActionBar myAB = getActionBar();
        myAB.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab myT = myAB.newTab();
        myT.setText("tab1").setTabListener(this);
        myAB.addTab(myT);
        myT = myAB.newTab().setTabListener(this).setText("tab2");
        myAB.addTab(myT);
        myT = myAB.newTab().setTabListener(this).setText("tab3");
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        int tabNumber = tab.getPosition();
        switch (tabNumber) {
            case 1:
                transakcja.detach(f12);
                transakcja.detach(f13);
                transakcja.attach(f11);
                break;
            case 2:
                transakcja.detach(f11);
                transakcja.detach(f13);
                transakcja.attach(f12);
                break;
            case 3:
                transakcja.detach(f12);
                transakcja.detach(f11);
                transakcja.attach(f13);
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }
}
