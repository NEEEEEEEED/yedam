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

  getuserDetail(selectedRow) {
    return axios
      .post("/api/getUserDetail", selectedRow)
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },

  modifyUser(MemVO) {
    console.log(MemVO);
    return axios
      .post("/api/modifyUser", MemVO)
      .then((response) => {
        console.log(response.data);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },

  getProductsMini() {
    return Promise.resolve(this.getUserData().slice(0, 5));
  },

  getProductsSmall() {
    return Promise.resolve(this.getUserData().slice(0, 10));
  },

  getProducts() {
    return Promise.resolve(this.getUserData());
  },

  getProductsWithOrdersSmall() {
    return Promise.resolve(this.getProductsWithOrdersData().slice(0, 10));
  },

  getProductsWithOrders() {
    return Promise.resolve(this.getProductsWithOrdersData());
  },
};
