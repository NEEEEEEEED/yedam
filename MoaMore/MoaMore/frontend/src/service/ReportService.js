import axios from "axios";

export const reportList = {
  getReportData(notiwrNo) {
    console.log(notiwrNo);
    return axios
      .post("/api/getReportData", notiwrNo)
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  modifyRprt(vo) {
    return axios
      .post("/api/modifyRprt", vo)
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
