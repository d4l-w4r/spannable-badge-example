package examples.com.spannablebadges;


import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public class AndroidTagBadgeBuilder implements TagBadgeBuilder {

    private final SpannableStringBuilder stringBuilder;
    private final String textColor;
    final int lineHeight;

    public AndroidTagBadgeBuilder(SpannableStringBuilder stringBuilder, int lineHeight,String textColor) {
        this.stringBuilder = stringBuilder;
        this.lineHeight = lineHeight;
        this.textColor = textColor;
    }

    public void appendTag(String tagName, String badgeColor) {
        final String nbspSpacing = "\u202F\u202F"; // none-breaking spaces

        String badgeText = nbspSpacing + tagName + nbspSpacing;
        stringBuilder.append(badgeText);
        stringBuilder.setSpan(
                new TagBadgeSpannable(lineHeight, Color.parseColor(textColor), Color.parseColor(badgeColor)),
                stringBuilder.length() - badgeText.length(),
                stringBuilder.length() - badgeText.length() + badgeText.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        stringBuilder.append("  ");
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
