const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  publicPath: '',
})

// module.exports = defineConfig({
//   outputDir: "../src/main/resources/static",
//   indexPath: "../static/index.html",

//   devServer: {
//       proxy: {
//           '/': {
//             //   target: 'https://i7c205.p.ssafy.io/api/',
//               target: 'http://localhost:3000/api/',
//               pathRewrite: { '^/': '' },
//               changeOrigin: true,
//               secure: false,
//               ws: false,
//           }
//       }
//   }
// });