import { StyleSheet } from "react-native";

const styles = (width, height, borderRadius, padding) =>
  StyleSheet.create({
    buttonStyle: {
      width: width ? width : 108,
      height: height ? height : 48,
      borderRadius: borderRadius ? borderRadius : 8,
    },
  });

export default styles;
