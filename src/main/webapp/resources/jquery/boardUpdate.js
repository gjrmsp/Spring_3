/**
 * 
 */

$(".fileDelete").click(function(){
	//fileNum
	let fileNum = $(this).attr("title");
	//noticeFileDelete
	$.ajax({
		url: "./noticeFileDelete",
		type: "GET",
		data: {fileNum: fileNum},
		success:function(result) {
			result=result.trim();
			if(result>0) {
				alert("삭제 성공");
			} else {
				alert("삭제 실패");
			}
		}
	});
});