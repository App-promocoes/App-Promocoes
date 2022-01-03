import React from "react";
import { Button } from "react-native-elements";

import styles from "./styles";

const CustomButton = (props) => {
  function getIcon(iconName, size, color) {
    console.log(props.width);
    return {
      name: iconName,
      type: "font-awesome",
      size: size,
      color: color,
    };
  }

  return (
    <Button
      title={props.title}
      icon={getIcon(props.iconName, 20, "white")}
      iconContainerStyle={{ marginRight: 8 }}
      onPress={props.onPress}
      containerStyle={
        styles(props.width, props.height, props.borderRadius).buttonStyle
      }
    />
  );
};

export default CustomButton;
