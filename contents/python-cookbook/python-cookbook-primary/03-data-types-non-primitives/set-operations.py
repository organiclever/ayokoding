# creation

from functools import reduce


my_set = {1, 2, 3, 4, 5}

# length

my_set = {1, 2, 3, 4, 5}
length = len(my_set)
print(length)  # Output: 5

# membership

my_set = {1, 2, 3, 4, 5}
result = 3 in my_set
print(result)  # Output: True

# adding elements

my_set = {1, 2, 3}
my_set.add(4)
print(my_set)  # Output: {1, 2, 3, 4}

# removing elements

my_set = {1, 2, 3, 4}
my_set.remove(3)
print(my_set)  # Output: {1, 2, 4}

# set operations

# - union

set1 = {1, 2, 3}
set2 = {3, 4, 5}
union_set = set1.union(set2)
print(union_set)  # Output: {1, 2, 3, 4, 5}

# - intersection

set1 = {1, 2, 3}
set2 = {3, 4, 5}
intersection_set = set1.intersection(set2)
print(intersection_set)  # Output: {3}

# - difference

set1 = {1, 2, 3, 4}
set2 = {3, 4, 5}
difference_set = set1.difference(set2)
print(difference_set)  # Output: {1, 2}

# - symmetric difference

set1 = {1, 2, 3, 4}
set2 = {3, 4, 5}
symmetric_difference_set = set1.symmetric_difference(set2)
print(symmetric_difference_set)  # Output: {1, 2, 5}

# copying

my_set = {1, 2, 3}
copy_set = my_set.copy()
print(copy_set)  # Output: {1, 2, 3}
print(my_set)  # Output: {1, 2, 3}
copy_set.add(10)
print(my_set)  # Output: {1, 2, 3}
print(copy_set)  # Output: {10, 1, 2, 3}

# iteration - using for

my_set = {1, 2, 3, 4, 5}
for item in my_set:  # Output: 1 2 3 4 5
    print(item)

# iteration - using map
my_set = {1, 2, 3, 4, 5}
result = map(lambda x: x * 2, my_set)
print(set(result))  # Output: {2, 4, 6, 8, 10}

# iteration - using reduce

my_set = [1, 2, 3, 4, 5]
result = reduce(lambda x, y: x + y, my_set)
print(result)  # output: 15
