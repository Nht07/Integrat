package com.fifthmain.integrated;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    EditText text;
    EditText text2;
    Button genQR;
    ImageView imgQR;
    String texttoQR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.entName);
        text2 = (EditText)findViewById(R.id.entAadhar);
        genQR = (Button)findViewById(R.id.btnGen);
        imgQR = (ImageView)findViewById(R.id.imgQR);
        genQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text2.getText().toString().length()==12){
                texttoQR = text.getText().toString().concat("/"+text2.getText().toString()).trim();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(texttoQR, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    imgQR.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }}
                else{
                    Toast.makeText(MainActivity.this,"Invalid Aadhar",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
