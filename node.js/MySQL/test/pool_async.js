const mysql = require("mysql");

const conn = {
  host: "localhost",
  port: "3306",
  user: "dev01",
  password: "2214",
  database: "dev",
  connectionLimit: 10,
};
let pool = mysql.createPool(conn);
function query(sql) {
  return new Promise((resolve, reject) => {
    pool.query(sql, (err, results, fields) => {
      resolve(results);
    });
  });
}

module.exports = { pool, query };
//pool_async_select에 주는 예시
