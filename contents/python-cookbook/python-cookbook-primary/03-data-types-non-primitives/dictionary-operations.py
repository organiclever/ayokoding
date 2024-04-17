# dictionary creation

my_dict = {"name": "John Doe", "age": 25}

# accessing values

my_dict = {'name': 'John', 'age': 25, 'country': 'USA'}
print(my_dict['age'])  # Output: 25

# adding and modifying elements

my_dict = {'name': 'John', 'age': 25}
my_dict['city'] = 'New York'  # Adding a new key-value pair
print(my_dict)  # Output: {'name': 'John', 'age': 25, 'city': 'New York'}

my_dict['age'] = 26  # Modifying an existing value
print(my_dict)  # Output: {'name': 'John', 'age': 26, 'city': 'New York'}

# removing elements

my_dict = {'name': 'John', 'age': 25, 'country': 'USA'}

# - using del

del my_dict['country']  # Removing an item by key using the `del` statement
print(my_dict)  # Output: {'name': 'John', 'age': 25}

# - using pop
removed_value = my_dict.pop('age')
print(my_dict)  # Output: {'name': 'John'}
print(removed_value)  # Output: 25

# dictionary length

my_dict = {'name': 'John', 'age': 25, 'country': 'USA'}
length = len(my_dict)
print(length)  # Output: 3

# membership

my_dict = {'name': 'John', 'age': 25, 'country': 'USA'}
result = 'age' in my_dict
print(result)  # Output: True

# dictionary methods

my_dict = {'name': 'John', 'age': 25, 'country': 'USA'}

# - Retrieving keys as iterable
keys = my_dict.keys()
print(keys)  # Output: dict_keys(['name', 'age', 'country'])

# - Retrieving values as iterable
values = my_dict.values()
print(values)  # Output: dict_values(['John', 25, 'USA'])

# - Retrieving key-value pairs as iterable
items = my_dict.items()
# Output: dict_items([('name', 'John'), ('age', 25), ('country', 'USA')])
print(items)

# iterating through a dictionary

my_dict = {'name': 'John', 'age': 25, 'country': 'USA'}

# - Iterating through keys
for key in my_dict:  # Output: name age country
    print(key)

# - Iterating through values
for value in my_dict.values():  # Output: John 25 USA
    print(value)

# - Iterating through keys and values
for key, value in my_dict.items():  # Output: name John age 25 country USA
    print(key, value)
