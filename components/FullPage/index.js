import React,{
  Component,
  PropTypes
} from 'react';
import {
  View,
  StyleSheet,
  Platform
} from 'react-native';

export default class FullPage extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    const {
      backgroundColor,
      children
    } = this.props;
    const styles = {
      flex:1,
      paddingTop: (Platform.OS === 'ios') ? 20 : 0,
      backgroundColor
    };
    return (
      <View style={styles}>
        {children}
      </View>
    );
  }
}

FullPage.propTypes = {
  backgroundColor: PropTypes.string
}

FullPage.defaultProps = {
  backgroundColor: '#FFF'
}

const styles = StyleSheet.create({
  container:{
    flex:1,
    paddingTop: (Platform.OS === 'ios') ? 20 : 0,
  }
});