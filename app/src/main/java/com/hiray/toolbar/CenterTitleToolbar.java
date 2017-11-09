package com.hiray.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * @author: hiray
 * @date 2017/11/6
 */
public class CenterTitleToolbar extends Toolbar {

    private AppCompatTextView titleTextView;

    public CenterTitleToolbar(Context context) {
        this(context, null);
    }

    public CenterTitleToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

    }

    public CenterTitleToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    @SuppressLint("PrivateResource")
    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        super.setTitle(null);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Toolbar, defStyleAttr, 0);
        // same as ToolBar's default color
        int titleTextColor = a.getColor(R.styleable.Toolbar_titleTextColor, 0xffffffff);
        //fetch the customized TextAppearance
        int appearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        String title = a.getString(R.styleable.Toolbar_title);
        a.recycle();
        titleTextView = new AppCompatTextView(context);
        LayoutParams layoutParams = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        titleTextView.setLayoutParams(layoutParams);
        titleTextView.setText(title);
        titleTextView.setTextColor(titleTextColor);

        if (appearance != 0)
            titleTextView.setTextAppearance(context, appearance);
        else
            titleTextView.setTextAppearance(context, R.style.TextAppearance_AppCompat_Title);
        addView(titleTextView);
    }


    //override  setting text to our own textview
    @Override
    public void setTitle(CharSequence title) {
        if (titleTextView != null) {
            titleTextView.setText(title);
        }
    }

    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getResources().getString(resId));
    }
}
