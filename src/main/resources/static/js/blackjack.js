// 댓글쓰기
var socket = null;

$("document").ready(connectWS);
function connectWS() {

    console.log("tttt")
    var ws = new WebSocket("ws://" +  document.URL.substring(7,document.URL.length-10) + "/blackjackGame")
    socket = ws;

    ws.onopen = function () {
        console.log('info: connection opend')
    }

    ws.onmessage = function (event) {
        console.log('ReceiveMessage', event.data + '\n');
        var stringA = event.data;
        var bbb = stringA.split(":");

        if(bbb[0] == "user") {
            var socketAlert = $("#game_userCard_text");
        }
        if(bbb[0] == "dealer") {
            var socketAlert = $("#game_dealerCard_text");
        }
        console.log(socketAlert);
        socketAlert.text(bbb[1]);

    }
}

$(".submit-write-answer button[type=submit]").on("click", submitMessage);
function submitMessage(e) {
    e.preventDefault()
    console.log("메세지")
    var queryString = $(".submit-write-answer").serialize(); //form data들을 자동으로 묶어준다.
    console.log("query : "+ queryString)
    console.log("query : "+ queryString.replace(/%/g, '%25'))
    socket.send(queryString);   //클라이언트가 서버에 메시지를 보낸다.


}


$('#game-start-button').on('click',showHitButton)
function showHitButton(e) {
    e.preventDefault()
    console.log("메세지")
    $('.hit-or-stand').css('display','block');
    $('#game-start-button').css('display','none');
    var bettingchip = prompt("배팅할 칩을 입력하세요");

    socket.send("bettingchip "+bettingchip);
    console.log(bettingchip);
}

function startGame() {

}


function userChoiceHitOrStand() {


}

$('#hit-button').on('click',hit)
function hit(e) {
    var abc = $("#game_dealerCard_text");
    abc.text("카드 1");

}

function whenUserTurnFinish() {

}

String.prototype.format = function() {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function(match, number) {
      return typeof args[number] != 'undefined'
          ? args[number]
          : match
          ;
    });
  };