import 'result.dart';

Result<T, ({Object ex, StackTrace st})> tryCatch<T>(T Function() operation) {
  try {
    T result = operation();
    return Ok(result);
  } catch (e, s) {
    return Error((ex: e, st: s));
  }
}

void main() {
  // this will wrap exception in Result type
  var resError = tryCatch<bool>(() {
    dynamic foo = true;
    return foo++;
  });

  print(resError.isError()); // Output: true
  print(resError.isOk()); // Output: false

  resError.tapError((err) {
    print(err.ex.runtimeType); // Output: NoSuchMethodError
    print(err.st.runtimeType); // Output: _StackTrace
  });

  resError.mapError((e) => e.ex).tapError((err) {
    print(err.runtimeType); // Output: NoSuchMethodError
  });

  var resOk = tryCatch(() => "Hello".toLowerCase());

  resOk
      .map((x) => x * 2)
      .map((x) => x + "!")
      .map((x) => x.toUpperCase())
      .tap((x) {
    print(x); // Output: HELLOHELLO!
  });
}
