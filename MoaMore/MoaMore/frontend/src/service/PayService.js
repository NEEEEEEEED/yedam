import axios from "axios";

export const PayService = {
  getPayList() {
    return axios
      .get("/api/getPayList")
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  getReservList() {
    return axios
      .get("/api/getReservList")
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
