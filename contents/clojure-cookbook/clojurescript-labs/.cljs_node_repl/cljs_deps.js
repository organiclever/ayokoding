goog.addDependency('base.js', ['goog'], []);
goog.addDependency('debug/error.js', ['goog.debug.Error'], []);
goog.addDependency('dom/nodetype.js', ['goog.dom.NodeType'], []);
goog.addDependency(
  'asserts/asserts.js',
  ['goog.asserts', 'goog.asserts.AssertionError'],
  ['goog.debug.Error', 'goog.dom.NodeType']
);
goog.addDependency('dom/asserts.js', ['goog.dom.asserts'], ['goog.asserts']);
goog.addDependency('functions/functions.js', ['goog.functions'], []);
goog.addDependency('string/typedstring.js', ['goog.string.TypedString'], []);
goog.addDependency(
  'string/const.js',
  ['goog.string.Const'],
  ['goog.asserts', 'goog.string.TypedString']
);
goog.addDependency(
  'i18n/bidi.js',
  [
    'goog.i18n.bidi',
    'goog.i18n.bidi.Dir',
    'goog.i18n.bidi.DirectionalString',
    'goog.i18n.bidi.Format',
  ],
  []
);
goog.addDependency('html/trustedtypes.js', ['goog.html.trustedtypes'], []);
goog.addDependency(
  'html/safescript.js',
  ['goog.html.SafeScript'],
  [
    'goog.string.Const',
    'goog.string.TypedString',
    'goog.html.trustedtypes',
    'goog.asserts',
  ]
);
goog.addDependency('fs/url.js', ['goog.fs.url'], []);
goog.addDependency('fs/blob.js', ['goog.fs.blob'], []);
goog.addDependency(
  'html/trustedresourceurl.js',
  ['goog.html.TrustedResourceUrl'],
  [
    'goog.asserts',
    'goog.fs.blob',
    'goog.fs.url',
    'goog.html.SafeScript',
    'goog.html.trustedtypes',
    'goog.i18n.bidi.Dir',
    'goog.i18n.bidi.DirectionalString',
    'goog.string.Const',
    'goog.string.TypedString',
  ]
);
goog.addDependency('string/internal.js', ['goog.string.internal'], []);
goog.addDependency(
  'html/safeurl.js',
  ['goog.html.SafeUrl'],
  [
    'goog.asserts',
    'goog.fs.url',
    'goog.html.TrustedResourceUrl',
    'goog.i18n.bidi.Dir',
    'goog.i18n.bidi.DirectionalString',
    'goog.string.Const',
    'goog.string.TypedString',
    'goog.string.internal',
  ]
);
goog.addDependency(
  'html/safestyle.js',
  ['goog.html.SafeStyle'],
  [
    'goog.string.Const',
    'goog.html.SafeUrl',
    'goog.string.TypedString',
    'goog.asserts',
    'goog.string.internal',
  ]
);
goog.addDependency('object/object.js', ['goog.object'], []);
goog.addDependency(
  'html/safestylesheet.js',
  ['goog.html.SafeStyleSheet'],
  [
    'goog.string.Const',
    'goog.html.SafeStyle',
    'goog.string.TypedString',
    'goog.object',
    'goog.asserts',
    'goog.string.internal',
  ]
);
goog.addDependency('dom/htmlelement.js', ['goog.dom.HtmlElement'], []);
goog.addDependency(
  'dom/tagname.js',
  ['goog.dom.TagName'],
  ['goog.dom.HtmlElement']
);
goog.addDependency('array/array.js', ['goog.array'], ['goog.asserts']);
goog.addDependency('labs/useragent/useragent.js', ['goog.labs.userAgent'], []);
goog.addDependency(
  'labs/useragent/util.js',
  ['goog.labs.userAgent.util'],
  ['goog.labs.userAgent', 'goog.string.internal']
);
goog.addDependency(
  'labs/useragent/browser.js',
  ['goog.labs.userAgent.browser'],
  [
    'goog.array',
    'goog.object',
    'goog.labs.userAgent.util',
    'goog.string.internal',
  ]
);
goog.addDependency('dom/tags.js', ['goog.dom.tags'], ['goog.object']);
goog.addDependency(
  'html/safehtml.js',
  ['goog.html.SafeHtml'],
  [
    'goog.string.Const',
    'goog.i18n.bidi.Dir',
    'goog.i18n.bidi.DirectionalString',
    'goog.html.SafeScript',
    'goog.html.SafeStyle',
    'goog.html.SafeStyleSheet',
    'goog.html.SafeUrl',
    'goog.dom.TagName',
    'goog.html.TrustedResourceUrl',
    'goog.string.TypedString',
    'goog.asserts',
    'goog.labs.userAgent.browser',
    'goog.array',
    'goog.object',
    'goog.string.internal',
    'goog.dom.tags',
    'goog.html.trustedtypes',
  ]
);
goog.addDependency(
  'html/uncheckedconversions.js',
  ['goog.html.uncheckedconversions'],
  [
    'goog.asserts',
    'goog.html.SafeHtml',
    'goog.html.SafeScript',
    'goog.html.SafeStyle',
    'goog.html.SafeStyleSheet',
    'goog.html.SafeUrl',
    'goog.html.TrustedResourceUrl',
    'goog.string.Const',
    'goog.string.internal',
  ]
);
goog.addDependency(
  'dom/safe.js',
  ['goog.dom.safe', 'goog.dom.safe.InsertAdjacentHtmlPosition'],
  [
    'goog.asserts',
    'goog.dom.asserts',
    'goog.functions',
    'goog.html.SafeHtml',
    'goog.html.SafeScript',
    'goog.html.SafeStyle',
    'goog.html.SafeUrl',
    'goog.html.TrustedResourceUrl',
    'goog.html.uncheckedconversions',
    'goog.string.Const',
    'goog.string.internal',
  ]
);
goog.addDependency(
  'string/string.js',
  ['goog.string', 'goog.string.Unicode'],
  [
    'goog.dom.safe',
    'goog.html.uncheckedconversions',
    'goog.string.Const',
    'goog.string.internal',
  ]
);
goog.addDependency('collections/maps.js', ['goog.collections.maps'], []);
goog.addDependency(
  'structs/structs.js',
  ['goog.structs'],
  ['goog.array', 'goog.object']
);
goog.addDependency(
  'uri/utils.js',
  [
    'goog.uri.utils',
    'goog.uri.utils.ComponentIndex',
    'goog.uri.utils.QueryArray',
    'goog.uri.utils.QueryValue',
    'goog.uri.utils.StandardQueryParam',
  ],
  ['goog.asserts', 'goog.string']
);
goog.addDependency(
  'uri/uri.js',
  ['goog.Uri', 'goog.Uri.QueryData'],
  [
    'goog.array',
    'goog.asserts',
    'goog.collections.maps',
    'goog.string',
    'goog.structs',
    'goog.uri.utils',
    'goog.uri.utils.ComponentIndex',
    'goog.uri.utils.StandardQueryParam',
  ]
);
goog.addDependency('reflect/reflect.js', ['goog.reflect'], []);
goog.addDependency('math/integer.js', ['goog.math.Integer'], ['goog.reflect']);
goog.addDependency('string/stringbuffer.js', ['goog.string.StringBuffer'], []);
goog.addDependency(
  'math/long.js',
  ['goog.math.Long'],
  ['goog.asserts', 'goog.reflect']
);
goog.addDependency(
  '../cljs/core.js',
  ['cljs.core'],
  [
    'goog.string',
    'goog.Uri',
    'goog.object',
    'goog.math.Integer',
    'goog.string.StringBuffer',
    'goog.array',
    'goog.math.Long',
  ]
);
goog.addDependency('../nodejs.js', ['cljs.nodejs'], ['cljs.core']);
goog.addDependency(
  '../hello_world/core.js',
  ['hello_world.core'],
  ['cljs.core']
);
goog.addDependency(
  '../nodejscli.js',
  ['cljs.nodejscli'],
  ['cljs.nodejs', 'goog.object', 'cljs.core']
);