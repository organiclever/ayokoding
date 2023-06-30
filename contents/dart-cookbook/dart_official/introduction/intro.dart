import '../local_libs/fibonacci2.dart';

void main() {
  print("Hello World");

  var name = 'Voyager I';
  var year = 1977;
  var antennaDiameter = 3.7;
  var flybyObjects = ['Jupiter', 'Saturn', 'Uranus', 'Neptune'];
  var image = {
    'tags': ['saturn'],
    'url': '//path/to/saturn.jpg'
  };
  print(name);
  print(year);
  print(antennaDiameter);
  print(flybyObjects);
  print(image);

  print("---");
  if (year >= 2001) {
    print('21st century');
  } else if (year >= 1901) {
    print('20th century');
  }

  print("---");
  for (final object in flybyObjects) {
    print(object);
  }

  for (int month = 1; month <= 12; month++) {
    print(month);
  }

  while (year < 2016) {
    year += 1;
  }

  print("---");
  print(fibonacci(20));

  print("---");
  flybyObjects.where((name) => name.contains('turn')).forEach(print);

  print("---");
  fibonacci2(10);
}

int fibonacci(int n) {
  if (n == 0 || n == 1) return n;
  return fibonacci(n - 1) + fibonacci(n - 2);
}
