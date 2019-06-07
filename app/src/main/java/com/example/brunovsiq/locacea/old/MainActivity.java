package com.example.brunovsiq.locacea.old;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.brunovsiq.locacea.R;
import com.example.brunovsiq.locacea.old.new_contract.*;

public class MainActivity extends AppCompatActivity {

    private Button newContractButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewItems();
    }

    private void findViewItems() {

        newContractButton = findViewById(R.id.main_new_contract);

        newContractButton.setOnClickListener(newContractClickListener);

    }

    View.OnClickListener newContractClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(MainActivity.this, ContractActivity.class));

        }
    };

}
