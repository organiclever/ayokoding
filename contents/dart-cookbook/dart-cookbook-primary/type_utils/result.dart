sealed class Result<T, U> {
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

  // bimap

  // tap

  // tapError

  // flatmap

  T getOrElse(T defVal) {
    switch (this) {
      case (Ok ok):
        return ok.value;
      case (Error _):
        return defVal;
    }
  }

  // getErrorOrElse

  // isOk

  // isError

  // getOk => Option

  // getError
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
  var res = Ok<int, String>(1);
  print(res);

  var okMapRes = Ok<int, String>(1).map((x) => x.toString());
  var okMapErrorRes = Ok<int, String>(1).mapError((e) => e.toUpperCase());
  var errorMapRes =
      Error<int, String>("something wrong").map((x) => x.toString());
  var errorMapErrorRes =
      Error<int, String>("something wrong").mapError((e) => e.toUpperCase());

  print(okMapRes.getOrElse("nothing")); // Output: 1
  print(okMapErrorRes.getOrElse(0)); // Output: 1
  print(errorMapRes
      .getOrElse("default error message")); // Output: default error message
  print(errorMapErrorRes.getOrElse(0));
}
