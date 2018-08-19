package com.afree.canary.sample.develop.controller;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.afree.canary.base.BaseController;
import com.afree.canary.sample.develop.DevelopActivity;
import com.afree.canary.sample.main.model.CommonModel;
import com.afree.canary.sample.main.view.DesignItemContainer;

/**
 * @author afree8909@gmail.com on 6/23/16.
 */
public class DevelopItemController extends BaseController<DesignItemContainer, CommonModel> {
    @Override
    public void bind(DesignItemContainer view, final CommonModel model) {
        if (model == null) {
            return;
        }
        view.getTvName().setText(model.getName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DevelopActivity.launch(v.getContext(), model.getFragmentName());
            }
        });


        view.getEvName().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isChinese(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    public static boolean isChinese(CharSequence cs) {


        boolean flag = false;
        for (int i = 0, len = cs.length(); i < len; i++) {

            char c = cs.charAt(i);

            if (isChinese(c)) {

                flag = true;
                break;
            }
        }

        return flag;
    }

    public static boolean isChinese(char c) {

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS

                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS

                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A

                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION

                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION

                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {

            return true;

        }

        return false;
    }

}
