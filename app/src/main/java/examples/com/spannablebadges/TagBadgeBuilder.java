package examples.com.spannablebadges;

import android.support.annotation.Nullable;

public interface TagBadgeBuilder {

    void appendTag(String tagName, String badgeColor);

    void appendTag(String tagName, String badgeColor, @Nullable SpannableClickAction clickAction);

    CharSequence getTags();

    void clear();
}
