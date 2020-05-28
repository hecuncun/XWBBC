package com.cvnchina.xingwanban.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.cvnchina.xingwanban.R;

/**
 * Created by hecuncun on 2020-5-2
 */
public class LimitScrollEditText extends LinearLayout {
    private String hint;
    private int maxLength;

    private EditText content;
    private TextView textCount;
    private TextWatcher textWatcher;
    private int hintTextColor;
    private int textColor;

    public LimitScrollEditText(Context context) {
        this(context, null);
    }

    public LimitScrollEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LimitScrollEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        initView(context);
        initData();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.LimitScrollEditText);
        if (arr != null) {
            hint = arr.getString(R.styleable.LimitScrollEditText_hint);
            maxLength = arr.getInt(R.styleable.LimitScrollEditText_maxLength, 0);
            maxLength = arr.getInt(R.styleable.LimitScrollEditText_maxLength, 0);
            hintTextColor=arr.getColor(R.styleable.LimitScrollEditText_hintTextColor, Color.parseColor("#CCCCCC"));
            textColor=arr.getColor(R.styleable.LimitScrollEditText_textColor, Color.parseColor("#000000"));
            arr.recycle();
        }
    }

    private void initView(Context context) {
        inflate(context, R.layout.layout_limit_scroll_edittext, this);
        // 因为布局layout_limit_scroll_edittext使用了merge标签, 所以需要设置方向
        setOrientation(VERTICAL);
        content = (EditText) findViewById(R.id.content);
        content.setTextColor(textColor);
        content.setHintTextColor(hintTextColor);
        textCount = (TextView) findViewById(R.id.textCount);
    }

    private void initData() {
        setHint(hint);
        setMaxLength(maxLength);
        setTextWatcher();
    }

    public void setHint(String hint) {
        if (!TextUtils.isEmpty(hint)) content.setHint(hint);
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = Math.max(0, maxLength);
        content.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.maxLength)});
        setTextCount();
    }

    private void setTextWatcher() {
        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setTextCount();
            }
        };

        content.addTextChangedListener(textWatcher);
    }

    private void setTextCount() {
        if (TextUtils.isEmpty(content.getText().toString())) {
            String str="<font color='#F37E00'>0</font>/"+maxLength;
            textCount.setText(Html.fromHtml(str));
        } else {
            String str="<font color='#F37E00'>"+content.getText().toString().length()+"</font>/"+maxLength;
            textCount.setText( Html.fromHtml(str));
        }

        if(content.getText().toString().length()==maxLength){
            ToastUtils.showShort("已达到最大输入字符限制");
        }
    }

    public String getTextString() {
        return TextUtils.isEmpty(content.getText().toString())? "" : content.getText().toString().trim();
    }

    public void setTextString(String str){
        content.setText(str);
    }
}
