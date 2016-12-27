import FullPage from './FullPage';
import Button from './Button';
import * as Natives from './NativeModule';

let components = {
  FullPage,
  Button,
};
components = Object.assign(components,Natives);
console.log(components);
module.exports = exports = components;