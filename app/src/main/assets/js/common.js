$(document).ready(function(){
	
	var h = $(window).height();	
	$(".btn-all-menu").click(function(e){
		var h = $(window).height();
		e.preventDefault();
		if($('#navPrimary').hasClass("show")){
			$('#navPrimary').removeClass("show");
			$("#wrap").css("position","relative");
		}else{
			$("#navPrimary").height(h);
			$('#navPrimary').addClass("show");
			$("#wrap").css("position","fixed");
		}
	});
	
	$("#navPrimary .btn-all-menu-close").click(function(e){
		e.preventDefault();
		$('#navPrimary').removeClass("show");
		$("#wrap").css("position","relative");
	});
	
	
	
	//개인정보보호정책 보기
	$(".btn-policy-view").click(function(e){
		e.preventDefault();
		//$("html, body").css("position","fixed");
		//$(".policy_layer_popup .layer_con").css("height",$(window).height()-80);
		$(".policy_layer_popup").show();
	});
	
	//개인정보보호정책 보기 닫기
	$(".policy_layer_popup .layer_close").click(function(e){
		e.preventDefault();
		//$("html, body").css("position","relative");
		$(".policy_layer_popup").hide();
	});
	
	$("#navPrimary .menu-list .tssol>a").click(function(e){
		e.preventDefault();
		var tssol = $("#navPrimary .menu-list .tssol");
		var sub = tssol.find(".sub");
		if(sub.css("display") == "none"){
			tssol.addClass("show");
			sub.slideDown();
		}else{
			tssol.removeClass("show");
			sub.slideUp();
		}		
	});
	
	//tab_menu 
	$(".tab_menu li>a").click(function(e) {
		e.preventDefault();
		var index = $(".tab_menu li>a").index($(this));
		$(".tab_cont").hide();
		$(".tab_cont").eq(index).show();
		$(".tab_menu li").removeClass("on");
		$(this).parent().addClass("on");
		$("#contents").height($('#c2').height());
	});

	
	$('#top_btn').click(function (e) {
		e.preventDefault();
        $('body,html').animate({ scrollTop: 0 }, 600);
        return false;
    });
	
	
});


$(window).scroll(function () {
	if(!$('#navPrimary').hasClass("show")){
		if ($(this).scrollTop() > 100) { // 스크롤 내릴 표시
	        $('#top_btn').fadeIn();
	    } else {
	        $('#top_btn').fadeOut();
	    }	
	}
}); 

//포트폴리오 상세보기
$(document).on('click', ".imgTitleWrapper", function(e) {
	e.preventDefault();
	var index = $(".imgTitleWrapper").index($(this));
	if($(".myToggle").eq(index).css("display") == "none"){
		$(".myToggle").hide();
		$(".myToggle").eq(index).slideDown();
		$('html, body').animate({ scrollTop: $(this).offset().top}, 1);
	}else{
		$(".myToggle").eq(index).slideUp();
	}
});


function isAppleDevice(){
    return (
        (navigator.userAgent.toLowerCase().indexOf("ipad") > -1) ||
        (navigator.userAgent.toLowerCase().indexOf("iphone") > -1) ||
        (navigator.userAgent.toLowerCase().indexOf("ipod") > -1)
    );
}

function isMobile(){
	var UserAgent = navigator.userAgent;

	if (UserAgent.match(/iPhone|ipad|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson/i) != null || UserAgent.match(/LG|SAMSUNG|Samsung/) != null)
	{
		return true;
	}else{
		return false;
	}
}
