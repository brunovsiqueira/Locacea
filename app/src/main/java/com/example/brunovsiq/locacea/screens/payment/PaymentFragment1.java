package com.example.brunovsiq.locacea.screens.payment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.brunovsiq.locacea.R;

public class PaymentFragment1 extends Fragment {

    private View view;
    private Button nextButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_payment_1, container, false);

        findViewItems(view);

        return view;
    }

    private void findViewItems(View view) {

        nextButton = view.findViewById(R.id.register1_next);

        nextButton.setOnClickListener(nextClickListener);

    }

    View.OnClickListener nextClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //validates
            ((PaymentActivity) getActivity()).goesForwardOnePage();
        }
    };

}

