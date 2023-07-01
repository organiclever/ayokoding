import 'package:test/test.dart';
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

  group("Map working correctly", () {
    test("Map working correctly for Ok", () {
      expect(Ok(1).map((x) => x + 1).isEqual(Ok(2)), equals(true));
      expect(Ok("hello").map((x) => x.toUpperCase()).isEqual(Ok("HELLO")),
          equals(true));
    });
    test("Map working correctly for Error", () {
      expect(Error(1).map((x) => x + 1).isEqual(Error(1)), equals(true));
    });
  });

  group("MapError working correctly", () {
    test("MapError working correctly for Ok", () {
      expect(Ok(1).mapError((x) => x + 1).isEqual(Ok(1)), equals(true));
    });
    test("MapError working correctly for Error", () {
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
}
