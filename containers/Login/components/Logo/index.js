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
      <Image style={styles.logo} source={require('imgs/yh_logo@2x.png')}/>
    </View>
  );
};

const styles = StyleSheet.create({
  logoSection:{
    marginTop: 66,
    marginBottom: 50,
    justifyContent:'center',
    flexDirection: 'row',
  },
  logo: {
  }
});

export default Logo;