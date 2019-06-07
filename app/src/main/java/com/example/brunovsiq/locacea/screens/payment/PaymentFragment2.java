package com.example.brunovsiq.locacea.screens.payment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.brunovsiq.locacea.R;

public class PaymentFragment2 extends Fragment {

    private View view;
    private Button registerButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_payment_2, container, false);

        findViewItems(view);

        return view;
    }

    private void findViewItems(View view) {

        registerButton = view.findViewById(R.id.register_card_register);

        registerButton.setOnClickListener(registerClickListener);



    }

    View.OnClickListener registerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final ProgressDialog pd = new ProgressDialog(view.getContext());
            pd.setMessage("Efetuando reserva");
            pd.show();

            //success on payment
            //success on reservation
            pd.dismiss();
            //go to success activity
        }
    };

}
