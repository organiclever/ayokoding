export default {
  '*.{js,jsx,ts,tsx,mjs}': ['npx prettier --write'],
  '*.{clj,cljc,cljs,edn}': (files) =>
    `clj -Tcljfmt fix '{:paths ["${files.join('", "')}"]}'`,
};
