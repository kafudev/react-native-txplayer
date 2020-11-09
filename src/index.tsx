import { requireNativeComponent, NativeModules } from 'react-native';
const { Txplayer } = NativeModules;
const TxplayerView = requireNativeComponent('TxplayerView');

export async function multiply(a: number, b: number) {
  return await Txplayer.multiply(a, b);
}

export default TxplayerView;
