import React from "react";
import { View } from "react-native";
import { Icon } from "react-native-elements";
import { StyleSheet, TextInput } from "react-native";

export default function SearchBar({ navigation }) {
  return (
    <View style={styles.container}>
      <Icon
        name="search"
        size={24}
        type="font-awesome"
        style={{ marginLeft: 8 }}
      />
      <TextInput placeholder="Buscar?" style={styles.searchBar} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: "row",
    justifyContent: "flex-start",
    alignItems: "center",
    width: "90%",
    borderWidth: 2,
    borderRadius: 8,
  },

  searchBar: {
    width: "100%",
    padding: 8,
    height: 48,
    fontSize: 20,
  },
});
