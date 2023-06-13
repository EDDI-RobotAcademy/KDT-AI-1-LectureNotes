const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  lintOnSave: false,
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    proxy: 'http://localhost:7777'
  }
 

})

// ,
//   chainWebpac: config => {
//     config.module.rules.delete('eslint');
//   }
