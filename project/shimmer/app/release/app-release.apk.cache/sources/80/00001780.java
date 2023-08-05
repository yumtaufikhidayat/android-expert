package com.yumtaufikhidayat.tourismappflow.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yumtaufikhidayat.tourismappflow.R;

/* loaded from: classes.dex */
public final class ActivityDetailTourismBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final ContentDetailTourismBinding content;
    public final FloatingActionButton fab;
    public final ImageView ivDetailImage;
    private final CoordinatorLayout rootView;
    public final Toolbar toolbar;

    private ActivityDetailTourismBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ContentDetailTourismBinding contentDetailTourismBinding, FloatingActionButton floatingActionButton, ImageView imageView, Toolbar toolbar) {
        this.rootView = coordinatorLayout;
        this.appBar = appBarLayout;
        this.content = contentDetailTourismBinding;
        this.fab = floatingActionButton;
        this.ivDetailImage = imageView;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDetailTourismBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDetailTourismBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_detail_tourism, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDetailTourismBinding bind(View view) {
        View findChildViewById;
        int i = R.id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i);
        if (appBarLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.content))) != null) {
            ContentDetailTourismBinding bind = ContentDetailTourismBinding.bind(findChildViewById);
            i = R.id.fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
            if (floatingActionButton != null) {
                i = R.id.iv_detail_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                    if (toolbar != null) {
                        return new ActivityDetailTourismBinding((CoordinatorLayout) view, appBarLayout, bind, floatingActionButton, imageView, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}