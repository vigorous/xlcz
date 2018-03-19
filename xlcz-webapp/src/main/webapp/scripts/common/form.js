$(document.body).on("keydown", ".mini-textbox-input,.mini-buttonedit-input", function(e) {
    var e = e || window.event;
    if(e.keyCode == 13) {
        var el = $(this);
        var forms=el.closest(".form");
        var id=forms.attr("id");
        var nextControl = getNextInput(el[0],id);
        if(nextControl) {
            nextControl.focus();
        }
        return false;
    }
})
$(document.body).on("blur", ".mini-textbox-input", function() {
    var _this = $(this);
    setTimeout(function() {
        if(_this.parentsUntil(".mini-error").parent().length==1){
            setError(_this.parentsUntil(".mini-error").parent().parent().parent());
        }
    }, 100)
})
$(document.body).on("focus", ".mini-textbox-input", function() {
    $(this).parent().parent().removeClass("mini-error");
    $(this).parent().parent().parent().parent().parent().find(".error-text").remove();
})
function setError(obj) {
    obj.parent().css({
        "position": "relative"
    });
    var $div = $("<div></div>").addClass("error-text mini-col-4").text(obj.find(".mini-errorIcon").attr("title")).appendTo(obj.parent());
}
function getNextInput(current,id) {
    var form = new mini.Form(id);
    var controls = form.getFields();
    for(var i = 0, l = controls.length; i < l; i++) {
        var control = controls[i];
        if(current == control._textEl) {
            for(var j = 0, k = l - i; j < k; j++) {
                var nextControl = controls[i + j + 1];
                if(nextControl && nextControl.getEnabled() !== false) {
                    if($(nextControl.el).attr("class").indexOf("mini-textbox-none") != -1 ||
                        $(nextControl.el).attr("class").indexOf("mini-checkbox") != -1 ||
                        nextControl.visible == false || nextControl.allowInput == false) {
                        continue;
                    }
                    return nextControl;
                } else {
                    continue;
                }
            }
        }
    }
    return null;
}
