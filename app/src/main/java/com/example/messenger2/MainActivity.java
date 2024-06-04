package com.example.messenger2;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.messenger2.UserChat.User;
import com.example.messenger2.UserChat.UserAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mviewPager;
    private BottomNavigationView mbottomNavigationView;
    private UserAdapter userAdapter;
    private List<User> mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mviewPager = findViewById(R.id.view_pager);
        mbottomNavigationView = findViewById(R.id.bottom_nav);

        mviewPager.setAdapter(new ViewPagerAdapter(this));
        mviewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mbottomNavigationView.setSelectedItemId(R.id.tab_chat);
                        break;
                    case 1:
                        mbottomNavigationView.setSelectedItemId(R.id.tab_danhba);
                        break;
                    case 2:
                        mbottomNavigationView.setSelectedItemId(R.id.tab_tin);
                        break;
                }
            }
        });

//        mbottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.tab_chat:
//                        mviewPager.setCurrentItem(0);
//                        return true;
//                    case R.id.tab_danhba:
//                        mviewPager.setCurrentItem(1);
//                        return true;
//                    case R.id.tab_tin:
//                        mviewPager.setCurrentItem(2);
//                        return true;
//                }
//                return false;
//            }
//        });
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        mviewPager.setAdapter(adapter);
//
//        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//

    }
}