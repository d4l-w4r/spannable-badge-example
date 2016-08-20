package examples.com.spannablebadges;

public interface TagBadgeBuilder {

    void appendTag(String tagName, String badgeColor);

    CharSequence getTags();

    void clear();
}
