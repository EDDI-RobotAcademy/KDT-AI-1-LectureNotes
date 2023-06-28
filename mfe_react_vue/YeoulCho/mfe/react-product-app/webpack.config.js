const path = require("path")
const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const ExternalTemplateRemotesPlugin = require('external-remotes-plugin')

const deps = require("./package.json").dependencies;
module.exports = (_, argv) => ({
  mode: 'development',
  entry: './src/index',
  output: {
    publicPath: "http://localhost:3009/",
  },
  resolve: {
    extensions: [".tsx", ".ts", ".jsx", ".js", ".json"],
  },
  devServer: {
    port: 3009,
    historyApiFallback: true,
    hot: true,
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
      'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authroization',
    }
  },

  module: {
    rules: [
      {
        test: /\.m?js/,
        type: "javascript/auto",
        resolve: {
          fullySpecified: false,
        },
      },
      {
        test: /\.(css|s[ac]ss)$/i,
        use: ["style-loader", "css-loader", "postcss-loader"],
      },
      {
        test: /\.(ts|tsx|js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
        },
      },
    ],
  },

  plugins: [
    new ModuleFederationPlugin({
      name: "reactProductApp",
      filename: "remoteEntry.js",
      exposes: {
        './ReactProduct': './src/bootstrap.js',
        './ProductApp': './src/ProductApp.jsx',
        './ProductListPage': './src/page/ProductListPage.js',
        './ProductReadPage': './src/page/ProductReadPage.js',
        './ProductModifyPage': './src/page/ProductModifyPage.js',
        './ProductRegisterPage': './src/page/ProductRegisterPage.js'
      },
      shared: {
        ...deps,
        react: {
          singleton: true,
          requiredVersion: deps.react,
        },
        "react-dom": {
          singleton: true,
          requiredVersion: deps["react-dom"],
        },
        "react-router-dom": {
          singleton: true,
          requiredVersion: deps["react-router-dom"]
        }
      },
    }),
    new HtmlWebPackPlugin({
      template: "./public/index.html",
      chunks: ['main'],
    }),
    new ExternalTemplateRemotesPlugin(),
  ],
});