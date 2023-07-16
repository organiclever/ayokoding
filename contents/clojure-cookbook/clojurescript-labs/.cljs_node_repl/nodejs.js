// Compiled by ClojureScript 1.11.54 {:target :nodejs, :nodejs-rt true, :optimizations :none}
goog.provide('cljs.nodejs');
goog.require('cljs.core');
cljs.nodejs.require = require;
cljs.nodejs.process = process;
cljs.nodejs.enable_util_print_BANG_ =
  function cljs$nodejs$enable_util_print_BANG_() {
    cljs.core._STAR_print_newline_STAR_ = false;

    cljs.core.set_print_fn_BANG_.call(
      null,
      (function () {
        var G__538__delegate = function (args) {
          return console.log.apply(
            console,
            cljs.core.into_array.call(null, args)
          );
        };
        var G__538 = function (var_args) {
          var args = null;
          if (arguments.length > 0) {
            var G__539__i = 0,
              G__539__a = new Array(arguments.length - 0);
            while (G__539__i < G__539__a.length) {
              G__539__a[G__539__i] = arguments[G__539__i + 0];
              ++G__539__i;
            }
            args = new cljs.core.IndexedSeq(G__539__a, 0, null);
          }
          return G__538__delegate.call(this, args);
        };
        G__538.cljs$lang$maxFixedArity = 0;
        G__538.cljs$lang$applyTo = function (arglist__540) {
          var args = cljs.core.seq(arglist__540);
          return G__538__delegate(args);
        };
        G__538.cljs$core$IFn$_invoke$arity$variadic = G__538__delegate;
        return G__538;
      })()
    );

    cljs.core.set_print_err_fn_BANG_.call(
      null,
      (function () {
        var G__541__delegate = function (args) {
          return console.error.apply(
            console,
            cljs.core.into_array.call(null, args)
          );
        };
        var G__541 = function (var_args) {
          var args = null;
          if (arguments.length > 0) {
            var G__542__i = 0,
              G__542__a = new Array(arguments.length - 0);
            while (G__542__i < G__542__a.length) {
              G__542__a[G__542__i] = arguments[G__542__i + 0];
              ++G__542__i;
            }
            args = new cljs.core.IndexedSeq(G__542__a, 0, null);
          }
          return G__541__delegate.call(this, args);
        };
        G__541.cljs$lang$maxFixedArity = 0;
        G__541.cljs$lang$applyTo = function (arglist__543) {
          var args = cljs.core.seq(arglist__543);
          return G__541__delegate(args);
        };
        G__541.cljs$core$IFn$_invoke$arity$variadic = G__541__delegate;
        return G__541;
      })()
    );

    return null;
  };

//# sourceMappingURL=nodejs.js.map
