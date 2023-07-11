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
  var res = tryCatch<bool>(() {
    dynamic foo = true;
    return foo++;
  });

  print(res.isError()); // Output: true
  print(res.isOk()); // Output: false

  res.tapError((err) {
    print(err.ex.runtimeType); // Output: NoSuchMethodError
    print(err.st.runtimeType); // Output: _StackTrace
  });
}
