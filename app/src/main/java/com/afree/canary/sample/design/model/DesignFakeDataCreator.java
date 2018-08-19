package com.afree.canary.sample.design.model;

import com.afree.canary.sample.design.fragment.AnimatorFragment;
import com.afree.canary.sample.design.fragment.CoordinatorLayoutFragment;
import com.afree.canary.sample.main.model.CommonModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author afree8909@gmail.com on 6/29/16.
 */
public class DesignFakeDataCreator {

  private static final String[] NAMES = {
      "Animator", "CoordinatorLayout", "NavigationView", "AppBarLayout", "CollapsingToolbarLayout",
      "CollapsingToolbarLayout", "Snackbar", "FloatingActionButton", "TextInputLayout"
  };

  private static final String[] FRAGMENT_NAMES = {
      AnimatorFragment.class.getName(), CoordinatorLayoutFragment.class.getName()
  };


  public static List<CommonModel> create() {
    List<CommonModel> list = new ArrayList<>();
    for (int i = 0; i < FRAGMENT_NAMES.length; i++) {
      CommonModel m = new CommonModel(NAMES[i], FRAGMENT_NAMES[i]);
      list.add(m);
    }
    return list;
  }
}
