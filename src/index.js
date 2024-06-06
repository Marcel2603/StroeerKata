#!/usr/bin/env node

const BASE_URL = "http://jsonplaceholder.typicode.com";
const USER_ID = 1;

function main() {
  let fetch1 = fetch(`${BASE_URL}/users/${USER_ID}`).then((res) => res.json());
  let fetch2 = fetch(`${BASE_URL}/posts?userId=${USER_ID}`).then((res) =>
    res.json(),
  );
  return Promise.all([fetch1, fetch2]).then((responses) => {
    if (Array.isArray(responses[0])) {
      return { user: responses[1], comments: responses[0] };
    } else {
      return { user: responses[0], comments: responses[1] };
    }
  });
}

main().then((response) => console.log(JSON.stringify(response)));
