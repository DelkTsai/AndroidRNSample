import React,{
  Component,
  PropTypes
} from 'react';
import * as Natives from '../NativeModule';
import {
  View,
  StyleSheet,
  Text,
  TouchableOpacity,
  Image,
  ToastAndroid
} from 'react-native';

export default class QRScanner extends Component {
  constructor(props) {
    super(props);
    this.startQRScan = this.startQRScan.bind(this);
  }

  async startQRScan() {
    const {
      callback
    } = this.props;
    try {
      const qrresult = await Natives.OpenQRScanner.openQRScanner();
      console.log(qrresult);
      ToastAndroid.show(qrresult,ToastAndroid.LONG);
      callback && callback(qrresult,null);
    }catch(e) {
      console.log(e);
      ToastAndroid.show(JSON.stringify(e),ToastAndroid.LONG);
      callback && callback(null,e);
    }
  }

  render() {
    return(
      <TouchableOpacity onPress={this.startQRScan}>
        <Image style={styles.scanner} source={require('./img/qrscanner.png')}/>
      </TouchableOpacity>
    );
  }
}

QRScanner.propTypes = {
  callback: PropTypes.func
};

QRScanner.defaultProps = {
  callback: (success,err)=>{console.log(success)}
}
const styles = StyleSheet.create({
  scanner : {
    width: 26,
    height: 26
  }
});