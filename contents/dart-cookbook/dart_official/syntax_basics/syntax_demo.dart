late String description;

void main() {
  // recommended way to declare a variable
  var name = 'Bob';

  // used if you want to change the type of a variable later
  Object name2 = 'Bob';

  // manual type declaration
  String name3 = 'Bob';

  String? name4;

  print(name); // Output: Bob
  print(name2); // Output: Bob
  print(name3); // Output: Bob
  print(name4); // Output: null

  print("---");

  description = 'My name is $name';
  print(description);

  final name5 = 'Bob'; // Without a type annotation
  final String nickname = 'Bobby';

  // name5 = 'Alice'; // Error: a final variable can only be set once.
  print(name5); // Output: Bob
  print(nickname); // Output: Bobby

  const bar = 1000000; // Unit of pressure (dynes/cm2)
  // ignore: unused_local_variable
  const double atm = 1.01325 * bar; // Standard atmosphere

  // ignore: unused_local_variable
  var foo2 = const [];
  // ignore: unused_local_variable
  final bar2 = const [];
  // ignore: unused_local_variable
  const baz = []; // Equivalent to `const []`

  foo2 = [1, 2, 3]; // Was const []
  // baz = [42]; // Error: Constant variables can't be assigned a value.

  print("---");

  const Object i = 3; // Where i is a const Object with an int value...
  const list = [i as int]; // Use a typecast.
  // ignore: unnecessary_type_check, unused_local_variable
  const map = {if (i is int) i: 'int'}; // Use is and collection if.
  // ignore: unused_local_variable, unnecessary_type_check
  const set = {if (list is List<int>) ...list}; // ...and a spread.

  print(i); // Output: 3
  print(list); // Output: [3]
  print(map); // Output: {3: int}
  print(set); // Output: {3}
}
