import React, { useState } from "react";
import { Image, StyleSheet, View } from "react-native";
import { Button, CheckBox, Input, Text } from "react-native-elements";
import CustomButton from "../Components/CustomButton";
import styles from "../Styles/MainStyles";

export default function TelaCadastro({ navigation }) {
  const cadastroCliente = () => {
    navigation.push("TelaCadastroCliente");
  };

  const cadastroLoja = () => {
    navigation.push("TelaCadastroLoja");
  };

  return (
    <View style={styles.container}>
      <Image
        style={styles.image}
        resizeMode="center"
        source={require("../assets/User.png")}
      />

      <View
        style={{
          padding: 8,
          height: 108,
          alignItems: "center",
          justifyContent: "space-between",
        }}
      >
        <CustomButton
          title="Fazer cadastro como cliente"
          iconName="user-circle"
          height={48}
          width={280}
          onPress={() => cadastroCliente()}          
        />

        <CustomButton
          title="Fazer cadastro como loja"
          iconName="shopping-bag"
          height={48}
          width={250}
          onPress={() => cadastroLoja()}
          
        />
      </View>
    </View>
  );
}
