import { NativeModules } from 'react-native';

type TxplayerType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Txplayer } = NativeModules;

export default Txplayer as TxplayerType;
