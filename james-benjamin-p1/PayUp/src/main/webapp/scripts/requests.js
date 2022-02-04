url = "http://localhost:8080/payUp/requests"
userUrl="http://localhost:8080/payUp/users/"

function $(x) {
    return document.getElementById(x);
}

async function fetchAllRequests() {
    let resp = await fetch(url)
    .then(resp => {
        return resp.json()
    })
    .then(data => {
        displayRequests(data)
    })
}

let usr = {}

function displayRequests(requests) {
    let target = $('request-list')
    for(let i = 0; i < requests.length; i++) {
        let card = document.createElement('div')
        card.setAttribute("id", `${requests[i].id}-id`)
        card.innerHTML = `<div class="card border-secondary mb-3">
        <div class="card-header">$${requests[i].cost} - ${requests[i].description} - ${requests[i].status}</div>
        <div class="card-body text-secondary">
          <a href="#" onclick="" style="color: #0d6efd;">Edit </a> | <a href="#" style="color: #cc382b;"> Cancel</a>
        </div>`;
                
                                
                                              
                        
        
        target.append(card)                 

    }

}

function fetchUser() {
    let resp = fetch(userUrl)
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