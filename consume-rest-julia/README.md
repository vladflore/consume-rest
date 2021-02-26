# Consuming a Web Service from Julia 

This small project exemplifies how to consume a REST Web Service by using Julia, specifically making a `GET` request to read some data from a publically available REST web service.

The response data is converted to custom composite Julia types.

## Run the code

1. install [Julia](https://julialang.org/downloads/), if it's the case
2. run the `rest.jl` file:
   1. from the command line: `julia rest.jl`
   2. from **inside** julia REPL:

    ```
    > julia

    julia> include("rest.jl")
    getusers (generic function with 1 method)

    julia> users = getusers("https://jsonplaceholder.typicode.com/users")
    ...output omitted...

    julia> exit()
    ```

### Notes
1. running the code by following 2.i. above will not print anything because the `println` line is commented out in the `rest.jl` file
2. the order in which one defines the `struct`s is important, see [Discourse question](https://discourse.julialang.org/t/json-string-to-composite-type/56112)
3. you might need to add the following packages: `HTTP, JSON3, StructTypes`. To do this, go into the Julia REPL, press `]`, type `add HTTP JSON3 StructTypes`, press `backspace`, type `exit()`

The code is licensed under [LICENSE](../LICENSE)
