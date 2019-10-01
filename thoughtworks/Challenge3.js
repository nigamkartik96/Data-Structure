let a = "One of the consequences of centralised governance is the tendency to standardise on single technology platforms. Experience shows that this approach is constricting - not every problem is a nail and not every solution a hammer. We prefer using the right tool for the job and while monolithic applications can take advantage of different languages to a certain extent, it isn't that common. Splitting the monolith's components out into services we have a choice when building each of them. You want to use Node.js to standup a simple reports page? Go for it. C++ for a particularly gnarly near-real-time component? Fine. You want to swap in a different flavour of database that better suits the read behaviour of one component? We have the technology to rebuild him";
console.log(a.split(/[?.]\s/))


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
            sentenceCount: t.text.split(/[?.]\s/).length
        }
    };

    request(output, (e, r) => {
        console.log(r.body);
    })
}) 