module.exports = {
  theme: {},
  variants: {},
  plugins: [],
  darkMode: "class",
  corePlugins: {
    preflight: false,
  },
  // important: true, // 给 tailwindcss 的样式加上最高优先级
  content: [
    "./src/pages/**/*.tsx",
    "./src/components/**/*.tsx",
    "./src/layouts/**/*.tsx",
  ],
};
