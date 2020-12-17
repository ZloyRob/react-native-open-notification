import { NativeModules, Platform, Linking } from 'react-native';

const open = () => {
  if (Platform.OS === 'ios') {
    Linking.openURL('app-settings:');
  } else {
    NativeModules.OpenNotification.open();
  }
};

export const openChannelSettings = (channelId) => {
  if (Platform.OS === 'ios') {
    Linking.openURL('app-settings:');
  } else {
    NativeModules.OpenNotification.openChannelSettings(channelId);
  }
};

export const openNotificationSettings = () => {
  if (Platform.OS === 'ios') {
    Linking.openURL('app-settings:');
  } else {
    NativeModules.OpenNotification.openNotificationSettings();
  }
};

export default { open };
