let origin = window.location.origin;
window.onload = async function () {
    let index = 0;
    const url = `${origin}/songs`;
    const configObj = {
        method: "get"
    }

    const response = await fetch(url, configObj);
    const data = await response.json();
    // console.log(data);
    displayData(data);

    const button = document.querySelector("button");
    button.onclick = addSong;
}

// This function displays data
function displayData(data) {

    const table = document.querySelector("#songs");
    table.innerHTML = `
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Artist</th>
            <th>Year</th>
            <th>Explicit</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    `;
    for (let i = 0; i < data.length; i++) {
        const song = data[i];
        table.innerHTML += addSongRow(i, song);
        saveIndex(i);
    }
}

// This function saves the index of the last row
function saveIndex(i) {
    index = i;
}

// This function gets the index of the last row
function getIndex() {
    return index;
}

// Function to add new song from form
async function addSong(event) {

    event.preventDefault();

    const newSong = {
        title: document.querySelector("#title").value,
        artist: document.querySelector("#artist").value,
        year: document.querySelector("#year").value,
        explicit: document.querySelector("#explicit").checked
    }

    let url = `${origin}/songs`;
    let configObj = {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newSong)
    }

    await fetch(url, configObj);
    // console.log(response);

    url = `${origin}/songs`;
    configObj = {
        method: "get",
    }

    const response = await fetch(url, configObj);
    let data = await response.json();

    displayData(data);
}

// Function to save song once edited
async function saveSong(event, i) {
    event.preventDefault();

    const newSong = {
        title: document.querySelector(".title").value,
        artist: document.querySelector(".artist").value,
        year: document.querySelector(".year").value,
        explicit: document.querySelector(".explicit").checked
    }

    let url = `${origin}/songs/`+i;
    let configObj = {
        method: "put",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newSong)
    }

    await fetch(url, configObj);

    url = `${origin}/songs`;
    configObj = {
        method: "get",
    }

    let response = await fetch(url, configObj);
    let data = await response.json();

    displayData(data);
}

// Function to edit a song and create song edit menu
function editSong(event, i) {
    const row = document.querySelector("#song" + i);
    const editMenu = `
        <form>
            <tr class="song" id="song${i}">
                <td>${i}</td>
                <td><input type="text" class="title" name="title"></td>
                <td><input type="text" class="artist" name="artist"></td>
                <td><input type="number" class="year" name="year"></td>
                <td><input type="checkbox" class="explicit" name="explicit"></td>
                <td><button type="submit" onclick="saveSong(event, ${i})">Save</button></td>
                <td></td>
            </tr>
        </form>
    `;
    row.innerHTML = editMenu;
}

// Function to delete a song
async function deleteSong(event, i) {
    let url = `${origin}/songs/`+i; //
    let config = {
        method: 'delete'
    }
    await fetch(url, config);

    url = `${origin}/songs`; //
    configObj = {
        method: 'get'
    }

    let response = await fetch(url, configObj);
    let data = await response.json();

    displayData(data);
}

// Function to add new song row
function addSongRow(i, song) {
    return `
        <tr class="song" id="song${i}">
            <td>${i}</td>
            <td>${song.title}</td>
            <td>${song.artist}</td>
            <td>${song.year}</td>
            <td>${song.explicit}</td>
            <td><a href="#" onclick="editSong(event, ${i})" class="edit">Edit</a></td>
            <td><a href="#" onclick="deleteSong(event, ${i})" class="delete">Delete</a></td>
        </tr>
    `;
}