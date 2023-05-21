import axios from "axios";

export const reportList = {
  getApprvList() {
    return axios
      .get("/api/getApprvList")
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  removeBoard(nos) {
    return axios
      .post("/api/removeBoard", nos)
      .then((response) => {
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  approveBoard(nos) {
    return axios
      .post("/api/approveBoard", nos)
      .then((response) => {
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
