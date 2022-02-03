function $(x) {
    return document.getElementById(x);
}

const currentUser = sessionStorage.getItem('currentUser')

console.log(currentUser);

// Set available balance value on page
let balance = $('balance');

balance.innerHTML = '$ ' + 'user.balance ';

//Set user name value in button
let name = $('user-name')
name.innerHTML = 'J' + 'B'


