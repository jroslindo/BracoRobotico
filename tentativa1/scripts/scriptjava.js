var grausAresta = -45;

function teste (direita){
    if (direita == 0)
        grausAresta-=5;

    if (direita == 1){
        grausAresta+=5;
    }   
    
    document.getElementById('aresta').style.WebkitTransform = 'rotate(' + grausAresta.toString() +'deg)';
  
    console.log(direita.toString())
}

