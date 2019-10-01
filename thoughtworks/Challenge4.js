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

    let body = {
        a: 0,
        e: 0,
        i: 0,
        o: 0,
        u: 0
    }
    
    t.text.toLowerCase().split('').forEach(c => {
        switch(c) {
            case 'a': body.a++; break;
            case 'e': body.e++; break;
            case 'i': body.i++; break;
            case 'o': body.o++; break;
            case 'u': body.u++; break;
        }
    })

    let outputUrl = 'https://http-hunt.thoughtworks-labs.net/challenge/output'
    let output = {
        url: outputUrl,
        method: 'POST',
        headers: {
            'userId': 'ho-ghIGjC',
            'content-type': 'application/json'
        },
        json: body
    };

    request(output, (e, r) => {
        console.log(r.body);
    })
});