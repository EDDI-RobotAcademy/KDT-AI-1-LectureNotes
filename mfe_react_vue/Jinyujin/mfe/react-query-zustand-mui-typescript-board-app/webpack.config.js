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
      name: "reactQueryZustandMuiTypescriptBoardApp",
      filename: "remoteEntry.js",
      exposes: {
      // 결론적으로 현재 React Container에
      // remotes React Component를 붙이는 것이기 때문에 가능함
        './TypescriptBoard': './src/bootstrap.tsx',
        './TypescriptBoardApp': './src/ReactQueryZustandMuiTypescriptBoardApp.tsx',
        './TypescriptBoardListPage': './src/page/TypescriptBoardListPage.tsx',
        './TypescriptBoardReadPage': './src/page/TypescriptBoardReadPage.tsx',
        './TypescriptBoardRegisterPage': './src/page/TypescriptBoardRegisterPage.tsx',
        './TypescriptBoardModifyPage': './src/page/TypescriptBoardModifyPage.tsx',
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
        },
        "react-query": {
          singleton: true,
          requiredVersion: deps["react-query"]
        },
      },
    }),
    new HtmlWebPackPlugin({
      template: "./public/index.html",
      chunks: ['main'],
    }),
    new ExternalTemplateRemotesPlugin(),
  ],
});
