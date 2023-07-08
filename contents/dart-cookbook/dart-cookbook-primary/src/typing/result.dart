import 'option.dart';

sealed class Result<T, U> {
  bool isError() {
    switch (this) {
      case (Ok _):
        return false;
      case (Error _):
        return true;
    }
  }

  bool isOk() {
    switch (this) {
      case (Ok _):
        return true;
      case (Error _):
        return false;
    }
  }

  bool isEqual(Result<T, U> other) {
    switch ((this, other)) {
      case (Ok ok, Ok other):
        return ok.value == other.value;
      case (Error error, Error other):
        return error.value == other.value;
      default:
        return false;
    }
  }

  String toString() {
    switch (this) {
      case (Ok ok):
        return "Ok(${ok.value})";
      case (Error error):
        return "Error(${error.value})";
    }
  }

  Option<T> getOk() {
    switch (this) {
      case (Ok ok):
        return Some(ok.value);
      case (Error _):
        return None();
    }
  }

  Option<U> getError() {
    switch (this) {
      case (Ok _):
        return None();
      case (Error error):
        return Some(error.value);
    }
  }

  T getOrElse(T defVal) {
    switch (this) {
      case (Ok ok):
        return ok.value;
      case (Error _):
        return defVal;
    }
  }

  U getErrorOrElse(U defVal) {
    switch (this) {
      case (Ok _):
        return defVal;
      case (Error error):
        return error.value;
    }
  }

  Result<T1, U> map<T1>(T1 Function(T) f) {
    switch (this) {
      case (Ok ok):
        return Ok(f(ok.value));
      case (Error error):
        return Error(error.value);
    }
  }

  Result<T, U1> mapError<U1>(U1 Function(U) f) {
    switch (this) {
      case (Ok ok):
        return Ok(ok.value);
      case (Error error):
        return Error(f(error.value));
    }
  }

  Result<T1, U> flatmap<T1>(Result<T1, U> Function(T) f) {
    switch (this) {
      case (Ok ok):
        return f(ok.value);
      case (Error error):
        return Error(error.value);
    }
  }

  Result<T, U1> flatmapError<U1>(Result<T, U1> Function(U) f) {
    switch (this) {
      case (Ok ok):
        return Ok(ok.value);
      case (Error error):
        return f(error.value);
    }
  }

  Result<T1, U1> bimap<T1, U1>(T1 Function(T) f, U1 Function(U) g) {
    switch (this) {
      case (Ok ok):
        return Ok(f(ok.value));
      case (Error error):
        return Error(g(error.value));
    }
  }

  Result<T, U> tap(void Function(T) f) {
    switch (this) {
      case (Ok ok):
        f(ok.value);
        return Ok(ok.value);
      case (Error error):
        return Error(error.value);
    }
  }

  Result<T, U> tapError(void Function(U) f) {
    switch (this) {
      case (Ok ok):
        return Ok(ok.value);
      case (Error error):
        f(error.value);
        return Error(error.value);
    }
  }

  Result<T, U> bitap(void Function(T) f, void Function(U) g) {
    switch (this) {
      case (Ok ok):
        f(ok.value);
        return Ok(ok.value);
      case (Error error):
        g(error.value);
        return Error(error.value);
    }
  }
}

class Ok<T, U> extends Result<T, U> {
  final T value;

  Ok(this.value);
}

class Error<T, U> extends Result<T, U> {
  final U value;

  Error(this.value);
}

void main() {
  Result<String, ({int status, String message})> okRes = Ok("hello world!");
  Result<String, ({int status, String message})> errorRes =
      Error((status: 404, message: "URL not found"));

  print(okRes); // Output: Ok(hello world!)
  print(errorRes); // Output: Error((message: URL not found, status: 404)))

  print(okRes.isOk()); // Output: true
  print(okRes.isError()); // Output: false
  print(errorRes.isOk()); // Output: false
  print(errorRes.isError()); // Output: true

  print(okRes.isEqual(Ok("hello world!"))); // Output: true
  print(errorRes
      .isEqual(Error((status: 404, message: "URL not found")))); // Output: true

  print(okRes.getOk()); // Output: Some(hello world!)
  print(okRes.getError()); // Output: None()
  print(errorRes.getOk()); // Output: None()
  print(errorRes
      .getError()); // Output: Some((message: URL not found, status: 404))

  print(okRes.getOrElse("default value")); // Output: hello world!
  print(errorRes.getOrElse("default value")); // Output: default value

  print(okRes.getErrorOrElse((
    status: 500,
    message: "Internal server error",
  ))); // Output: (message: Internal server error, status: 500)
  print(errorRes.getErrorOrElse((
    status: 500,
    message: "Internal server error",
  ))); // Output: (message: URL not found, status: 404)

  print(okRes.map((value) => value.toUpperCase())); // Output: Ok(HELLO WORLD!)
  print(errorRes.map((value) => value
      .toUpperCase())); // Output: Error((message: URL not found, status: 404))

  print(okRes.mapError((err) => (
        status: err.status,
        message: err.message.toUpperCase()
      ))); // Output: Ok(hello world!)
  print(errorRes.mapError((err) => (
        status: err.status,
        message: err.message.toUpperCase()
      ))); // Output: Error((message: URL NOT FOUND, status: 404))

  print(okRes
      .flatmap((value) => Ok(value.toUpperCase()))); // Output: Ok(HELLO WORLD!)
  print(errorRes.flatmap((value) => Ok(value
      .toUpperCase()))); // Output: Error((message: URL not found, status: 404))

  print(okRes.flatmapError((err) => Error((
        status: 500,
        message: err.message.toUpperCase()
      )))); // Output: Ok(hello world!)
  print(errorRes.flatmapError((err) => Error((
        status: err.status,
        message: err.message.toUpperCase()
      )))); // Output: Error((message: URL NOT FOUND, status: 404))

  print(okRes.bimap(
      (value) => value.toUpperCase(),
      (err) => (
            status: err.status,
            message: err.message.toUpperCase()
          ))); // Output: Ok(HELLO WORLD!)
  print(errorRes.bimap(
      (value) => value.toUpperCase(),
      (err) => (
            status: err.status,
            message: err.message.toUpperCase()
          ))); // Output: Error((message: URL NOT FOUND, status: 404))

  print(okRes.tap((value) =>
      print(value))); // Output: print hello world! then Ok(hello world!)
  print(errorRes.tap((value) =>
      print(value))); // Output: Error((message: URL not found, status: 404))

  print(
      okRes.tapError((err) => print(err.message))); // Output: Ok(hello world!)
  print(errorRes.tapError((err) => print(err
      .message))); // Output: print URL not found then Error((message: URL not found, status: 404))

  print(okRes.bitap(
      (value) => print(value),
      (err) => print(
          err.message))); // Output: print hello world! then Ok(hello world!)
  print(errorRes.bitap(
      (value) => print(value),
      (err) => print(err
          .message))); // Output: print URL not found then Error((message: URL not found, status: 404)
}
