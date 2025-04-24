const main_nav = document.getElementById("nav-bar");
const nav = document.getElementById("mobile-nav-bar");
const mobile_all = document.getElementById("mobile-nav");
const desk_nav = document.getElementById("desk-nav-bar");

function showMobileNav() {
  main_nav.style.width = "1024px";
  main_nav.style.borderRadius = "0px";
  main_nav.style.position = "";
  main_nav.style.backgroundColor = "white";

  nav.style.display = "flex";
  mobile_all.style.display = "flex";
  desk_nav.style.display = "none";
}

function hideMobileNav() {
  main_nav.style.width = "85%";
  nav.style.display = "none";
  mobile_all.style.display = "none";
  desk_nav.style.display = "flex";
}
