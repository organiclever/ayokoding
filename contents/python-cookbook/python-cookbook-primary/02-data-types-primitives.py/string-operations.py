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

# formatting using %

name = "Alice"
age = 25
message = "My name is %s and I am %d years old." % (name, age)
print(message)  # Output: My name is Alice and I am 25 years old.
