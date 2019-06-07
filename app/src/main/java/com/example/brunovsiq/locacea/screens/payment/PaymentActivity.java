package com.example.brunovsiq.locacea.screens.payment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.design.widget.*;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.brunovsiq.locacea.R;
import com.example.brunovsiq.locacea.basic.BasicActivity;

public class PaymentActivity extends BasicActivity {

    private TabLayout tabLayout;
    public ViewPager viewPager;
    private TextView toolbarTitle;

    protected PaymentFragment1 page1;
    protected PaymentFragment2 page2;

    public static int numberOfItems = 2; //number of pages

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setupLayout();
        instantiateFragments();
    }

    private void setupLayout() {
        tabLayout = (TabLayout) findViewById(R.id.register_tab);
        viewPager = (ViewPager) findViewById(R.id.register_viewpager);

        viewPager.setAdapter(new PaymentPagerAdapter(getSupportFragmentManager(), PaymentActivity.this));
        viewPager.setOffscreenPageLimit(numberOfItems-1); //keeps all fragments on memory;
        tabLayout.setupWithViewPager(viewPager, true);

        toolbarTitle = (TextView) findViewById(R.id.toolbar_event_menus_title);

        toolbarTitle.setText("Pagamento");
        viewPager.setOnTouchListener(pagerTouchListener);
    }

    private void instantiateFragments() {

        page1 = new PaymentFragment1();
        page2 = new PaymentFragment2();
    }

    public void goesForwardOnePage() {
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    View.OnTouchListener pagerTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (viewPager.getCurrentItem() > 0) {
                return false; //pode retornar a pagina
            } else {
                return true;
            }
        }
    };
}
