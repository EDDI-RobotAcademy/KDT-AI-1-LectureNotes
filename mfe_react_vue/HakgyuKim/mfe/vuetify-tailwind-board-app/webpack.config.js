const MiniCssExtractPlugin = require("mini-css-extract-plugin")
const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const { VueLoaderPlugin } = require("vue-loader");
const path = require("path");
const { DefinePlugin } = require("webpack");

module.exports = (_, argv) => ({
  mode: 'development',
  cache: false,
  devtool: 'source-map',
  optimization: {
    minimize: false,
  },
  target: 'web',
  entry: path.resolve(__dirname, './src/index'),
  output: {
    publicPath: "http://localhost:3007/",
  },
  resolve: {
    extensions: [".tsx", ".ts", ".vue", ".jsx", ".js", ".json"],
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: "vue-loader",
      },
      {
        test: /\.tsx?$/,
        use: [
          "babel-loader",
          {
            loader: "ts-loader",
            options: {
              transpileOnly: true,
              appendTsSuffixTo: ["\\.vue$"],
              happyPackMode: true,
            },
          },
        ],
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: MiniCssExtractPlugin.loader,
            options: {}
          },
          'css-loader',
        ]
      },
      {
        test: /\.sass$/,
        use: ['vue-style-loader', 'css-loader', 'sass-loader']
      },
      {
        test: /\.s[ac]ss$/i,
        use: ["vue-style-loader", "css-loader", "sass-loader"],
      },
      {
        test: /\.svg$/,
        use: 'svg-loader',
      }
    ],
  },
  plugins: [
    new DefinePlugin({
      __VUE_OPTIONS_API__: true,
      __VUE_PROD_DEVTOOLS__: false,
    }),
    new MiniCssExtractPlugin({
      filename: '[name].css',
    }),
    new VueLoaderPlugin(),
    new ModuleFederationPlugin({
      name: "vuetifyTailwindBoardApp",
      filename: "remoteEntry.js",
      exposes: {
        './vuetifyBoardBootstrap' : './src/bootstrap',
        './vuetifyBoardModuleStore' : './src/store/board/boardModule',
        './boardRegisterBootstrap': './src/bootstrapper/boardRegisterBootstrap',
        './boardReadBootstrap': './src/bootstrapper/boardReadBootstrap',
        './boardModifyBootstrap': './src/bootstrapper/boardModifyBootstrap',
        './boardListBootstrap': './src/bootstrapper/boardListBootstrap',
      },
      shared: require("./package.json").dependencies,
      shared: {
        vuetify: {
          singleton: true,
          requiredVersion: "^3.3.5",
        }
      }
    }),
    new HtmlWebPackPlugin({
      template: path.resolve(__dirname, './public/index.html'),
      chunks: ['main'],
    }),
  ],
  devServer: {
    static: {
      directory: path.join(__dirname),
    },
    historyApiFallback: true,
    compress: true,
    port: 3007,
    hot: true,
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
      'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authorization',
    }
  },
});