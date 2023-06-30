const path = require('path')
const { VueLoaderPlugin } = require("vue-loader");
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");

module.exports = (_, argv) => ({
  mode: 'development',
  cache: false,
  devtool: 'source-map',
  optimization: {
    minimize: false,
  },
  target: 'web',
  entry: path.resolve(__dirname, './src/index.js'),
  output: {
    publicPath: 'http://localhost:3001/',
  },
  resolve: {
    extensions: [".vue", ".js", ".json"],
    alias: {
      vue: 'vue/dist/vue.esm-bundler.js',
    }
  },
  experiments: {
    topLevelAwait: true,
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: "vue-loader",
      },
      {
        test: /\.png$/,
        use: {
          loader: 'url-loader',
          options: { limit: 8192 },
        },
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: MiniCssExtractPlugin.loader,
            options: {},
          },
          'css-loader',
        ],
      },
    ],
  },
  plugins: [
    new MiniCssExtractPlugin({
      filename: '[name].css',
    }),
    new ModuleFederationPlugin({
      name: "vueModuleApp",
      filename: "remoteEntry.js",
      exposes: {
        './Sample': './src/bootstrap',
        './Store': './src/store/board/BoardModule',
        './boardRegisterBootstrap': './src/domain/board/bootstrapper/boardRegisterBootstrap',
        './boardReadBootstrap': './src/domain/board/bootstrapper/boardReadBootstrap',
        './boardModifyBootstrap': './src/domain/board/bootstrapper/boardModifyBootstrap',
        './boardListBootstrap': './src/domain/board/bootstrapper/boardListBootstrap',
      },
      shared: require("./package.json").dependencies
    }),
    new HtmlWebPackPlugin({
      template: path.resolve(__dirname, './public/index.html'),
      chunks: ['main'],
    }),
    new VueLoaderPlugin(),
  ],
  devServer: {
    static: {
      directory: path.join(__dirname),
    },
    historyApiFallback: true,
    compress: true,
    port: 3001,
    hot: true,
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
      'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authroization',
    }
  },
});