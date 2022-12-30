const mysql = require("mysql");
//mysql 접속정보
const conn = {
  host: "localhost",
  port: "3306",
  user: "dev01",
  password: "2214",
  database: "dev",
  connectionLimit: 10,
};
let pool = mysql.createPool(conn);

module.exports = pool;
