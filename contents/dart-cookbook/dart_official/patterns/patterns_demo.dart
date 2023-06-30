sealed class Result<T, U> {
  map<T1>(T1 Function(T) f) {
    switch (this) {
      case (Ok ok):
        return Ok(f(ok.value));
      case (Error error):
        return Error(error.value);
    }
  }

  mapError<U1>(U1 Function(U) f) {
    switch (this) {
      case (Ok ok):
        return Ok(ok.value);
      case (Error error):
        return Error(f(error.value));
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
}

class Ok<T> extends Result {
  final T value;

  Ok(this.value);
}

class Error<U> extends Result {
  final U value;

  Error(this.value);
}

Result mapFunc<T, U, T1>(T1 Function(T) f, Result<T, U> val) {
  switch (val) {
    case (Ok ok):
      return Ok(f(ok.value));
    case (Error error):
      return Error(error.value);
  }
}

String processResult(Result res) {
  switch (res) {
    case (Ok ok):
      return "OK: ${ok.value}";
    case (Error error):
      return "Error: ${error.value}";
  }
}

void main() {
  print(processResult(Ok("Hello World"))); // OK: Hello World
  print(processResult(Ok(100))); // Ok: 100
  print(processResult(Error("Error Bro!"))); // Error: Error Bro!
  print(processResult(Error(-100))); // Error: -100

  print("---");

  print(Ok(100).getOrElse(0));
  print(Error(100).getOrElse(0));

  var theVal = Ok("100").map((val) => val.toUpperCase()).getOrElse("yo");
  print(theVal);

  print("---");

  // var mapped = Ok(10).map((message) => message.toString());
  var mapped = mapFunc((p0) => Ok(p0 + 10), Ok(10));
  var errorMapped = Ok(10).mapError((message) => message.toString());

  print(processResult(mapped));
  print(processResult(errorMapped));

  print("---");
}
