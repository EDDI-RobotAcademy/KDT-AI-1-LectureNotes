import axios from "axios";

const axiosInst = axios.create({
  baseURL: "http://localhost:7777",
  //baseURL: "http://192.168.20.23:7777",
  timeout: 2500,
});

export default axiosInst;
