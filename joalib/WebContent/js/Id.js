$(function()   {
    // Document.ready를 줄여서 이렇게 쓴다.
   $("#member_id_check").click(function(){
     var id= $('#member_id').val();
     // 앞에서 입력한 아이디 받아오기!
   $.ajax({

       url: 'Id_db.jsp',
       // 여기에서는 join_2의 상대경로 였어!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       // id.js의 상대경로가 아니라고
       // 속성: '속성값'
       dataType: 'html',
       // 가져오는 값의 타입==return타입(어떤형식으로 가지고 올거야?)
       // html대신 text 넣어도 똑같대


       data: {'id':id},  //앞에서 입력한 값 id에 넣어주고 보내기
       // data: {'id',id} :키값,벨류값
       // data를 사용하면 url의 페이지에서 얘를 받을 수가 있대연

       success: function(req){
           // ajax파일의 모든 글자 다 읽음
           //성공해서 가져오는 작업

           // alert(req);
           $("#idCheck").append(req);
          
           // 존재하는 아이디 입니다 들어갈거셈
           // append: 추가적으로 값을 집어넣는
       }
   });
   });
});
