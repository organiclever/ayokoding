# concatenation

str1 = "Hello"
str2 = " world!"
result = str1 + str2
print(result)  # Output: Hello world!

# repetition

str1 = "Hello"
result = str1 * 3
print(result)  # Output: HelloHelloHello

# indexing

str1 = "Hello"
print(str1[0])  # Output: H

# slicing

str1 = "Hello, Python!"
result = str1[7:13]
print(result)  # Output: Python

# length

str1 = "Hello"
length = len(str1)
print(length)  # Output: 5

# membership

str1 = "Hello, Python!"
result = "Python" in str1
print(result)  # Output: True

# string methods

str1 = "Hello, Python!"
lowercase = str1.lower()
print(lowercase)  # Output: hello, python!

# single line formatting

# - formatting using %

name = "Alice"
age = 25
message = "My name is %s and I am %d years old." % (name, age)
print(message)  # Output: My name is Alice and I am 25 years old.

# - using str.format()

name = "Bob"
age = 30
message = "My name is {} and I am {} years old.".format(name, age)
print(message)  # Output: My name is Bob and I am 30 years old.

# - using f-strings

name = "Charlie"
age = 35
message = f"My name is {name} and I am {age} years old."
print(message)  # Output: My name is Charlie and I am 35 years old.

# multiline formatting

# - formatting using %

name = "Alice"
age = 25

message = """
Hello,
My name is %s.
I am %d years old.
""" % (name, age)

print(message)

# - formatting using str.format()

name = "Alice"
age = 25

message = """
Hello,
My name is {}.
I am {} years old.
""".format(name, age)

print(message)

# - formatting using f-strings

name = "Alice"
age = 25

message = f"""
Hello,
My name is {name}.
I am {age} years old.
"""

print(message)
