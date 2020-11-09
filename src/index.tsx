import React, { Component } from 'react';
import { requireNativeComponent, NativeModules, View } from 'react-native';
import PropTypes from 'prop-types';
const { Txplayer } = NativeModules;
const RCTTxplayerView = requireNativeComponent('TxplayerView');

export async function multiply(a: number, b: number) {
  return await Txplayer.multiply(a, b);
}

export default class TxplayerView extends Component {
  static defaultProps = {
    ...Component.defaultProps,
    style: {},
    showVideoView: false,
  };

  propTypes = {
    ...View,
    style: PropTypes.object,
    showVideoView: PropTypes.bool,
  };

  render() {
    return <RCTTxplayerView {...this.props} />;
  }
}

// TxplayerView.propTypes = {
//   showVideoView: PropTypes.bool,
//   ...View.propTypes,
// };
