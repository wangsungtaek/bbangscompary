var pathName = window.location.pathname;
var navList = document.querySelectorAll("#navbar li a");

for( var i = 0 ; i < navList.length; i++ ) {

    if(navList[i].className == "active") {
        navList[i].classList.remove("active");
    }
}

if(pathName == "/") {
    navList[0].classList.add("active");
}
else if (pathName == "/about") {
    navList[1].classList.add("active");
}
else if (pathName == "/onlineMarketing") {
    navList[2].classList.add("active");
}
else if (pathName == "/offlineMarketing") {
    navList[3].classList.add("active");
}
else if (pathName == "/brandMarketing") {
    navList[4].classList.add("active");
}