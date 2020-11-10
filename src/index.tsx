import React, { Component } from 'react';
import { requireNativeComponent, NativeModules, View } from 'react-native';
import PropTypes from 'prop-types';
const { Txplayer } = NativeModules;
const RCTTxplayerView = requireNativeComponent('RCTTxplayerView');

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

  _onChange = (event: Event) => {
    if (!this.props.onChangeMessage) {
      return;
    }
    this.props.onChangeMessage(event.nativeEvent.message);
  };

  render() {
    return (
      <RCTTxplayerView {...this.props} onChange={this._onChange.bind(this)} />
    );
  }
}

// TxplayerView.propTypes = {
//   showVideoView: PropTypes.bool,
//   ...View.propTypes,
// };
