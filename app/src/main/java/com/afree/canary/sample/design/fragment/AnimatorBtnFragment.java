package com.afree.canary.sample.design.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afree.canary.R;
import com.afree.canary.base.BaseFragment;

/**
 * @author afree8909@gmail.com on 7/5/16.
 */
public class AnimatorBtnFragment extends BaseFragment {

  private ViewGroup mContainer;

  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mContainer = (ViewGroup) inflater.inflate(R.layout.main_develop_fragment, container, false);
    return mContainer;
  }
}
