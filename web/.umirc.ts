import { defineConfig } from "umi";

export default defineConfig({
  routes: [
    { path: "/", component: "UploadFiles", name: "Upload Files" },
    { path: "/files", component: "FileBrowser", name: "File Browser" },
    // { path: "/products", component: "products", name: "products" },
  ],
  dva: {},
  tailwindcss: {},
  npmClient: 'yarn',
  plugins: [
    "@umijs/plugins/dist/react-query",
    "@umijs/plugins/dist/dva",
    "@umijs/plugins/dist/tailwindcss",
  ],
  extraPostCSSPlugins: [
    require("postcss-import"),
    require("tailwindcss")({ config: "./tailwind.config.js" }),
  ],
  proxy: {
    "/api": {
      // 标识需要进行转换的请求的url
      target: "http://localhost:8080", // 服务端域名
      changeOrigin: true, // 允许域名进行转换
    },
  },
});
