import * as React from 'react';
import { StyleSheet, View, Text, TouchableOpacity } from 'react-native';
import Txplayer, { multiply } from 'react-native-txplayer';

export default class App extends React.Component {
  constructor(props: Object) {
    super(props);
    this.state = {
      result: 0,
      show: false,
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
    const { result, show } = this.state;
    return (
      <View style={styles.container}>
        <Text>Result: {result}</Text>
        <Txplayer style={styles.player} showVideoView={show} />
        <TouchableOpacity
          onPress={() => {
            this.setState({
              show: !show,
            });
          }}
        >
          <Text>{'打开视频'}</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  player: {
    backgroundColor: '#f60',
    width: 100,
    height: 100,
  },
});
