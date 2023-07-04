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
}

class Some<T> extends Option<T> {
  final T value;

  Some(this.value);
}

class None<T> extends Option<T> {
  final value = Null;
}

void main() {
  var someList = Some([1, 2, 3]);
  print(someList.map((x) => x.map((y) => y + 1).toList()).tap((p0) {
    print(p0);
  }).isEqual(Some([2, 3, 4])));

  print([2, 3, 4] == [2, 3, 4]);

  someList.tap((p0) {
    print(p0);
  });
}
