import { Base } from './.nuxt/components';
const ModuleFederationPlugin = require("webpack/lib/container/ModuleFederationPlugin");

// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  builder: 'webpack',
  devServer: {
    port: 3020,
  },
  sourcemap: {
    server: true,
    client: true,
  },
  webpack: {
    analyze: true,
    cssSourceMap: true,
    loaders: {
      vue: {
        hotReload: true,
      }
    },
    plugins: [
      new ModuleFederationPlugin({
        name: "nuxtBasicApp",
        filename: "remoteEntry.js",
        exposes: {
          './NuxtBasicApp': './components/NuxtBasicApp.vue',
        },
        shared: require("./package.json").dependencies,
      }),
    ],
  },
  vue: {
    defineModel: true,
    propsDestructure: true,
  },
})
