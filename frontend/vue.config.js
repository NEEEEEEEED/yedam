const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: "../MoaMore/src/main/resources/static", // Build Directory
  devServer: {
    proxy: "http://localhost:8000", // Spring Boot Server
  },
});
