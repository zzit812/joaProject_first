
			//동의 체크 확인 메서드
			function termsCheck(){
				var result = true;
		 		var check = document.querySelector('input[name=agreeTerms]');
		 		if(check.checked != true){
		 			//체크 안됨
		 			alert("약관에 동의해주세요.");
		 			result = false;}
		 		return result;
		 	}

		 	//링크 이동
		 	function kids(){
		 		if(termsCheck()){
		 			location.href='join_2_kid.html';}
		 	}
		 	function general(){
		 		if(termsCheck()){
		 			location.href='join_2_general.html';}
		 	}