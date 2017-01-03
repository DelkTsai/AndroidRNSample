import React,{
  Component,
  PropTypes
} from 'react';
import {
  View,
  StyleSheet,
  Image,
  PixelRatio,
  TextInput
} from 'react-native';

export default class UsernameInput extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return(
      <View style={styles.container}>
        <Image style={styles.logo} source={require('imgs/locked@2x.png')}/>
        <TextInput 
          underlineColorAndroid="transparent"
          style={styles.txtInput}
          placeholder={`登录名/手机号`}/>
        <Image style={styles.logo}  source={require('imgs/delete@2x.png')}/>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flexDirection:'row',
    borderBottomWidth: 1/PixelRatio.get(),
    alignItems:'center',
    borderColor:'#DDD',
    marginTop:5,
    marginRight:40,
    marginLeft: 40,
  },
  txtInput:{
    height: 40,
    flex: 1,
    fontSize: 14,
    textAlign: 'center',
    borderColor:'#DDD',
  },
  logo:{}
});