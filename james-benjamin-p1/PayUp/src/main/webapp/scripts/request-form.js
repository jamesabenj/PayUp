requestUrl = 'http://localhost:8080/payUp/requests'

function $(x) {
    return document.getElementById(x);
}

//Set user name value in button
let name = $('user-name')
name.innerHTML = 'J' + 'B'



/*function addRequest() {
    let eventCost = $('cost').value;
    let type = $('event-type').value;
    let format = $('grade-format').value;
    let desc = $('description').value;
    let prov = $('provider').value;
    let date = $('event-date').value;

    let newRequest = {
        cost: eventCost,
        description: desc,
        eventType: type,
        gradeFormat: format,
        provider: prov,
        eventDate: date
    }

    let json = JSON.stringify(newRequest)
    console.log(json)
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(newRequest);

        }
    };

    xhr.open('POST', requestUrl);

    xhr.setRequestHeader('Content-Type', 'application/json')

    xhr.send(json); //xhr.send(JSON.stringify(newAuthor))

}*/

async function addRequest() {

    let request = {
        cost: $('cost').value,
        description: $('description').value,
        eventType: $('event-type').value,
        gradeFormat: $('grade-format').value,
        provider: $('provider').value,
        eventDate: $('event-date').value
    }

    let res = await fetch(requestUrl, {
        method: 'POST',
        body: JSON.stringify(request),
        header: { 'Content-Type' : 'application/json'}
    })
        .then(res => res.json)
        .then(displaySuccessWindow())
        .catch(function () {
            console.log('Error')
        }) 
}

function displaySuccessWindow(){
    let target = $('request-form')
    let newContent = document.createElement('div')
    newContent.innerHTML = "<h3>You're submission was successful!</h3><br>" + "<h4>See 'My Requests' to view and edit request.</h4>"
                        
    target.parentNode.replaceChild(newContent, target)
}






/*function addAttachment() {
    let attach = $('file');

    let newAttachment = {file = attach}

    let json = JSON.stringify(newAttachment)
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let r = this.responseText;
            console.log(r)
        }
    };

    xhr.open('POST', url);

    xhr.setRequestHeader('Content-Type', 'application/json')

    xhr.send(json); //xhr.send(JSON.stringify(newAuthor))    

}*/









