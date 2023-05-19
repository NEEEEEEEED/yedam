import axios from "axios";

export const userList = {
  getUserData() {
    return axios
      .get("/api/getUserInfo")
      .then((response) => {
        console.log(response);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },

  modifyUser(selectedUser) {
    console.log(selectedUser);
    return axios
      .post("/api/modifyUser", selectedUser)
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },

  deleteUsers(emails) {
    console.log(emails);
    return axios
      .post("/api/deleteUsers", emails)
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },

  getSearchUser(vo) {
    return axios
      .post("/api/getSearchUser", vo)
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
