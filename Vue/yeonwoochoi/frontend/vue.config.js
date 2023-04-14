const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  lintOnSave: false,
  transpileDependencies: [
    'vuetify'
  ], 
  chainWebpack: config=> {
    config.module.rules.delete('eslint');
  }
})
