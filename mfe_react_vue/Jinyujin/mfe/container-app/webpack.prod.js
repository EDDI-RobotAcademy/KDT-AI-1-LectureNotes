const path = require("path")
const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const ExternalTemplateRemotePlugin = require('external-remotes-plugin')

module.exports = (_, argv) => ({
  mode: "production",
  entry: "./src/index",
  devServer: {
    static: path.join(__dirname, 'dist'),
    port: 3000,
  },
  output: {
    publicPath: '/container/',
  },
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        loader: "babel-loader",
        exclude: /node_modules/,
        options: {
          presets: ['@babel/preset-react']
        },
      },
    ],
  },
  plugins: [
    new HtmlWebPackPlugin({
      template: "./public/index.html",
    }),
    new ExternalTemplateRemotePlugin(),
    new ModuleFederationPlugin({
      name: "ContainerApp",
      remotes: { // vue를 가져오는 부분
        vueModuleApp: 'vueModuleApp@http://15.164.237.78/vue/remoteEntry.js'
      },
    }),
  ],
});