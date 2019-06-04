function slidingMaxWindow(arr, k){
  const result = [];
  
  for(let i = 0; i < arr.length-1; i++){
    const stack = [];
    let j = 2;
    // we want to get however many item between i and j
    for(let j = i; j< k + i; j++){
      stack.push(arr[j]);
    }
    
    const max = Math.max(...stack);
    result.push(max);
  }

  console.log(result)
  return result;
}


const arr = [6, 7, 5, 2, 1, 7, 2, 1, 10]

slidingMaxWindow(arr, 2)
