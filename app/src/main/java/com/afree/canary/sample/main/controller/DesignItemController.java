package com.afree.canary.sample.main.controller;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;

import com.afree.canary.base.BaseController;
import com.afree.canary.sample.design.DesignActivity;
import com.afree.canary.sample.main.model.CommonModel;
import com.afree.canary.sample.main.view.DesignItemContainer;

/**
 * @author afree8909@gmail.com on 6/23/16.
 */
public class DesignItemController extends BaseController<DesignItemContainer, CommonModel> {
    private String html = "<ul>\n" +
            "  <li>请携带所有入住人的身份证，报确认号<font color=\"red\">32345678、87654321</font>办理入住</li>\n" +
            "  <li>请在10月10日14:00后入住，10月11日12:00之后办理离地店</li>\n" +
            "  <li>请在10月10日14:00后入住，10月11日12:00之后办理离地店</li>\n" +
            "</ul>";

    @Override
    public void bind(DesignItemContainer view, final CommonModel model) {
        if (model == null) {
            return;
        }
        view.getTvName().setText(Html.fromHtml(html));

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DesignActivity.launch(v.getContext(), model.getFragmentName());
//            }
//        });

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

            isChinese(c);

        }

        return flag;
    }

    public static boolean isChinese(char c) {

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS // CJK 统一表意符号

                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS //CJK 兼容象形文字

                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A //CJK 统一表意符号扩展 A

                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION //常用标点

                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION //CJK 符号和标点

                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS//半角及全角形式
                ) {

            return true;

        }

        return false;
    }


}
