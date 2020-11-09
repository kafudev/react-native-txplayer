import * as React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import { multiply } from 'react-native-txplayer';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  React.useEffect(() => {
    multiply(3, 5).then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
      {/* <Txplayer style={styles.player} /> */}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  // player: {
  //   backgroundColor: '#f60',
  //   width: 100,
  //   height: 100,
  // },
});
