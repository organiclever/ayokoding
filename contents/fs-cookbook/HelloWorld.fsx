open System

let main() =
    let now = DateTime.Now

    printfn "Current time is %s" (now.ToString("yyyy-MM-dd HH:mm:ss"))

let test = 1

main()