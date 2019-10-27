var course = my$("course");
var exep = my$("exep");
var shopp = my$("shopp");

var show_all = my$("show_all");

course.style.borderBottom ="#fa9302 solid 3px";
course.style.color = "#fa9302";


course.onclick = function() {
    course.style.borderBottom ="#fa9302 solid 3px";
    exep.style.borderBottom = "";
    shopp.style.borderBottom = "";
    exep.style.color = "";
    shopp.style.color = "";
    animate(show_all,0,1120);
    course.style.color = "#fa9302";
    var loading = my$("loading");
    loading.style.display = 'block';
    var pass = my$("pass");
    var step = 14;

    var id = setInterval(function() {
        pass.style.width = (pass.clientWidth + step) + 'px';
        if(pass.clientWidth > 400){
            clearInterval(id);
            loading.style.display = 'none';
            pass.style.width = "0px";
        }
    },40);

}
exep.onclick = function() {
    exep.style.borderBottom ="#fa9302 solid 3px";
    course.style.borderBottom = "";
    shopp.style.borderBottom = "";
    course.style.color = "";
    shopp.style.color = "";
    animate(show_all,-1158,1120);
    this.style.color = "#fa9302";
    var loading = my$("loading");
    loading.style.display = 'block';
    var pass = my$("pass");
    var step = 14;

    var id = setInterval(function() {
        pass.style.width = (pass.clientWidth + step) + 'px';
        if(pass.clientWidth > 400){
            clearInterval(id);
            loading.style.display = 'none';
            pass.style.width = "0px";
        }
    },40);
}
shopp.onclick = function() {
    shopp.style.borderBottom ="#fa9302 solid 3px";
    exep.style.borderBottom = "";
    course.style.borderBottom = "";
    exep.style.color = "";
    course.style.color = "";
    animate(show_all,-2316,1120);
    this.style.color = "#fa9302";
    var loading = my$("loading");
    loading.style.display = 'block';
    var pass = my$("pass");
    var step = 14;

    var id = setInterval(function() {
        pass.style.width = (pass.clientWidth + step) + 'px';
        if(pass.clientWidth > 400){
            clearInterval(id);
            loading.style.display = 'none';
            pass.style.width = "0px";
        }
    },40);

}



// 轮播图
var img1 = my$("img1");
var img2 = my$("img2");
var img3 = my$("img3");
var img4 = my$("img4");
var imgArr = [];
imgArr.push(img1);
imgArr.push(img2);
imgArr.push(img3);
imgArr.push(img4);
var li1 = my$("li1");
var li2 = my$("li2");
var li3 = my$("li3");
var li4 = my$("li4");
var liArr = [];
liArr.push(li1);
liArr.push(li2);
liArr.push(li3);
liArr.push(li4);
var cur = 1;
for(var j = 0; j < liArr.length; j++) {
    liArr[j].onclick = function() {
        var that= this;
        var index = that.getAttribute("index");
      
        // console.log("wdww");
        for(var i = 0; i < imgArr.length; i++) {
            // console.log("wdwwwwwwwww");
            imgArr[i].style.opacity = "0";
            liArr[i].className = "";
            
        }
        this.className = "active";
        imgArr[index].style.opacity = "1";
    }
}



setInterval(function(){
    liArr[cur].click();
    cur = cur + 1;
    if(4 == cur){
        cur = 0;
    }
},4000);





// 弹出框部分
var xuanze = my$("xuanze");
xuanze.onchange = function () {
    var bigname = my$("bigname1");
    bigname.innerText = this.value;
}
var xuanze2 = my$("xuanze2");
xuanze2.onchange = function () {
    var bigname = my$("bigname2");
    bigname.innerText = this.value;
}
var xuanze3 = my$("xuanze3");
xuanze3.onchange = function () {
    var bigname = my$("bigname3");
    bigname.innerText = this.value;
}

    // 确定后发送请求
var enter = my$("enter");
enter.onclick = function () {
    var sum = 0; // 记录目标总数
    // 获取目标（文本 ）和期限：
        // 第一个
    var span1input1 = my$("span1input1");
    var span1input2 = my$("span1input2");
    if(span1input1.value != "" && span1input2.value != "") {
        sum += 1;
    }
   
        // 第二个
    var span2input1 = my$("span2input1");
    var span2input2 = my$("span2input2");
    if(span2input1.value !="" && span2input2.value != "") {
        sum += 1;
    }
    
            // 第三个
    var span3input1 = my$("span3input1");
    var span3input2 = my$("span3input2");
    if(span3input1.value != "" && span3input2.value != "") {
        sum += 1;
    }

    var pop_bg = document.getElementById("pop_bg");
    var popframe = document.getElementById("popframe");
    pop_bg.style.display = 'none';
    popframe.style.display = 'none';


exit.onclick = function () {
    pop_bg.style.display = 'none';
    popframe.style.display = 'none';
}
   
    $.ajax({
        type:'post',
        dataType:'json',
        url:'/addUserCourseServlet',  // 填写弹框确定后请求的地址
        data:{"target1":xuanze.value,"target2":xuanze2.value,"target3":xuanze3.value,
        "target1text":span1input1.value,"target1date":span1input2.value,
        "target2text":span2input1.value,"target2date":span2input2.value,
        "target3text":span3input1.value,"target3date":span3input2.value,
        "targetSum":sum}, // 发送过去的数据
        success:function (data) {

        },
        error:function () {
            console.log("出错了");
        }
    });
}



// 弹出框部分