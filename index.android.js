import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>我是React组件</Text>
      </View>
    )
  }
}

class TestComp extends React.Component {
    render() {
      return (
         <View style={styles.container}>
                <Text style={styles.hello}>我是Test组件</Text>
              </View>
      )
    }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);
AppRegistry.registerComponent('TestComp', () => TestComp);