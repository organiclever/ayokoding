import 'package:test/test.dart';
import '../../src/typing_utils/option.dart';

void main() {
  group('None creation working correctly', () {
    test('None is equal to other None', () {
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
    test('Some is equal to other Some', () {
      expect(Some(1).isEqual(Some(1)), equals(true));
    });
    test('Some is Some', () {
      expect(Some(1).isSome(), equals(true));
    });
    test('Some is not None', () {
      expect(Some(1).isNone(), equals(false));
    });
  });

  group("getOrElse working correctly", () {
    test("getOrElse working correctly for Some", () {
      expect(Some(1).getOrElse(2), equals(1));
    });
    test("getOrElse working correctly for None", () {
      expect(None().getOrElse(2), equals(2));
    });
  });

  group('map working correctly', () {
    test('map working correctly for Some', () {
      expect(Some(1).map((x) => x + 1).isEqual(Some(2)), equals(true));
      expect(Some("hello").map((x) => x.toUpperCase()).isEqual(Some("HELLO")),
          equals(true));
    });
    test('map chaining working correctly for Some', () {
      expect(Some(1).map((x) => x + 1).map((x) => x + 1).isEqual(Some(3)),
          equals(true));
      expect(
          Some("hello")
              .map((x) => x.toUpperCase())
              .map((x) => x.toLowerCase())
              .isEqual(Some("hello")),
          equals(true));
    });
    test('map working correctly for None', () {
      expect(None().map((x) => x + 1).isEqual(None()), equals(true));
    });
  });

  group("flatmap working correctly", () {
    test("flatmap working correctly for Some", () {
      expect(
          Some(1).flatmap((x) => Some(x + 1)).isEqual(Some(2)), equals(true));
      expect(
          Some(1)
              .flatmap((x) => Some(x + 1))
              .flatmap((x) => Some(x + 1))
              .isEqual(Some(3)),
          equals(true));
    });
    test("flatmap working correctly for None", () {
      expect(None().flatmap((x) => Some(x + 1)).isEqual(None()), equals(true));
    });
  });

  group("tap working correctly", () {
    test("tap working correctly for Some", () {
      var called = false;
      var anOption = Some(1).tap((x) => called = true);

      expect(anOption.isEqual(Some(1)), equals(true));
      expect(called, equals(true));
    });
    test("tap working correctly for None", () {
      var called = false;
      var anOption = None().tap((x) => called = true);

      expect(anOption.isEqual(None()), equals(true));
      expect(called, equals(false));
    });
  });
}
