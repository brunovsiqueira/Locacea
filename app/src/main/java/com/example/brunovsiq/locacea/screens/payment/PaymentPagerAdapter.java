package com.example.brunovsiq.locacea.screens.payment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PaymentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;

    private PaymentActivity paymentActivity;

    private boolean isForeigner;

    public PaymentPagerAdapter(FragmentManager fm, PaymentActivity activity) {
        super(fm);
        this.paymentActivity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return paymentActivity.page1;
            case 1:
                return paymentActivity.page2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


}
