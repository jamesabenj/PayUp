url = "http://localhost:8080/payUp/requests"

function $(x) {
    return document.getElementById(x);
}

async function fetchAllRequests() {
    let resp = await fetch(url)
    .then(resp => {
        return resp.json()
    })
    .then(data => {
        console.log(data)
        displayRequests(data)
    })
}

function displayRequests(requests) {
    let target = $('request-list')
    for(let i = 0; i < requests.length; i++) {
        let card = document.createElement('div')
        card.setAttribute("class", "accordion shadow-sm")
        card.setAttribute("id", `${requests[i].id}`)
        card.innerHTML = `<div class="accordion-item"></div>` + 
                            `<h2 class="accordion-header">` + `<button class='accordion-button' type='button' data-bs-toggle='collapse' data-bs-target='${requests[i].id}'>$${requests[i].cost} - ${requests[i].description} <span styl="align:end;">${requests[i].status}</span></button></h2>`
                            /*"<h2 class='accordion-header' id='heading`${req.id}`'>" + 
                            "<button class='accordion-button' type='button' data-bs-toggle='collapse' data-bs-target='#collapse-`${req.id}`'>`${req.description}</button></h2>`" +
                            "<div id='collapse-`${req.id}`' class='accordion-collapse collapse' data-bs-parent='#`${req.id}`'>" +
                                "<div class='accordion-body'> `${req.cost}` </div> " +
                            "</div>" +
                          "</div>"; */
        
        target.append(card)                 

    }

}

/* async function addAuthor() {

    let author = {
        firstName: document.getElementById('#').value,
        lastName: document.getElementById('#').value
    }

    let res = await fetch(url, {
        method: postMessage,
        body: JSON.stringify(author),
        header: { 'Content-Type': 'application/json'}
    })

    let resJSON = await res.json()
        .then((resp) => {
            console.log(resp)
        })
        .catch((error) => {
            console.log(error)
        });


} */