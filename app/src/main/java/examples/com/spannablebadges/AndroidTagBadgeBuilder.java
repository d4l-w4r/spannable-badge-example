package examples.com.spannablebadges;


import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public class AndroidTagBadgeBuilder implements TagBadgeBuilder {

    final int lineHeight;
    private final SpannableStringBuilder stringBuilder;
    private final String textColor;

    public AndroidTagBadgeBuilder(SpannableStringBuilder stringBuilder, int lineHeight, String textColor) {
        this.stringBuilder = stringBuilder;
        this.lineHeight = lineHeight;
        this.textColor = textColor;
    }

    public void appendTag(String tagName, String badgeColor) {
        appendTag(tagName, badgeColor, null);
    }

    @Override
    public void appendTag(String tagName, String badgeColor, @Nullable SpannableClickAction clickAction) {
        final String nbspSpacing = "\u202F\u202F"; // none-breaking spaces
        String badgeText = nbspSpacing + tagName + nbspSpacing;

        appendVisibleTag(badgeText, badgeColor);

        if (clickAction != null) {
            appendClickOverlay(badgeText, clickAction);
        }

        // add some extra white space between this and the next tag
        stringBuilder.append("  ");
    }

    private void appendVisibleTag(String badgeText, String badgeColor) {
        stringBuilder.append(badgeText);
        stringBuilder.setSpan(
                new TagBadgeSpannable(lineHeight, Color.parseColor(textColor), Color.parseColor(badgeColor)),
                stringBuilder.length() - badgeText.length(),
                stringBuilder.length() - badgeText.length() + badgeText.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
    }

    private void appendClickOverlay(String badgeText, @NonNull SpannableClickAction clickAction) {
        stringBuilder.setSpan(new SpannableClickOverlay(clickAction),
                stringBuilder.length() - badgeText.length(),
                stringBuilder.length() - badgeText.length() + badgeText.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public CharSequence getTags() {
        return stringBuilder;
    }

    @Override
    public void clear() {
        stringBuilder.clear();
        stringBuilder.clearSpans();
    }

}
