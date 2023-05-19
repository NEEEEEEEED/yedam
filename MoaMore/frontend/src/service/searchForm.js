import axios from "axios";

export const searchForm = {
  getCommonCode() {
    return axios
      .get("/api/getCommonCode")
      .then((response) => {
        console.log(response.data.I);
        return response.data.I;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
