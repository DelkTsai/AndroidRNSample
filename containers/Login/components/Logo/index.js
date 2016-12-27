import React,{
  Component
} from 'react';
import {
  View,
  Image,
  StyleSheet
} from 'react-native';

const Logo = (props) => {
  return (
    <View style={styles.logoSection}>
      <Image style={styles.logo} source={require('imgs/yh_logo.png')}/>
    </View>
  );
};

const styles = StyleSheet.create({
  logoSection:{
    marginTop:40,
    marginBottom:40,
    justifyContent:'center',
    flexDirection: 'row',
  },
  logo: {
    width: 98,
    height: 70.66
  }
});

export default Logo;