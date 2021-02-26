using HTTP, JSON3, StructTypes

# The order in which you define the structs matters!

struct Geo
  lat::String
  lng::String
end

struct Address
    street::String
    suite::String
    city::String
    zipcode::String
    geo::Geo
end

struct Company
    name::String
    catchPhrase::String
    bs::String
end

struct User 
  id::Int
  name::String
  username::String
  email::String
  address::Address
  phone::String
  website::String
  company::Company
end

StructTypes.StructType(::Type{Geo}) = StructTypes.Struct()
StructTypes.StructType(::Type{Address}) = StructTypes.Struct()
StructTypes.StructType(::Type{Company}) = StructTypes.Struct()
StructTypes.StructType(::Type{User}) = StructTypes.Struct()

function getusers(url)
    response = HTTP.request("GET", url)
    return JSON3.read(String(response.body), Array{User})
end

# println(getusers("https://jsonplaceholder.typicode.com/users"))
