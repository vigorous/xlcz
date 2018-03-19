$(document).ready(function() {
	var panelImg = ["../../images/dropDown.png", "../../images/dropUp.png"];
	$(".panel-head").on("click", function() {
		var drop=$(this).find("img");
		var index = panelImg.indexOf(drop.attr("src"));
		index = (index + 1) % 2;
		drop.attr("src", panelImg[index]);
		if(index == 0) {
			drop.parentsUntil(".panel").parent().removeClass("panel_active");
			drop.parentsUntil(".panel").parent().parent().addClass("panel-container");
		} else {
			drop.parentsUntil(".panel").parent().addClass("panel_active");
			drop.parentsUntil(".panel").parent().parent().removeClass("panel-container");
		}
	})
})