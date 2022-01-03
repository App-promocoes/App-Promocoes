import React from "react";
import { View, Text, ScrollView } from "react-native";

import Promocao from "../Promocao";

export default function Promocoes(props) {
  return (
    <View>
      <View style={{ marginVertical: 8 }}>
        <Text style={{ fontSize: 25, paddingLeft: 16 }}>{props.title}</Text>
        <ScrollView
          overScrollMode="never"
          horizontal
          showsHorizontalScrollIndicator={false}
          contentContainerStyle={{
            paddingRight: 7.5,
            paddingLeft: 7.5,

            flexGrow: 0,
            justifyContent: "space-between",

            flexDirection: "row",
            alignItems: "center",

            width: "auto",

            borderColor: "#0f0",
            borderWidth: 2,
          }}
        >
          <Promocao source={require("../../assets/exemplolanche1.png")} />
          <Promocao source={require("../../assets/exemplolanche2.png")} />
          <Promocao source={require("../../assets/exemplolanche1.png")} />
          <Promocao source={require("../../assets/exemplolanche1.png")} />
        </ScrollView>
      </View>
    </View>
  );
}
