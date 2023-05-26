import axios from "axios";
import env from "../env";


const mainRequest = axios.create({
  baseURL: env.api.MAIN_API_URL,
  timeout: 2500,
});

export default mainRequest;
