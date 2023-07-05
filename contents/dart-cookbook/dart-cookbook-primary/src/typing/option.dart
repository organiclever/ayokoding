sealed class Option<T> {
  bool isSome() {
    switch (this) {
      case (Some _):
        return true;
      case (None _):
        return false;
    }
  }

  bool isNone() {
    switch (this) {
      case (Some _):
        return false;
      case (None _):
        return true;
    }
  }

  bool isEqual(Option<T> other) {
    switch ((this, other)) {
      case (Some some, Some other):
        return some.value == other.value;
      case (None _, None _):
        return true;
      case _:
        return false;
    }
  }

  T getOrElse(T defVal) {
    switch (this) {
      case (Some some):
        return some.value;
      case (None _):
        return defVal;
    }
  }

  Option<T1> map<T1>(T1 Function(T) f) {
    switch (this) {
      case (Some some):
        return Some(f(some.value));
      case (None _):
        return None();
    }
  }

  Option<T1> flatmap<T1>(Option<T1> Function(T) f) {
    switch (this) {
      case (Some some):
        return f(some.value);
      case (None _):
        return None();
    }
  }

  Option<T> tap(void Function(T) f) {
    switch (this) {
      case (Some some):
        f(some.value);
        return Some(some.value);
      case (None _):
        return None();
    }
  }

  String toString() {
    switch (this) {
      case (Some some):
        return "Some(${some.value})";
      case (None _):
        return "None";
    }
  }
}

class Some<T> extends Option<T> {
  final T value;

  Some(this.value);
}

class None<T> extends Option<T> {
  final value = Null;
}

void main() {
  var someNumber = Some(1);
  Option<int> noneNumber = None();
  var someString = Some("hello");
  Option<String> noneString = None();

  print(someNumber); // Output: Some(1)
  print(noneNumber); // Output: None
  print(someString); // Output: Some(hello)
  print(noneString); // Output: None

  print(someNumber.isSome()); // Output: true
  print(someNumber.isNone()); // Output: false

  print(someNumber.isEqual(Some(1))); // Output: true
  print(someNumber.isEqual(None())); // Output: false

  print(someNumber.getOrElse(2)); // Output: 1
  print(noneNumber.getOrElse(2)); // Output: 2

  print(someNumber.map((x) => x + 1)); // Output: Some(2)
  print(someString.map((x) => x + " world")); // Output: Some(hello world)
  print(noneNumber.map((x) => x + 1)); // Output: None
  print(someNumber.map((x) => x + 1).map((x) => x * 3)); // Output: Some(6)
  print(someNumber); // Output: Some(1)

  print(someNumber.flatmap((x) => Some(x + 1))); // Output: Some(2)
  print(someString
      .flatmap((x) => Some(x + " world"))); // Output: Some(hello world)
  print(noneNumber.flatmap((x) => Some(x + 1))); // Output: None
  print(someNumber
      .flatmap((x) => Some(x + 1))
      .flatmap((x) => Some(x * 3))); // Output: Some(6)

  print(someNumber.tap((p0) {
    print(p0);
  })); // Output: Some(1), but print 1 first
}
