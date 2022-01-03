import React from "react";
import styles from "../../Styles/MainStyles";
import { TouchableOpacity, Image, Text, View } from "react-native";
import { useNavigation } from "@react-navigation/native";

export default function Promocao(props) {
  const navigation = useNavigation();

  return (
    <TouchableOpacity
      style={styles.precoContainer}
      onPress={() => alert("Clicado")}
    >
      <Image style={styles.oferta} source={props.source}></Image>
      <View style={{ heigth: "100%", padding: 5 }}>
        <View>
          <Text
            style={{
              textDecorationLine: "line-through",
              textDecorationStyle: "solid",
              color: "#c2c2c2",
            }}
          >
            {"22.99"}
          </Text>
        </View>
        <View
          style={{
            flexDirection: "row",
            alignItems: "center",
            justifyContent: "space-between",
            width: "100%",
          }}
        >
          <Text style={styles.preco}>{"18.99"}</Text>
          <TouchableOpacity onPress={() => navigation.navigate("PerfilLoja")}>
            <Image source={require("../../assets/UserLoja.png")} />
          </TouchableOpacity>
        </View>
      </View>
    </TouchableOpacity>
  );
}
