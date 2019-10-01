const request = require('request');

let inputUrl = 'https://http-hunt.thoughtworks-labs.net/challenge/input';
let input = {
    url: inputUrl,
    method: 'GET',
    headers: {
        userId: 'ho-ghIGjC'
    }
};

request(input, (error, response) => {
    let t = JSON.parse(response.body);
    console.log(t.text);

    let outputUrl = 'https://http-hunt.thoughtworks-labs.net/challenge/output'
    let output = {
        url: outputUrl,
        method: 'POST',
        headers: {
            'userId': 'ho-ghIGjC',
            'content-type': 'application/json'
        },
        json: {
            wordCount: t.text.split(/\s/).length
        }
    };

    request(output, (e, r) => {
        console.log(r.body);
    })
})