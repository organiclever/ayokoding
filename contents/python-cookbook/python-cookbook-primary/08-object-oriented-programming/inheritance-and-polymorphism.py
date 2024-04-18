# inheritance

class ParentClass:
    def parent_method(self):
        print("This is parent method")


class ChildClass(ParentClass):
    def child_method(self):
        print("This is child method")


child = ChildClass()
child.parent_method()  # Output: This is parent method

print("---")

# method overriding


class ParentClass2:
    def method(self):
        print("This is parent method")


class ChildClass2(ParentClass2):
    def method(self):
        print("This is child method")


child2 = ChildClass2()
child.parent_method()  # Output: This is child method

print("---")

# polymorphism


class Dog:
    def sound(self):
        print("Bark")


class Cat:
    def sound(self):
        print("Meow")


def make_sound(animal):
    animal.sound()


dog = Dog()
cat = Cat()

make_sound(dog)  # Output: Bark
make_sound(cat)  # Output: Meow

print("---")

# encapsulation


class Person:
    def __init__(self):
        self.__name = ""

    def set_name(self, name):
        self.__name = name

    def get_name(self):
        return self.__name


person = Person()
person.set_name("John Doe")
print(person.get_name())  # Output: John Doe

print("---")


# class variables vs instance variables

class Circle:
    pi = 3.14  # class variable

    def __init__(self, radius):
        self.radius = radius  # instance variable


circle1 = Circle(5)
circle2 = Circle(10)

print(circle1.radius)  # Output: 5
print(circle2.radius)  # Output: 10
print(circle1.pi)  # Output: 3.14
print(circle2.pi)  # Output: 3.14

print("---")


# class composition

class Engine:
    def start(self):
        print("Engine started")


class Car:
    def __init__(self):
        self.engine = Engine()

    def start(self):
        self.engine.start()


car = Car()
car.start()  # Output: Engine started

print("---")


# built-in methods and attributes

class Rectangle:
    def __init__(self, length, width):
        self.length = length
        self.width = width

    def __str__(self):
        return f"Rectangle with length {self.length} and width {self.width}"

    def __len__(self):
        return 2 * (self.length * self.width)


rectangle = Rectangle(5, 10)
print(rectangle)  # Output: Rectangle with length 5 and width 10
print(str(rectangle))  # Output: Rectangle with length 5 and width 10
print(len(rectangle))  # Output: 100
