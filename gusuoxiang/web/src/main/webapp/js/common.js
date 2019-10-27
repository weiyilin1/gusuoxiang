function my$(id) {
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






function getPage(e) {
    var pageX = e.pageX || e.clientX + getScroll().scrollLeft;
    var pageY = e.pageY || e.clientY + getScroll().scrollTop;
    return {
      pageX: pageX,
      pageY: pageY
    }
  }
  
