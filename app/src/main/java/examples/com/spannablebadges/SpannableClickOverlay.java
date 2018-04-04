package examples.com.spannablebadges;

import android.support.annotation.NonNull;
import android.text.style.ClickableSpan;
import android.view.View;


public class SpannableClickOverlay extends ClickableSpan {

    private final SpannableClickAction clickAction;

    public SpannableClickOverlay(@NonNull SpannableClickAction clickAction) {
        this.clickAction = clickAction;
    }

    @Override
    public void onClick(View view) {
        clickAction.onClick();
    }
}

