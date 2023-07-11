import 'package:test/test.dart';

import '../../src/typing/exception_utils.dart';

void main() {
  group('tryCatch working for non throwing case', () {
    test('', () {
      var res = tryCatch(() => 1 / 0);
      expect(res.isError(), equals(false));
      expect(res.isOk(), equals(true));

      res.tap((x) {
        expect(x, equals(double.infinity));
      });
    });
  });
  group('tryCatch working for throwing case', () {
    test('boolean++ should throw and return Error', () {
      var res = tryCatch<bool>(() {
        dynamic foo = true;
        return foo++;
      });

      expect(res.isError(), equals(true));

      res.tapError((err) {
        expect(err.ex.runtimeType == NoSuchMethodError, equals(true));
        expect(err.st.runtimeType != Null, equals(true));
        expect(err.st.toString() != Null, equals(true));
      });
    });
  });
}
