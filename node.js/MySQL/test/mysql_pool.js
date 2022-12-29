// mySQL_select.js
const pool = require("./pool");

// pool.getConnection(); //db접속
sql = "SELECT * FROM customers";
pool.query(sql, function (err, results, fields) {
  console.log(results);
  console.log(err);
});
// pool.release()
