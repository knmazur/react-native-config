package com.lugg.ReactNativeConfig;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;

import java.util.Map;

public class ReactNativeConfigModule extends NativeConfigSpec {
  public ReactNativeConfigModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return ReactNativeConfigModuleImpl.NAME;
  }

  @Override
  public WritableMap getTurboConstants() {
    Map<String, Object> constants = ReactNativeConfigModuleImpl.getConstants(getReactApplicationContext());
    WritableMap result = Arguments.createMap();

    for(Map.Entry<String, Object> entry: constants.entrySet()) {
        result.putString(entry.getKey(), entry.getValue().toString());
    }

    return result;
  }
}
