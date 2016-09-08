package my.assignment.actionbartab;

import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import my.assignment.actionbartab.adapter.Pager;


public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    Pager adapter;
    TabLayout tabLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding ToolBar to the Activity
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.android);

        //initializing the tab layout
         tabLay=(TabLayout)findViewById(R.id.tablayout);

        //Creating our pager adapter
        vp=(ViewPager)findViewById(R.id.viewPager);
        adapter = new Pager(getSupportFragmentManager(), tabLay.getTabCount());
        adapter.addFragment(new AudioFragment(), "Audio");
        adapter.addFragment(new VideoFragment(), "Video");




        //Adding adapter to pager
        vp.setAdapter(adapter);
        tabLay.setupWithViewPager(vp);
       // tabLay.getTabAt(0).setIcon(R.drawable.android_128x128_32);
        //tabLay.getTabAt(1).setIcon(R.drawable.android_128x128_32);
        createTabIcon();

    }
    public void createTabIcon(){
        TextView tabOne=(TextView) LayoutInflater.from(this).inflate(R.layout.custome_tab,null);
        tabOne.setText("Audio");
        tabOne.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.android_32_black,0,0,0);
        tabLay.getTabAt(0).setCustomView(tabOne);
        TextView tabTwo=(TextView) LayoutInflater.from(this).inflate(R.layout.custome_tab,null);
        tabTwo.setText("Video");
        tabTwo.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.android_32_black,0,0,0);
        tabLay.getTabAt(1).setCustomView(tabTwo);
    }


}
