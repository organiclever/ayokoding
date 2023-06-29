module Greet =
    let greet name = printfn "Hello, %s!" name

let the_numbers = 1

Greet.greet (sprintf "%d" the_numbers) // Output: Hello, 1!
