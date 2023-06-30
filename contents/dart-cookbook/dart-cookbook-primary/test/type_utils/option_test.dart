import 'package:test/test.dart';
import "../../type_utils/option.dart";

void main() {
  group('Option creation for none', () {
    test('None will return default value when getOrElse', () {
      expect(None().isEqual(None()), equals(true));
    });
    test('None is None', () {
      expect(None().isNone(), equals(true));
    });
    test('None is not Some', () {
      expect(None().isSome(), equals(false));
    });
  });
}
