// Generated by view binder compiler. Do not edit!
package com.opensw.mainscreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.opensw.mainscreen.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMatchingStartBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnBackToHome;

  @NonNull
  public final Button btnMatchingStart;

  @NonNull
  public final Spinner spinner;

  private FragmentMatchingStartBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton btnBackToHome, @NonNull Button btnMatchingStart,
      @NonNull Spinner spinner) {
    this.rootView = rootView;
    this.btnBackToHome = btnBackToHome;
    this.btnMatchingStart = btnMatchingStart;
    this.spinner = spinner;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMatchingStartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMatchingStartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_matching_start, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMatchingStartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBackToHome;
      ImageButton btnBackToHome = ViewBindings.findChildViewById(rootView, id);
      if (btnBackToHome == null) {
        break missingId;
      }

      id = R.id.btnMatchingStart;
      Button btnMatchingStart = ViewBindings.findChildViewById(rootView, id);
      if (btnMatchingStart == null) {
        break missingId;
      }

      id = R.id.spinner;
      Spinner spinner = ViewBindings.findChildViewById(rootView, id);
      if (spinner == null) {
        break missingId;
      }

      return new FragmentMatchingStartBinding((ConstraintLayout) rootView, btnBackToHome,
          btnMatchingStart, spinner);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
