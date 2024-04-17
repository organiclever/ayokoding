# function definition


def greet():
    print("Hello, World!")


# function invocation


greet()  # Output: Hello, World!

print("---")


# arguments and parameters


def multiply(x, y):
    return x * y


result = multiply(3, 4)
print(result)  # Output: 12

print("---")


# return statements


def square(x):
    return x ** 2


result = square(5)
print(result)  # Output: 25

print("---")


# default parameter


def greet_2(name="World"):
    print(f"Hello, {name}!")


greet_2()  # Output: Hello, World!
greet_2("John")  # Output: Hello, John!

print("---")


# variable length arguments


def multiply_2(*args):
    result = 1
    for num in args:
        result *= num
    return result


product = multiply_2(2, 3, 4)
print(product)  # Output: 24

print("---")


# lambda functions


def multiply_3(x, y): return x * y


result = multiply_3(3, 4)
print(result)  # Output: 12

print("---")


# higher order functions


def apply_operation(x, y, operation):
    return operation(x, y)


result = apply_operation(3, 4, multiply)
print(result)  # Output: 12

print("---")


# recursive functions


def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)


result = factorial(5)
print(result)  # Output: 120

print("---")

# decorators


def decorator(func):
    def wrapper():
        print("Before function execution")
        func()
        print("After function execution")
    return wrapper


@decorator
def greet_3():
    print("Hello, World!")


greet_3()  # Output: Before function execution Hello, World! After function execution


print("---")


# decorators with arguments


def decorator_2(func):
    def wrapper(*args, **kwargs):
        print("Before function execution")
        func(*args, **kwargs)
        print("After function execution")
    return wrapper


@decorator_2
def greet_4(name):
    print(f"Hello, {name}!")


# Output: Before function execution Hello, John! After function execution
greet_4("John")

print("---")


# scope and lifetime of variables

def outer_function():
    x = 10  # local variable

    def inner_function():
        print(x)  # accessing outer function's local variable

    inner_function()


outer_function()

print("---")


# docstrings


def greet_5(name):
    """
    This function greets a person by their name.
    """
    print("Hello, ", name)


print(greet_5.__doc__)  # Output: This function greets a person by their name.


print("---")


# namespace and closure


def outer_function_2():
    x = 10

    def inner_function():
        nonlocal x  # using nonlocal to access the variable of the outer function
        x += 5
        print(x)

    return inner_function


an_fn = outer_function_2()

an_fn()  # Output: 15
an_fn()  # Output: 20
an_fn()  # Output: 25
