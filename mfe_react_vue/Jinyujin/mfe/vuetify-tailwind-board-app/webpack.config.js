const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const { VueLoaderPlugin } = require("vue-loader");
const path = require("path");
const { DefinePlugin } = require("webpack");
const MiniCssExtractPlugin = require("mini-css-extract-plugin")

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
    publicPath: "http://localhost:3008/",
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
        // bootstrap에 있는 mount 계열들 전달하기
        './vuetifyBoardBootstrap': './src/bootstrap',
        './vuetifyBoardModuleStore': './src/store/board/boardModule',
        './boardListBootstrap': './src/bootstrapper/boardListBootstrap',
        './boardModifyBootstrap': './src/bootstrapper/boardModifyBootstrap',
        './boardReadBootstrap': './src/bootstrapper/boardReadBootstrap',
        './boardRegisterBootstrap': './src/bootstrapper/boardRegisterBootstrap',
      },
      shared: require("./package.json").dependencies,
      shared: {
        vuetify: {
          singleton: true,
          requiredVersion: "^3.3.3"
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
    compress: true,
    port: 3008,
    historyApiFallback: true,
    hot: true,
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
      'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authroization',
    }
  },
});
