var app = require('express')();
var server = require('http').createServer(app);
const io = require("socket.io")(server);

const io = require("socket.io")(8888, { //8888번 포트 사용
    path: "/server",
    serveClient: false,
    pingInterval: 10000,
    pingTimeout: 5000,
    cookie: false
});

io.on('connection', function(socket) { //소켓연결이 확인되면 위치 로그
    console.log('user connected'); //디버깅용 소켓연결시 Log

    socket.on('update_loc', function(data) { //위치정보가 서버로 들어오면 다른 유저들에게 전송
        io.emit('refreshloc', locdata);
    });
    
    socket.on('disconnect', function() { //디버깅용 연결 끊길 시 Log
        console.log('user disconnected');
    });
});