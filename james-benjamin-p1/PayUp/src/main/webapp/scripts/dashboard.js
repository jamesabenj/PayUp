url="http://localhost:8080/payUp/users/"
requestsUrl="http://localhost:8080/payUp/requests"

function $(x) {
    return document.getElementById(x);
}

let usr = {}

let requests = []


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
            let bal = $('balance')
            bal.innerHTML = '$ ' + `${usr.balance}`
            let name = $('user-name')
            name.innerHTML = `${usr.firstName.charAt(0)}` + `${usr.lastName.charAt(0)}`
        })
}    

function fetchRequests() {
    let resp = fetch(requestsUrl)
    .then(resp => {
        return resp.json()
    })
    .then(data => {
        if (data != null) {
            for(let i = 0; i < data.length; i++) {
                console.log(data[i])
                requests.push(data[i])
            }
        }
    })
    .then(function() {
        /* for (let req of requests) {
            console.log(req)
            let target = $('pending-requests')
            if(req.status == 'PENDING') {
                console.log('inside if')
                let card = document.createElement('div')
                card.setAttribute("class", "accordion shadow-sm")
                card.setAttribute("id", `${req.id}`)
                card.innerHTML = `<div class="accordion-item"></div>` + 
                            `<h2 class="accordion-header">` + `<button class='accordion-button' type='button' data-bs-toggle='collapse' data-bs-target='${req.id}'>$${req.cost} - ${req.description} - <div style="color: orange;">${req.status}</div></button></h2><br>`
                let child = $('requests-placeholder')
                target.replaceChild(card, child)
            }
        } */
        
    })
} 
fetchRequests()



/* // Set available balance value on page
window.addEventListener('DOMContentLoaded', (event) => {
    let bal = $('balance');
    bal.innerHTML = '$ ' + `${usr.balance}`;
    
    //Set user name value in button
    let name = $('user-name')
    name.innerHTML = `${usr.firstName.charAt(0)}` + `${usr.lastName.charAt(0)}`
})
 */

