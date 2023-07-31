package com.yumtaufikhidayat.tourismappkoin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import com.google.android.material.navigation.NavigationView;
import com.yumtaufikhidayat.tourismappflow.R;
import com.yumtaufikhidayat.tourismappflow.databinding.ActivityMainBinding;
import com.yumtaufikhidayat.tourismappkoin.favorite.FavoriteFragment;
import com.yumtaufikhidayat.tourismappkoin.home.HomeFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/yumtaufikhidayat/tourismappkoin/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "binding", "Lcom/yumtaufikhidayat/tourismappflow/databinding/ActivityMainBinding;", "getBinding", "()Lcom/yumtaufikhidayat/tourismappflow/databinding/ActivityMainBinding;", "binding$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "setUi", "app_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final Lazy binding$delegate = LazyKt.lazy(new Function0<ActivityMainBinding>() { // from class: com.yumtaufikhidayat.tourismappkoin.MainActivity$binding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ActivityMainBinding invoke() {
            return ActivityMainBinding.inflate(MainActivity.this.getLayoutInflater());
        }
    });

    private final ActivityMainBinding getBinding() {
        return (ActivityMainBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getBinding().getRoot());
        setSupportActionBar(getBinding().appBarMain.toolbar);
        setUi(bundle);
    }

    private final void setUi(Bundle bundle) {
        ActivityMainBinding binding = getBinding();
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.appBarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                return;
            }
            supportActionBar.setTitle(getString(R.string.menu_home));
        }
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem item) {
        FavoriteFragment favoriteFragment;
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        ActivityMainBinding binding = getBinding();
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            favoriteFragment = new HomeFragment();
            str = getString(R.string.menu_home);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.menu_home)");
        } else if (itemId == R.id.nav_favorite) {
            favoriteFragment = new FavoriteFragment();
            str = getString(R.string.menu_favorite);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.menu_favorite)");
        } else {
            if (itemId == R.id.nav_map) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tourismapp://maps")));
            }
            favoriteFragment = null;
            str = "";
        }
        if (favoriteFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, favoriteFragment).commit();
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(str);
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}