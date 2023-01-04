function greet() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("hello");
    }, 3000);
  });
}
//async 함수(비동기) 안에서만 await 가능
async function callgreet() {
  var result = await greet();
  console.log(result);
  console.log(result.length);
}
callgreet(); //non-블록킹
console.log("end");

//MySQL 파일 pool_async.js 로 이동
