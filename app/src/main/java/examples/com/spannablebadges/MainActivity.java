package examples.com.spannablebadges;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;


import java.util.Arrays;
import java.util.List;

import examples.com.spannablebadges.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static final String TEXT_COLOR = "#ffffff";

    // Excuse the weird colors
    private final List<TagDto> dummyTagData = Arrays.asList(
            TagDto.createWith("#Dummy1", "#3BC23F"),
            TagDto.createWith("#Dummy2", "#29BDCC"),
            TagDto.createWith("#Dummy3", "#6B255E"),
            TagDto.createWith("#Dummy4", "#382DB5"),
            TagDto.createWith("#Dummy5", "#ff2c2a"),
            TagDto.createWith("#Dummy6", "#6B255E"),
            TagDto.createWith("#Dummy7", "#29BDCC"),
            TagDto.createWith("#Dummy8", "#29BDCC"),
            TagDto.createWith("#ExtraLargeDummyFTW", "#382DB5"),
            TagDto.createWith("#Dummy9", "#3BC23F"),
            TagDto.createWith("#Dummy10", "#6B255E")
    );

    private ActivityMainBinding dataBinding; // auto-generated
    private BadgeListViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBinding = DataBindingUtil.bind(findViewById(R.id.content));

        final TagBadgeBuilder badgeBuilder = new AndroidTagBadgeBuilder(new SpannableStringBuilder(), 2, TEXT_COLOR);
        viewModel = new BadgeListViewModel(badgeBuilder);
        dataBinding.setViewModel(viewModel);

        loadData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        viewModel.clearTags();
        super.onSaveInstanceState(outState);
    }

    private void loadData() {
        // Logic to fetch data. Just insert dummy list for now
        viewModel.setTags(dummyTagData);
    }
}
