const fetch = require('node-fetch')
const url = 'https://jsonplaceholder.typicode.com/users'

fetch(url)
    .then(response => response.json())
    .then(data => console.log(data))