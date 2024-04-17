# main.py

import my_module
from my_package import my_module as my_module_2

my_module.greet("Alice")  # Output: Hello, Alice!
result = my_module.square(5)
print(result)  # Output: 25

print("---")

my_module_2.greet("Bob")  # Output: Hello, Bob!
result = my_module_2.square(5)
print(result)  # Output: 25
