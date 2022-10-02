// @flow
import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
    +getTurboConstants: () => Object;
}

export default (TurboModuleRegistry.get<Spec>(
    'ReactNativeConfigModule'
    ): ?Spec);