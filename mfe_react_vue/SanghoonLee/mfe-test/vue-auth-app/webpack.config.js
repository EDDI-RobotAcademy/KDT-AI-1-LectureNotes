const MiniCssExtractPlugin = require("mini-css-extract-plugin")
const HtmlWebPackPlugin = require("html-webpack-plugin");
const { DefinePlugin } = require("webpack");
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");
const { VueLoaderPlugin } = require("vue-loader");
const path = require("path");

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
    publicPath: "http://localhost:3010/",
  },
  resolve: {
    extensions: [".tsx", ".ts", ".vue", ".jsx", ".js", ".json"],
    alias: {
      '@': path.resolve(__dirname, 'src')
    }
  },
  devServer: {
    static: {
      directory: path.join(__dirname),
    },
    port: 3010,
    historyApiFallback: true,
    compress: true,
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
        test: /\.vue$/,
				use: [
					{
						loader: "vue-loader",
						options: { /* ... */ }
					},
					// {
					// 	loader: "vue-svg-inline-loader",
					// 	options: { /* ... */ }
					// }
				]
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
      // {
      //   test: /\.svg$/,
      //   use: 'vue-loader',
      // },
      // {
      //   test: /\.svg$/,
      //   use: [
      //     "babel-loader",
      //     {
      //       loader: "vue-loader",
      //       options: {
      //         compilerOptions: {
      //           isCustomElement: (tag) => tag === "LogoSvg" || tag === "GithubIconSvg"
      //         }
      //       }
      //     }
      //   ]
      // }
      {
        test: /\.svg$/,
        oneOf: [
          {
            resourceQuery: /inline/, // SVG 파일을 인라인으로 처리
            use: [
              "babel-loader",
              {
                loader: "vue-loader",
                options: {
                  compilerOptions: {
                    isCustomElement: (tag) => tag === "LogoSvg" || tag === "GithubIconSvg"
                  }
                }
              }
            ]
          },
          {
            resourceQuery: /external/, // SVG 파일을 외부 파일로 처리
            use: [
              {
                loader: "file-loader",
                options: {
                  name: "assets/[name].[hash:8].[ext]"
                }
              }
            ]
          },
          {
            // 추가된 로더 설정
            test: /\.svg$/,
            loader: "raw-loader" // raw-loader를 사용하여 SVG 파일을 처리
          }
        ]
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
      name: "vueAuthApp",
      filename: "remoteEntry.js",
      exposes: {
        './VueAuth': './src/bootstrap',
      },
      shared: require("./package.json").dependencies,
      shared: {
        vuetify: {
          singleton: true,
          requiredVersion: "^3.3.3",
        },
      },
    }),
    new HtmlWebPackPlugin({
      template: "./public/index.html",
    }),
  ],
});
