package com.rodrigomirandamarenco.android.fonts;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextViewLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewLabel = (TextView) findViewById(R.id.textViewLabel);

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                final String[] fontTypes = getResources().getStringArray(R.array.font_types);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.dialog_title));
                builder.setItems(fontTypes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {
                        if (fontTypes[item].equals(getString(R.string.font_type_normal))) {
                            mTextViewLabel.setTypeface(Typeface.create(mTextViewLabel.getTypeface(), Typeface.NORMAL));
                        } else if (fontTypes[item].equals(getString(R.string.font_type_italic))) {
                            mTextViewLabel.setTypeface(Typeface.create(mTextViewLabel.getTypeface(), Typeface.ITALIC));
                        }
                    }

                });
                builder.show();
                break;
        }
    }

}
