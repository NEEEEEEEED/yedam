const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  //outputDir: "../MoaMore/src/main/resources/static", // Build Directory
  indexPath: "admin.html",
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8000/",
        ws: true,
        changeOrigin: true,
        pathRewrite: {
          "^/api": "",
        },
      },
    },
  },
});
