/**
 * 
 */

let id = document.getElementById("id");
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");
let btn = document.getElementById("btn");
let etc = document.getElementsByClassName("etc");

let idCheckResult = false; //id check 결과
let pwCheckResult = false; //pw check 결과
let pwEqualResult = false; //pw equal 결과
let etcResult = true; // name, email, phone 결과

check.addEventListener("click", function() {
	alert("test");
	return false;
});

btn.addEventListener("click", function() {
	for(let e of etc) {
		if(e.value == "") {
			etcResult = false;
			break;
		}
	}
});

/* pw equal check */
pw2.addEventListener("blur", function() {
	if(pw.value != pw2.value) {
		pw2.value = "";
		pwEqualResult = true;
	}
});

/* pw Check */
pw.addEventListener("change", function() {
	alert("change");
});

pw.addEventListener("blur", function() {
	let message = "8글자 미만입니다";
	let c = "r1"
	if(pw.value.length>7) {
		message = "8글자 이상입니다";
		c = "r2";
		pwCheckResult = true;
	}
	
	let pwResult = document.getElementById("pwResult");
	pwResult.innerHTML = message;
	pwResult.setAttribute("class", c);
	
});

/* id Check */
	id.addEventListener("blur", function() {
	let message = "6글자 미만입니다";
	let c = "r1"
	if(id.value.length>5) {
		message = "6글자 이상입니다";
		c = "r2";
		idCheckResult = true;
	}
	
	let idResult = document.getElementById("idResult");
	idResult.innerHTML = message;
	idResult.setAttribute("class", c);
	
});