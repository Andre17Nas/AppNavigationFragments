package com.andrenas.learnfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.andrenas.learnfragments.fragments.FavoriteFragment;
import com.andrenas.learnfragments.fragments.HomeFragment;
import com.andrenas.learnfragments.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.bottomNavigationView = this.findViewById(R.id.bottom_nav);
        this.mViewHolder.bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener
            navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
            Fragment selectFragment =  null;

            switch (Item.getItemId()){
                case R.id.item_home:
                    selectFragment = new HomeFragment();
                    break;
                case R.id.item_favorite:
                    selectFragment = new FavoriteFragment();
                    break;
                case R.id.item_search:
                    selectFragment =  new SearchFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();

            return true;
        }
    };

    private static class ViewHolder{
        BottomNavigationView bottomNavigationView;
    }
}
