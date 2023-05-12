import axios from "axios";

export const boardList = {
  getBoardData() {
    return axios
      .get("/api/getBoardData")
      .then((response) => {
        console.log(response.data.commVO);
        console.log(response.data.intrvVO);
        console.log(response.data.prjtVO);
        console.log(response.data.studyVO);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
