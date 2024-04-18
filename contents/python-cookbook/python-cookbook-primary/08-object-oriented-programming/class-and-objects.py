# class definition

class MyClass:
    pass

# object instantiation


my_object = MyClass()

# Output: <__main__.MyClass object at 0x7f8b1b3b7d30> (memory address will be different)
print(my_object)

print("---")

# class attribute


class Circle:
    pi = 3.14


circle1 = Circle()
print(circle1.pi)  # Output: 3.14
print(Circle.pi)  # Output: 3.14


print("---")

# instance attributes


class Circle2:
    def __init__(self, radius):
        self.radius = radius


circle2 = Circle2(5)
print(circle2.radius)  # Output: 5

print("---")

# class methods


class Circle3:
    pi = 3.14

    def __init__(self, radius):
        self.radius = radius

    @classmethod
    def get_pi(cls):
        return cls.pi


circle3 = Circle3(5)
print(circle3.pi)  # Output: 3.14

print("---")


# instance methods


class Circle4:
    pi = 3.14

    def __init__(self, radius):
        self.radius = radius

    def calculate_area(self):
        return self.pi * self.radius ** 2


circle4 = Circle4(5)
print(circle4.calculate_area())  # Output: 78.5

print("---")

# the self parameter


class Rectangle:
    def __init__(self, length, width):
        self.length = length
        self.width = width

    def calculate_area(self):
        return self.length * self.width


rectangle1 = Rectangle(5, 4)
area = rectangle1.calculate_area()
print(area)  # Output: 20

print("---")


# constructor and destructor

class Person:
    def __init__(self, name):
        self.name = name
        print("Constructor called")

    def __del__(self):
        print("Destructor called for", self.name)


person1 = Person("John")  # Output: Constructor called
del person1  # Output: Destructor called for John
