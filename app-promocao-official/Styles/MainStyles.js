import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#ff6600",
    justifyContent: "center",
    alignItems: "center",
    borderColor: "#000",
    borderWidth: 1,
    borderStyle: "solid",
  },

  image: {
    width: 150,
    height: 150,
  },

  buttonsContainer: {
    borderWidth: 1,
    borderColor: "rgba(0,0,0,0.2)",
    alignItems: "center",
    justifyContent: "center",
    width: 100,
    height: 100,
    backgroundColor: "#fff",
    borderRadius: 50,
  },

  textTitlle: {
    textAlign: "center",
    padding: 5,
  },

  button: {
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "#fff",
    width: 60,
    height: 60,
  },
  border: {
    height: 70,
    flexDirection: "row",
    justifyContent: "space-between",
    width: "80%",
    alignItems: "center",
  },

  precoContainer: {
    borderWidth: 1,
    width: 128,
    height: 184,
    marginLeft: 7.5,
    marginRight: 7.5,
  },

  oferta: {
    width: "100%",
    height: 125,
    borderWidth: 2,
  },

  preco: {
    color: "#000",
    fontSize: 20,
    fontWeight: "600",
  },

  titles: {
    color: "#fff",
    fontSize: 22,
    fontWeight: "bold",
    borderColor: "#f00",
    borderWidth: 0,
    marginLeft: 7.5,
  },
});

export default styles;
