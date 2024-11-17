const container = document.querySelector('.container');
const loginLink = document.querySelector('.SignIn');
const registerLink = document.querySelector('.SignUp');

registerLink.addEventListener('click', () => {
    container.classList.add('active');
});

loginLink.addEventListener('click', () => {
    container.classList.remove('active');
});
