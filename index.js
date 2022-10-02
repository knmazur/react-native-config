'use strict';

// Bridge to:
// Android: buildConfigField vars set in build.gradle, and exported via ReactConfig
// iOS: config vars set in xcconfig and exposed via ReactNativeConfig.m
import { NativeModules } from 'react-native';

const isTurboModuleEnabled = global.__turboModuleProxy != null;
const module = isTurboModuleEnabled ? require('./codegen/NativeConfig').default : (NativeModules.ReactNativeConfigModule || {});
const Config = isTurboModuleEnabled ? module.getTurboConstants() : module;

export default Config;
