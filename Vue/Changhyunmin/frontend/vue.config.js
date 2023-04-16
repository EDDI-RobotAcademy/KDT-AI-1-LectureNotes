const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  lintOnSave: false,
  transpileDependencies: [
    'vuetify'
  ]

})

// ,
//   chainWebpac: config => {
//     config.module.rules.delete('eslint');
//   }
