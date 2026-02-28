console.log("js loaded");

const startBtn = document.getElementById("startButton");
const pauseBtn = document.getElementById("pauseButton");
const resetBtn = document.getElementById("resetButton");

const minutesEl = document.getElementById("minutes");
const secondsEl = document.getElementById("seconds");

const setTimerButton = document.getElementById("setTimerButton");
const setTimerInput = document.getElementById("setTimerInput");

const sessionCounterEl = document.getElementById("sessionCounter");


let timerState = false;
let timerResetTime = 25;
let totalSeconds = timerResetTime * 60;
let timerInterval = null;
let isStarted = false;
let sessionCount = 0;

startBtn.addEventListener("click", handleStartButtonClick);
pauseBtn.addEventListener("click", handlePauseButton);
resetBtn.addEventListener("click", handleResetButton);
setTimerButton.addEventListener("click", handleSetTimerButton);

function startTimer() {
    timerState = true;

    timerInterval = setInterval(() => {
        if (totalSeconds <= 0) {
            clearInterval(timerInterval);
            timerState = false;
            pauseBtn.innerText = "PAUSE";
            sessionCount++;
            sessionCounterEl.innerText = sessionCount;
            return;
        }

        totalSeconds--;
        updateTimerUI();
    }, 1000);
}

function handleStartButtonClick() {
    console.log("start button got clicked");

    if (isStarted) {
        console.log("Start button disabled after first use");
        return;
    }

    isStarted = true;
    pauseBtn.innerText = "PAUSE";
    startTimer();
}

function handlePauseButton() {
    console.log("pause/resume button got clicked");

    if (!isStarted) return;

    if (timerState === true) {
        // Pause
        clearInterval(timerInterval);
        timerState = false;
        pauseBtn.innerText = "RESUME";
    } else {
        // Resume
        pauseBtn.innerText = "PAUSE";
        startTimer();
    }
}

function handleResetButton() {
    console.log("Reset button got clicked");

    clearInterval(timerInterval);
    timerState = false;
    isStarted = false;

    totalSeconds = timerResetTime * 60;
    pauseBtn.innerText = "PAUSE";
    updateTimerUI();
}

function handleSetTimerButton() {
    console.log("set timer button clicked");

    const newtime = parseInt(setTimerInput.value);

    if (isNaN(newtime) || newtime <= 0 || newtime >=61) {
        alert("Please enter a valid number of minutes");
        return;
    }

    timerResetTime = newtime;
    totalSeconds = newtime * 60;
    updateTimerUI();

    setTimerInput.value = "";
}


function updateTimerUI() {
    const mins = Math.floor(totalSeconds / 60);
    const secs = totalSeconds % 60;

    minutesEl.innerText = String(mins).padStart(2, "0");
    secondsEl.innerText = String(secs).padStart(2, "0");
}
