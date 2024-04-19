import re

# introduction

match = re.search(r"apple", "I have an apple")
if match:  # Output: Match found
    print("Match found")
else:
    print("No match")

print("---")

# the re module

match = re.search(r"banana", "I love bananas")
if match:  # Output: Match found
    print("Match found")
else:
    print("No match")

print("---")

# pattern matching

match = re.search(r"[0-9]+", "The meeting is at 9:30 AM")
if match:  # Output: Match found: 9
    print("Match found:", match.group())
else:
    print("No match")

print("---")

# regex methods

pattern = r"apple"
text = "I have an apple, red apple and an orange"

matches = re.findall(pattern, text)
print(matches)  # Output: ['apple', 'apple']

match_iter = re.finditer(pattern, text)
for match in match_iter:  # Output: Match found: apple Match found: apple
    print("Match found:", match.group())

print("---")

# anchors and boundaries

patterns = r"^apple$"
texts = ["apple", "apple pie"]

for text in texts:  # Output: Match found No match
    match = re.search(patterns, text)
    if match:
        print("Match found")
    else:
        print("No match")

print("---")

# character classes

pattern = r"[A-Za-z]+"
text = "Hello, World!"

matches = re.findall(pattern, text)
print(matches)  # Output: ['Hello', 'World']

print("---")

# quantifiers and greedy behavior

pattern = r"a[bcd]*b"
text = "abbcbdbbdc"

matches = re.findall(pattern, text)
print(matches)  # Output: ['abbcbdbb']


print("---")

# grouping and capturing


pattern = r"(apple|banana)+"
text = "I like apples and bananas"

matches = re.findall(pattern, text)
print(matches)  # Output: ['apple', 'banana']


print("---")

# lookahead and lookbehind


pattern = r"\d+(?= dollars)"
text = "I have 100 dollars"

match = re.search(pattern, text)
if match:  # Output: Match found: 100
    print("Match found:", match.group())
else:
    print("No match")

print("---")

# flags for regex


pattern = r"hello"
text = "Hello, World!"

match = re.search(pattern, text, re.IGNORECASE)
if match:  # Output: Match found: Hello
    print("Match found:", match.group())
else:
    print("No match")


print("---")

# other examples


text = "I am 25 years old. My email is abc@example.com"

age_pattern = r"\d+"
email_pattern = r"\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}\b"

ages = re.findall(age_pattern, text)
emails = re.findall(email_pattern, text)

print("Ages:", ages)  # Output: Ages: ['25']
print("Emails:", emails)  # Output: Emails: ['abc@example.com']

print("---")
