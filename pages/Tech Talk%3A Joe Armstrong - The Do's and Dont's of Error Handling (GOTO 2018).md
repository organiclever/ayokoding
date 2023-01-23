content-channels:: [[YouTube]]
content-origin:: external
content-status:: wip
content-authors:: [[Joe Armstrong]]
lang:: en
type:: content

- {{video https://www.youtube.com/watch?v=TTM_b7EJg5E}}
- Topics
  - [[Fault Tolerant]]
  - [[Error Handling]]
  - [[Erlang]]
- Related links
  - [Original slide](https://files.gotocon.com/uploads/slides/conference_9/352/original/do_dont_error_handling.pdf)
- Summary
  - A system is fault tolerant if it continues working if something is wrong
  - Things to note
    - Hardware can fail => relatively uncommon
    - Software can fail => common
  - Overview
    - Fault tolerance cannot be achieved using a single computer
      - It might fail
    - We have touse several computers
      - Concurrency
      - Parallel programming
      - Distributed programming
      - Physics
      - Engineering
      - Message passing is inevitable
    - Programming languages should make this ~~easy~~ doable
    - How individual computers work is the smaller problem
    - How the computers are interconnected and the protocols used between the computers is the significant problem.
    - We want the same way to program large and small scale systems
  - Message passing is inevitable
    - #wip
  - What's the big deal about concurrency?
    - #WIP
  - Why concurrent?
    - #WIP
  - Detecting errors
    - #WIP
  - Is that all?
    - #WIP
  - How do we descript contracts?
    - #wip
