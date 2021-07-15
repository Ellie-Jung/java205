//회원의 정보
function Member(id, pw, name){
    this.id = id;
    this.pw = pw;
    this.name=name;
}
//객체가 가지는 메서드 공동으로 사용 -> 프로토타입
Member.prototype.makeHtml = function(){
    return '[id:'+this.id + ' , pw: '+ this.pw + ', name : '+ this.name+']'
};


//회원의 정보 저장하는 배열
var Member = [];



window.onload = function(){
    
    //로컬스토웨지 (브라우저) 저장
    if(localStorage.getItem('members')==null){ //로컬스토웨지에 저장된 멤버 없으면 null  반환
        localStorage.setItem('members', JSON.stringify(members));  //
    }else{
        members = JSON.parse(localStorage.getItem('members')); //json문자열을 객체로 변환
        setList();
    }


    var id = document.querySelector('#userID');
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var name = document.querySelector('#userName');

    var regForm = document.getElementById('regForm');


    regForm.onsubmit = function(){

        if(id.value.trim().length<1){
            document.querySelector("userID+div.msg").innerHTML ='필수항목입니다.';
            document.querySelector('userID+div.msg').style.display = 'block';
            return false;
        }

        if(pw.value.trim().length<1){
            document.querySelector('pw+div.msg').innerHTML='필수항목입니다.';
            document.querySelector('pw+div.msg').style.display='block';
            return false;
        }

        if(repw.value.trim().length<1){
            document.querySelector('repw+div.msg').innerHTML='필수항목입니다.';
            document.querySelector('repw+div.msg').style.display='block';
            return false;
        }

        if(pw.value.trim() != repw.value.trim()){
            document.querySelector('#repw+div.msg').innerHTML = '비밀번호가 일치하지 않습니다.';
            document.querySelector('#repw+div.msg').style.display='block';
            return false;
        
        }


        if(name.value.trim().length<1){
            document.querySelector('#userName+div.msg').innerHTML = '필수항목입니다.';
            document.querySelector('#userName+div.msg').style.display='block';
            return false;
        }

        //배열에 사용자 정보 추가
        members.push(new Member(id.value, pw.value, name.value));

        //로컬스토리지저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('등록되었습니다.')

        //form초기화
        this.reset();

        setList();
        return false;

    }

    id.addEventListener('focus', function(){
        document.querySelector('#userID+div.msg').style.display= 'none';
        document.querySelector("#userID+div.msg").innerHTML='';
    })
    pw.addEventListener('focus', function () {
        document.querySelector('#pw+div.msg').style.display = 'none';
        document.querySelector('#pw+div.msg').innerHTML = '';
    });

    repw.addEventListener('focus', function () {
        document.querySelector('#repw+div.msg').style.display = 'none';
        document.querySelector('#repw+div.msg').innerHTML = '';
        repw.value = '';
    });

    name.addEventListener('focus', function () {
        document.querySelector('#userName+div.msg').style.display = 'none';
        document.querySelector('#userName+div.msg').innerHTML = '';
    });

}


function setList(){

    var list = document.querySelector('#list');

    var tbody = '<tr>';
    tbody +='   <th>순번(index)</th>';
    tbody +='   <th>아이디</th>';
    tbody +='   <th>비밀번호</th>';
    tbody +='   <th>이름</th>';
    tbody +='   <th>관리</th>';
    tbody +='</tr>';



}