requestUrl = 'http://localhost:8080/payUp/requests'
userUrl="http://localhost:8080/payUp/users"

function $(x) {
    return document.getElementById(x);
}

//Set user name value in button
let name = $('user-name')
name.innerHTML = 'J' + 'B'



async function addRequest() {
    if ($('cost').value == 0.00) {
        alert("All fields must be filled out")
    } else if ($('description').value == ""){
        alert("All fields must be filled out")
    } else if ($('provider').value == "") {
        alert("All fields must be filled out")
    } else if (($('event-date')).value == "") {
        alert("All fields must be filled out")
    }else {
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
    
}

function displaySuccessWindow(){
    let target = $('request-form')
    let newContent = document.createElement('div')
    newContent.innerHTML = "<h3>You're submission was successful!</h3><br>" + "<h4>See 'My Requests' to view and edit request.</h4>"
                        
    target.parentNode.replaceChild(newContent, target)
}

function fetchUser() {
    let resp = fetch(userUrl)
    .then(resp => {
        return resp.json()
    })
    .then(data => {
        usr = {}

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









