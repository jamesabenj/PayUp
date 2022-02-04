url="http://localhost:8080/payUp/users/"

function $(x) {
    return document.getElementById(x);
}

let usr = {}

function fetchUser() {
        let resp = fetch(url)
        .then(resp => {
            return resp.json()
        })
        .then(data => {
            usr.balance = data.balance
            usr.firstName = data.firstName
            usr.lastName = data.lastName
        })
        .then(function() {
            let name = $('user-name')
            name.innerHTML = `${usr.firstName.charAt(0)}` + `${usr.lastName.charAt(0)}`
        })
}  
fetchUser()