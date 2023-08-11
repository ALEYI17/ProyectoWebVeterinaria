
let arbolderecho =document.getElementById("hola4")
let arbolizquierdo =document.getElementById("hola3")

let text =document.getElementById("text")


let para=document.getElementsByClassName("Paralax")

window.addEventListener("scroll",()=>{

    let value = window.scrollY;
    
    text.style.marginTop = value*2.5 +'px';
    arbolderecho.style.left = value*1.5 +'px';
    arbolizquierdo.style.left = value*-1.5 +'px';

});

const observer= new IntersectionObserver((entries)=>{
    entries.forEach((entry)=>{
        console.log(entry);
        if(entry.isIntersecting){
            entry.target.classList.add('show');

        }
        else{
            entry.target.classList.remove('show');
        }
    });
});
const hiddenElements = document.querySelectorAll('.hidden'); 
hiddenElements.forEach((el)=> observer.observe(el));
