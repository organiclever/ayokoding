// Compiled by ClojureScript 1.11.54 {:target :nodejs, :nodejs-rt true, :optimizations :none}
goog.provide('hello_world.core');
goog.require('cljs.core');
cljs.core.println.call(null, 'Hello world!');
hello_world.core.average = function hello_world$core$average(a, b) {
  return (a + b) / 2.0;
};
hello_world.core.average.call(null, 20, 13);
console.log(hello_world.core.average, 20, 13);

//# sourceMappingURL=core.js.map
