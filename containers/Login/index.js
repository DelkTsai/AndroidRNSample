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
  Button,
  OpenLogin,
  QRScanner
} from 'yhui';
import {
  Logo,
} from './components';

export default class Login extends Component {
  constructor(props) {
   super(props); 
   this.goToLoginPage = this.goToLoginPage.bind(this);  
  }

  goToLoginPage() {
    console.log(OpenLogin);
    OpenLogin.openLoginPage();
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
      <QRScanner/>
      <Button bgStyle={loginBgStyle} txtStyle={loginTxtStyle} txt={"登录"} callback={this.goToLoginPage}/>
    </FullPage>);
  }
}

const styles = StyleSheet.create({

});