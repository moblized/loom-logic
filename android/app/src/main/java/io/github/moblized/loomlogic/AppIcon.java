package io.github.moblized.loomlogic;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.res.Configuration;

/**
 * Swaps the home-screen icon between the light and dark versions to match the phone's dark mode,
 * which the game follows. Called when the app goes to the background, because switching the
 * launcher entry while the app is on screen can close it on some phones.
 */
final class AppIcon {
    private AppIcon() {}

    static boolean phoneIsDark(Activity activity) {
        int night = activity.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return night == Configuration.UI_MODE_NIGHT_YES;
    }

    static void sync(Activity activity, boolean dark) {
        String base = activity.getPackageName();
        PackageManager pm = activity.getPackageManager();
        ComponentName light = new ComponentName(base, MainActivity.class.getPackage().getName() + ".LauncherLight");
        ComponentName darkAlias = new ComponentName(base, MainActivity.class.getPackage().getName() + ".LauncherDark");
        ComponentName wanted = dark ? darkAlias : light;
        ComponentName other = dark ? light : darkAlias;

        // Leave it alone when it already matches, so the launcher isn't disturbed.
        if (isEnabled(pm, wanted, light) && !isEnabled(pm, other, light)) return;

        try {
            // Turn the new one on first so there's always an icon to tap.
            pm.setComponentEnabledSetting(wanted, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            pm.setComponentEnabledSetting(other, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        } catch (RuntimeException ignored) {
        }
    }

    private static boolean isEnabled(PackageManager pm, ComponentName component, ComponentName light) {
        switch (pm.getComponentEnabledSetting(component)) {
            case PackageManager.COMPONENT_ENABLED_STATE_ENABLED:
                return true;
            case PackageManager.COMPONENT_ENABLED_STATE_DEFAULT:
                return component.equals(light);
            default:
                return false;
        }
    }
}
