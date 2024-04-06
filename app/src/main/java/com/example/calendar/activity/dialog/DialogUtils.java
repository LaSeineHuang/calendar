package com.example.calendar.activity.dialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.calendar.R;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DialogUtils {

    /**
     * 日期选择弹窗
     * @param context
     * @param Listener
     */
    public static void showDatePickerDialog(Context context,DatePickerDialog.OnDateSetListener Listener){
            Calendar calendar = Calendar.getInstance();//调用Calendar类获取年月日
            int  mYear = calendar.get(Calendar.YEAR);//年
            int  mMonth = calendar.get(Calendar.MONTH);//月份要加一个一，这个值的初始值是0。不加会日期会少一月。
            int  mDay = calendar.get(Calendar.DAY_OF_MONTH);//日
            DatePickerDialog datePickerDialog = new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, Listener, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数
            datePickerDialog.show();//显示dialog

    }

    /**
     * 日期查询弹窗
     * @param context
     */
    public static void showDateQueryDialog(Context context, IConfirmAndCancelCallBack callBack){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(LayoutInflater.from(context).inflate(R.layout.dialog_input, null));
        Dialog dialog = builder.create();
        dialog.show();
        EditText editTextDate = dialog.findViewById(R.id.et_query_date);
        editTextDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 文本改变之前的处理逻辑
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 文本正在改变的处理逻辑
            }

            @Override
            public void afterTextChanged(Editable s) {//YYYY-MM-DD
                // 文本改变之后的处理逻辑
//                if (s.length() == 4){
//                    editTextDate.setText(s.toString()+"-");
//                } else if (s.length() == 5) {
////                    editTextDate.setText(s.toString().substring(0,4));
//                }

            }
        });
        dialog.findViewById(R.id.bt_dialog_query_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editTextDate.getText())){
                    callBack.confirm(editTextDate.getText().toString());
                }
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.bt_dialog_query_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.cancel();
                dialog.dismiss();
            }
        });

    }



}
