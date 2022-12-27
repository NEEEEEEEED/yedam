// faSync.js
// 동기식 - 블로킹 함수
const fs = require("fs");
const data = fs.readFileSync("./template/sample.txt", "utf8");
console.log(data);
