const rows = 20;
const cols = 10;

let boardEl = null;
let pauseBtn, resetBtn;
let score = 0;
let isPlaying = false;
let gameTimer = null;
let speed = 750;
let current = null;
let block = [];
let level = 0;
let linesCleared = 0;

const tetris = [
    [[0,0],[0,1],[0,2],[0,3]], // I
    [[0,0],[0,1],[1,0],[1,1]], // O
    [[0,1],[1,0],[1,1],[1,2]], // T
    [[0,2],[1,0],[1,1],[1,2]], // L
    [[0,0],[1,0],[1,1],[1,2]], // J
    [[0,1],[0,2],[1,0],[1,1]], // S
    [[0,0],[0,1],[1,1],[1,2]]  // Z
];


function createEl(tag, text, opts) {
    const el = document.createElement(tag);
    if (text) el.textContent = text;
    if (opts) Object.assign(el, opts);
    return el;
}
function cellId(r, c) { return `cell-${r}-${c}`; }


function buildUI() {
    const container = document.getElementById('game-container');
    const left = document.createElement('div');
    left.id = 'left-panel';

    pauseBtn = createEl('button', 'Pause', {id: 'pause-btn', className: 'button'});
    resetBtn = createEl('button', 'Reset', {id: 'reset-btn', className: 'button'});
    left.appendChild(pauseBtn);
    left.appendChild(resetBtn);

    const scoreBox = createEl('div', '', {id: 'scoreBox'}); 
    scoreBox.innerHTML = '<h3>Score</h3><div id="score">0</div><div id="levelBox">Level: 0</div>';
    left.appendChild(scoreBox);

    const guide = createEl('div', '', {id: 'guide'});
    guide.innerHTML = '<h4>Guide</h4><p>← → Move</p><p>↓ Drop</p><p>↑ Rotate</p><p>Space: Drop to bottom</p>';
    left.appendChild(guide);

    container.insertBefore(left, document.getElementById('board'));

    const right = document.createElement('div');
    right.id = 'right-panel';
    right.innerHTML = '<h3>Top Scores</h3><div id="topScores"></div>';
    container.appendChild(right);
}


function buildBoard() {
    boardEl = document.getElementById('board');
    boardEl.innerHTML = '';
    for (let r = 0; r < rows; r++) {
        const tr = document.createElement('tr');
        for (let c = 0; c < cols; c++) {
            const td = document.createElement('td');
            td.id = cellId(r, c);
            tr.appendChild(td);
        }
        boardEl.appendChild(tr);
    }
}


function drawBlock() {
    for(const [r,c] of block) {
        const td = document.getElementById(cellId(r,c));
        if(td) td.style.background='#28ff81';
    }
}
function clearBoardDraw() {
    for(let r=0; r<rows; r++) {
        for(let c=0; c<cols; c++) {
            const td=document.getElementById(cellId(r,c));
            if(td) td.style.background='#000';
        }
    }
}
function drawCurrent() {
    if(!current) return;
    for(const [r,c] of current.coords){
        const td = document.getElementById(cellId(r,c));
        if(td) td.style.background = '#ff7171';
    }
}
function render() {
    clearBoardDraw();
    drawBlock();
    drawCurrent();
    document.getElementById('score').textContent = score;
    document.getElementById('levelBox').textContent = `Level: ${level}`;
}


function inBounds(r,c) { return r>=0 && r<rows && c>=0 && c<cols; }
function occupied(r,c) { return block.some(p => p[0]==r && p[1]==c); }

function canPlace(coords, dr=0, dc=0) {
    for (const [r,c] of coords) {
        const nr = r+dr, nc = c+dc;
        if (!inBounds(nr,nc)) return false;
        if (occupied(nr,nc)) return false;
    }
    return true;
}

function spawn() {
    const idx = Math.floor(Math.random()*tetris.length);
    const shape = tetris[idx];
    const offsetR = 0;
    const shapeCols = Math.max(...shape.map(([r,c]) => c)) + 1;
    const offsetC = Math.floor(Math.random() * (cols - shapeCols + 1));
    const coords = shape.map(([r,c]) => [r + offsetR, c + offsetC]);
    current = {coords};
    if(!canPlace(current.coords)) endGame();
}

function moveDown() {
    if (!current) return;
    if (canPlace(current.coords,1,0)) {
        current.coords = current.coords.map(([r,c])=>[r+1,c]);
    } else {
        block.push(...current.coords);
        clearLines();
        spawn();
    }
    render();
}
function moveLeft() {
    if(current && canPlace(current.coords,0,-1)) {
        current.coords = current.coords.map(([r,c])=>[r,c-1]);
        render();
    }
}
function moveRight() {
    if(current && canPlace(current.coords,0,1)) {
        current.coords = current.coords.map(([r,c])=>[r,c+1]);
        render();
    }
}
function dropToBottom() {
    if(!current) return;
    while (canPlace(current.coords,1,0)) {
       current.coords = current.coords.map(([r,c]) => [r+1,c]);
    }
    block.push(...current.coords);
    clearLines();
    spawn();
    render();
}

function rotate() {
    if(!current) return;
    const coordsStr = JSON.stringify(current.coords.map(([r,c])=>[r-current.coords[0][0], c-current.coords[0][1]]).sort());
    const isO = coordsStr === JSON.stringify([[0,0],[0,1],[1,0],[1,1]]);
    if (isO) return;

    const origin = current.coords[2];
    const rel = current.coords.map(([r,c]) => [r-origin[0], c-origin[1]]);
    const rotated = rel.map(([r,c])=>[-c,r]).map(([r,c])=>[r+origin[0],c+origin[1]]);
    const kicks = [[0,0],[0,1],[0,-1],[-1,0]];
    for (const [kr,kc] of kicks) {
        const kicked = rotated.map(([r,c]) => [r+kr,c+kc]);
        if (canPlace(kicked)) {
            current.coords = kicked;
            render();
            return;
        }
    }
}

function getSpeedByLevel(lv) {
    if (lv < 9) return 750 - lv * 50;
    if (lv < 19) return 350 - (lv - 9) * 20;
    if (lv < 29) return 150 - (lv - 19) * 5;
    return 30;
}

function clearLines() {
    let cleared = 0;
    for (let r = rows-1; r>=0; r--) {
        let full = true;
        for (let c = 0; c<cols; c++) {
            if(!occupied(r,c)) { full = false; break; }
        }
        if (full) {
            block = block.filter(p => p[0]!==r);
            block = block.map(p => p[0]<r ? [p[0]+1,p[1]] : p);
            cleared++;
            r++;
        }
    }
    if (cleared > 0) {
        linesCleared += cleared;
        switch(cleared) {
            case 1: score += (40*(level+1)); break;
            case 2: score += (100*(level+1)); break;
            case 3: score += (300*(level+1)); break;
            case 4: score += (1200*(level+1)); break;
            default: score += (1500*(level+1)); break;
        }
        if (Math.floor(linesCleared / 10) > level) {
            level = Math.floor(linesCleared / 10);
            setGameInterval(getSpeedByLevel(level));
        }
    }
}

function setGameInterval(ms) {
    if (gameTimer) clearInterval(gameTimer);
    isPlaying = true;
    gameTimer = setInterval(()=>{ if (isPlaying) moveDown(); }, ms);
}
function pauseGame() {
    isPlaying = !isPlaying;
    pauseBtn.textContent = isPlaying ? 'Pause' : 'Resume';
}
function resetGame() {
    clearInterval(gameTimer);
    block = [];
    current = null;
    score = 0;
    level = 0;
    linesCleared = 0;
    buildBoard();
    spawn();
    render();
    setGameInterval(getSpeedByLevel(0));
    isPlaying = true;
    pauseBtn.textContent = 'Pause';
}

function endGame() {
    if(gameTimer) clearInterval(gameTimer);
    isPlaying = false;
    document.getElementById('finalScore').textContent = score;
    document.getElementById('gameOverModal').classList.remove('hidden');
}

function saveTopScore(finalScore) {
    const raw = prompt('Enter your name for the leaderboard:');
    if (raw !== null) {
        const name = raw.trim() ? raw.trim() : 'Anonymous';
        try {
            const key = 'top_scores';
            const existing = JSON.parse(localStorage.getItem(key) || '[]');
            existing.push({name, score: finalScore});
            existing.sort((a,b) => b.score - a.score);
            const top = existing.slice(0,5);
            localStorage.setItem(key, JSON.stringify(top));
            displayTopScores();
        } catch(e) { console.error('Error saving top score', e); }
    }
}
function displayTopScores() {
    const div = document.getElementById('topScores');
    const raw = localStorage.getItem('top_scores');
    if (!raw) { div.innerHTML = '<div class="no-score">No scores yet</div>'; return; }
    try {
        const arr = JSON.parse(raw) || [];
        if (!arr.length) { div.innerHTML = '<div class="no-score">No scores yet</div>'; return; }
        div.innerHTML = arr.map(a=>`<div>${a.name}: ${a.score}</div>`).join('');
    } catch(e) {
        console.error('Error reading top scores', e);
        div.innerHTML = '<div class="no-score">No scores yet</div>';
    }
}

document.addEventListener('DOMContentLoaded',()=>{
    buildUI();
    buildBoard();
    render();
    displayTopScores();

    const startModal = document.getElementById('startModal');
    const startButton = document.getElementById('startButton');

    startModal.classList.remove('hidden');
    startButton.addEventListener('click',()=>{
        startModal.classList.add('hidden');
        resetGame();
        const audio = document.getElementById('bgm');
        if (audio) { audio.muted = false; audio.play(); }
    });

    document.getElementById('pause-btn').addEventListener('click',()=>pauseGame());
    document.getElementById('reset-btn').addEventListener('click',()=>resetGame());

    document.getElementById('newGameBtn').addEventListener('click', () => {
        document.getElementById('gameOverModal').classList.add('hidden');
        saveTopScore(score);
        resetGame();
    });

    document.addEventListener('keydown',(e)=>{
        if(!isPlaying) return;
        switch(e.keyCode) {
            case 37: moveLeft(); break;
            case 39: moveRight(); break;
            case 40: moveDown(); break;
            case 38: rotate(); break;
            case 32: e.preventDefault(); dropToBottom(); break;
        }
        render();
    });
});