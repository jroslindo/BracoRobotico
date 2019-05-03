var grausAresta = -45;

function teste (){
    grausAresta+=5;
    document.getElementById('aresta').style.WebkitTransform = 'rotate(' + grausAresta.toString() +'deg)';
  
    console.log(grausAresta.toString())
}

