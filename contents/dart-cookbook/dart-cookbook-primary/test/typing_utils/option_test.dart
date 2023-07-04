import 'package:collection/collection.dart';
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
    test("getOrElse for Some", () {
      expect(Some(1).getOrElse(2), equals(1));
    });
    test("getOrElse for None", () {
      expect(None().getOrElse(2), equals(2));
    });
  });

  group('map working correctly', () {
    test('map for None', () {
      expect(None().map((x) => x + 1).isEqual(None()), equals(true));
    });
    test('map for Some number', () {
      var someNumber = Some(1);

      expect(someNumber.map((x) => x + 1).map((x) => x + 1).isEqual(Some(3)),
          equals(true));
      expect(someNumber.isEqual(Some(1)), equals(true));
    });
    test('map for Some string', () {
      var someString = Some("hello");

      expect(
          someString
              .map((x) => x.toUpperCase())
              .map((x) => x.toLowerCase())
              .isEqual(Some("hello")),
          equals(true));
      expect(someString.isEqual(Some("hello")), equals(true));
    });
    test('map for Some record', () {
      var someRecord = Some((name: "John", age: 30));

      expect(someRecord.map((x) => x.name.toUpperCase()).isEqual(Some("JOHN")),
          equals(true));
      expect(someRecord.isEqual(Some((name: "John", age: 30))), equals(true));
    });
    test('map for Some list', () {
      var someList = Some([1, 2, 3]);
      var processedList =
          someList.map((x) => x.map((y) => y + 1).toList()).getOrElse([]);

      expect(ListEquality().equals(processedList, [2, 3, 4]), equals(true));
      expect(ListEquality().equals(someList.getOrElse([]), [1, 2, 3]),
          equals(true));
    });
  });

  group("flatmap working correctly", () {
    test("flatmap for None", () {
      expect(None().flatmap((x) => Some(x + 1)).isEqual(None()), equals(true));
    });
    test('flatmap for Some number', () {
      var someNumber = Some(1);

      expect(someNumber.flatmap((x) => Some(x + 1)).isEqual(Some(2)),
          equals(true));
      expect(someNumber.isEqual(Some(1)), equals(true));
    });
    test('flatmap for Some string', () {
      var someString = Some("hello");

      expect(
          someString
              .flatmap((x) => Some(x.toUpperCase()))
              .isEqual(Some("HELLO")),
          equals(true));

      expect(someString.isEqual(Some("hello")), equals(true));
    });
    test('flatmap for Some record', () {
      var someRecord = Some((name: "John", age: 30));

      expect(
          someRecord
              .flatmap((x) => Some(x.name.toUpperCase()))
              .isEqual(Some("JOHN")),
          equals(true));

      expect(someRecord.isEqual(Some((name: "John", age: 30))), equals(true));
    });
    test('flatmap for Some list', () {
      var someList = Some([1, 2, 3]);
      var processedList = someList
          .flatmap((x) => Some(x.map((y) => y + 1).toList()))
          .getOrElse([]);

      expect(ListEquality().equals(processedList, [2, 3, 4]), equals(true));
      expect(ListEquality().equals(someList.getOrElse([]), [1, 2, 3]),
          equals(true));
    });
  });

  group("tap working correctly", () {
    test("tap for Some", () {
      var called = false;
      var anOption = Some(1).tap((x) => called = true);

      expect(anOption.isEqual(Some(1)), equals(true));
      expect(called, equals(true));
    });
    test("tap for None", () {
      var called = false;
      var anOption = None().tap((x) => called = true);

      expect(anOption.isEqual(None()), equals(true));
      expect(called, equals(false));
    });
  });
}
