import 'package:test/test.dart';
import "../../type_utils/option.dart";

void main() {
  group('None creation working correctly', () {
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
  group('Some creation working correctly', () {
    test('None will return default value when getOrElse', () {
      expect(Some(1).isEqual(Some(1)), equals(true));
    });
    test('Some is Some', () {
      expect(Some(1).isSome(), equals(true));
    });
    test('Some is not None', () {
      expect(Some(1).isNone(), equals(false));
    });
  });
}
