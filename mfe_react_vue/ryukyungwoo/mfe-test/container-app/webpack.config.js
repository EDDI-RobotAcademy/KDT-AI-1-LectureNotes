const path = require("path")
const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const ExternalTemplateRemotePlugin = require('external-remotes-plugin')

const deps = require("./package.json").dependencies

module.exports = (_, argv) => ({
  mode: "development",
  entry: "./src/index",
  resolve: {
    extensions: [".tsx", ".ts", ".jsx", ".js", ".json"],
    alias: {
      'event-bus': path.resolve(__dirname, '../event-bus/event-bus.js'),
    },
  },
  devServer: {
    //static: path.join(__dirname, 'dist'),
    port: 3000,
    historyApiFallback: true,
    compress: true,
    hot: true,
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
      'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authroization',
    }
  },
  output: {
    publicPath: 'http://localhost:3000/',
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
        }
      },
      // {
      //   test: /\.jsx?$/,
      //   loader: "babel-loader",
      //   exclude: /node_modules/,
      //   options: {
      //     presets: ['@babel/preset-react']
      //   },
      // },
    ],
  },
  plugins: [
    new HtmlWebPackPlugin({
      template: "./public/index.html",
    }),
    new ExternalTemplateRemotePlugin(),
    new ModuleFederationPlugin({
      name: "containerApp",
      remotes: {
        // vueModuleApp은 Vue Counter App과 Vue Board App이 합쳐져 있음
        vueModuleApp: 'vueModuleApp@http://localhost:3001/remoteEntry.js',
        vueNavigationApp: 'vueNavigationApp@http://localhost:3002/remoteEntry.js',
        // reactModuleApp은 사실상 React Counter App임
        reactModuleApp: 'reactModuleApp@http://localhost:3003/remoteEntry.js',
        reactBoardApp: 'reactBoardApp@http://localhost:3004/remoteEntry.js',
        reactZustandTodoApp: 'reactZustandTodoApp@http://localhost:3005/remoteEntry.js',
        reactQueryTestApp: 'reactQueryTestApp@http://localhost:3006/remoteEntry.js',
        vuetifyTailwindBoardApp: 'vuetifyTailwindBoardApp@http://localhost:3007/remoteEntry.js',
        reactQueryZustandMuiTypescriptBoardApp: 'reactQueryZustandMuiTypescriptBoardApp@http://localhost:3008/remoteEntry.js',
        vueEventBusTestApp: 'vueEventBusTestApp@http://localhost:3009/remoteEntry.js',
        vueCounterContainerApp: 'vueCounterContainerApp@http://localhost:3012/remoteEntry.js',
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
          singleton: true
        },
        "react-query": {
          singleton: true,
          requiredVersion: deps["react-query"]
        }
      }
    }),
  ],
});
