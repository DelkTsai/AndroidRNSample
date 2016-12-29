import FullPage from './FullPage';
import Button from './Button';
import QRScanner from './QRScanner';
import * as Natives from './NativeModule';

let components = {
  FullPage,
  Button,
  QRScanner,
};
components = Object.assign(components,Natives);
console.log(components);
module.exports = exports = components;