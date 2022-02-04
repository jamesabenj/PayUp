url="http://localhost:8080/payUp/users/"
requestsUrl="http://localhost:8080/payUp/admin/"

function $(x) {
    return document.getElementById(x);
}

let usr = {}

requests = []

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

async function fetchAllRequests() {
    let resp = await fetch(requestsUrl)
    .then(resp => {
        return resp.json()
    })
    .then(data => {
        requests.push(data)
        displayRequests(data)
    })
}
fetchAllRequests()


function displayRequests(requests) {
    let target = $('request-list')

    for(let i = 0; i < requests.length; i++) {
        let requestUser = {}

        let resp = fetch(`http://localhost:8080/payUp/users/${requests[i].author.id}`)
        .then(resp => {
            return resp.json()
        })
        .then(data => {
        requestUser.firstName = data.firstName
        requestUser.lastName = data.lastName
        requestUser.balance = data.balance
        })
        .then(function() {
            let card = document.createElement('div')

        card.setAttribute("id", `${requests[i].id}-id`)

        card.innerHTML = `<div class="card border-secondary mb-3">
        <div class="card-header">$${requests[i].cost} - ${requests[i].description} - ${requests[i].status}</div>
        <div class="card-body text-secondary">
          <button class="btn btn-primary btn-sm" onclick="approve(${requests[i].id})">Approve </button> | <button class="btn btn-warning btn-sm" onclick="deny(${requests[i].id})" style="color: #cc382b;"> Deny</button> | <button class="btn btn-light btn-sm" onlick="custom">Approve w/ Custom Reimbursement</button>
        </div>`;
                
                                
                                              
        
        target.append(card)    
        })               

    }

}

function approve(id) {
    
    if(window.confirm(`Approve this request?`)) {
        let request = {}
        let res = fetch(`http://localhost:8080/payUp/admin/${id}`)
        .then(res =>{
            return res.json()
        })
        .then(data =>{
            let request = {
                id: data.id,
                cost: data.cost,
                description: data.description,
                eventType: data.eventType,
                gradeFormat: data.gradeFormat,
                provider: data.provider,
                eventDate: data.eventDate,
                status: 'APPROVED'
            }
            let resp = fetch("http://localhost:8080/payUp/admin", {
                method: 'PUT',
                body: JSON.stringify(request),
                header: { 'Content-Type' : 'application/json'}
            })

        })
      




            

            
        
        
    }
}