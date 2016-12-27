import React,{
  Component,
  PropTypes
} from 'react';
import {
  View,
  StyleSheet,
  Text,
  TouchableOpacity
} from 'react-native';

export default class Button extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    const {
      txt,
      bgStyle,
      txtStyle
    } = this.props;
    return (
      <TouchableOpacity style={bgStyle}>
        <Text style={txtStyle}> {txt}</Text>
      </TouchableOpacity>
    );
  }
}

Button.propTypes = {
  txt: PropTypes.string,
  bgStyle: PropTypes.object,
  txtStyle: PropTypes.object
};

const styles = StyleSheet.create({

});