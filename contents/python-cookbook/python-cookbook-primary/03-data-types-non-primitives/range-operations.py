# creating range

my_range = range(5)
print(my_range)  # Output: range(0, 5)

# converting range to list

my_range = range(5)
print(list(my_range))  # Output: [0, 1, 2, 3, 4]

print("---")

# length of a range

my_range = range(1, 6, 2)
length = len(my_range)
print(list(my_range))
print(length)  # Output: 3

print("---")

# iterating over a range

my_range = range(1, 6)
for num in my_range:
    print(num)  # Output: 1 2 3 4 5

print("---")

# indexing and slicing

my_range = range(1, 6)
print(my_range[2])  # Output: 3
print(my_range[1:4])  # Output: range(2, 5)

print("---")

# checking membership

my_range = range(1, 6)
print(3 in my_range)  # Output: True
print(8 in my_range)  # Output: False
