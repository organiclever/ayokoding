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
