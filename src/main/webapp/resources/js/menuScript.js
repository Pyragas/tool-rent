function init() {
    document.body.style.visibility = 'visible'
    let curPageId = sessionStorage.getItem('pageId')
    let array = Array.from(document.querySelectorAll('.active-menu-button'))
    if(array) array.forEach((el) => el.classList.remove('active-menu-button'))
    let element = document.getElementById(curPageId)
    if (element) element.classList.add("active-menu-button");
}

function setCurrentPage(page) {
    sessionStorage.setItem("pageId", page.id);
}