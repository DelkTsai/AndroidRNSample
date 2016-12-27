import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import {
  FullPage
} from 'yhui';
import {
  Login
} from 'pages';

class HelloWorld extends React.Component {
  render() {
    const {
      name
    } = this.props; 
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>{name}</Text>
      </View>
    )
  }
}

class TestComp extends React.Component {
 
    render() {
      const {
        name
      } = this.props;
      return (
         <FullPage backgroundColor="yellow">
                <Text style={styles.hello}>{name}</Text>
              </FullPage>
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
AppRegistry.registerComponent('Login', ()=>Login);