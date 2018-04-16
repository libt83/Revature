//1
let name = document.getElementsByName("google");
name[0].setAttribute("href", "https://www.google.com/");
name = document.getElementsByName("twitter");
name[0].setAttribute("href", "https://twitter.com/?lang=en");
name = document.getElementsByName("slack");
name[0].setAttribute("href", "https://slack.com/");
name = document.getElementsByName("javadocs");
name[0].setAttribute("href", "https://javadocs.com/");

//--------------------------------------------------------------------------------------------
//2
var option = document.getElementById("planet").options[3].disabled = true;

//---------------------------------------------------------------------------------------------
//3
function alienText(e) {
    let ptags = document.getElementsByTagName("p");
    let elem;

    for (let i = 0; i < ptags.length; i++) {
        if (ptags[i].innerHTML === "Beep boop") {
            elem = ptags[i];
            break;
        }
    }
    if (e.currentTarget.value !== "Earth") {
        $(elem).removeAttr("hidden");
    } else {
        $(elem).hide();
    }
}

document.getElementById('planet').addEventListener("change", alienText);

//4
document.getElementById("form-sub").addEventListener("click", makeRow);
function makeRow() {


    let fName = document.getElementById("firstname").value;
    let lName = document.getElementById("lastname").value;

    if (lName.length < 2 || fName.length < 2) {
        alert("First and last names must have a minimum of two characters each");
        return;
    }

    // Email validation using regex from 
    let email = document.getElementById("email").value;
    let pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!pattern.test(email)) {
        alert("Invalid email");
        return false;
    }

    // Phone number validation
    let phone = document.getElementById("phone").value;
    pattern = /[0-9]{10}/;
    if (!pattern.test(phone)) {
        alert("Phone number is not in proper format: ##########");
        return;
    }

    let date = document.getElementById("bday");
    // date.setAttribute("required", "true");

    date = date.value;

    let rBtns = document.getElementsByName("gender");
    let checkdBtn = null;
    for (let i = 0; i < rBtns.length; i++) {
        if (rBtns[i].checked) {
            checkdBtn = rBtns[i].value;
            break;
        }
    }

    // Validate that a box is checked
    if (checkdBtn === null) {
        alert("One of the gender options must be selected");
        return;
    }

    let checkdAct = [];
    let activities = document.getElementsByClassName("activity");

    for (let i = 0; i < activities.length; i++) {
        if (activities[i].checked) {
            checkdAct.push(activities[i].value);
        }
    }

    let table = document.getElementsByClassName("table table-striped table-bordered table-hover table-sm");
    let newRow = table[0].insertRow(-1);

    let cell0 = newRow.insertCell(0);
    let cell1 = newRow.insertCell(1);
    let cell2 = newRow.insertCell(2);
    let cell3 = newRow.insertCell(3);
    let cell4 = newRow.insertCell(4);
    let cell5 = newRow.insertCell(5);
    let cell6 = newRow.insertCell(6);

    cell0.innerHTML = fName + " " + lName;
    cell1.innerHTML = email;
    cell2.innerHTML = phone;
    cell3.innerHTML = date;
    cell4.innerHTML = document.getElementById("color").value;
    cell5.innerHTML = checkdBtn;

    let ul = document.createElement("ul");
    // append a child unordered list to a parent cell
    cell6.appendChild(ul);
    // For each activity create a list item and append it to the parent unordered list
    // and create a text node to append to its parent list item
    checkdAct.forEach(function (element) {
        let li = document.createElement("li");
        ul.appendChild(li);
        if (element === "stamp") {
            element += " collecting";
        }
        if (element === "basket") {
            element = "underwater " + element + " weaving";
        }
        let t = document.createTextNode(element);
        li.appendChild(t);
    });
}

//-----------------------------------------------------------------------------------------------
//5
document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
function openDetails(e) {
    let details = document.getElementsByTagName("details")[0];
    if (e)
        details.open = true;
}

document.getElementsByTagName("details")[0].addEventListener("mouseout", closeDetails);
function closeDetails(e) {
    let details = document.getElementsByTagName("details")[0];
    if (e)
        details.open = false;
}

//------------------------------------------------------------------------------------------------
//6
function printAllSpanContent() {
    // Gets all of the span elements
    let spanContent = document.getElementsByTagName("span");
    let str = "";
    // Loop through span elements to concactenate their html text
    for (let i = 0; i < spanContent.length; i++) {
        str += spanContent[i].innerHTML;
    }
    console.log(str);
}
printAllSpanContent();

//---------------------------------------------------------------------------------------------------
//7
document.getElementById("earth_time_check").addEventListener("click", getEarthTime);

// Creates a new span node and appends it to a header4 parent
// moved this outside of function, so repeated clicks wouldn't keep
// adding on to the previously generated time
let h4Elem = document.getElementById("earth_time");
let spanNode = document.createElement("span");
h4Elem.appendChild(spanNode);

function getEarthTime() {
    const time = new Date();
    spanNode.innerText = time;
}

//-------------------------------------------------------------------------------------
//8
document.getElementById("mars_time_check").addEventListener("click", displayMarsTime);
function displayMarsTime() {
    let date = new Date();
    // Get current time in milliseconds  
    let ms = date.getTime();
    // Get Mars time in milliseconds
    let mMS = ms * (365/687);
    let time = date.setTime(mMS);
    document.getElementById("mars_time").innerHTML = date.toString(time);
}

// document.getElementById("acb_time_check").addEventListener("click", getAlphaTimeWithAJAX);
// function getAlphaTimeWithAJAX() {
//     let url = "http://www.astropical.space/astrodb/api-exo.php?which=name&limit=proxima&format=json";
//     let orbPeriod;
//     let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
//     xhr.onreadystatechange = function() {
//         if(this.readyState == 4 && this.status == 200) {
//             let exo = JSON.parse(xhr.responseText);
//             // Get the rotational period from JSON
//             let orbPeriod = exo.exoplanets[0].per;

//             let date = new Date();
//             // Get current time in milliseconds
//             let ms = date.getTime();
//             // Get milliseconds for Alpha Centari
//             let alphaMS = ms * (365 / orbPeriod);
//             let time = date.setTime(alphaMS);
//             document.getElementById("acb_time").innerHTML = date.toString(time);
//         }
//     }
//     xhr.open("GET", url);
//     xhr.send();
// }

document.getElementById("acb_time_check").addEventListener("click", getAlphaTimeWithFetch);
function getAlphaTimeWithFetch() {
    fetch("http://www.astropical.space/astrodb/api-exo.php?which=name&limit=proxima&format=json")
        .then((resp) => resp.json())
        .then(function(data) {
            // Get rotational period from returned JSON
            let orbPeriod = data.exoplanets[0].per;
            let date = new Date();
            // Get current time in milliseconds
            let ms = date.getTime();
            // Get milliseconds for Alpha Centari
            let alphaMS = ms * (365 / orbPeriod);
            let time = date.setTime(alphaMS);
            document.getElementById("acb_time").innerHTML = date.toString(time);
        })
        .catch(e => console.log(e));

}

//-------------------------------------------------------------------------------------
//9
document.getElementsByTagName("h4")[0].addEventListener("click", function () {
    // Delay the background color change by 3 seconds after clicking the header
    setTimeout(changeBGColor, 3000);
});

function changeBGColor() {
    // Get random RGB values
    let red = Math.floor(Math.random() * 256);
    let green = Math.floor(Math.random() * 256);
    let blue = Math.floor(Math.random() * 256);

    // If it's black then get new RGB values
    while (red === 0 & green === 0 & blue === 0) {
        red = Math.floor(Math.random() * 256);
        green = Math.floor(Math.random() * 256);
        blue = Math.floor(Math.random() * 256);
    }
    document.body.style.background = "rgb(" + red + ", " + green + ", " + blue + ")";
}

//-------------------------------------------------------------------------------------
//10
let result = document.getElementById("result");

document.getElementById("operation").addEventListener("change", calculate)
function calculate(e) {
    // Get the max/min allowable numbers for validation checks
    const maxNum = Number.MAX_SAFE_INTEGER;
    const minNum = Number.MIN_SAFE_INTEGER;

    let num1 = document.getElementById("n1").value;
    let num2 = document.getElementById("n2").value;

    // Checks for black text fields
    if (num1.length < 1 | num2.length < 1) {
        alert("ERROR - Cannot leave a field black");
        return;
    }

    // Ensure the values are numbers
    num1 = Number(num1);
    num2 = Number(num2);
    // Make sure numbers are only comprised of digits
    if (!Number.isInteger(num1) | !Number.isInteger(num2)) {
        alert("Invalid input");
        return;
    }

    // Make sure numbers are within acceptable range
    if (num1 > maxNum | num1 < minNum | num2 > maxNum | num2 < minNum) {
        alert("Invalid number - number is outside of the valid range of acceptable input");
        return;
    }

    if (e.currentTarget.value === "Add") {
        result.innerText = num1 + num2;
    } else if (e.currentTarget.value === "Subtract") {
        result.innerText = num1 - num2;
    } else if (e.currentTarget.value === "Multiply") {
        result.innerText = num1 * num2;
    } else {
        // Don't allow for dividing by zero
        if (num2 === 0) {
            alert("ERROR - Cannot divide by zero");
        } else {
            result.innerHTML = num1 / num2;
        }
    }
}
//-----------------------------------------------------------------------------------------------------
//11
function traverseTheDOM(node, fun) {
    // If the node is an element then console log element
    // and get its first child
    if (node.nodeType == 1) {
        fun(node);
        // Gets the node's first child in the DOM tree
        node = node.firstChild;
        // Keeps traversing down the DOM tree until a node is null (no children) then
        // it moves back up the call stack to the previous node to see if it has another child
        // then it repeats the process until all the nodes in the call stack have been traversed
        // to a childless node
        while (node) {
            traverseTheDOM(node, fun);
            node = node.nextSibling;
        }
    }
}

// Get the root node
let root = document.documentElement;
traverseTheDOM(root, function (node) {
    console.log(node);
});