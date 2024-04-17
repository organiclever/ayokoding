import copy
from functools import reduce

my_tuple = (1, 2, 3, 4, 5)

# indexing

print(my_tuple[0])  # Output: 1

# slicing

print(my_tuple[1:4])  # Output: (2, 3, 4)

# concatenation

tuple1 = (1, 2, 3)
tuple2 = (4, 5, 6)
result = tuple1 + tuple2
print(result)  # Output: (1, 2, 3, 4, 5, 6)

# repetition

result = my_tuple * 3
print(result)  # Output: (1, 2, 3, 1, 2, 3, 1, 2, 3)

# length

length = len(my_tuple)
print(length)  # Output: 5

# membership

result = 3 in my_tuple
print(result)  # Output: True

# iteration - using for

my_tuple = (1, 2, 3, 4, 5)
for item in my_tuple:  # Output: 1 2 3 4 5
    print(item)

# iteration - using map

my_tuple = (1, 2, 3, 4, 5)
result = map(lambda x: x * 2, my_tuple)
print(tuple(result))  # Output: (2, 4, 6, 8, 10)

# iteration - using reduce

my_tuple = (1, 2, 3, 4, 5)
result = reduce(lambda x, y: x + y, my_tuple)
print(result)  # Output: 15
