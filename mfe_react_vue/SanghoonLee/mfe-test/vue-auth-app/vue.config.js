const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  pluginOptions: {
    vuetify: {
			// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
		}
  },
  chainWebpack: (config) => {
    config.module
      .rule('svg')
      .exclude.add(path.resolve(__dirname, 'src/assets'))
      .end();

    config.module
      .rule('raw-svg')
      .test(/\.svg$/)
      .include.add(path.resolve(__dirname, 'src/assets'))
      .end()
      .use('raw-loader')
      .loader('raw-loader')
      .end();
  },
})
