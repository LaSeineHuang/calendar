package com.example.calendar.activity.view;

import android.content.Context;
import android.view.ViewStub;

import com.example.calendar.R;


public class PickerViewDialog extends BottomFullWidthDialog {

    public PickerViewDialog(Context context) {
        super(context, 0);
        super.setContentView(R.layout.top_defaults_view_pickerview_dialog);
    }

    @Override
    public void setContentView(int layoutResID) {
        ViewStub stub = findViewById(R.id.content);
        stub.setLayoutResource(layoutResID);
        stub.inflate();
    }
}
