/*
 * Copyright 2018 Keval Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance wit
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 *  the specific language governing permissions and limitations under the License.
 */

package com.kevalpatel2106.fingerprint_dialog_compat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;

/**
 * Created by Keval on 08/04/18.
 * Utils class for all the module.
 *
 * @author [kevalpatel2106](https : / / github.com / kevalpatel2106)
 */
public class FingerprintUtils {

    /**
     * Get the application icon.
     *
     * @param context {@link Context} of the caller.
     * @return {@link Drawable} icon of the application.
     * @throws PackageManager.NameNotFoundException If the package npt found.
     */
    @NonNull
    static Drawable getApplicationIcon(@NonNull final Context context) throws PackageManager.NameNotFoundException {
        try {
            return context.getPackageManager().getApplicationIcon(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Open the Security settings screen.
     *
     * @param context instance of the caller.
     */
    public static void openSecuritySettings(@NonNull final Context context) {
        Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
        context.startActivity(intent);
    }

    /**
     * Check if the device have supported hardware fir the finger print scanner.
     *
     * @param context instance of the caller.
     * @return true if device have the hardware.
     */
    public static boolean isSupportedHardware(@NonNull final Context context) {
        FingerprintManagerCompat fingerprintManager = FingerprintManagerCompat.from(context);
        return fingerprintManager.isHardwareDetected();
    }
}
