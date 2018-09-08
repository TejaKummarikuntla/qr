package com.coffee.qrcodescanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coffee.qrcodescanner.ListActivityPack.ListActivity;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    public static String[] mNames = new String[] {"Teja Kummarikuntla","Manisai Prasad","Rafi Naqvi","someoneElse","Hello", "Dell","Hp","Divyanshu"," Charlotte Doyle "," Stephen Sherman "," Eugene Craig "," Nina Hicks "," Christie Romero "};
    public String[] mScanned = new String[]{"0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public int p = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button qrScanBtn = findViewById(R.id.qrScanBtn);
        qrScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QRScanActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        Button showList = findViewById(R.id.listBtn);
        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int flag = 5;
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String qrCodeValue = data.getStringExtra("QR_CODE_VALUE");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                for(int x =0;x< mNames.length;x++){
                    if (qrCodeValue.equals(mNames[x]) && mScanned[x].equals("0")) {
                        flag = 0;
                        mScanned[x]="1";
                        //p = x;
                        break;
                        } else if (qrCodeValue.equals(mNames[x]) && mScanned[x].equals("1")) {
                        flag =2;
                        break;
                    } else {
                        if (!qrCodeValue.equals(mNames[x])) {
                            flag = 1;
                        }
                    }
                }

                if (flag == 0) {
                    builder.setTitle("Access Granted");
                    builder.setMessage("ThankYou").setIcon(R.drawable.access_granted);

                } else if (flag == 1) {
                    builder.setTitle("Access Denied");
                    builder.setMessage("Sorry, You are not in the List").setIcon(R.drawable.denied);

                } else if(flag ==2  ){
                    builder.setTitle("Already Exists");
                    builder.setMessage("Let's Have some Fun!!").setIcon(R.drawable.alert);

                }
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
