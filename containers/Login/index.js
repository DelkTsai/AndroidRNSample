import React,{
  Component
} from 'react';
import {
  Text,
  View,
  StyleSheet,
  Image,
  TextInput,
  TouchableOpacity
} from 'react-native';
import {
  FullPage
} from 'yhui';

export default class Login extends Component {
  constructor(props) {
   super(props); 
  }

  render() {
    return (<FullPage>
      <Text>Sample</Text>
    </FullPage>);
  }
}