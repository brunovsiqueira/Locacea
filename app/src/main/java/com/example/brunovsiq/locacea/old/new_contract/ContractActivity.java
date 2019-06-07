package com.example.brunovsiq.locacea.old.new_contract;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.brunovsiq.locacea.R;
import com.example.brunovsiq.locacea.basic.BasicActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Scanner;

public class ContractActivity extends BasicActivity implements DatePickerDialog.OnDateSetListener {

    static final int REQUEST_IMAGE_CAPTURE_FRONT = 1;
    static final int REQUEST_IMAGE_CAPTURE_VERSE = 2;

    private TextView toolbarTitle;
    private Button initialDateButton;
    private Button finalDateButton;
    private Button scanButton;
    private Bitmap imageBitmapFrente;
    private Bitmap imageBitmapVerso;

    private int day;
    private int year;
    private int month;
    private boolean isInitial;

    private DialogFragment initialDateDialog;
    private DialogFragment finalDateDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        findViewItems();

    }

    private void findViewItems() {

        toolbarTitle = findViewById(R.id.toolbar_title);
        initialDateButton = findViewById(R.id.contract_initial_date);
        finalDateButton = findViewById(R.id.contract_final_date);
        scanButton = findViewById(R.id.contract_scan_button);

        toolbarTitle.setText("Novo Contrato");
        initialDateButton.setOnClickListener(initialDateClickListener);
        finalDateButton.setOnClickListener(finalDateClickListener);
        scanButton.setOnClickListener(scanClickListener);

    }

    public void showDatePicker(boolean isInitial) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        this.isInitial = isInitial;

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog datePickerDialog;

        datePickerDialog = new DatePickerDialog(ContractActivity.this, this, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();


    }

    private void dispatchTakePictureIntentFront() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_FRONT);
        }
    }

    private void dispatchTakePictureIntentVerse() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_VERSE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE_FRONT && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmapFrente = (Bitmap) extras.get("data");
            //mImageView.setImageBitmap(imageBitmap);
            dispatchTakePictureIntentVerse();
        } else if (requestCode == REQUEST_IMAGE_CAPTURE_VERSE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmapVerso = (Bitmap) extras.get("data");

            try {
                writeOnDocument();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeOnDocument() throws FileNotFoundException {
        FileInputStream in = null;
        FileOutputStream out = null;
        out = new FileOutputStream("documento.pages");

        File file = new File("abhishek.txt");
        Scanner scanner = new Scanner(file).useDelimiter("\n");
        String line = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(line);
        //String newLine = line.substring(0, 5) + "Abhishek" + line.substring(5);

//        FileWriter writer = new FileWriter(file);
//        writer.write(newLine);
//        writer.close();


    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        if (isInitial) {
            initialDateButton.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
        } else {
            finalDateButton.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
        }

    }

    View.OnClickListener initialDateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDatePicker(true);
        }
    };

    View.OnClickListener finalDateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDatePicker(false);
        }
    };

    View.OnClickListener scanClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dispatchTakePictureIntentFront();
        }
    };
}
