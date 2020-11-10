import * as React from 'react';
import { StyleSheet, View, Dimensions, Button, Text } from 'react-native';
import Txplayer, { multiply } from '@kafudev/react-native-txplayer';
const { width } = Dimensions.get('window');
export default class App extends React.Component {
  constructor(props: Object) {
    super(props);
    this.state = {
      result: 0,
      show: false,
      play: true,
      pause: false,
    };
  }

  componentDidMounted() {
    multiply(3, 5).then((result: Number) => {
      this.setState({
        result,
      });
    });
  }

  render() {
    const { result, show, play, pause, stop } = this.state;
    return (
      <View style={styles.container}>
        <Text>Result: {result}</Text>
        <Txplayer
          style={styles.player}
          showVideoView={show}
          startPlay={play}
          pausePlay={pause}
          stopPlay={stop}
          onChangeMessage={(msg: object) => {
            console.log('Txplayer onChangeMessage', msg);
          }}
        />
        {/* <View style={styles.box}>
          <Text>{'这是覆盖层文字'}</Text>
        </View> */}
        <Button
          style={styles.btn}
          onPress={() => {
            this.setState({
              show: !show,
            });
          }}
          title="打开视频"
        />
        <Button
          style={styles.btn}
          onPress={() => {
            this.setState({
              play: true,
              pause: false,
              stop: false,
            });
          }}
          title="开始播放"
        />
        <Button
          style={styles.btn}
          onPress={() => {
            this.setState({
              play: false,
              pause: true,
              stop: false,
            });
          }}
          title="暂停播放"
        />
        <Button
          style={styles.btn}
          onPress={() => {
            this.setState({
              play: false,
              pause: false,
              stop: true,
            });
          }}
          title="停止播放"
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    // alignItems: 'center',
    // justifyContent: 'center',
  },
  box: {
    position: 'absolute',
    top: 50,
    left: 50,
    backgroundColor: 'rgba(255,255,255,0.8)',
    borderRadius: 10,
    width: 50,
    height: 50,
    zIndex: 999,
  },
  player: {
    backgroundColor: '#f60',
    padding: 0,
    borderTopWidth: 2,
    borderTopColor: '#f60',
    borderRadius: 5,
    marginTop: 50,
    marginLeft: 10,
    marginBottom: 50,
    width: width - 20,
    height: 200,
  },
  btn: {
    margin: 10,
  },
});
