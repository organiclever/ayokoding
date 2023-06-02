export default {
  '*.{js,jsx,ts,tsx,mjs}': ['npx prettier --write'],
  '*,{clj,cljc,cljs,edn}': (files) => {
    console.log(files);
    return `clj -Tcljfmt fix '{:paths [${files.join(', ')}]}'
    `;
  },
};
