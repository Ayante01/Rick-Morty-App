package cr.ac.ucr.rickmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import cr.ac.ucr.rickmorty.adapters.MainViewPagerAdapter;
import cr.ac.ucr.rickmorty.fragments.CharacterFragment;
import cr.ac.ucr.rickmorty.fragments.EpisodeFragment;
import cr.ac.ucr.rickmorty.fragments.LocationsFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager vPager;
    private TabLayout tlTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tToolbar = findViewById(R.id.t_toolbar);
        setSupportActionBar(tToolbar);

        tlTabs = findViewById(R.id.tl_tabs);

        vPager = findViewById(R.id.vp_pager);

        setupViewPager();
    }

    private void setupViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        ArrayList<String> titles = new ArrayList<>();
        titles.add("CHARACTERS");
        titles.add("LOCATIONS");
        titles.add("EPISODES");


        fragments.add(CharacterFragment.newInstance());
        fragments.add(LocationsFragment.newInstance());
        fragments.add(EpisodeFragment.newInstance());

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragments, titles);

        vPager.setAdapter(mainViewPagerAdapter);

        tlTabs.setupWithViewPager(vPager);
    }
}