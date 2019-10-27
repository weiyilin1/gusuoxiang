function $(id) {
    return document.getElementById(id);
}

function animate (element, target, step) {
    if(element.timerId) {
        clearInterval(element.timerId);
        element.timerId = null;
    }
    element.timerId = setInterval(function () {
   // 步进  每次移动的距离
   var step1 = step;

   // 盒子当前的位置
   var current = element.offsetLeft;

   if (current > target) {
       step1 = -Math.abs(step1);
   }

   if (Math.abs(current - target) < Math.abs(step1)) {
     // 让定时器停止
     clearInterval(element.timerId);
     // 让盒子到target的位置
     element.style.left = target + 'px';
     return;
   }
   // 移动盒子
   current += step1;
   element.style.left = current + 'px';
 }, 30);
}


var login_box = $("login_box");
var login_r = $("login_r");

var jianbian_r = $("jianbian_r");
var jianbian_g = $("jianbian_g");
var jianbian_b = $("jianbian_b");

login_box.style.opacity = 0;



var current = 0;
var id = setInterval(function(){
        login_box.style.opacity = current;
        current = current + 0.1;
        if(login_box.style.opacity == 1) {
            clearInterval(id);
            
            login_r.style.display = 'block';
            current = 0;
            animate(login_r,340,20);
            
           
           
        }
},100);

setTimeout(function(){ 
    var id_r = setInterval(function(){

    jianbian_r.style.opacity = current;
    
    current = current + 0.1;
    if(jianbian_r.style.opacity == 1) {
        clearInterval(id_r);
        current = 0;
    }
},100);},2000);

setTimeout(function(){ 
    var id_g = setInterval(function(){
    jianbian_g.style.opacity = current;
   
    current = current + 0.1;
    if(jianbian_g.style.opacity == 1) {
        clearInterval(id_g);
        current = 0;
    }
},100);},3200);

setTimeout(function(){ 
    var id_b = setInterval(function(){

    jianbian_b.style.opacity = current;
    
    current = current + 0.1;
    if(jianbian_b.style.opacity == 1) {
        clearInterval(id_b);
        current = 0;
    }
},100);},4500);



// var id_g = setInterval(function(){

//     jianbian_g.style.opacity = current;
//     console.log(jianbian_g.style.opacity);
//     current = current + 0.1;
//     if(jianbian_g.style.opacity == 1) {
//         clearInterval(id_g);
//         current = 0;
//     }
// },100);









