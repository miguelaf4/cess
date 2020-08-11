window.addEventListener('scroll', function () {
    const logoImage = document.querySelector('.logo img')
    const mainNav = document.getElementById('mainNav')

    if(window.pageYOffset > 0) {
        logoImage.style.height = "80px"
        mainNav.classList.add('shadow')
    } else {
        logoImage.style.height = "120px"
        mainNav.classList.remove('shadow') 
    }
})

