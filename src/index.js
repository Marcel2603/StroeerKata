const BASE_URL = "http://jsonplaceholder.typicode.com"

function main() {
    let fetch1 = fetch(`${BASE_URL}/users/1`).then(res => res.json());
    let fetch2 = fetch(`${BASE_URL}/posts?userId=1`).then(res => res.json());
    return Promise.all([fetch1, fetch2])
        .then(responses => {
            if ("name" in responses[0]) {
                return {name: responses[0], posts: responses[1]};
            }
            return {name: responses[1], posts: responses[0]};
        });
}

main()
    .then(response => console.log(response));
