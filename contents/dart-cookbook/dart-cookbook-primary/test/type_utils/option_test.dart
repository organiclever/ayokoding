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
  group('Map working correctly', () {
    test('Map working correctly for Some', () {
      expect(Some(1).map((x) => x + 1).isEqual(Some(2)), equals(true));
    });
    test('Map working correctly for None', () {
      expect(None().map((x) => x + 1).isEqual(None()), equals(true));
    });
  });
}
