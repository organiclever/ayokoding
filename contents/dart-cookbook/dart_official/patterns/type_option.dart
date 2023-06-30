sealed class Option<T> {
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

  T getOrElse(T defVal) {
    switch (this) {
      case (Some some):
        return some.value;
      case (None _):
        return defVal;
    }
  }

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
}

class Some<T> extends Option<T> {
  final T value;

  Some(this.value);
}

class None<T> extends Option<T> {}

void main() {
  // map
  // flatmap
  // tap
  // getOrElse
  // isSome
  // isNone}
}
