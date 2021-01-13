package com.quarterlife.autolayouttest;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class HideBottom {
    public static boolean setHidden = true; // 控制是否要隱藏系統底部欄（測試用）

    /*   測試時 setHidden 須設定為 true（因手機預設有底部系統欄），
     *   隱藏底部系統欄後，顯示的 UI 比例才是對的。
     *   PS. 因正式機台沒有底部系統欄，所以測試完成後，設定為 false 就可以了。   */

    // 隱藏 Android 下方系統內建虛擬按鍵，並且全螢幕
    public static void hideBottomMenu(Window window) {
        if(setHidden){
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
                View v = window.getDecorView();
                v.setSystemUiVisibility(View.GONE);
            } else if (Build.VERSION.SDK_INT >= 19) {
                Window _window = window;
                WindowManager.LayoutParams params = _window.getAttributes();
                params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;
                _window.setAttributes(params);
            }
        }
    }
}