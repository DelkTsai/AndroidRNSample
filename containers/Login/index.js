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
  FullPage,
  Button
} from 'yhui';
import {
  Logo,
} from './components';

export default class Login extends Component {
  constructor(props) {
   super(props); 
  }

  render() {
    const loginBgStyle = {
      borderRadius:2,marginLeft:25,marginRight:25,height:35,backgroundColor:'#24a8e8',alignItems:'center',justifyContent:'center'
    };
    const loginTxtStyle = {
      fontSize:16,color:'#FFF'
    };
    return (<FullPage backgroundColor="#F5F5F5">
      <Logo />
      <Button bgStyle={loginBgStyle} txtStyle={loginTxtStyle} txt={"登录"}/>
    </FullPage>);
  }
}

const styles = StyleSheet.create({

});