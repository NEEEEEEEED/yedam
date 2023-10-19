var createError = require("http-errors");
var express = require("express");
var path = require("path");
var cookieParser = require("cookie-parser"); //현재버전에서는 필요없음
var logger = require("morgan");

var indexRouter = require("./routes/index");
var usersRouter = require("./routes/users");
//라우터 js파일 만들면 추가해줘야함
var customersRouter = require("./routes/customers");
var booksRouter = require("./routes/books");

const session = require("express-session");
const fileStore = require("session-file-store")(session); //서버단에서 session 저장위치
var app = express();

// view engine setup
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "jade");

app.use(logger("dev"));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
// app.use(cookieParser());
app.use(
  session({
    secret: "secret key",
    resave: false,
    saveUninitialized: true,
    cookie: {
      httpOnly: true,
      //secure: true,
      maxAge: 60000,
    },
    store: new fileStore(),
  })
);

app.use(express.static(path.join(__dirname, "public")));

app.use("/", indexRouter);
app.use("/users", usersRouter);
//추가해야 실행가능
app.use("/customers", customersRouter);
app.use("/books", booksRouter);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get("env") === "development" ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render("error");
});

module.exports = app;
