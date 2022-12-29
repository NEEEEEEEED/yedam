// mySQL_select.js
const mysql = require("mysql");
//mysql 접속정보
const conn = {
  host: "localhost",
  port: "3306",
  user: "dev01",
  password: "2214",
  database: "dev",
};
let connection = mysql.createConnection(conn); //db 커넥션 생성
connection.connect(); //db접속

let sql = "SELECT * FROM customers";
connection.query(sql, function (err, results, fields) {
  console.log(results);
  console.log(err);
});

connection.end(); //DB 접속 종료
