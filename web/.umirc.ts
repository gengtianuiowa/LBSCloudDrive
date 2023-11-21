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
});
