- YAML Ain't Markup Language
- Resources
  - [Official website](https://yaml.org/)
  - [YAML Spec version 1.2](https://yaml.org/spec/1.2.2/)
- Most elements in YAML are based on key-value pairs.
  - `key: value` syntax.
- YAML is case-sensitive
- Indentation in YAML is used to signify structure.
  - Items with the same indentation -> same level
  - Tree-structure (Parent-Child)
  - Created using spaces and not tabs.
- Comments
  - Using `#`
- Scalars
  - Defined by
    - integers
    - floats
    - strings
    - Booleans
  - Example
    - From [[Book: Priscilia Heller - Automating Workflows with GitHub Actions]]
      - ```yaml
        integer: 10

        #different ways to write booleans

        boolean: true

        another-boolean: yes

        yet-another-boolean: off

        a key with spaces: a value with spaces

        #different ways to write strings

        string-with-quotes: 'a string with quotes'

        string-without-quotes: a string with quotes

        new-lines-are-kept-as-new-lines: |

          This is line number 1, and it will show exactly this way

          This is line number 2, and it will show exactly this way

          This is line number 3… you get it

        multi-lines-here-that-will-render-as-one-line: >

          When you want a block of text made of many lines

          To show all in one single line

          You can use the special character greater than
        ```
- Sequences
  - Example
    - From [[Book: Priscilia Heller - Automating Workflows with GitHub Actions]]
      - ```yaml
        runs-on: ubuntu-latest
        steps:
          - name: Close Issue
        ```
