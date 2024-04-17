# list creation

my_list = [1, 2, 3, 4, 5]

# indexing

my_list = [1, 2, 3, 4, 5]
print(my_list[0])  # Output: 1

# slicing

my_list = [1, 2, 3, 4, 5]
print(my_list[1:4])  # Output: [2, 3, 4]

# concatenation

list1 = [1, 2, 3]
list2 = [4, 5, 6]
result = list1 + list2
print(result)  # Output: [1, 2, 3, 4, 5, 6]

# repetition

my_list = [1, 2, 3]
result = my_list * 3
print(result)  # Output: [1, 2, 3, 1, 2, 3, 1, 2, 3]

# length

my_list = [1, 2, 3, 4, 5]
length = len(my_list)
print(length)  # Output: 5

# membership

my_list = [1, 2, 3, 4, 5]
result = 3 in my_list
print(result)  # Output: True

# mutability

my_list = [1, 2, 3, 4, 5]
my_list[0] = 10
print(my_list)  # Output: [10, 2, 3, 4, 5]

# appending

my_list = [1, 2, 3]
my_list.append(4)
print(my_list)  # Output: [1, 2, 3, 4]

# extending

list1 = [1, 2, 3]
list2 = [4, 5, 6]
list1.extend(list2)
print(list1)  # Output: [1, 2, 3, 4, 5, 6]

# insertion

my_list = [1, 3, 4, 5]
my_list.insert(1, 2)
print(my_list)  # Output: [1, 2, 3, 4, 5]

# removal

my_list = [1, 2, 3, 4, 5]
my_list.remove(3)
print(my_list)  # Output: [1, 2, 4, 5]

# pop

my_list = [1, 2, 3, 4, 5]
popped_value = my_list.pop()
print(popped_value)  # Output: 5

# sorting

my_list = [3, 1, 4, 2, 5]
my_list.sort()
print(my_list)  # Output: [1, 2, 3, 4, 5]

# reversing

my_list = [1, 2, 3, 4, 5]
my_list.reverse()
print(my_list)  # Output: [5, 4, 3, 2, 1]

# copying

my_list = [1, 2, 3]
copy_list = my_list.copy()
print(copy_list)  # Output: [1, 2, 3]
