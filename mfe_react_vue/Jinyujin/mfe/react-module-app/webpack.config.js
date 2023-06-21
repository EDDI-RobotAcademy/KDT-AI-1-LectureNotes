const HtmlWebPackPlugin = require("html-webpack-plugin");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const ExternalTemplateRemotesPlugin = require('external-remotes-plugin')

const deps = require("./package.json").dependencies;
module.exports = (_, argv) => ({
  // mode 지정이 필요
  mode: 'development',
  entry: './src/index',
  output: {
    publicPath: "auto",
  },
  resolve: {
    extensions: [".tsx", ".ts", ".jsx", ".js", ".json"],
  },

  devServer: {
    port: 3003,
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
      {
        test: /\.(js|jsx)$/,
        exclude: /(node_modules|bower_components)/,
        loader: "babel-loader",
        options: {presets: ['@babel/env', '@babel/preset-react']}
      },
    ],
  },

  plugins: [
    new ModuleFederationPlugin({
      // ModuleFederation(연합)Plugin: reactModuleApp에서 expose하고 싶은 페이지들을
      // 함께 모아서 remoteEntry.js라는 파일로 연결시켜줄 수 있는 것 같음
      name: "reactModuleApp",
      filename: "remoteEntry.js",
      exposes: { // exposes에서 노출할 컴포넌트 혹은 모듈 지정
        './ReactSample': './src/bootstrap.js', 
        // './src/bootstrap.js' 파일을 './ReactSample' 컴포넌트로 노출
        './Counter': './src/components/Counter.js'
        // './src/components/Counter.js' 파일을 './Counter' 컴포넌트로 노출
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
      },
    }),
    new HtmlWebPackPlugin({
      template: "./public/index.html",
      chunks: ['main'],
    }),
    new ExternalTemplateRemotesPlugin(), 
    // ExternalTemplateRemotesPlugin(): 외부 템플릿을 사용하기 위해 추가했다고 하심
    // 왜 여기서만 사용했는지는 잘 모르겠지만 일단 이렇게 알고 넘어가자
  ],
});
