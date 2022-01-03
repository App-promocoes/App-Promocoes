import React, { useState } from "react";
import { Image, View } from "react-native";
import { Button, Input, Text } from "react-native-elements";
import CustomButton from "../Components/CustomButton";
import styles from "../Styles/MainStyles";

export default function Login({ navigation }) {
  const [email, setEmail] = useState(null);
  const [password, setPassword] = useState(null);

  const entrar = () => {
    navigation.push("Home");
  };

  const cadastro = () => {
    navigation.push("TelaCadastro");
  };

  return (
    <View style={styles.container}>
      <Image
        style={styles.image}
        resizeMode="center"
        source={require("../assets/User.png")}
      />
      <Text h4>Faça seu login </Text>

      <View style={{ width: "80%" }}>
        <Input
          placeholder="E-mail"
          leftIcon={{ type: "font-awesome", name: "envelope" }}
          onChangeText={(value) => setEmail(value)}
          keyboardType="email-address"
          placeholderTextColor="#000000"
        />
        <Input
          placeholder="Senha"
          leftIcon={{ type: "font-awesome", name: "key" }}
          onChangeText={(value) => setPassword(value)}
          secureTextEntry={true}
          placeholderTextColor="#000000"
        />
      </View>

      <View
        style={{
          padding: 8,
          flexDirection: "row",
          width: "70%",
          alignItems: "center",
          justifyContent: "space-between",
        }}
      >
        <CustomButton
          title="Entrar"
          iconName="user"
          height={48}
          width={96}
          onPress={() => entrar()}          
        />

        <CustomButton
          title="Fazer Cadastro"
          iconName="home"
          height={48}
          width={150}
          onPress={() => cadastro()}           
        />
      </View>
    </View>
  );
}
