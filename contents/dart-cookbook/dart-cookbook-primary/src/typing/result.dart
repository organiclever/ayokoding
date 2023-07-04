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
  Result<int, String> resultOk = Ok(2);
  Result<int, String> resultError = Error("something went wrong");

  var processedResultOk = resultOk.map((val) => val * 2).map((val) => val + 1);
  var processedResultError =
      resultError.map((val) => val * 2).map((val) => val + 1);

  print(processedResultOk.getOk().getOrElse(0));
  print(processedResultError.getOk().getOrElse(0));
  print(processedResultError.getError().getOrElse("test"));
}
