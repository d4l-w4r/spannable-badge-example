package examples.com.spannablebadges;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

public class BadgeListViewModel extends BaseObservable {
    private final TagBadgeBuilder badgeBuilder;
    private List<TagDto> tags;

    public BadgeListViewModel(TagBadgeBuilder badgeBuilder) {
        this.badgeBuilder = badgeBuilder;
        this.tags = new ArrayList<>();
    }

    @Bindable
    public CharSequence getRenderedTagBadges() {
        return createTagBadges();
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
        notifyChange();
    }

    public void clearTags() {
        badgeBuilder.clear();
    }

    private CharSequence createTagBadges() {
        for (TagDto tag : tags) {
            badgeBuilder.appendTag(tag.getName(), tag.getColorHex());
        }

        return badgeBuilder.getTags();
    }

}
