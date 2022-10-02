package com.lugg.ReactNativeConfig;

import android.content.res.Resources;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReactNativeConfigModuleImpl {
  public static final String NAME = "ReactNativeConfigModule";

  public static Map<String, Object> getConstants(ReactApplicationContext context) {
    final Map<String, Object> constants = new HashMap<>();

    try {
      int resId = context.getResources().getIdentifier("build_config_package", "string", context.getPackageName());
      String className;
      try {
        className = context.getString(resId);
      } catch (Resources.NotFoundException e) {
        className = context.getApplicationContext().getPackageName();
      }
      Class clazz = Class.forName(className + ".BuildConfig");
      Field[] fields = clazz.getDeclaredFields();
      for(Field f: fields) {
        try {
          constants.put(f.getName(), f.get(null));
        }
        catch (IllegalAccessException e) {
          Log.d("ReactNative", "ReactConfig: Could not access BuildConfig field " + f.getName());
        }
      }
    }
    catch (ClassNotFoundException e) {
      Log.d("ReactNative", "ReactConfig: Could not find BuildConfig class");
    }

    return constants;
  }
}
