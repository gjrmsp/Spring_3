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
		success: function(result) {}
	});
});