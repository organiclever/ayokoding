import 'package:test/test.dart';
import '../../type_utils/option.dart';
import "../../type_utils/result.dart";

void main() {
  group('Ok creation working correctly', () {
    test('Ok is equal to other Ok', () {
      expect(Ok("hello").isEqual(Ok("hello")), equals(true));
      expect(Ok(1).isEqual(Ok(1)), equals(true));
    });
    test('Ok isOk', () {
      expect(Ok(1).isOk(), equals(true));
    });
    test('Ok is not Error', () {
      expect(Ok(1).isError(), equals(false));
    });
  });

  group('Error creation working correctly', () {
    test('Error is equal to other Error', () {
      expect(Error("hello").isEqual(Error("hello")), equals(true));
      expect(Error(1).isEqual(Error(1)), equals(true));
    });
    test('Error isError', () {
      expect(Error(1).isError(), equals(true));
    });
    test('Error is not Ok', () {
      expect(Error(1).isOk(), equals(false));
    });
  });

  group("map working correctly", () {
    test("map working correctly for Ok", () {
      expect(Ok(1).map((x) => x + 1).isEqual(Ok(2)), equals(true));
      expect(Ok("hello").map((x) => x.toUpperCase()).isEqual(Ok("HELLO")),
          equals(true));
    });
    test("map working correctly for Error", () {
      expect(Error(1).map((x) => x + 1).isEqual(Error(1)), equals(true));
    });
  });

  group("mapError working correctly", () {
    test("mapError working correctly for Ok", () {
      expect(Ok(1).mapError((x) => x + 1).isEqual(Ok(1)), equals(true));
    });
    test("mapError working correctly for Error", () {
      expect(Error(1).mapError((x) => x + 1).isEqual(Error(2)), equals(true));
      expect(
          Error("hello")
              .mapError((x) => x.toUpperCase())
              .isEqual(Error("HELLO")),
          equals(true));
    });
  });

  group("flatmap working correctly", () {
    test("flatmap working correctly for Ok", () {
      expect(Ok(1).flatmap((x) => Ok(x + 1)).isEqual(Ok(2)), equals(true));
      expect(
          Ok("hello").flatmap((x) => Ok(x.toUpperCase())).isEqual(Ok("HELLO")),
          equals(true));
    });
    test("flatmap working correctly for Error", () {
      expect(
          Ok(1).flatmap((x) => Error(x + 1)).isEqual(Error(2)), equals(true));
      expect(
          Ok("hello")
              .flatmap((x) => Error(x.toUpperCase()))
              .isEqual(Error("HELLO")),
          equals(true));
    });
  });

  group("flatmapError working correctly", () {
    test("flatmapError working correctly for Ok", () {
      expect(Ok(1).flatmapError((x) => Ok(x + 1)).isEqual(Ok(1)), equals(true));
    });
    test("flatmapError working correctly for Error", () {
      expect(
          Error(1).flatmapError((x) => Ok(x + 1)).isEqual(Ok(2)), equals(true));
      expect(Error(1).flatmapError((x) => Error(x + 1)).isEqual(Error(2)),
          equals(true));
    });
  });

  group("bimap working correctly", () {
    test("bimap working correctly for Ok", () {
      expect(
          Ok(1).bimap((x) => x + 1, (e) => e + 2).isEqual(Ok(2)), equals(true));
      expect(
          Ok("Hello")
              .bimap((x) => x.toUpperCase(), (e) => e.toLowerCase())
              .isEqual(Ok("HELLO")),
          equals(true));
    });
    test("bimap working correctly for Error", () {
      expect(Error(1).bimap((x) => x + 1, (e) => e + 2).isEqual(Error(3)),
          equals(true));
      expect(
          Error("Hello")
              .bimap((x) => x.toUpperCase(), (e) => e.toLowerCase())
              .isEqual(Error("hello")),
          equals(true));
    });
  });

  group("tap working correctly", () {
    test("tap working correctly for Ok", () {
      var called = false;
      var aResult = Ok(1).tap((x) => called = true);

      expect(aResult.isEqual(Ok(1)), equals(true));
      expect(called, equals(true));
    });
    test("tap working correctly for Error", () {
      var called = false;
      var aResult = Error(1).tap((x) => called = true);

      expect(aResult.isEqual(Error(1)), equals(true));
      expect(called, equals(false));
    });
  });

  group("tapError working correctly", () {
    test("tapError working correctly for Ok", () {
      var called = false;
      var aResult = Ok(1).tapError((x) => called = true);

      expect(aResult.isEqual(Ok(1)), equals(true));
      expect(called, equals(false));
    });
    test("tapError working correctly for Error", () {
      var called = false;
      var aResult = Error(1).tapError((x) => called = true);

      expect(aResult.isEqual(Error(1)), equals(true));
      expect(called, equals(true));
    });
  });

  group("bitap working correctly", () {
    test("bitap working correctly for Ok", () {
      var xCalled = false;
      var eCalled = false;
      var aResult = Ok(1).bitap((x) => xCalled = true, (x) => eCalled = true);

      expect(aResult.isEqual(Ok(1)), equals(true));
      expect(xCalled, equals(true));
      expect(eCalled, equals(false));
    });
    test("bitap working correctly for Error", () {
      var xCalled = false;
      var eCalled = false;
      var aResult =
          Error(1).bitap((x) => xCalled = true, (e) => eCalled = true);

      expect(aResult.isEqual(Error(1)), equals(true));
      expect(xCalled, equals(false));
      expect(eCalled, equals(true));
    });
  });

  group("getOrElse working correctly", () {
    test("getOrElse working correctly for Ok", () {
      expect(Ok(1).getOrElse(2), equals(1));
    });
    test("getOrElse working correctly for Error", () {
      expect(Error(1).getOrElse(2), equals(2));
    });
  });

  group("getErrorOrElse working correctly", () {
    test("getErrorOrElse working correctly for Ok", () {
      expect(Ok(1).getErrorOrElse(2), equals(2));
    });
    test("getErrorOrElse working correctly for Error", () {
      expect(Error(1).getErrorOrElse(2), equals(1));
    });
  });

  group("getOk working correctly", () {
    test("getOk working correctly for Ok", () {
      expect(Ok(1).getOk().isEqual(Some(1)), equals(true));
    });
    test("getOk working correctly for Error", () {
      expect(Error(1).getOk().isEqual(None()), equals(true));
    });
  });
}
