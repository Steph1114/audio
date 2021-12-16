//Declaration of all variables
//song details
let photoAlbum = document.querySelector(".song-album-photo");
let songName = document.querySelector(".song-name");
let artistName = document.querySelector(".song-artist");
let albumName = document.querySelector(".album-name");

//volume
let volume_slider = document.querySelector(".volume-slider");

//timer
let current_time = document.querySelector(".current-time");
let duration_slider = document.querySelector(".duration-slider");
let total_duration = document.querySelector(".total-duration");

//buttons
let playpause_btn = document.querySelector(".playpause-btn");
let prev_btn = document.querySelector(".preview-btn");
let next_btn = document.querySelector(".forward-btn");
let stop_btn = document.querySelector(".stop-btn")

//first song
let song_index = 0;
let isPlaying = false;

let updateTimer;

//Audio object
let current_song = document.createElement("audio");

//table of all songs
let song_list = [{
        name: "Miss Independent",
        artist: "Ne-Yo",
        album: "Year of The Gentleman",
        img: "images/neyo_album.jpeg",
        duration: "4:37",
        source: "audios/Ne-Yo - Miss Independent.mp3"
    },
    {
        name: "See you on the other side",
        artist: "Ozzy Osbourne",
        album: "Ozzmosis",
        img: "images/ozzy_album.jpg",
        duration: "3:58",
        source: "audios/Ozzy OSBOURNE - See you on the other side.mp3"
    },
    {
        name: "Mixed Signals",
        artist: "Ruth B.",
        album: "Safe Haven",
        img: "images/ruth_album.jpg",
        duration: "4:16",
        source: "audios/Ruth B. - Mixed Signals.mp3"
    },
    {
        name: "Breakeven",
        artist: "The script",
        album: "The Script",
        img: "images/thescript.jpg",
        duration: "4:16",
        source: "audios/The Script - Breakeven.mp3"
    },
    {
        name: "Everything Black",
        artist: "Unlike Pluto",
        album: "Everything Black",
        img: "images/unlike.jpg",
        duration: "3:49",
        source: "audios/Unlike Pluto - Everything Black.mp3"
    },
    {
        name: "Angels cry",
        artist: "Mariah carey",
        album: "Memoirs of an imperfect",
        img: "images/carey.jpg",
        duration: "4:05",
        source: "audios/Mariah Carey - Angels Cry (Official Music Video) ft. Ne-Yo.mp3"
    }

]

//trigger events when buttons being clicked on
playpause_btn.addEventListener("click", (e) => {
    playpauseSong();
})

next_btn.addEventListener("click", (e) => {
    nextSong();
})

prev_btn.addEventListener("click", (e) => {
    previousSong();
})

stop_btn.addEventListener("click", (e) => {
    stopSong();
})

//trigger events on changing range sliders
volume_slider.addEventListener("change", (e) => {
    setVolume();
})

duration_slider.addEventListener("change", (e) => {
    slideTo();
})



//Load the song
function loadMusic(song_index) {
    //clear previous timer
    clearInterval(updateTimer);
    resetValues();
    for (let index = 0; index < song_list.length; index++) {
        let element = song_list[index];
        if (element.source == song_index) {
            current_song.src = element.source;
            current_song.load();

            photoAlbum.style.backgroundImage = "url(" + element.img + ")";

            songName.textContent = element.name;
            artistName.textContent = element.artist;
            albumName.textContent = element.album;
        }
    }

    updateTimer = setInterval(update, 1000);
    //get to next song at the end of current song without triggering button
    current_song.addEventListener("ended", nextSong);
}

function resetValues() {
    current_time.textContent = "00:00";
    total_duration.textContent = "00:00";
    duration_slider.value = 0;
}

// load the first in the playlist on the playing screen
loadMusic(song_list[song_index].source);


function playpauseSong() {
    //switch between playing and pausing
    if (!isPlaying) playSong();
    else pauseSong();
}

//display pause button when a music is being played
function playSong() {
    //play what's loaded
    current_song.play();

    isPlaying = true;
    playpause_btn.innerHTML = '<i class="fas fa-pause fa-2x"></i>';
}

//display play button when a music is being paused
function pauseSong() {
    current_song.pause();
    isPlaying = false;
    playpause_btn.innerHTML = '<i class="fas fa-play fa-2x"></i>';
}

//next
function nextSong() {

    //Target the index of current song when playlist is called
    let currentSongIndex = null;
    for (let index = 0; index < song_list.length; index++) {
        let element = song_list[index];

        if (element.source == current_song.getAttribute("src")) {
            currentSongIndex = index;
        }
    }

    if (currentSongIndex < song_list.length - 1) {
        currentSongIndex++;

    } else {
        currentSongIndex = 0;
    }

    loadMusic(song_list[currentSongIndex].source);
    playSong();
}

//previous
function previousSong() {

    let currentSongIndex = null;
    for (let index = 0; index < song_list.length; index++) {
        let element = song_list[index];

        if (element.source == current_song.getAttribute("src")) {
            currentSongIndex = index;
        }
    }
    if (currentSongIndex > 0) {
        currentSongIndex -= 1;

    } else {
        currentSongIndex = song_list.length - 1;

    }
    loadMusic(song_list[currentSongIndex].source);
    playSong();
}

//stop
function stopSong() {
    pauseSong();
    current_song.currentTime = 0;
}

//volume
function setVolume() {
    //To trigger wave when volume range slider is over 30%
    if (volume_slider.value > 30) {
        wave();
    }
    current_song.volume = volume_slider.value / 100;
}


//calculate position by the percentage of the slideto slider and get the duration of the song
function slideTo() {
    let slideto = current_song.duration * (duration_slider.value / 100);
    current_song.currentTime = slideto;
}

function update() {
    let getToPosition = 0;

    //check if the duration of current song is a number
    if (!isNaN(current_song.duration)) {
        getToPosition = current_song.currentTime * (100 / current_song.duration);

        duration_slider.value = getToPosition;

        //assess the time left and total_duration
        let currentMinutes = Math.floor(current_song.currentTime / 60);
        let currentSeconds = Math.floor(current_song.currentTime - currentMinutes * 60);
        let durationMinutes = Math.floor(current_song.duration / 60);
        let durationSeconds = Math.floor(current_song.duration - durationMinutes * 60);

        //write time properly
        if (currentSeconds < 10) { currentSeconds = "0" + currentSeconds; }
        if (durationSeconds < 10) { durationSeconds = "0" + durationSeconds; }
        if (currentMinutes < 10) { currentMinutes = "0" + currentMinutes; }
        if (durationMinutes < 10) { durationMinutes = "0" + durationMinutes; }

        //showcase
        current_time.textContent = currentMinutes + ":" + currentSeconds;
        total_duration.textContent = durationMinutes + ":" + durationSeconds;
    }

}

//Creation of playlist
function playlist() {

    for (var i = 0; i < song_list.length; i++) {
        let newDiv = document.createElement("div");
        let ulTag = document.querySelector("ul");
        let list = document.createElement("li");

        newDiv.setAttribute("class", "newDiv")
        list.setAttribute("class", "title");

        //Give it an id to better target it
        list.setAttribute("data-id", song_list[i].source);

        let p = document.createElement("p");
        p.setAttribute("class", "singer");

        let spanTag = document.createElement("span");
        spanTag.setAttribute("class", "length");


        list.textContent = song_list[i].name;
        p.textContent = song_list[i].artist;
        spanTag.textContent = song_list[i].duration;


        ulTag.appendChild(newDiv);
        newDiv.appendChild(list);
        list.appendChild(p);
        newDiv.appendChild(spanTag);

        list.addEventListener("click", (el) => {
            el.preventDefault();
            console.log(el.target.dataset.id);

            //load the song being targeted
            loadMusic(el.target.dataset.id);
            playSong();

        })
    }

}
playlist();

//Wave is only triggered when volume value is changed to certain point
function wave() {
    //Creation of audio context
    let context = new AudioContext();

    //Creation of audio context to monitore / analyse
    let src = context.createMediaElementSource(current_song);

    //Creation of analyser
    let analyser = context.createAnalyser();
    let canvas = document.getElementById("canvas");

    //set size in accordance with windows
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    //creation of canvas context
    let ctx = canvas.getContext("2d");
    src.connect(analyser);
    analyser.connect(context.destination);
    analyser.fftSize = 256;
    let bufferLength = analyser.frequencyBinCount;


    let dataArray = new Uint8Array(bufferLength);
    let WIDTH = canvas.width;
    let HEIGHT = canvas.height;
    let barWidth = (WIDTH / bufferLength) * 2.5;
    let barHeight;
    let x = 0;

    function renderFrame() {
        requestAnimationFrame(renderFrame);
        x = 0;
        analyser.getByteFrequencyData(dataArray);
        ctx.fillStyle = "#ddd3f6";
        ctx.fillRect(0, 0, WIDTH, HEIGHT);
        for (let i = 0; i < bufferLength; i++) {
            barHeight = dataArray[i] * 2;

            let r = barHeight + (15 * (i / bufferLength)); //25
            let g = 132 * (i / bufferLength); //250
            let b = 190; //128

            ctx.fillStyle = "rgb(" + r + "," + g + "," + b + ")";
            ctx.fillRect(x, HEIGHT - barHeight, barWidth, barHeight);

            x += barWidth + 1;
        }
    }
    renderFrame();
};