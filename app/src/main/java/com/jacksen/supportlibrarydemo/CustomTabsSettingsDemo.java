package com.jacksen.supportlibrarydemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.jacksen.supportlibrarydemo.broadcast.ShareBroadcastReceiver;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * custom tabs settings
 *
 * @author jacksen
 */
public class CustomTabsSettingsDemo extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.test_url_et)
    EditText testUrlEt;
    @Bind(R.id.set_action_button)
    CheckBox setActionButton;
    @Bind(R.id.custom_add_menus)
    CheckBox customAddMenus;
    @Bind(R.id.show_title)
    CheckBox showTitle;
    @Bind(R.id.custom_back_button)
    CheckBox customBackButton;
    @Bind(R.id.auto_hide_checkbox)
    CheckBox autoHideCheckbox;
    @Bind(R.id.add_toolbaritem_checkbox)
    CheckBox addToolbaritemCheckbox;
    @Bind(R.id.secondary_toolbar_color)
    CheckBox setSecondaryToolbarColor;
    @Bind(R.id.start_animations_checkbox)
    CheckBox startAnimationsCheckbox;
    @Bind(R.id.exit_animations_checkbox)
    CheckBox exitAnimationsCheckbox;
    @Bind(R.id.set_toolbar_color_checkbox)
    CheckBox setToolbarColorCheckbox;
    @Bind(R.id.start_custom_tab)
    Button startCustomTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tabs_settings);
        ButterKnife.bind(this);

    }

    /**
     * setToolbarColor
     *
     * @param builder
     */
    private void setToolbarColor(CustomTabsIntent.Builder builder) {
        if (setToolbarColorCheckbox.isChecked()) {
            int color = getResources().getColor(R.color.colorPrimary);
            builder.setToolbarColor(color);
        }
    }

    /**
     * setCloseButtonIcon
     *
     * @param builder
     */
    private void setCloseButtonIcon(CustomTabsIntent.Builder builder) {
        if (customBackButton.isChecked()) {
            Bitmap closeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back);
            builder.setCloseButtonIcon(closeIconBitmap);
        }
    }

    /**
     * show Title
     *
     * @param builder
     */
    private void showTitle(CustomTabsIntent.Builder builder) {
        if (showTitle.isChecked()) {
            builder.setShowTitle(true);
        }
    }

    /**
     * @param builder
     */
    private void setAutoHide(CustomTabsIntent.Builder builder) {
        if (autoHideCheckbox.isChecked()) {
            builder.enableUrlBarHiding();
        }
    }

    /**
     * setActionButton
     *
     * @param builder
     */
    private void setActionButton(CustomTabsIntent.Builder builder) {
        if (setActionButton.isChecked()) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                    android.R.drawable.ic_menu_share);
            builder.setActionButton(bitmap, "share", createSharePendingIntent());
        }
    }

    /**
     * addMenuItem
     *
     * @param builder
     */
    private void addMenuItem(CustomTabsIntent.Builder builder) {
        if (customAddMenus.isChecked()) {
            builder.addMenuItem("menu item 1", createSharePendingIntent());
        }
    }

    /**
     * addToolBarItem
     *
     * @param builder
     */
    private void addToolBarItem(CustomTabsIntent.Builder builder) {
        if (addToolbaritemCheckbox.isChecked()) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                    android.R.drawable.ic_menu_help);
            builder.addToolbarItem(1, bitmap, "help", createSharePendingIntent());
        }
    }

    /**
     * setSecondaryToolbarColor
     *
     * @param builder
     */
    private void setSecondaryToolbarColor(CustomTabsIntent.Builder builder) {
        if (setSecondaryToolbarColor.isChecked()) {
            builder.setSecondaryToolbarColor(Color.parseColor("#009688"));
        }
    }

    /**
     * setStartAnimation
     *
     * @param builder
     */
    private void setStartAnimation(CustomTabsIntent.Builder builder) {
        if (startAnimationsCheckbox.isChecked()) {
            builder.setStartAnimations(this, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        }
    }

    /**
     * setExitAnimation
     *
     * @param builder
     */
    private void setExitAnimation(CustomTabsIntent.Builder builder) {
        if (exitAnimationsCheckbox.isChecked()) {
            builder.setExitAnimations(this, R.anim.slide_in_from_top, R.anim.slide_out_to_bottom);
        }
    }

    /**
     * open chrome custom tab
     */
    private void openCustomTabs() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();

        setToolbarColor(builder);
        setCloseButtonIcon(builder);
        showTitle(builder);
        setAutoHide(builder);
        setActionButton(builder);
        addMenuItem(builder);
        addToolBarItem(builder);
        setSecondaryToolbarColor(builder);
        setStartAnimation(builder);
        setExitAnimation(builder);

        String url = testUrlEt.getText().toString();


        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    /**
     * @return
     */
    private PendingIntent createSharePendingIntent() {
        Intent actionIntent = new Intent(this, ShareBroadcastReceiver.class);
        return PendingIntent.getBroadcast(this, 0, actionIntent, 0);
    }

    /**
     *
     */
    private void createAndShowNotification() {

    }

    @OnClick(value = {R.id.start_custom_tab})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_custom_tab:
                openCustomTabs();
                break;
            default:

                break;
        }
    }
}
